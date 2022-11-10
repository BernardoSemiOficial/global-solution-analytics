package com.global.global.dto;

import com.global.global.model.AmbienteModel;
import com.global.global.model.VeiculoModel;

public class VeiculoDTO {
	
	private int id;
	private String marca;
	private String modelo;
	private String placaVeiculo;
	private double quilometragem;
	private AmbienteModel ambiente;

    public VeiculoModel toEntity() {
        VeiculoModel veiculoModel = new VeiculoModel();
        veiculoModel.setMarca(getMarca());
        veiculoModel.setModelo(getModelo());
        veiculoModel.setPlacaVeiculo(getPlacaVeiculo());
        veiculoModel.setQuilometragem(getQuilometragem());
        veiculoModel.setAmbiente(getAmbiente());
        return veiculoModel;
    }
	
	public VeiculoDTO() {
	}
	
	public VeiculoDTO(String marca, String modelo, String placaVeiculo, double quilometragem, AmbienteModel ambiente) {
		this.marca = marca;
		this.modelo = modelo;
		this.placaVeiculo = placaVeiculo;
		this.quilometragem = quilometragem;
		this.ambiente = ambiente;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	
	public double getQuilometragem() {
		return quilometragem;
	}
	
	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public AmbienteModel getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(AmbienteModel ambiente) {
		this.ambiente = ambiente;
	}
	
}