package com.ba.apti.core;

import java.util.HashMap;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class Subjective {
	
	HashMap<String,String> subjectiveQuestionResponses;
	
	public Subjective(JSONObject fullJson) {
		subjectiveQuestionResponses = new HashMap<String,String>();
		getSubjectiveQuestionResponses(fullJson);
	}
	
	static String [] subjectiveQuestions = {
			"Tuition/coaching classes",					
			"Academic failures / course changes",		
			"Counselling",
			"Changes in school/college",
			"Likes and/or dislikes about school and college",
			"Other skills, courses or studies undertaken",
			"Reliving life from std X onwards",
			"Favorite songs",
			"Pets",
			"Languages spoken at home",
			"Three best qualities",
			"Three shortcomings or bad qualities",
			"Comments heard from parents and friends",
			"Extra-curricular activities",
			"Information about parents",
			"Role model",
			"Favorite teacher/friend",
			"Digital Life",
			"Candidate's career choices",
			"Parents' career choices",
			"What is your greatest achievement so far?",
			"Do you think engineers and doctors make more money and have better careers than others?",
			"If I won a prize that gave me 50 lakhs every six months, 4 installments totaling to two crore rupees, I would ...",
			"Write directions how you will go from your house to railway station.",
			"Write about one very good incident in your life involving you and your friend(s)",
			"Write how you will convince the buyer if you want to sell your old bicycle to him"			
	};

	private void getSubjectiveQuestionResponses(JSONObject fullJson) {
		subjectiveQuestionResponses.put(subjectiveQuestions[0], fullJson.get("tuition").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[1], fullJson.get("failChange").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[2], 
				fullJson.get("wantCounselling").toString() + ". " + fullJson.get("counsellingReason").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[3], fullJson.get("schoolCollegeChange").toString());		
		
		subjectiveQuestionResponses.put(subjectiveQuestions[4], fullJson.get("likeDislike").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[5], fullJson.get("oskills").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[6], fullJson.get("relive").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[7], fullJson.get("songs").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[8], fullJson.get("pets").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[9], fullJson.get("lang").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[10], 
				"<ol><li>" + fullJson.get("gq1").toString() + "</li>" +  
				"<li>" + fullJson.get("gq2").toString() + "</li>" +  
				"<li>" + fullJson.get("gq3").toString() + "</li></ol>");
		
		subjectiveQuestionResponses.put(subjectiveQuestions[11], 
				"<ol><li>" + fullJson.get("bq1").toString() + "</li>" +  
				"<li>" + fullJson.get("bq2").toString() + "</li>" +  
				"<li>" + fullJson.get("bq3").toString() + "</li></ol>");
		
		
		subjectiveQuestionResponses.put(subjectiveQuestions[12], fullJson.get("othersComments").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[13], fullJson.get("extraCurriculars").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[14],
				Html.table(
						Html.thead(Html.tr(Html.th("&emsp;")+ Html.th("Mother") + Html.th("Father")) + 
				Html.body(
				Html.tr(Html.td("Name") + Html.td(fullJson.get("motherName").toString()) + Html.td(fullJson.get("fatherName").toString())) +    
				Html.tr(Html.td("Qualification") + Html.td(fullJson.get("motherQual").toString()) + Html.td(fullJson.get("fatherQual").toString())) +
				Html.tr(Html.td("Profession") + Html.td(fullJson.get("motherProf").toString()) + Html.td(fullJson.get("fatherProf").toString()))
				))));
		
		subjectiveQuestionResponses.put(subjectiveQuestions[15],fullJson.get("roleModel").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[16],fullJson.get("favPerson").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[17], digitalLifeDetails(fullJson));
		
		subjectiveQuestionResponses.put(subjectiveQuestions[18], personalCareerChoices(fullJson));
		
		subjectiveQuestionResponses.put(subjectiveQuestions[19], fullJson.get("parentChoice").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[20], fullJson.get("greatAchieve").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[21], fullJson.get("engdoc").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[22], fullJson.get("prize").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[23], fullJson.get("directions").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[24], fullJson.get("incident").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[25], fullJson.get("bicycle").toString());
	}
	
	
	
	private String digitalLifeDetails(JSONObject fullJson) {
		StringBuilder digiLife = new StringBuilder();
		digiLife.append("<ol>");
		if(fullJson.containsKey("browsing"))
			digiLife.append("<li>Browsing</li>");
		if(fullJson.containsKey("games"))
			digiLife.append("<li>Playing games</li>");
		if(fullJson.containsKey("social"))
			digiLife.append("<li>Using social networking tools like Facebook, Whatsapp</li>");
		if(fullJson.containsKey("creative"))
			digiLife.append("<li>Creative work like designing, animation</li>");
		if(fullJson.containsKey("coding"))
			digiLife.append("<li>Computer Programming</li>");
		if(fullJson.containsKey("otherActs"))
			digiLife.append("<li>"+fullJson.get("otherActivities").toString()+"</li>");
		digiLife.append("</ol>");
		return digiLife.toString();
	}
	
	private String personalCareerChoices(JSONObject fullJson) {
		String header = Html.thead(Html.tr(Html.th("Question")		
				+ Html.th("Choice 1") + Html.th("Choice 2")));
		
		String row1 = Html.tr(Html.td("<b>Name of the profession</b>")
				+Html.td(fullJson.get("p1name").toString())
				+Html.td(fullJson.get("p2name").toString()));
		
		String row2 = Html.tr(Html.td("<b>Why have you chosen this profession?</b>")
				+Html.td(fullJson.get("p1reason").toString())
				+Html.td(fullJson.get("p2reason").toString()));
		
		String row3 = Html.tr(Html.td("<b>What courses would you need to take up?</b>")
				+Html.td(fullJson.get("p1courses").toString())
				+Html.td(fullJson.get("p2courses").toString()));
		
		String row4 = Html.tr(Html.td("<b>What subjects would you need to study?</b>")
				+Html.td(fullJson.get("p1subjects").toString())
				+Html.td(fullJson.get("p2subjects").toString()));
		 

		String row5 = Html.tr(Html.td("<b>What skills would you need to develop?</b>")
				+Html.td(fullJson.get("p1skills").toString())
				+Html.td(fullJson.get("p2skills").toString()));

		String row6 = Html.tr(Html.td("<b>What kind of a job would you be doing?</b>")
				+Html.td(fullJson.get("p1job").toString())
				+Html.td(fullJson.get("p2job").toString()));

		return Html.table(header + Html.tbody(row1+row2+row3+row4+row5+row6));
		
		
	}
	
	public String toString() {
		StringBuilder subjectives = new StringBuilder();
		subjectives.append(Html.h(2, "Subjective Questions"));
		for(String question : subjectiveQuestions) {
			subjectives.append(Html.b(question) + Html.br(1));
			subjectives.append(subjectiveQuestionResponses.get(question) + Html.br(3));
		}
		subjectives.append(Html.br(4));
		return subjectives.toString();
	}
	
}