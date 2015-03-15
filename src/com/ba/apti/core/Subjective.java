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
				fullJson.get("wantCounselling").toString() + "==>" + fullJson.get("counsellingReason").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[3], fullJson.get("schoolCollegeChange").toString());		
		
		subjectiveQuestionResponses.put(subjectiveQuestions[4], fullJson.get("likeDislike").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[5], fullJson.get("oskills").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[6], fullJson.get("relive").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[7], fullJson.get("songs").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[8], fullJson.get("pets").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[9], fullJson.get("lang").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[10], 
				fullJson.get("gq1").toString() + "==>" + 
				fullJson.get("gq2").toString() + "==>" + 
				fullJson.get("gq3").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[11], 
				fullJson.get("bq1").toString() + "==>" + 
				fullJson.get("bq2").toString() + "==>" + 
				fullJson.get("bq3").toString());
			
		subjectiveQuestionResponses.put(subjectiveQuestions[12], fullJson.get("othersComments").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[13], fullJson.get("extraCurriculars").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[14], 
				fullJson.get("motherName").toString() + "==>" + 
				fullJson.get("motherQual").toString() + "==>" + 
				fullJson.get("motherProf").toString() + "==>" + 
				fullJson.get("fatherName").toString() + "==>" + 
				fullJson.get("fatherQual").toString() + "==>" + 
				fullJson.get("fatherProf").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[15],fullJson.get("roleModel").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[16],fullJson.get("favPerson").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[17], digitalLifeDetails(fullJson));
		
		subjectiveQuestionResponses.put(subjectiveQuestions[18], personalCareerChoices(fullJson));
		
		subjectiveQuestionResponses.put(subjectiveQuestions[19], fullJson.get("parentChoice").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[20], fullJson.get("engdoc").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[21], fullJson.get("prize").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[22], fullJson.get("directions").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[23], fullJson.get("incident").toString());
		
		subjectiveQuestionResponses.put(subjectiveQuestions[24], fullJson.get("bicycle").toString());
	}
	
	
	
	private String digitalLifeDetails(JSONObject fullJson) {
		StringBuilder digiLife = new StringBuilder();
		int count = 0;
		if(fullJson.containsKey("browsing"))
			digiLife.append(count + "." + "Browsing<br>");
		if(fullJson.containsKey("games"))
			digiLife.append("Playing games ==>");
		if(fullJson.containsKey("social"))
			digiLife.append("Using social networking tools like Facebook, Whatsapp ==>");
		if(fullJson.containsKey("creative"))
			digiLife.append("Creative work like designing, animation ==>");
		if(fullJson.containsKey("coding"))
			digiLife.append("Computer Programming");
		if(fullJson.containsKey("otherActs"))
			digiLife.append(fullJson.get("otherActivities").toString() + "==>");
		return digiLife.toString();
	}
	
	private String personalCareerChoices(JSONObject fullJson) {
		StringBuilder careerChoices = new StringBuilder();
		careerChoices.append("<h3>Career Choice 1</h3>");
		careerChoices.append("<p>");
		careerChoices.append("<b>Name of the profession</b>");
		careerChoices.append("Ans. " + fullJson.get("p1name").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>Why have you chosen this profession?</b>");
		careerChoices.append("Ans. " + fullJson.get("p1reason").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What courses would you need to take up?</b>");
		careerChoices.append("Ans. " + fullJson.get("p1courses").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What subjects would you need to study?</b>");
		careerChoices.append("Ans. " + fullJson.get("p1subjects").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What skills would you need to develop?</b>");
		careerChoices.append("Ans. " + fullJson.get("p1skills").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What kind of a job would you be doing?</b>");
		careerChoices.append("Ans. " + fullJson.get("p1job").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("</p>");
		
		careerChoices.append("<h3>Career Choice 2</h3>");
		careerChoices.append("<p>");
		careerChoices.append("<b>Name of the profession</b>");
		careerChoices.append("Ans. " + fullJson.get("p2name").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>Why have you chosen this profession?</b>");
		careerChoices.append("Ans. " + fullJson.get("p2reason").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What courses would you need to take up?</b>");
		careerChoices.append("Ans. " + fullJson.get("p2courses").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What subjects would you need to study?</b>");
		careerChoices.append("Ans. " + fullJson.get("p2subjects").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What skills would you need to develop?</b>");
		careerChoices.append("Ans. " + fullJson.get("p2skills").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("<b>What kind of a job would you be doing?</b>");
		careerChoices.append("Ans. " + fullJson.get("p2job").toString());
		careerChoices.append("<br><br>");
		careerChoices.append("</p>");
		
		return careerChoices.toString();
	}
	
	public String toString() {
		StringBuilder subjectives = new StringBuilder();
		for(String question : subjectiveQuestionResponses.keySet()) {
			subjectives.append(Html.b(question) + Html.br(2));
			subjectives.append(subjectiveQuestionResponses.get(question) + Html.br(3));
		}
		subjectives.append(Html.br(4));
		return subjectives.toString();
	}
	
}