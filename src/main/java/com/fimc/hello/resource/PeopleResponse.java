package com.fimc.hello.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeopleResponse {
	private String firstName;
	private String lastName;
	private String birthDate;
	
	public boolean isThisDateValid(String birthDate, String dateFromat) {
		
		if(birthDate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		
		try {
			
			//if not valid, it will throw ParseException
			Date date = sdf.parse(birthDate);
			System.out.println(date);
		
		} catch (ParseException e) {
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

}
