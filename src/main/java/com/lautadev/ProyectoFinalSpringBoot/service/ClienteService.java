package com.lautadev.ProyectoFinalSpringBoot.service;

import com.lautadev.ProyectoFinalSpringBoot.model.Cliente;
import com.lautadev.ProyectoFinalSpringBoot.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clienteRepo;
    
    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cliente = clienteRepo.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        this.crearCliente(cliente);
    }
    
}
