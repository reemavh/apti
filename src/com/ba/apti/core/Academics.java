package com.ba.apti.core;

import java.util.HashMap;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class Academics {

	private SchoolYear stdIX;
	
	private SchoolYear stdX;
	
	private SchoolYear stdXI;
	
	private SchoolYear stdXII;
	
	private HigherStudies higherStudies;
	
	private CompetitiveExams compExams;
	
	public String toString() {
		String header = Html.h(2, "Academics");
		StringBuilder section = new StringBuilder();
		section.append(Html.br(2));
		section.append(header);
		section.append(stdIX.toString() + stdX.toString() + stdXI.toString()
				 + stdXII.toString() + higherStudies.toString() + compExams.toString());
		section.append(Html.br(3) + "<hr>");
		return section.toString();
	}
	
	public Academics(JSONObject fullJson) {
		stdIX = new SchoolYear(fullJson, "9");
		stdX = new SchoolYear(fullJson,"X");
		stdXI = new SchoolYear(fullJson, "XI");
		stdXII = new SchoolYear(fullJson, "XII");
		
		higherStudies = new HigherStudies();
		higherStudies.getHigherStudiesInfo(fullJson);
		
		compExams = new CompetitiveExams();
		compExams.getCompetitiveExamsInfo(fullJson);
	}
		
}

class SchoolYear {
	
	String academicYear;
	String schoolName;
	String board;
	String yearOfPassing;
	HashMap<String,String> marksMap;
	private boolean notAttended = false;
	
	public String toString() {
		
		StringBuilder section = new StringBuilder();
		section.append(Html.h(4, "Standard " + academicYear));	
		if(notAttended) {
			section.append("Yet to attend standard " + academicYear + "<br><br>");
			return section.toString();
		}
		section.append(Html.b("Name of school: "))
			.append(schoolName)
			.append(Html.br(1))
			.append(Html.b("Board: "))
			.append(board)
			.append(Html.br(1))
			.append(Html.b("Year: "))
			.append(yearOfPassing)
			.append(Html.br(1));
		section.append(Html.b("Scores")).append(Html.br(1));
		
		StringBuilder nameRow = new StringBuilder();
		for(String subject : marksMap.keySet())
			if(!subject.equals("Enter subject name"))
				nameRow.append(Html.th(subject.toLowerCase()) + Html.emsp());
		
		StringBuilder marksRow = new StringBuilder();
		for(String marks : marksMap.values())
			if(!marks.isEmpty())				
				marksRow.append(Html.td(marks));
		
		String table = Html.table(Html.thead(Html.tr(nameRow.toString())) + Html.tbody(Html.tr(marksRow.toString())));
		section.append(table);
		section.append(Html.br(1));
		return Html.div(section.toString(), "");
	}
	
	public SchoolYear(JSONObject fullJson, String yearPrefix) {
		academicYear = yearPrefix == "9" ? "IX" : yearPrefix;
		if(fullJson.get("school" + yearPrefix) == null) {
			notAttended = true;
			return;
		}
		this.schoolName = fullJson.get("school" + yearPrefix).toString();		
		this.board = fullJson.get("board"+yearPrefix).toString();
		this.yearOfPassing = fullJson.get("year"+yearPrefix).toString();
		marksMap = new HashMap<String,String>();
		if(yearPrefix.equals("9") || yearPrefix.equals("X")) {
			String [] subjects = {"english", "hindi", "kannada", "math", "science", "social"};		
			for(String subject : subjects) {
				marksMap.put(subject, fullJson.get(subject+yearPrefix).toString());
			}
			marksMap.put(fullJson.get("othern1"+yearPrefix).toString(), 
					fullJson.get("other1"+yearPrefix).toString());
			marksMap.put(fullJson.get("othern2"+yearPrefix).toString(), 
					fullJson.get("other2"+yearPrefix).toString());
		}
		
		else {
			String [] subjects = {"english", "hindi", "kannada"};
			for(String subject : subjects) {
				marksMap.put(subject, fullJson.get(subject+yearPrefix).toString());
			}
			marksMap.put(fullJson.get("othern1"+yearPrefix).toString(), 
					fullJson.get("other1"+yearPrefix).toString());
			marksMap.put(fullJson.get("othern2"+yearPrefix).toString(), 
					fullJson.get("other2"+yearPrefix).toString());
			marksMap.put(fullJson.get("othern3"+yearPrefix).toString(), 
					fullJson.get("other3"+yearPrefix).toString());
			marksMap.put(fullJson.get("othern4"+yearPrefix).toString(), 
					fullJson.get("other4"+yearPrefix).toString());						
		}
		
	}
			
}

class HigherStudies {
	String collegeName;
	String courseName;
	String [] yearStart;
	String [] yearEnd;
	String [] percentage;
	String comments;
	boolean notAttended = false;
	
