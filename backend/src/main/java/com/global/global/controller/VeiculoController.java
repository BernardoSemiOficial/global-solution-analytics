package com.global.global.controller;

import java.util.Collection;

import com.global.global.model.RegionalModel;
import com.global.global.service.RegionalService;
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

import com.global.global.dto.VeiculoDTO;
import com.global.global.model.AmbienteModel;
import com.global.global.model.VeiculoModel;
import com.global.global.service.AmbienteService;
import com.global.global.service.VeiculoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private AmbienteService ambienteService;

    @Autowired
    private RegionalService regionalService;
	
	@GetMapping
	public ResponseEntity<Collection<VeiculoModel>> getVeiculos() {
        return ResponseEntity.ok(veiculoService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<VeiculoModel> postVeiculos(@RequestBody VeiculoDTO dto) {
		VeiculoModel veiculoModel = dto.toEntity();
        RegionalModel regional = new RegionalModel();
        regional.setVeiculo(veiculoModel);
		
        ambienteService.save(dto.getAmbiente());
		veiculoService.save(veiculoModel);
        regionalService.save(regional);
		return new ResponseEntity<>(veiculoModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateVeiculos(@PathVariable(value = "id") String id,
													   @RequestBody VeiculoDTO dto) {
		VeiculoModel veiculo = veiculoService.updateById(Integer.parseInt(id), dto);
        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        }
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<VeiculoModel> deleteVeiculos(@PathVariable(value = "id") String id) {
		regionalService.remove(Integer.parseInt(id));
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
