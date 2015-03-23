package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;


public class GATL {
	String [] answers;
	int score;
	String [] remark = new String[15];
	public GATL(JSONObject fullJson) {
		score = 0;
		answers = new String[15];
		answers[0] = fullJson.get("gatl1").toString();
		answers[1] = fullJson.get("gatl2").toString();
		answers[2] = fullJson.get("gatl3").toString();
		
		for(int i=1; i<=15;i++) 
			answers[i-1] = fullJson.get("gatl"+i).toString();		
	}
	
	public void evaluate() {
		String [] ansVector = {"a","a","b","d","b","a","c","c","d","b","c","a","d","b","d"};
		int [] scoreVector = {3,3,3,5,5,6,5,5,5,6,6,6,7,2,3};
		
		for(int i=0;i<15;i++) {
			if(answers[i].equalsIgnoreCase(ansVector[i])) {
				score += scoreVector[i];				
				remark[i] = "(correct)";
			}
			else
				remark[i] = "(wrong)";
		}
		
	}

	private String dumpAnswers() {
		StringBuilder allAnswers = new StringBuilder();
		for(int i = 0; i < 15; i++) {
			allAnswers.append(Integer.toString(i) + ". " + answers[i] + remark[i]);
			allAnswers.append(Html.br(1));
		}
		return Html.div(allAnswers.toString(), "hidden-gatl-details");
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Html.h(3,"GATL"))
			.append(Html.br(1))
			.append(Html.b("Score: ") + Integer.toString(score))
			.append(Html.br(2))
			.append(Html.button("Details", "toggleDetail('hidden-gatl-details')"))
			.append(Html.br(2))
			.append(dumpAnswers())
			.append(Html.br(1))
			.append("<hr>");
		return builder.toString();

	}
}