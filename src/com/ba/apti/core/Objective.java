package com.ba.apti.core;

import org.json.simple.JSONObject;

import com.ba.apti.core.objectives.BLR;
import com.ba.apti.core.objectives.BM;
import com.ba.apti.core.objectives.DS;
import com.ba.apti.core.objectives.GATCF;
import com.ba.apti.core.objectives.GATL;
import com.ba.apti.core.objectives.GATM;
import com.ba.apti.core.objectives.IE;
import com.ba.apti.core.objectives.STMT;
import com.ba.apti.core.objectives.TIQ;
import com.ba.apti.util.Html;


public class Objective {
	private IE ieAnswers;
	private DS dsAnswers;
	private BM bmAnswers;
	private GATCF gatcfAnswers;
	private STMT stmtAnswers;	
	private TIQ tiqAnswers;
	private GATM gatmAnswers;
	private GATL gatlAnswers;
	private BLR blrAnswers;
	
	public Objective(JSONObject fullJson) {
		
		ieAnswers = new IE(fullJson);
		ieAnswers.evaluate();
		
		dsAnswers = new DS(fullJson);
		dsAnswers.evaluate();
		
		bmAnswers = new BM(fullJson);
		bmAnswers.evaluate();
		
		gatcfAnswers = new GATCF(fullJson);
		gatcfAnswers.evaluate();
		
		stmtAnswers = new STMT(fullJson);
		stmtAnswers.evaluate();
		
		tiqAnswers = new TIQ(fullJson);
		tiqAnswers.evaluate();
		
		gatmAnswers = new GATM(fullJson);
		gatmAnswers.evaluate();
		
		gatlAnswers = new GATL(fullJson);
		gatlAnswers.evaluate();
		
		blrAnswers = new BLR(fullJson);
		blrAnswers.evaluate();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(Html.h(2, "Aptitude"))
				.append(ieAnswers.toString())
			   .append(dsAnswers.toString())
			   .append(bmAnswers.toString())
			   .append(gatcfAnswers.toString())
			   .append(stmtAnswers.toString())
			   .append(tiqAnswers.toString())
			   .append(gatlAnswers.toString())
			   .append(gatmAnswers.toString())
			   .append(blrAnswers.toString());
		return builder.toString();
	}
}








