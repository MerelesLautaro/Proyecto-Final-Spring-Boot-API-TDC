package com.lautadev.ProyectoFinalSpringBoot.repository;

import com.lautadev.ProyectoFinalSpringBoot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository <Venta,Long>{
    
}
