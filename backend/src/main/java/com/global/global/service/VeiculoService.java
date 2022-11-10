package com.global.global.service;

import java.util.List;
import java.util.Optional;

import com.global.global.model.AmbienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.global.dto.VeiculoDTO;
import com.global.global.model.VeiculoModel;
import com.global.global.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

    @Autowired
    private AmbienteService ambienteService;
	
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
	
	public VeiculoModel updateById(Integer id, VeiculoDTO dto) {
        Optional veiculo = veiculoRepository.findById(id);
        if(veiculo.isPresent()) {
            VeiculoModel veiculoAntigo = (VeiculoModel) veiculo.get();
            VeiculoModel entity = dto.toEntity();
            AmbienteModel ambiente = dto.getAmbiente();
            ambiente.setId(veiculoAntigo.getAmbiente().getId());
            entity.setId(veiculoAntigo.getId());
            entity.setAmbiente(ambiente);
            ambienteService.updateById(entity.getAmbiente().getId(), dto.getAmbiente());
            return veiculoRepository.save(entity);
        } else {
            return null;
        }
	}
	
	public void remove(int id) {
		try {
			veiculoRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
