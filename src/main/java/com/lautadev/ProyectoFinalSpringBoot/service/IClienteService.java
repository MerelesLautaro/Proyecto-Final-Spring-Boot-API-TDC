package com.lautadev.ProyectoFinalSpringBoot.service;

import com.lautadev.ProyectoFinalSpringBoot.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public void crearCliente(Cliente cliente); 
    
    public List<Cliente> traerClientes();
    
    public Cliente findCliente(Long id);
    
    public void eliminarCliente(Long id);
    
    public void editarCliente(Cliente cliente);
}
