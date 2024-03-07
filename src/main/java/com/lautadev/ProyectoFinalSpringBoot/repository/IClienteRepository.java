package com.lautadev.ProyectoFinalSpringBoot.repository;

import com.lautadev.ProyectoFinalSpringBoot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente,Long> {
    
}
