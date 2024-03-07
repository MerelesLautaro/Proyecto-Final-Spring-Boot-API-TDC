package com.lautadev.ProyectoFinalSpringBoot.dto;

import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ventasDTO {
    Long codigo_venta;
    Double total;
    List<Producto> listaProductos;
    String nombre;
    String apellido;

    public ventasDTO() {
    }

    public ventasDTO(Long codigo_venta, Double total, List<Producto> listaProductos, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    
    
    
}
