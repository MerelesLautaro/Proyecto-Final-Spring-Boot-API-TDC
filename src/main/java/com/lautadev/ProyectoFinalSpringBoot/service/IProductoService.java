package com.lautadev.ProyectoFinalSpringBoot.service;

import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void crearProducto(Producto producto);
    
    public List<Producto> traerProductos();
    
    public Producto findProducto(Long id);
    
    public void eliminarProducto(Long id);
    
    public void editarProducto(Producto producto);

    public List<Producto> faltaStock();

    public void controlStock(List<Producto> listaProductos);
    
}
