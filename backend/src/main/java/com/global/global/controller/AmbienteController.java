package com.global.global.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.global.dto.AmbienteDTO;
import com.global.global.model.AmbienteModel;
import com.global.global.service.AmbienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ambientes")
public class AmbienteController {

	@Autowired
	private AmbienteService ambienteService;
	
	@GetMapping
	public ResponseEntity<Collection<AmbienteModel>> getAmbientes() {
		Collection<AmbienteModel> ambientes = ambienteService.findAll();
		return new ResponseEntity<>(ambientes, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AmbienteModel> postAmbientes(@RequestBody AmbienteDTO dto) {
		AmbienteModel ambienteModel = new AmbienteModel();
		ambienteModel.setEstado(dto.getEstado());
		ambienteModel.setCidade(dto.getCidade());
		ambienteModel.setBairro(dto.getBairro());
		ambienteModel.setTempAmbiente(dto.getTempAmbiente());
		ambienteModel.setQualidadeAr(dto.getQualidadeAr());
		ambienteService.save(ambienteModel);
		return new ResponseEntity<>(ambienteModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAmbientes(@PathVariable(value = "id") String id,
													   @RequestBody AmbienteDTO dto) {
		Object ambienteUpdated = ambienteService.updateById(Integer.parseInt(id), dto);
		return new ResponseEntity<>(ambienteUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AmbienteModel> deleteAmbientes(@PathVariable(value = "id") String id) {
		ambienteService.remove(Integer.parseInt(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
