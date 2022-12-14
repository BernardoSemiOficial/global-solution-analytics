package com.global.global.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.global.dto.AmbienteDTO;
import com.global.global.model.AmbienteModel;
import com.global.global.repository.AmbienteRepository;

@Service
public class AmbienteService {

	@Autowired
	private AmbienteRepository ambienteRepository;
	
	public List<AmbienteModel> findAll() {
		try {
			return ambienteRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void save(AmbienteModel ambiente) {
		try {
			ambienteRepository.save(ambiente);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Object updateById(Integer id, AmbienteModel ambienteModel) {
		try {
			Optional<AmbienteModel> ambiente = ambienteRepository.findById(id);
			if(ambiente.isPresent()) {
                ambienteModel.setId(id);
				ambienteRepository.save(ambienteModel);
				return ambienteModel;					
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Optional.empty();
	}
	
	public void remove(int id) {
		try {
			ambienteRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
