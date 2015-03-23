package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class GATM {
	
	String [] answers;
	int score;
	String [] remark = new String[15];
	public GATM(JSONObject fullJson) {
		score = 0;
		answers = new String[15];
		for(int i = 1; i <= 15; i++ ) 
			answers[i-1] = fullJson.get("gatm"+i).toString();
	}
	
	public void evaluate() {
		String [] answerVector = {"c","7","c","d","c","a","c","b","d","b","c","8.485","10-8","d","8"};
		int [] scoreVector = {3,5,7,3,3,5,4,5,5,5,5,5,7,5,3};
		for(int i=0; i<15;i++) {
			if(i==11 && answers[i].startsWith(answerVector[i])) {
					score += scoreVector[i];
					remark[i] = "(correct)";
			}
			else if(answers[i].equalsIgnoreCase(answerVector[i])) {
				score += scoreVector[i];
				remark[i] = "(correct)";
			}
			else
				remark[i] = "(wrong)";

		}		
	}
	
	public String dumpAnswers() {
		StringBuilder allAnswers = new StringBuilder();
		for(int i = 0; i < 15; i++) {
			allAnswers.append(Integer.toString(i) + ". " + answers[i] + remark[i]);
			allAnswers.append(Html.br(1));
		}
		return Html.div(allAnswers.toString(), "hidden-gatm-details");

	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Html.h(3,"GATM"))
			.append(Html.br(1))
			.append(Html.b("Score: ") + Integer.toString(score))
			.append(Html.br(2))
			.append(Html.button("Details", "toggleDetail('hidden-gatm-details')"))
			.append(Html.br(2))
			.append(dumpAnswers())
			.append(Html.br(1))
			.append("<hr>");
		return builder.toString();

	}
	
}
