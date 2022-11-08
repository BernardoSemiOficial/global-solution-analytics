package com.global.global.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.global.dto.VeiculoDTO;
import com.global.global.model.VeiculoModel;
import com.global.global.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<VeiculoModel> findAll() {
		try {
			return veiculoRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void save(VeiculoModel veiculo) {
		try {
			veiculoRepository.save(veiculo);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Object updateById(Integer id, VeiculoDTO dto) {
		try {
			Optional<VeiculoModel> veiculo = veiculoRepository.findById(id);
			if(veiculo.isPresent()) {
				VeiculoModel veiculoModel = veiculo.get();
				veiculoModel.setMarca(dto.getMarca());
				veiculoModel.setModelo(dto.getModelo());
				veiculoModel.setPlacaVeiculo(dto.getPlacaVeiculo());
				veiculoModel.setQuilometragem(dto.getQuilometragem());
				veiculoRepository.save(veiculoModel);
				return veiculoModel;				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Optional.empty();
	}
	
	public void remove(int id) {
		try {
			veiculoRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
