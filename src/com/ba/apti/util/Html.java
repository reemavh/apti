package com.ba.apti.util;



public class Html {
	
	public static String table(String content) {
		return "<table>" + content + "</table>";				
	}
	
	public static String tr(String content) {
		return "<tr>" + content + "</tr>";
	}
	
	public static String td(String content) {
		return "<td>" + content + "</td>";
	}
	
	public static String br(int number) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<number;i++) {
			builder.append("<br>");
		}
		return builder.toString();		
	}
	
	public static String p(String content) {
		return "<p>" + content + "</p>";
	}
	
	public static String b(String content) {
		return "<b>" + content + "</b>";
	}
	
	public static String i(String content) {
		return "<i>" + content + "</i>";
	}
	
	public static String label(String content) {
		return "<label>" + content + "</label>";
	}

	public static String body(String content) {
		return "<body>" + content + "</body>";		
	}
	
	public static String html(String content) {
		return "<html>" + content + "</html>";
	}
	
	public static String h(int n, String content) {
		String hn = "<" + "h" + n + ">";
		String en = "<" + "/h" + n + ">"; 
		return hn + content + en;
	}
	
	public static String div(String content, String id) {
		if(id == "")
			return "<div>" + content + "</div>";
		if(id.startsWith("hidden"))
			return "<div id=\"" + id + "\" style=\"display:none\">" + content + "</div>";
		return "<div id=\"" + id + "\">" + content + "</div>";
	}
	
	public static String emsp() {
		return "&emsp;";
	}
}
