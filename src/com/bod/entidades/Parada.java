package com.bod.entidades;


public class Parada {
	
	
	private String codigoParada ;
	private String logradouro   ;
	private String cidade       ;
	private String bairro       ;
	private String latitude     ;
	private String longitude    ;
	
	public Parada() {}

	public Parada(String codigoParada, String logradouro, String cidade,
			String bairro, String latitude, String longitude) {
		super();
		this.codigoParada = codigoParada;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.bairro = bairro;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getCodigoParada() {
		return codigoParada;
	}
	public void setCodigoParada(String codigoParada) {
		this.codigoParada = codigoParada;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
	
	
	
	
}
