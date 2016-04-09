package com.br.hotmart.unittest;

import java.io.IOException;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import com.br.hotmart.model.Hotel;
import com.br.hotmart.model.ReservaHotel;
import com.br.hotmart.service.HotelService;
import com.br.hotmart.service.ReservaHotelService;
import com.br.hotmart.util.Consts;
import com.br.hotmart.util.FileUtils;

public class HotmartTest {

	private HotelService hotelService = new HotelService();
	private ReservaHotelService reservaHotelService = new ReservaHotelService();
	
	/**
	 * Testes unitários de funções da aplicação
	 */
		
	@Test
	public void findAllHoteisSimple() throws IOException{
		List<Hotel> hoteis = hotelService.findAll();
		assertEquals(3, hoteis.size());
	}
	
	@Test
	public void findAllReservasSimple() throws IOException, ParseException{
		List<ReservaHotel> reservas = reservaHotelService.findAll();
		assertEquals(3, reservas.size());
	}
	
	@Test
	public void getDataFromDataFile() throws IOException{
		List<String> rows = FileUtils.GET_DATA_FROM_FILE(Consts.HOTMART_DATA_FILE);
		assertEquals(3, rows.size());
	}
	
	@Test
	public void getDataFromHoteisFile() throws IOException{
		List<String> rows = FileUtils.GET_DATA_FROM_FILE(Consts.HOTMART_HOTEIS_FILE);
		assertEquals(3, rows.size());
	}
	
	@Test
	public void stringToDate() throws ParseException{
		Calendar calendar = FileUtils.STRING_TO_DATE("17Mar2016");
		assertNotNull(calendar);
	}
	
	@Test
	public void getMonthNumber(){
		String result = FileUtils.GET_MONTH_NUMBER("Abr");
		assertEquals(result, "04");
	}
	
	/**
	 * Testes de fluxo da aplicação
	 * @throws IOException 
	 */
	
	@Test
	public void findAllHoteis() throws IOException{
		List<Hotel>hoteis = hotelService.findAll();
		assertEquals(hoteis.size(), 3);
	}
	
	@Test
	public void findAllReservas() throws IOException, ParseException{
		List<ReservaHotel>reservas = reservaHotelService.findAll();
		assertEquals(reservas.size(), 3);
	}
	
}
