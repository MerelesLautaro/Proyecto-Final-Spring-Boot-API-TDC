package com.lautadev.ProyectoFinalSpringBoot.service;

import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import com.lautadev.ProyectoFinalSpringBoot.repository.IProductoRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void crearProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> traerProductos() {
        List<Producto> listaProductos = productoRepo.findAll();
        return listaProductos;
    }

    @Override
    public Producto findProducto(Long id) {
        Producto producto = productoRepo.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void editarProducto(Producto producto) {
        this.crearProducto(producto);
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listaProductos = this.traerProductos();
        List<Producto> listaFaltaStock = new LinkedList<>();
        for(Producto producto:listaProductos){
            if(producto.getCantidad_disponible()<5){
                listaFaltaStock.add(producto);
            }
        }
        return listaFaltaStock;
    }

    @Override
    public void controlStock(List<Producto> listaProductos) {
        List<Producto> controlStock = listaProductos;
        for(Producto producto:controlStock){
            Producto productoControl = this.findProducto(producto.getCodigo_producto());
            Double cantidadControl = productoControl.getCantidad_disponible()-1;
            productoControl.setCantidad_disponible(cantidadControl);
            this.crearProducto(productoControl);
        }
    }

    
    
    
}
