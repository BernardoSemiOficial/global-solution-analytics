package com.global.global.service;

import com.global.global.model.RegionalModel;
import com.global.global.repository.RegionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalService {

    @Autowired
    RegionalRepository repository;

    public void save(RegionalModel regional) {
        repository.save(regional);
    }
    
    public void remove(int id) {
        try {
        	repository.deleteById(id);
		} catch (Exception e) {
			System.out.println(e);
		}
    }

}