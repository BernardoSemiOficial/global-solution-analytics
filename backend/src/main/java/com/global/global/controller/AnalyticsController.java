package com.global.global.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.global.dto.VeiculoDTO;
import com.global.global.model.VeiculoModel;
import com.global.global.service.VeiculoService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/veiculos")
	public ResponseEntity<Collection<VeiculoModel>> getVeiculos() {
		Collection<VeiculoModel> veiculos = veiculoService.findAll();
		return new ResponseEntity<>(veiculos, HttpStatus.OK);
	}
	
	@PostMapping("/veiculos")
	public ResponseEntity<VeiculoModel> postVeiculos(@RequestBody VeiculoDTO dto) {
		VeiculoModel veiculoModel = new VeiculoModel();
		veiculoModel.setMarca(dto.getMarca());
		veiculoModel.setModelo(dto.getModelo());
		veiculoModel.setPlacaVeiculo(dto.getPlacaVeiculo());
		veiculoModel.setQuilometragem(dto.getQuilometragem());
		veiculoService.save(veiculoModel);
		return new ResponseEntity<>(veiculoModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/veiculos/{id}")
	public ResponseEntity<Object> updateVeiculos(@PathVariable(value = "id") String id,
													   @RequestBody VeiculoDTO dto) {
		Object veiculoUpdated = veiculoService.updateById(Integer.parseInt(id), dto);
		return new ResponseEntity<>(veiculoUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/veiculos/{id}")
	public ResponseEntity<VeiculoModel> deleteVeiculos(@PathVariable(value = "id") String id) {
		veiculoService.remove(Integer.parseInt(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	/*
	 * @GetMapping("/aberto")
	 * 
	 * @PreAuthorize("hasRole('admin')") public String getOpenAdmin() { return
	 * "Somente admin"; }
	 */
	
}
