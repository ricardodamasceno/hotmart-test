package com.br.hotmart.model;

public class Hotel {

	private Long id;
	private String nome;
	private int estrelas;
	private double diariaSemana;
	private double diariaFimSemana;
	private double diariaSemanaVip;
	private double diariaFimSemanaVip;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}
	public double getDiariaSemana() {
		return diariaSemana;
	}
	public void setDiariaSemana(double diariaSemana) {
		this.diariaSemana = diariaSemana;
	}
	public double getDiariaFimSemana() {
		return diariaFimSemana;
	}
	public void setDiariaFimSemana(double diariaFimSemana) {
		this.diariaFimSemana = diariaFimSemana;
	}
	public double getDiariaSemanaVip() {
		return diariaSemanaVip;
	}
	public void setDiariaSemanaVip(double diariaSemanaVip) {
		this.diariaSemanaVip = diariaSemanaVip;
	}
	public double getDiariaFimSemanaVip() {
		return diariaFimSemanaVip;
	}
	public void setDiariaFimSemanaVip(double diariaFimSemanaVip) {
		this.diariaFimSemanaVip = diariaFimSemanaVip;
	}
}
