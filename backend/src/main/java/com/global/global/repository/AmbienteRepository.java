package com.global.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.global.model.AmbienteModel;

@Repository
public interface AmbienteRepository extends JpaRepository<AmbienteModel, Long> {

}
