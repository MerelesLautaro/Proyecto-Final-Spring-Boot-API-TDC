package com.lautadev.ProyectoFinalSpringBoot.service;

import com.lautadev.ProyectoFinalSpringBoot.dto.ventasDTO;
import com.lautadev.ProyectoFinalSpringBoot.model.Producto;
import com.lautadev.ProyectoFinalSpringBoot.model.Venta;
import com.lautadev.ProyectoFinalSpringBoot.repository.IProductoRepository;
import com.lautadev.ProyectoFinalSpringBoot.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository ventaRepo;   
    
    @Autowired
    private IProductoRepository productoRepo;
    
    @Autowired
    private IProductoService productoServ;
    
    @Override
    public String crearVenta(Venta venta) {
        List<Producto> listaProductos = venta.getListaProductos();
        //"banderita" si hay algun producto que su cantidad sea menor a 1
        //se cambia a false y no se lleva a cabo la venta.
        Boolean banderita = true;
        for (Producto producto : listaProductos) {
            Producto productoControl = productoRepo.findById(producto.getCodigo_producto()).orElse(null);
            if (productoControl.getCantidad_disponible() < 1) {
                banderita = false;
            }
        }

        if (banderita) {
            ventaRepo.save(venta);
            productoServ.controlStock(listaProductos);
            return  "Venta creada";
        }
        
        return "La venta NO ha sido llevada a cabo, revisa stock";
    }

    @Override
    public List<Venta> traerVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public Venta findVenta(Long id) {
        Venta venta = ventaRepo.findById(id).orElse(null);
        return venta;
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editarVenta(Venta venta) {
        this.crearVenta(venta);
    }

    @Override
    public List<Producto> determinadaVenta(Long id) {
        Venta venta = this.findVenta(id);
        return venta.getListaProductos();
    }

    @Override
    public List<Double> ventasDia(LocalDate fecha_venta) {
        List<Venta> listaVentas = this.traerVentas();
        Double monto = 0.0;
        Double cantidadVentas = 0.0;
        List<Double> ventasDelDia = new LinkedList<>();
        for(Venta venta:listaVentas){
            if(fecha_venta.equals(venta.getFecha_venta())){
               monto = monto + venta.getTotal();
               cantidadVentas++;
            }
        }
        ventasDelDia.add(monto);
        ventasDelDia.add(cantidadVentas);
        
        return ventasDelDia;
    }

    @Override
    public ventasDTO mayorVenta() {
        List<Venta> listaVentas = this.traerVentas();
        Double monto = 0.0;
        ventasDTO ventaInfo = new ventasDTO();
        for(Venta venta:listaVentas){
            if(monto < venta.getTotal()){               
                ventaInfo.setCodigo_venta(venta.getCodigo_venta());
                ventaInfo.setTotal(venta.getTotal());
                ventaInfo.setListaProductos(venta.getListaProductos());
                ventaInfo.setNombre(venta.getUnCliente().getNombre());
                ventaInfo.setApellido(venta.getUnCliente().getApellido());
            }
        }
        
        return ventaInfo;
    }

   
}
