package com.ba.apti.core;

import org.json.simple.JSONObject;

import com.ba.apti.util.Html;

public class ContactInfo {
	
	private String title;	
	private String name;
	private String dateOfBirth;
	private String email;
	private String phone1;
	private String phone2;
	private String address;
	
	public ContactInfo(JSONObject fullJson) {		
		title = fullJson.get("title").toString();
		name = fullJson.get("name").toString();
		email = fullJson.get("email").toString();
		phone1 = fullJson.get("ph1").toString();
		phone2 = fullJson.get("ph2").toString();
		dateOfBirth = fullJson.get("date_birth").toString() 
					+ "-" + fullJson.get("month_birth").toString() 
					+ "-" + fullJson.get("year_birth").toString();
		address = fullJson.get("address").toString();
	}

	
	public String getName() {
		return name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}
	
	public String toString() {
		String header = Html.h(2, "Contact Information")+ Html.br(1);;
		String name = Html.b("Name: ") + (title + ". " + this.name) + Html.br(1);
		String email = Html.b("Email: ") + this.email + Html.br(1);;
		String phone = Html.b("Phone: ") + this.phone1 + " " + this.phone2 + Html.br(1);;
		String dateOfBirth = Html.b("Date of birth: ") + this.dateOfBirth+ Html.br(1);;
		String address = Html.b("Address: ") + this.address+ Html.br(1);;
		
		
		return new StringBuilder().append(header)			
					.append(name)
					.append(email)
					.append(phone)
					.append(dateOfBirth)
					.append(address).toString();
	}
}
