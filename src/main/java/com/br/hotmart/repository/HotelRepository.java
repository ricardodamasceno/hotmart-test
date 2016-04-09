package com.br.hotmart.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.br.hotmart.model.Hotel;
import com.br.hotmart.util.Consts;
import com.br.hotmart.util.FileUtils;

public class HotelRepository {

	public List<Hotel> findAll() throws IOException{
		
		List<Hotel> hoteis = new ArrayList<Hotel>();
		
		//Recebe todas as linhas do arquivo
		//Cada linha é colocada em uma string
		List<String> rowsFromFile = FileUtils.GET_DATA_FROM_FILE(Consts.HOTMART_HOTEIS_FILE);
		
		for(String row:rowsFromFile){
			//separa os atributos do hotel
			String [] hotelSplitted = row.split(",");
			
			//Monta o objeto Hotel
			Hotel hotel = new Hotel();
			for(int i=0;i<hotelSplitted.length;i++){
				String [] attribute = hotelSplitted[i].split(":");
				
				if(i==0){
					hotel.setNome(attribute[1]);
				}else if(i == 1){
					hotel.setEstrelas(Integer.parseInt(attribute[1]));
				}else if(i == 2){
					hotel.setDiariaSemana(Double.parseDouble(attribute[1]));
				}else if(i == 3){
					hotel.setDiariaFimSemana(Double.parseDouble(attribute[1]));
				}else if(i == 4){
					hotel.setDiariaSemanaVip(Double.parseDouble(attribute[1]));
				}else if(i == 5){
					hotel.setDiariaFimSemanaVip(Double.parseDouble(attribute[1]));
				}				
			}
			hoteis.add(hotel);				
		}		
		
		return hoteis;
	}
	
}
