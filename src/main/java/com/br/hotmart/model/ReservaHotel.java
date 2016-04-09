package com.br.hotmart.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservaHotel {
	
	private Long id;
	private String tipoCliente;
	private List<Calendar> datasReserva;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public List<Calendar> getDatasReserva() {
		if(this.datasReserva ==null){
			List<Calendar>datas = new ArrayList<Calendar>();
			datasReserva = datas;
		}
		return datasReserva;
	}
	public void setDatasReserva(List<Calendar> datasReserva) {
		this.datasReserva = datasReserva;
	}
	
}
