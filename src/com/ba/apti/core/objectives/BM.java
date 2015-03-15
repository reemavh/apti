package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class BM {
	
	static final int ALWAYS = 1;
	static final int MOSTLY = 2;
	static final int SOMETIMES = 3;
	static final int VERY_RARELY = 4;
	
	int [] answers;
	double score;
	
	public BM(JSONObject fullJson) {
		score = 0.0;
		answers = new int[25];
		for(int i=1; i<=25;i++) {
			answers[i-1] = toInt(fullJson.get("bm"+i).toString());
		}
	}
	
	public void evaluate() {
		int [] bmMatrix = {
				4,4,1,1,4,1,4,4,1,4,1,4,4,4,1,1,1,1,4,1,4,4,1,1,1,
				3,3,2,2,3,2,3,3,2,3,2,3,3,3,2,2,2,2,3,2,3,3,2,2,2,
				2,2,3,3,2,3,2,2,3,2,3,2,2,2,3,3,3,3,2,3,2,2,3,3,3,
				1,1,4,4,1,4,1,1,4,1,4,1,1,1,4,4,4,4,1,4,1,1,4,4,4,
		};
		
		for(int i=0;i<25;i++) {
			int column = i;
			int row = answers[i]-1;
			score += bmMatrix[row * 25 + column];
		}
		
		score = score * 3/4;
	}
	
	private int toInt(String ans) {
		if(ans == "always") return ALWAYS;
		if(ans == "mostly") return MOSTLY;
		if(ans == "sometimes") return SOMETIMES;
		else return VERY_RARELY;
	}
	
	private String dumpAnswers() {
		StringBuilder allAnswers = new StringBuilder();
		for(int i = 0; i < 25; i ++ ) {
			String answer = "NONE";			
			switch(answers[i]) {
				case 1:	answer = "ALWAYS";
						break;
				case 2: answer = "MOSTLY";
						break;
				case 3: answer = "SOMETIMES";
						break;
				case 4: answer = "VERY RARELY";
						break;
			}			
			allAnswers.append(Integer.toString(i+1) + ". " + answer + Html.br(1));			
		}
		return Html.div(allAnswers.toString(), "bm-details");
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Html.h(3,"DS"))
			.append(Html.br(1))
			.append(dumpAnswers())
			.append(Html.br(1))
			.append(Html.b("Score: ") + Double.toString(score))
			.append(Html.br(2));
		return builder.toString();
	}
	
}