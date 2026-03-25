package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepositorio repositorio;

    public Cliente cadastrar(Cliente cliente){
        return repositorio.save(cliente);
    } 

    public List<Cliente> listar(){
        List<Cliente> clientes = repositorio.findAll();
        return clientes;
    }

    public Cliente ListarByID(Cliente Client){
        Cliente cliente = repositorio.getById(Client.getId());
        return cliente;
    }

    public void deletar (Cliente cliente){
        Cliente clienteD = repositorio.getById(cliente.getId());
		repositorio.delete(clienteD);
    }
}
