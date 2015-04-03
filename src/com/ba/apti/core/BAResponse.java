package com.ba.apti.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ba.apti.comm.DropBoxClient;
import com.ba.apti.comm.Emailer;
import com.ba.apti.comm.MySQLClient;




public class BAResponse {
	
	private ContactInfo contactInfo;
	private Academics academics;
	private Objective objective;
	private Subjective subjective;
	private Vocations vocations;
	private RIT rit;
	private ISI isi;
	
	//high level method that registers a response
	public boolean register(String jsonResponse) {
		JSONObject jsonObject = null;
		try {
			JSONParser jsonParser = new JSONParser();
			jsonResponse.replace("\n", "").replace("\t", "").replace("\r", "")
				.replace("\b","").replace("\f", "").replace("\"", "'").replace("\\", "\\\\");						
			jsonObject = (JSONObject)jsonParser.parse(jsonResponse);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(jsonObject == null)
			return false;
		jsonObject = (JSONObject)jsonObject.get("answer");
		
		contactInfo = new ContactInfo(jsonObject);
		academics = new Academics(jsonObject);
		subjective = new Subjective(jsonObject);
		objective = new Objective(jsonObject); 
		isi = new ISI(jsonObject);
		vocations = new Vocations(jsonObject);
		rit = new RIT(jsonObject);
		Emailer.mail(this.toString(),contactInfo.getName());
		InputStream stream = new ByteArrayInputStream(this.toString().getBytes(StandardCharsets.UTF_8));
		String dbxFileName = (contactInfo.getName()+"_"+contactInfo.getEmail()).replace(" ", "_").replace(".", "_") + ".html";
		String phone;
		if( DropBoxClient.storeFile(stream, this.toString().length(), dbxFileName))		
			return MySQLClient.getConnector().addEntry(contactInfo.getName(), 
				contactInfo.getDateOfBirth(), 
				contactInfo.getEmail(), 
				(phone = contactInfo.getPhone1()) == null ? contactInfo.getPhone2() : phone, 
				dbxFileName);		
		return false;
	}
	
	public String toString() {
		String script = "<script> " + 
		"function toggleDetail(id) { " +  
		"    var disp = document.getElementById(id).style.display == \"none\" ? \"block\" : \"none\";"  + 		
		"    document.getElementById(id).style.display = disp;"  + 
		"}" + 
		"</script>";
		String bt1 = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">";
		StringBuilder builder = new StringBuilder();
		builder.append("<html>").append("<head>" + bt1+script + "</head>");
		builder.append("<body>");
		builder.append("<div class=\"container\"><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\">");
		builder.append(contactInfo.toString())
			.append(academics.toString())
			.append(subjective.toString())
			.append(objective.toString())
			.append(isi.toString())
			.append(vocations.toString())
			.append(rit.toString());
		builder.append("</div></div></div></body></html>");
		return builder.toString();
	}

}
