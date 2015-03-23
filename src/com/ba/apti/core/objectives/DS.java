package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

//code duplication
public class DS {	
	int [] yesNo;
	int dCount;
	public DS(JSONObject fullJson) {
		dCount = 0;
		yesNo = new int[20];
		for(int i=1; i<=20;i++) {
			if(fullJson.get("ds"+i).toString().equals("yes"))
				yesNo[i-1] = 1;			
		}
	}
	
	public void evaluate() {		
		int [] theDVector = {0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,1};
		
		for(int i=0; i < 20; i++) {
			if(theDVector[i] == yesNo[i])
				dCount++;
		}
	}
	
	private String dumpAnswers() {
		StringBuilder answers = new StringBuilder();
		for(int i = 0; i < 20; i++) {			
			String answer = (yesNo[i] == 1)? "Yes" : "No";
			String extra = i < 9 ? "&nbsp;":"";
			answers.append(Integer.toString(i+1) + ".&nbsp;"+ extra + answer + Html.br(1));
		}
		return Html.div(answers.toString(), "hidden-ds-detail");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(Html.h(3,"DS"));		
		builder.append(Html.b("D score: ") + dCount);
		builder.append(Html.br(1));
		builder.append(Html.b("S score: ") + (20-dCount));
		builder.append(Html.br(2));
		builder.append(Html.button("Details", "toggleDetail('hidden-ds-detail')"));
		builder.append(Html.br(2));
		builder.append(dumpAnswers());
		builder.append(Html.br(1));
		builder.append("<hr>");
		return builder.toString();
	}
	
}
