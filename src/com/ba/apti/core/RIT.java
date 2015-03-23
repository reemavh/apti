package com.ba.apti.core;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class RIT {
	
	private int [] rit;
	private String foodHow = null;
	private String backHow = null;
	private String placeHow = null;
	private String otherActivity;
	
	public RIT(JSONObject fullJson) {
		rit = new int[10];
		
		for(int i=1; i<=10; i++) {
			rit[i-1] = Integer.parseInt(fullJson.get("rit"+i).toString());			
		}
		
		if(rit[0] == 3 || rit[0] == 2) {
			placeHow  = fullJson.get("place_how").toString();
		}
		
		if(rit[1] == 3 || rit[1] == 2 ) {
			foodHow = fullJson.get("food_how").toString();		
		}
		
		if(rit[2] == 3 || rit[2] == 2) {
			backHow = fullJson.get("civ_how").toString();
		}
		
		otherActivity = fullJson.get("rit_other").toString();
	}

	public String toString() {
		StringBuilder ritBuilder = new StringBuilder();
		ritBuilder.append(Html.h(2, "RIT 5"));		
		ritBuilder.append(Html.br(1));
		String header = Html.thead(Html.tr((Html.th("Option") + Html.th("Priority") + Html.th("Details"))));
		StringBuilder rows = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			String column1 = Html.td(options[i]);	
			String column2 = Html.td(priorities[rit[i]]);
			String column3 = Html.td("Not applicable");
			if(i==0 && placeHow!= null)
				column3 = Html.td(placeHow);
			if(i==1 && foodHow!= null)
				column3 = Html.td(foodHow);
			if(i==2 && backHow!= null)
				column3 = Html.td(backHow);
			rows.append(Html.tr(column1+column2+column3));
		}
		ritBuilder.append(Html.table(header+Html.tbody(rows.toString())));
		
		ritBuilder.append(Html.br(1));
		ritBuilder.append(Html.b("Top priority task identified"));
		ritBuilder.append(Html.br(1));
		ritBuilder.append(options[rit[9]] + Html.br(2));

		ritBuilder.append(Html.b("Other options to explore"));
		ritBuilder.append(Html.br(1));
		ritBuilder.append(otherActivity + Html.br(2));
		return ritBuilder.toString();
	}

	                    
	String [] priorities = {
			"Won't do",
			"Low priority",
			"Moderate priority",
			"High priority"
	};
	
	String [] options = {
			"Find a secure place for your safety",
			"Look for food and water",
			"Find out ways to get back to civilization",
			"Say prayers",
			"Think deeply about why you landed up there in the first place",
			"Build a shelter, a raft or a lookout tower",
			"Use your mobile phone or laptop to ask for help",
			"Relax, put your thoughts in order and start planning on what to do",
			"Break down and cry, curse your fate and wait for death",
			"Out of the nine options above, which would be the top priority for you?"
		};

}
