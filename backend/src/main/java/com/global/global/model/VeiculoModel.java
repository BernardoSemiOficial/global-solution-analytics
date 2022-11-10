package com.global.global.model;

import lombok.Data;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class VeiculoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String placaVeiculo;
	
	@Column(nullable = false)
	private double quilometragem;
	
	@OneToOne
    @JoinColumn(name = "ambiente_id")
	private AmbienteModel ambiente;

}
