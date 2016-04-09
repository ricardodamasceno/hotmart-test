package com.br.hotmart.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FileUtils {

	public static List<String> GET_DATA_FROM_FILE(String filePath) throws IOException{
		
		List<String> listString = new ArrayList<String>();
		BufferedReader buffered = new BufferedReader(new FileReader(filePath));				
		String line = buffered.readLine();		
		
		while(line != null){
			if(!line.equals("")){
				listString.add(line);
			}			
			line = buffered.readLine();
		}			
		return listString;
	}
	
	public static Calendar STRING_TO_DATE(String dateString) throws ParseException{
		
		Date dateAux = new Date();
		Calendar date = Calendar.getInstance();
		
		dateString = dateString.trim();
		
		String dia = dateString.substring(0, 2);
		String mes = dateString.substring(2, 5);
		String ano = dateString.substring(5, 9);
		
		//recebe o numero do mês
		mes = GET_MONTH_NUMBER(mes);
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		dateAux = (Date)formatter.parse(dia+"/"+mes+"/"+ano);
		
		date.setTime(dateAux);
		
		return date;		
	}
	
	public static String GET_MONTH_NUMBER(String monthName){
		
		String monthNumber = "";
		
		if(monthName.equals(Consts.JANEIRO)){
			monthNumber = "01";
		}else if(monthName.equals(Consts.FEVEREIRO)){
			monthNumber = "02";
		}else if(monthName.equals(Consts.MARCO)){
			monthNumber = "03";
		}else if(monthName.equals(Consts.ABRIL)){
			monthNumber = "04";
		}else if(monthName.equals(Consts.MAIO)){
			monthNumber = "05";
		}else if(monthName.equals(Consts.JUNHO)){
			monthNumber = "06";
		}else if(monthName.equals(Consts.JULHO)){
			monthNumber = "07";
		}else if(monthName.equals(Consts.AGOSTO)){
			monthNumber = "08";
		}else if(monthName.equals(Consts.SETEMBRO)){
			monthNumber = "09";
		}else if(monthName.equals(Consts.OUTUBRO)){
			monthNumber = "10";
		}else if(monthName.equals(Consts.NOVEMBRO)){
			monthNumber = "11";
		}else if(monthName.equals(Consts.DEZEMBRO)){
			monthNumber = "12";
		}
		return monthNumber;
	}
}
