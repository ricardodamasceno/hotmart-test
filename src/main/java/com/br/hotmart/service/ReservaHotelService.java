package com.br.hotmart.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.br.hotmart.model.ReservaHotel;
import com.br.hotmart.repository.ReservaHotelRepository;

public class ReservaHotelService {

	ReservaHotelRepository reservaHotelRepository = new ReservaHotelRepository();
	
	public List<ReservaHotel> findAll() throws IOException, ParseException{
		return reservaHotelRepository.findAll();
	}
	
}
