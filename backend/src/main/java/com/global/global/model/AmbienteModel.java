package com.global.global.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AmbienteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private double tempAmbiente;
	
	@Column(nullable = false)
	private String qualidadeAr;
	
	@OneToOne(mappedBy = "ambiente")
	private VeiculoModel veiculo;

	public VeiculoModel getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModel veiculo) {
		this.veiculo = veiculo;
	}

	public AmbienteModel() {
	}
	
	public AmbienteModel(String estado, String cidade, String bairro, double tempAmbiente, String qualidadeAr) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.tempAmbiente = tempAmbiente;
		this.qualidadeAr = qualidadeAr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
