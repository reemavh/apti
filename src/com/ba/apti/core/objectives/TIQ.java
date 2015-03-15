package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class TIQ {
	
	String [] answers;
	int score;
	String [] remarks;
	public TIQ(JSONObject fullJson) {
		answers = new String[15];
		remarks = new String[15];
		score = 0;
		for(int i = 1; i <= 15; i++ ) 
			answers[i-1] = fullJson.get("tiq"+i).toString();	
	}
	
	public void evaluate() {
		int [] scoreVector = {5,3,3,5,5,5,5,7,5,7,5,5,5,5,5};
		String [] ansVector = {"e","e","d","d","c","b","d","15-24-33-52-41","d","c","c","d","173","Y","2"};
		for(int i = 0; i < 15; i++)
			if(answers[i].equalsIgnoreCase(ansVector[i])) {
				score += scoreVector[i];
				remarks[i] = "(correct)";
			}
			else
				remarks[i] = "(wrong)";
	}
	
	public String toString() {
		StringBuilder allAnswers = new StringBuilder();
		for(int i = 0; i < 15; i++) {
			allAnswers.append(Integer.toString(i) + ". " + answers[i] + remarks[i]);
			allAnswers.append(Html.br(1));
		}
		return Html.div(allAnswers.toString(), "tiq-details");
	}

}