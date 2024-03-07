package com.lautadev.ProyectoFinalSpringBoot.service;

import com.lautadev.ProyectoFinalSpringBoot.dto.ventasDTO;
import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import com.lautadev.ProyectoFinalSpringBoot.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public String crearVenta(Venta venta);
    
    public List<Venta> traerVentas();
    
    public Venta findVenta(Long id);
    
    public void eliminarVenta(Long id);
    
    public void editarVenta(Venta venta);
    
    public List<Producto> determinadaVenta(Long id);

    public List<Double> ventasDia(LocalDate fecha_venta);

    public ventasDTO mayorVenta();
}