	public String toString() {
		StringBuilder section = new StringBuilder();
		String sectionHeader = Html.h(4, "Higher Education");
		if(notAttended) {
			return sectionHeader + "I haven't pursued higher eduction yet <br><br>";
		}
		String college = Html.b("College Name: ") + collegeName;
		String course =  Html.b("CourseName: ") + courseName;
		
		String namesRow = Html.tr(Html.th("Started In")
				 + Html.th("Completed In")
				 +Html.th("Total Percentage Marks"));
		String year1 = Html.tr(Html.td(yearStart[0]) + Html.td(yearEnd[0]) + Html.td(percentage[0]));
		String year2 = Html.tr(Html.td(yearStart[1]) + Html.td(yearEnd[1]) + Html.td(percentage[1]));
		String year3 = Html.tr(Html.td(yearStart[2]) + Html.td(yearEnd[2]) + Html.td(percentage[2]));
		String year4 = Html.tr(Html.td(yearStart[3]) + Html.td(yearEnd[3]) + Html.td(percentage[3]));
		
		String otherComments = Html.p(comments);
		
		section.append(sectionHeader)
		.append(college)
		.append(Html.br(1))
		.append(course)
		.append(Html.br(2))
		.append(Html.table(Html.thead(namesRow)
				+ Html.tbody(year1 + year2 + year3 + year4)))
		.append(Html.br(1))
		.append(Html.b("Comments: ") + otherComments)
		.append(Html.br(1));
		
		return Html.div(section.toString(),"");
	}
	
	public HigherStudies() {
		yearStart = new String[4];
		yearEnd = new String[4];
		percentage = new String[4];				
	}
	
	public void getHigherStudiesInfo(JSONObject fullJson) {
		if(fullJson.get("gradCollege") == null) {
			notAttended = true;
			return;
		}
		collegeName = fullJson.get("gradCollege").toString();
		courseName = fullJson.get("gradCourse").toString();
		comments = fullJson.get("hcomments").toString();
		
		for(int i = 1; i < 4; i++) {				
			yearStart[i-1] = fullJson.get("grad" + i + "s").toString();
			yearEnd[i-1] = fullJson.get("grad" + i + "e").toString();
			percentage[i-1] = fullJson.get("grad" + i + "p").toString();			
		}
		
	}
}

class CompetitiveExams {
	String [] examNames;
	String [] years;
	String [] ranks;
	boolean notAttended;
	
	public String toString() {
		String row1 = "", row2 = "", row3 = "", row4 = "", row5 = "";
		String header = Html.h(4, "Competitive Exams");
		if(notAttended) {
			return header + "I haven't attended any yet <br><br>";
		}
		String headerRow = Html.tr(Html.th("Examination name")
				+ Html.th("Year")
				+ Html.th("Rank"));
		if(!examNames[0].isEmpty())
			 row1 = Html.tr(Html.td(examNames[0]) + Html.td(years[0]) + Html.td(ranks[0]));
		if(!examNames[1].isEmpty())
			 row2 = Html.tr(Html.td(examNames[1]) + Html.td(years[1]) + Html.td(ranks[1]));
		if(!examNames[2].isEmpty())
			 row3 = Html.tr(Html.td(examNames[2]) + Html.td(years[2]) + Html.td(ranks[2]));
		if(!examNames[3].isEmpty())
			 row4 = Html.tr(Html.td(examNames[3]) + Html.td(years[3]) + Html.td(ranks[3]));
		if(!examNames[4].isEmpty())
			 row5 = Html.tr(Html.td(examNames[4]) + Html.td(years[4]) + Html.td(ranks[4]));
		
		StringBuilder section = new StringBuilder();
		section.append(header)
			.append(Html.br(1))
			.append(Html.table(Html.thead(headerRow) + Html.tbody(row1 + row2 + row3 + row4 + row5)))
			.append(Html.br(1));
		
		return Html.div(section.toString(),"");
	}
	
	public CompetitiveExams() {
		examNames = new String[5];
		years = new String[5];
		ranks = new String[5];
	}
	
	public void getCompetitiveExamsInfo(JSONObject fullJson) {
		if (fullJson.get("comp1") == null 
				&& fullJson.get("comp2") == null
				&& fullJson.get("comp4") == null 
				&& fullJson.get("comp3") == null
				&& fullJson.get("comp5") == null) {
					notAttended = true;
					return;
				}
			
		for(int i = 0; i < 5; i++) {
			examNames[i] = fullJson.get("comp"+(i+1)).toString();
			years[i] = fullJson.get("cy"+(i+1)).toString();
			ranks[i] = fullJson.get("ry"+(i+1)).toString();
		}
	}
}