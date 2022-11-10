package com.global.global.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Data
public class RegionalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDateTime operationDate = now();

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoModel veiculo;
}