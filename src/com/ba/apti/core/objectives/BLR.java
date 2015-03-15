package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class BLR {
	
	static final int ALWAYS = 1;
	static final int OFTEN = 2;
	static final int RARELY = 3;
	static final int NEVER = 4;
	
	private int [] answers;
	private int score;
	
	public BLR(JSONObject fullJson) {
		
		answers = new int[32];
		for(int i=1; i<=32;i++) {
			answers[i-1] = toInt(fullJson.get("blr"+i).toString());
		}
	}
	
	public void evaluate() {
		int na = 0, nb = 0, nc = 0, nd = 0; 
		int [] a = {1,1,1,4,1,4,4,1,4,1,1,4,4,1,4,1,1,4,4,4,1,4,4,1,1,1,4,4,1,4,4,1};
		int [] b = {2,2,2,3,2,3,3,2,3,2,2,3,3,2,3,2,2,3,3,3,2,3,3,2,2,2,3,3,2,3,3,2};
		int [] c = {3,3,3,2,3,2,2,3,2,3,3,2,2,3,2,3,3,2,2,2,3,2,2,3,3,3,2,2,3,2,2,3};
		int [] d = {4,4,4,1,4,1,1,4,1,4,4,1,1,4,1,4,4,1,1,1,4,1,1,4,4,4,1,1,4,1,1,4};

		for(int i = 0; i < 32; i++) {
				 if(answers[i] == a[i]) na++;
			else if(answers[i] == b[i]) nb++;
			else if(answers[i] == c[i]) nc++;
			else if(answers[i] == d[i]) nd++;
		}
		score = 4*na + 3*nb + 2*nc + nd;
	}
	
	private int toInt(String ans) {
		if(ans == "always") return ALWAYS;
		if(ans == "often") return OFTEN;
		if(ans == "sometimes") return RARELY;
		else return NEVER;
	}
	
	private String dumpAnswers() {
		StringBuilder allAnswers = new StringBuilder();
		for(int i = 0; i < 32; i ++ ) {
			String answer = "NONE";			
			switch(answers[i]) {
				case 1:	answer = "ALWAYS";
						break;
				case 2: answer = "OFTEN";
						break;
				case 3: answer = "RARELY";
						break;
				case 4: answer = "NEVER";
						break;
			}			
			allAnswers.append(Integer.toString(i+1) + ". " + answer + Html.br(1));			
		}
		return Html.div(allAnswers.toString(), "blr-details");
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Html.h(3,"BLR"))
			.append(Html.br(1))
			.append(dumpAnswers())
			.append(Html.br(1))
			.append(Html.b("Score: ") + Integer.toString(score))
			.append(Html.br(2));
		return builder.toString();
	}

}