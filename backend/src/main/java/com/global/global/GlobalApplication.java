package com.global.global;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.global.global.model.AmbienteModel;
import com.global.global.model.VeiculoModel;
import com.global.global.repository.AmbienteRepository;
import com.global.global.repository.VeiculoRepository;

@SpringBootApplication
public class GlobalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner mappingDemo(VeiculoRepository veiculoRepository,
                                         AmbienteRepository ambienteRepository) {
        return args -> {
			/*
			 * AmbienteModel ambiente = new AmbienteModel("SP", "São Paulo", "Penha", 25.0,
			 * "ótima"); VeiculoModel veiculo = new VeiculoModel("Fiat", "Uno", "AB123",
			 * 5.5, ambiente); ambienteRepository.save(ambiente);
			 * veiculoRepository.save(veiculo);
			 */
        };
    }

}
