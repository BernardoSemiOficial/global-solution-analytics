package com.global.global.dto;

public class AmbienteDTO {

	private String estado;
	private String cidade;
	private String bairro;
	private double tempAmbiente;
	private String qualidadeAr;
	
	public AmbienteDTO() {
	}
	
	public AmbienteDTO(String estado, String cidade, String bairro, double tempAmbiente, String qualidadeAr) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.tempAmbiente = tempAmbiente;
		this.qualidadeAr = qualidadeAr;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public double getTempAmbiente() {
		return tempAmbiente;
	}

	public void setTempAmbiente(double tempAmbiente) {
		this.tempAmbiente = tempAmbiente;
	}

	public String getQualidadeAr() {
		return qualidadeAr;
	}

	public void setQualidadeAr(String qualidadeAr) {
		this.qualidadeAr = qualidadeAr;
	}
}
