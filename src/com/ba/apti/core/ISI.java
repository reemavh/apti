package com.ba.apti.core;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class ISI {	
	
	
/*			1, 7, 13, 19, 25,		mechanical 
			2, 8, 14, 20, 26,		medicine
			3, 9, 15, 21, 27,		literary
			4, 10, 16, 22, 28,		finance
			5, 11, 17, 23, 29,		business/marketing
			6, 12, 18, 24, 30		fashion/interiors
*/	
	
	private int [] scores;  //0 = mechanical ... 5 = fashion/interiors
	private int [] answerArray;
	
	public ISI(JSONObject fullJson) {
		answerArray = new int[30];
		scores = new int[6];
		String isi = fullJson.get("isi").toString();
		String [] isiNumbers = isi.split("\\|");
		
		for(int i=0; i < isiNumbers.length; i++) {
			answerArray[Integer.parseInt(isiNumbers[i])-1] = 1;
		}
		evaluate();
	}
	
	private void evaluate() {
		for(int i = 0; i < answerArray.length; i++)
			if( answerArray[i] != 0 )
				scores[i%6]++;
	}
	
	private String dumpAnswers() {
		StringBuilder isiBuilder = new StringBuilder();
		isiBuilder.append(Html.i("Selected options are in bold") + Html.br(2));
		
		//matrix
		StringBuilder rows = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			StringBuilder columns = new StringBuilder();
			for(int j = 0; j < 5; j++) {
				String column = Html.td((
						answerArray[j*6+i] == 1) ? Html.b(new Integer(j*6+i+1).toString()) : new Integer(j*6+i+1).toString());
				columns.append(column);
			}
			rows.append(Html.tr(columns.toString()));
		}
		isiBuilder.append(Html.table(Html.tbody(rows.toString())));
		return Html.div(isiBuilder.toString(), "hidden-isi");
	}
	public String toString() {
		StringBuilder isiBuilder = new StringBuilder();
		isiBuilder.append(Html.h(2, "Interest Inventory"));			
		//scores
		String rowh = Html.tr(Html.th("Profession") + Html.th(("Score")));
		String row1 = Html.tr(Html.td("Mechanical") + Html.td(Integer.toString(scores[0])));
		String row2 = Html.tr(Html.td("Medicine") + Html.td(Integer.toString(scores[1])));
		String row3 = Html.tr(Html.td("Literary") + Html.td(Integer.toString(scores[2])));
		String row4 = Html.tr(Html.td("Finance") + Html.td(Integer.toString(scores[3])));
		String row5 = Html.tr(Html.td("Business/Marketing") + Html.td(Integer.toString(scores[4])));
		String row6 = Html.tr(Html.td("Fashion/Interiors") + Html.td(Integer.toString(scores[5])));
		
		isiBuilder.append(Html.table(Html.thead(rowh) + Html.tbody(row1 + row2 + row3 + row4 + row5 + row6)));
		
		isiBuilder.append(Html.br(1));
		isiBuilder.append(Html.button("Details", "toggleDetail('hidden-isi')"));
		isiBuilder.append(Html.br(2));
		isiBuilder.append(dumpAnswers());
		isiBuilder.append(Html.br(2) + "<hr>");
		return isiBuilder.toString();
	}

}
