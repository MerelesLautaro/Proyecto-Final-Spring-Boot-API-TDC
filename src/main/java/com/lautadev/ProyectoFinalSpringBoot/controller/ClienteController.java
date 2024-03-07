package com.lautadev.ProyectoFinalSpringBoot.controller;

import com.lautadev.ProyectoFinalSpringBoot.model.Cliente;
import com.lautadev.ProyectoFinalSpringBoot.service.IClienteService;
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
public class ClienteController {
    @Autowired
    private IClienteService clienteServ;
    
    //Endpoints
    //2. Poder realizar un CRUD completo de clientes 
    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteServ.crearCliente(cliente);
        return "Cliente creado";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> traerClientes(){
        return clienteServ.traerClientes();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clienteServ.findCliente(id_cliente);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente){
        clienteServ.eliminarCliente(id_cliente);
    }
    
    @PutMapping("/clientes/editar")
    public Cliente editarCliente(@RequestBody Cliente cliente){
        clienteServ.editarCliente(cliente);
        return clienteServ.findCliente(cliente.getId_cliente());
    }
}
