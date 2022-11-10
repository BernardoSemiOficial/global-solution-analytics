package com.global.global.repository;

import com.global.global.model.RegionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalRepository extends JpaRepository<RegionalModel, Integer> {

}