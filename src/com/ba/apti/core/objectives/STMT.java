package com.ba.apti.core.objectives;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class STMT {
	
	String [] stmt1;
	String [] stmt2;	
	
	int score1 = 0;
	int score2 = 0;
	
	String [] stmt1Answers = { 
			"football", 
			"workshop", 
			"einstein", 
			"example", 
			"constantinople",
			"alluring",
			"aishwarya",
			"calculations",
			"durga pooja",
			"father-in-law"			
	};
	
	String [] stmt2Answers = {
			"dr. rajendra prasad",
			"93",
			"ranchi",
			"christmas",
			"g"
	};

	boolean [] matched1 = new boolean[10];

	boolean [] matched2 = new boolean[5];


	public STMT(JSONObject fullJson) {
		stmt1 = new String[10];
		stmt2 = new String[5];
		for(int i=1; i <= 5; i++) 
			stmt2[i-1] = fullJson.get("fq"+i).toString();
		for(int i=1; i <= 10; i++)
			stmt1[i-1] = fullJson.get("tw"+i).toString();
	}
	
	public void evaluate() {
		/* stmt1 */
		for(int i = 0; i < stmt1.length; i++)
			score1 += compareAllStmt1(stmt1[i]);
		
		/*stmt2 */
		for(int i = 0; i < stmt2.length; i++)
			score2 += compareAllStmt2(stmt2[i]);
		
	}
	
	private int compareAllStmt2(String answer) {
		answer = answer.toLowerCase();
		for(int i = 0; i < 5; i++) {
			int permissibleDistance = (stmt2Answers[i].length() * 4)/10;
			if(!matched2[i] && StringUtils.getLevenshteinDistance(answer, stmt2Answers[i]) <= permissibleDistance) {
				matched2[i] = true;
				return 1;
			}
		}
		return 0;
	}
	
	private int compareAllStmt1(String answer) {
		answer = answer.toLowerCase();
		for(int i = 0; i < 10; i++) {
			int permissibleDistance = (stmt1Answers[i].length() * 4)/10;
			if(!matched1[i] && StringUtils.getLevenshteinDistance(answer, stmt1Answers[i]) <= permissibleDistance) {
				matched1[i] = true;
				return 1;
			}
		}
		return 0;
	}
	
	
	public String toString() {
		StringBuilder stmt = new StringBuilder();
		stmt.append(Html.h(3, "STMT"));		
		stmt.append(Html.b("Words reproduced: "));	
		for(int i = 0; i < stmt1.length; i++ )
			stmt.append(stmt1[i]  + "&nbsp;&nbsp;");
		stmt.append(Html.br(1));
		stmt.append(Html.b("Words matching: "));
		for(int i = 0; i < stmt1.length; i++) {
			if(matched1[i])
				stmt.append(stmt1Answers[i] + "&nbsp;&nbsp;");
		}
		stmt.append(Html.br(1) + Html.b("Score: ") + Integer.toString(score1));
		
		stmt.append(Html.br(2));
		stmt.append(Html.b("Answers given:"));		
		
		for(int i = 1; i < stmt2.length; i++ )
			stmt.append(stmt2[i] + "&nbsp;&nbsp;");
		stmt.append(Html.br(1));
		stmt.append(Html.b("Answers matching:"));
		for(int i = 0; i < stmt2.length; i++) {
			if(matched2[i])
				stmt.append(stmt2Answers[i] + "&nbsp;&nbsp;");
		}
		stmt.append(Html.br(1) + Html.b("Score: ") + Integer.toString(score2));
		
		
		stmt.append(Html.br(2));
		stmt.append(Html.i("Note: The computer is only able to guess the score for this section. Manual verification needed."));
		stmt.append(Html.br(1));
		stmt.append("<hr>");

		return Html.div(stmt.toString(), "stmt");
	}
	
}

