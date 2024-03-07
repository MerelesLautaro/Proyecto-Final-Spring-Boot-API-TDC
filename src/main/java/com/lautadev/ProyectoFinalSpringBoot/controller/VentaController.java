package com.lautadev.ProyectoFinalSpringBoot.controller;

import com.lautadev.ProyectoFinalSpringBoot.dto.ventasDTO;
import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import com.lautadev.ProyectoFinalSpringBoot.model.Venta;
import com.lautadev.ProyectoFinalSpringBoot.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaServ;
    
    //Endpoints
    //3. Poder realizar un CRUD completo de ventas 
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta) {
       return ventaServ.crearVenta(venta);        
    }
    
    @GetMapping("/ventas")
    public List<Venta> traerVentas(){
        return ventaServ.traerVentas();
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaServ.findVenta(codigo_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable Long codigo_venta){
        ventaServ.eliminarVenta(codigo_venta);
    }
    
    @PutMapping("/ventas/editar")
    public Venta editarVenta(@RequestBody Venta venta){
        ventaServ.editarVenta(venta);
        return ventaServ.findVenta(venta.getCodigo_venta());
    }
    
    //5. Obtener la lista de productos de una determinada venta 
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> determinadaVenta(@PathVariable Long codigo_venta){
        return ventaServ.determinadaVenta(codigo_venta);
    }
    
    //6. Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día 
    @GetMapping("/ventas/fecha/{fecha_venta}")
    public List<Double> ventasDia(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_venta){
        return ventaServ.ventasDia(fecha_venta);
    }
      
    //7. Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el 
    //apellido del cliente de la venta con el monto más alto de todas.  
    @GetMapping("ventas/mayor_venta")
    public ventasDTO mayorVenta(){
        return ventaServ.mayorVenta();
    }
}
