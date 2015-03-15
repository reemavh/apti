package com.ba.apti.core;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



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
		System.out.println(this);
		//write to google drive - toString methods of the different sections need to return out html
		//create contact entry in SQL DB
		
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>");
		builder.append(contactInfo.toString())
			.append(academics.toString())
			.append(subjective.toString())
			.append(objective.toString())
			.append(isi.toString())
			.append(vocations.toString())
			.append(rit.toString());
		builder.append("</body></html>");
		return builder.toString();
	}

}
