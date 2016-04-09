package com.br.hotmart.service;

import java.io.IOException;
import java.util.List;

import com.br.hotmart.model.Hotel;
import com.br.hotmart.repository.HotelRepository;

public class HotelService {
	
	private HotelRepository hotelRepository = new HotelRepository();
	
	public List<Hotel> findAll() throws IOException{
		return hotelRepository.findAll();
	}

	
	
}
