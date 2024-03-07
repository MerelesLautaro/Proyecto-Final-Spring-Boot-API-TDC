package com.lautadev.ProyectoFinalSpringBoot.controller;

import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import com.lautadev.ProyectoFinalSpringBoot.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoServ;
    
    //Endpoints
    //1. Poder realizar un CRUD completo de productos
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoServ.crearProducto(producto);
        return "Producto creado";
    }
    
    @GetMapping("/productos")
    public List<Producto> traerProductos(){
        return productoServ.traerProductos();
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return productoServ.findProducto(codigo_producto);
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto){
        productoServ.eliminarProducto(codigo_producto);
    }
    
    @PutMapping("/productos/editar")
    public Producto editarProducto(@RequestBody Producto producto){
        productoServ.editarProducto(producto);
        return productoServ.findProducto(producto.getCodigo_producto());
    }
    
    
    //4. Obtener todos los productos cuya cantidad_disponible sea menor a 5 
    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock(){
        return productoServ.faltaStock();
    }    
    
}
