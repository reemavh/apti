package com.ba.apti.core;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class Vocations {
	
	public int [] vocationsAll;
	public String vocation1, vocation2;
	
	int nSelected;	
	int [] scores;
	
	public Vocations(JSONObject fullJson) {
		scores = new int[8];
		vocationsAll = new int [20];
		String [] tokens = fullJson.get("vocAll").toString().split("\\|");
		nSelected = tokens.length-1;
		for(int i = 0; i <nSelected; i++ ) {
			vocationsAll[i] = Integer.parseInt(tokens[i]);
		}
		
		if(fullJson.get("vocTwo").toString().split("\\|").length ==  1)
			vocation1 = fullJson.get("vocTwo").toString().split("\\|")[0];
		if(fullJson.get("vocTwo").toString().split("\\|").length ==  2)
			vocation2 = fullJson.get("vocTwo").toString().split("\\|")[1];
		
		System.out.println("vocation1 = " + vocation1);
		System.out.println("vocation2 = " + vocation2);
		evaluate();
	}
	
	private int [] groups = {
		1,2,3,3,8,2,2,1,3,3,3,
		3,1,4,1,8,8,6,5,8,4,8,
		2,8,4,1,6,3,7,3,5,5,5,
		1,6,8,7,4,2,3,7,7,5,2,
		3,1,3,2,4,1,8,7,6,5,2,
		7,8,1,7,6,4,1,6,6,8,8,
		7,1,4,4,4,2,2,8,6,5,8,
		3,5,5,5,6,8,4,6,3,7,7,
		7,6,8,4,4,5,1,1,4,5,4,
		7,1,6,7,2,2,7,8,2,2,5,
		5,6
	};

	public void evaluate() {
		for (int i = 0; i < nSelected; i++ )
			scores[groups[vocationsAll[i]-1]-1]++;	
	}
	
	private String dumpAnswers() {
		StringBuilder vocations = new StringBuilder();
		vocations.append(Html.b("Vocations chosen") + Html.br(2));
		for(int i = 0; i < nSelected; i++) 
			vocations.append(professions[vocationsAll[i]] + Html.br(1));		
		return Html.div(vocations.toString(), "hidden-vocations");
	}
	public String toString() {
		StringBuilder vocations = new StringBuilder();
		vocations.append(Html.h(2, "Vocation Test"));
		vocations.append(Html.b("Vocations chosen by category") + Html.br(1));
		String row1 = Html.tr(Html.td("Finance") + Html.td(Integer.toString(scores[0])));
		String row2 = Html.tr(Html.td("Entertainment") + Html.td(Integer.toString(scores[1])));
		String row3 = Html.tr(Html.td("Adnventure") + Html.td(Integer.toString(scores[2])));
		String row4 = Html.tr(Html.td("Science & Engineering") + Html.td(Integer.toString(scores[3])));
		String row5 = Html.tr(Html.td("Medical & Life Sciences") + Html.td(Integer.toString(scores[4])));
		String row6 = Html.tr(Html.td("Humanities") + Html.td(Integer.toString(scores[5])));
		String row7 = Html.tr(Html.td("Management") + Html.td(Integer.toString(scores[6])));
		String row8 = Html.tr(Html.td("Administration") + Html.td(Integer.toString(scores[7])));
		vocations.append(Html.table(row1+row2+row3+row4+row5+row6+row7+row8));		
		vocations.append(Html.br(1));
		vocations.append(Html.button("Details", "toggleDetail('hidden-vocations')"));
		vocations.append(Html.br(2));
		vocations.append(dumpAnswers());
		vocations.append(Html.br(2));
		vocations.append(Html.b("Two top preferences chosen") + Html.br(1));
		vocations.append(vocation1 + Html.br(1));
		if(vocation2 != null)
			vocations.append(vocation2 + Html.br(1));
		vocations.append(Html.br(2) + "<hr>");
		return vocations.toString();
	}
	
	private String [] professions = {
					   "Accountant/ C.A.",
	                   "Advertising Work",
	                   "Aerial Photographer",
	                   "Air Hostess/ Steward",
	                   "Air traffic Controller",
	                   "Airlines executive",
	                   "Anchoring/ RJ/ DJ",
	                   "Appraiser / valuer",
	                   "Archaeologist",
	                   "Army Officer",
	                   "Astronaut",
	                   "Athletics coach",
	                   "Banker",
	                   "Biotechnologist",
	                   "Budget/Finance planner",
	                   "Business consultant",
	                   "Cartoonist/animator",
	                   "CBI/Intelligence Officer",
	                   "Child Counselor",
	                   "City Planner",
	                   "Civil Engineer",
	                   "Commander",
	                   "Commercial Photographer",
	                   "Company director",
	                   "Computer Engineer",
	                   "Cost & Works accountant",
	                   "Counselor/psychologist",
	                   "Crime Reporter",
	                   "Department Store/Mall Manager",
	                   "Detective/ Investigator",
	                   "Disease Research work",
	                   "Doctor/ Para-medical",
	                   "Dog/Animal Breeder",
	                   "Economist",
	                   "Editor/journalist",
	                   "Education manager",
	                   "Entrepreneur",
	                   "Environment Specialist",
	                   "Event manager",
	                   "Explorer",
	                   "Facilities manager",
	                   "Factory Manager",
	                   "Farmer/ agriculturist",
	                   "Fashion Designer",
	                   "Fighter Pilot",
	                   "Finance manager",
	                   "Fire fighter",
	                   "Film/ theater Director",
	                   "Food Analyst",
	                   "Foreign exchange Specialist",
	                   "Foreign Service Officer",
	                   "Franchise developer",
	                   "Historian or Museum Mgr",
	                   "Hospital Administrator",
	                   "Hotel Manager",
	                   "HRD Manager",
	                   "IAS/KAS officer",
	                   "Insurance expert",
	                   "International Trade",
	                   "Interpreter/Translator",
	                   "Inventor or product developer",
	                   "Investment Banker",
	                   "Labor Welfare Officer",
	                   "Lawyer/ legal expert",
	                   "Librarian",
	                   "Logistics/supply officer",
	                   "Marketing Professional",
	                   "Mathematician",
	                   "Mechanical Engineer",
	                   "Meteorologist",
	                   "Microbiologist",
	                   "Model/Actor",
	                   "Music composer",
	                   "NGO manager",
	                   "Social worker",
	                   "Nutrition/ dietician",
	                   "Office manager",
	                   "Officer of a ship",
	                   "Pediatrician",
	                   "Pharmacist/drug mfr",
	                   "Plant specialist",
	                   "Political analyst",
	                   "Politician",
	                   "Pollution control Expert",
	                   "Portal/webpage manager",
	                   "Professional Car racing",
	                   "Projects developer",
	                   "Public Speaker",
	                   "Real Estate Developer",
	                   "Religious Leader",
	                   "Rural development mgr",
	                   "Scientific research",
	                   "Soil Scientist",
	                   "Speech therapist",
	                   "Statistician/ economist",
	                   "Stock/investments ",
	                   "Structural Engineer",
	                   "Surgeon",
	                   "Systems analyst",
	                   "Systems manager",
	                   "Tax consultant",
	                   "Teacher/educationist",
	                   "Team leader",
	                   "Theatre Set Designer",
	                   "Tourism guide",
	                   "Trader/ dealer",
	                   "Training Administrator",
	                   "Travel agent/Executive",
	                   "TV Script writer",
	                   "Veterinarian",
	                   "Wild life Specialist",
	                   "Writer/ publisher"
	};

}
