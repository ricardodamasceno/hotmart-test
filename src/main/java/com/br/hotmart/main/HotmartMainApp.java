package com.br.hotmart.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import com.br.hotmart.model.Hotel;
import com.br.hotmart.model.ReservaHotel;
import com.br.hotmart.service.HotelService;
import com.br.hotmart.service.ReservaHotelService;
import com.br.hotmart.util.Consts;

public class HotmartMainApp {
	

	public static void main( String[] args ) throws IOException, ParseException {
		
		//Variávies dos serviços da aplicação
		HotelService hotelService = new HotelService();
		ReservaHotelService reservaHotelService = new ReservaHotelService();
		
		//Lista de hotéis cadastrados
		List<Hotel> hoteis = hotelService.findAll();
		//Lista de reservas
		List<ReservaHotel> reservas = reservaHotelService.findAll();
		
		//Calcula os melhores valores para as reservas
		for(ReservaHotel reserva:reservas){
			
			Double totalGasto = 0.0;			
			Hotel hotelTemp = null;
			
			for(Hotel hotel:hoteis){				
				Double totalTemp = 0.0;				
				for(Calendar calendar : reserva.getDatasReserva()){					
					//Verifica se a data é de final de semana
					if(calendar.get(calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){						
						//Converte para lowercase como medida de segurança, afim de que erros de preenchimento causem erros
						if(reserva.getTipoCliente().toLowerCase().equals(Consts.REGULAR.toLowerCase())){
							totalTemp += hotel.getDiariaFimSemana();							
						}else if(reserva.getTipoCliente().toLowerCase().equals(Consts.VIP.toLowerCase())){
							totalTemp += hotel.getDiariaFimSemanaVip();
						}						
					}else{
						//Converte para lowercase como medida de segurança, afim de que erros de preenchimento causem erros
						if(reserva.getTipoCliente().toLowerCase().equals(Consts.REGULAR.toLowerCase())){
							totalTemp += hotel.getDiariaSemana();							
						}else if(reserva.getTipoCliente().toLowerCase().equals(Consts.VIP.toLowerCase())){
							totalTemp += hotel.getDiariaSemanaVip();
						}	
					}					
				}
				if(totalGasto == 0.0 || totalTemp < totalGasto){
					hotelTemp = hotel;
					totalGasto = totalTemp;
				}else if(totalTemp.toString().equals(totalGasto.toString())){
					//Se os valores das reservas forem iguais, o critério de desempate será o hotel com maior número de estrelas
					if(hotel.getEstrelas() > hotelTemp.getEstrelas()){
						hotelTemp = hotel;
					}
				}
			}
			System.out.println(hotelTemp.getNome()+" : R$ "+totalGasto);			
		}
		
	}
	
}
