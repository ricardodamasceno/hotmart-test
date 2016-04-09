package com.br.hotmart.repository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.br.hotmart.model.ReservaHotel;
import com.br.hotmart.util.Consts;
import com.br.hotmart.util.FileUtils;

public class ReservaHotelRepository {

	public List<ReservaHotel> findAll() throws IOException, ParseException{
		
		List<ReservaHotel> reservas = new ArrayList<ReservaHotel>();
		
		//Recebe todas as linhas do arquivo
		//Cada linha é colocada em uma string
		List<String> rowsFromFile = FileUtils.GET_DATA_FROM_FILE(Consts.HOTMART_DATA_FILE);
		
		for(String row:rowsFromFile){
			
			ReservaHotel reservaHotel = new ReservaHotel();
			
			//Monta o objeto da reserva
			String [] reservaSplitted = row.split(":");		
			reservaHotel.setTipoCliente(reservaSplitted[0]);
			
			String [] datas = reservaSplitted[1].split(",");
			
			//Adiciona datas das reservas a uma lista do tipo Calendar
			
			for(int i=0;i<datas.length;i++){				
				reservaHotel.getDatasReserva().add(FileUtils.STRING_TO_DATE(datas[i]));				
			}
			reservas.add(reservaHotel);			
		}		
		return reservas;
	}
	
}
