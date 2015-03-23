package com.ba.apti.core.objectives;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class GATCF {
	
	double score,uscore;
	int [] numberCounts;
	int wordCount;
	int [] numberCountsUntimed;
	int wordCountUntimed;
	int gatfTime; 
	int gatfWCTime;
	String [] remarks = new String[8];
	
	private String dumpAnswers1() {
		int [] keys = {236,519,860,423,156,610,549};
		int [] answerVector = {9,12,9,10,4,0,12};
		
		int wc = 24;
		
		StringBuilder builder = new StringBuilder();
		builder.append(Html.br(1));
		
		String rowHeader = Html.thead(Html.tr(Html.th("Search for") + 
						Html.th("Answer") +
						Html.th("Actual no. of occurrences") + 
						Html.th(Html.b("Marks"))));
		
		String [] rows = new String[7];
		for(int i = 0; i < 7; i++) {
			rows[i] = Html.tr(Html.td(Integer.toString(keys[i]))
					+ Html.td(Integer.toString(numberCounts[i]))
					+ Html.td(Integer.toString(answerVector[i]))
					+ Html.td(remarks[i]));	
		}
		
		String wordRow = Html.tr(Html.td("is")
				+ Html.td(Integer.toString(wordCount))
				+ Html.td(Integer.toString(wc))
				+ Html.td(remarks[7]));
		builder.append(Html.table(rowHeader + Html.tbody(rows[0] + rows[1] + rows[2] + rows[3]
				+rows[4] + rows[5] + rows[6]) + wordRow));
		
		return Html.div(builder.toString(),"hidden-gatcf-timed");
	}
	
	private String dumpAnswers2() {
		int [] keys = {143,240,432,550,611,325,444};
		int [] answerVector = {1,10,9,29,10,0,9,30};
		
		int wc = 30;
		
		StringBuilder builder = new StringBuilder();
		builder.append(Html.b("Timed version") + Html.br(1));
		
		String rowHeader = Html.thead(Html.tr(Html.th("Search for") + 
						Html.th("Answer") +
						Html.th("Actual no. of occurrences"))); 

		String [] rows = new String[8];
		for(int i = 0; i < 7; i++) {
			rows[i] = Html.tr(Html.td(Integer.toString(keys[i]))
					+ Html.td(Integer.toString(numberCounts[i]))
					+ Html.td(Integer.toString(answerVector[i])));			
		}
		
		String wordRow = Html.tr(Html.td("is")
				+ Html.td(Integer.toString(wordCount))
				+ Html.td(Integer.toString(wc)));
		
		builder.append(Html.table(rowHeader + Html.tbody(rows[0] + rows[1] + rows[2] + rows[3]
				+rows[4] + rows[5] + rows[6]) + wordRow));
		
		return Html.div(builder.toString(),"hidden-gatcf-untimed");
	}

	
	public String toString() {		
		StringBuilder gatcf = new StringBuilder();
		gatcf.append(Html.h(3,"GAT-C&F"));
		gatcf.append(Html.b("Timed version score: ") + Double.toString(score));
		gatcf.append(Html.br(2));
		gatcf.append(Html.button("Details", "toggleDetail('hidden-gatcf-timed')"));
		gatcf.append(Html.br(2));
		gatcf.append(dumpAnswers1() + Html.br(1));
		
		gatcf.append(Html.b("Untimed version score: ") + Double.toString(uscore));	
		gatcf.append(Html.br(1));
		gatcf.append("Time taken(numbers): " + Integer.toString(gatfTime));
		gatcf.append(Html.br(1));
		gatcf.append("Time taken(\"is\"): " + Integer.toString(gatfWCTime));
		gatcf.append(Html.br(2));
		gatcf.append(Html.button("Details", "toggleDetail('hidden-gatcf-untimed')"));
		gatcf.append(Html.br(2));
		gatcf.append(dumpAnswers2() + Html.br(1));
		gatcf.append("<hr>");
		return gatcf.toString();		
	}
	
	public GATCF(JSONObject fullJson) {
		numberCounts = new int[7];
		numberCountsUntimed = new int[7];
		score = 0;
		wordCount = Integer.parseInt(fullJson.get("gatc1wc").toString());
		wordCountUntimed = Integer.parseInt(fullJson.get("gatf1wc").toString());
		
		for(int i=1;i<=7;i++) { 
			numberCounts[i-1] = Integer.parseInt(fullJson.get("gatc"+i).toString());
			numberCountsUntimed[i-1] = Integer.parseInt(fullJson.get("gatf"+i).toString());
		}
		
		gatfTime = Integer.parseInt(fullJson.get("gatfTime").toString());
		gatfWCTime = Integer.parseInt(fullJson.get("gatfwcTime").toString());
		
	}
	
	public void evaluate() {
		
		int [] answerVector = {9,12,9,10,4,0,12};
		int [] answerVectorUntimed = {1,10,9,29,10,0,9};
		int wc = 24;
		int wcUntimed = 30;
		
		remarks[7] = "0";
		if(wordCount == wc) {
			score += 1.0;
			remarks[7] = "(+1)";
		}
			
		else if(Math.abs(wordCount-wc) == 1) {
			score += 0.5;
			remarks[7] = "(+0.5)";
		}
		
		for(int i = 0; i < answerVector.length; i++) {
			remarks[i] = "0";
			if(answerVector[i] == numberCounts[i]) { 
				score += 1.0;
				remarks[i] = "(+1)";
			}
			else if(Math.abs(answerVector[i]-numberCounts[i]) == 1) { 
				score += 0.5;
				remarks[i] = "(+0.5)";
			}
		}
		
		if(wcUntimed == wordCountUntimed)
			uscore += 1.0;
		
		for(int i = 0; i < 7; i++) {
			if(answerVectorUntimed[i] == numberCountsUntimed[i])
				uscore += 1.0;
		}
	}	
}
