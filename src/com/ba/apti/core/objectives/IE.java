package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class IE {
	
	int [] yesNo;
	int nIntrovert;
	
	public IE(JSONObject fullJson) {
		nIntrovert = 0;
		yesNo = new int[20];
		for(int i=0; i<20;i++) {
			if(fullJson.get("ie"+(i+1)).toString().equals("yes"))							
				yesNo[i] = 1;									
		}
	}
	
	public void evaluate() {		
		int [] introvertVector = {0,0,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1};

		for(int i = 0; i < 20; i++) {
			 if(yesNo[i] == introvertVector[i])
				 nIntrovert++;
		 }
	}
	
	private String dumpAnswers() {
		StringBuilder answers = new StringBuilder();
		for(int i = 0; i < 20; i++) {
			String answer;
			if(i == 10) {
				answer = (yesNo[i] == 1)? "Man" : "Society";					
			}
			else
				answer = (yesNo[i] == 1)? "Yes" : "No";
			String extra = i < 9? "&nbsp;":"";
			answers.append(Integer.toString(i+1) + ".&nbsp;" + extra + answer + Html.br(1));
		}
		return Html.div(answers.toString(), "hidden-ie-detail");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Html.h(3,"IE"));
		builder.append(Html.b("Introvert score: ") + nIntrovert );
		builder.append(Html.br(1));
		builder.append(Html.b("Extrovert score: ") + (20 - nIntrovert) );
		builder.append(Html.br(2));
		builder.append(Html.button("Details", "toggleDetail('hidden-ie-detail')"));
		builder.append(Html.br(2));
		builder.append(dumpAnswers());	
		builder.append(Html.br(1));
		builder.append("<hr>");
		return builder.toString();
	}
}
