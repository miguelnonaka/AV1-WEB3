package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.ClienteAtualizador;
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

    public Cliente ListarByID(Long id){
        Cliente cliente = repositorio.findById(id).orElse(null);
        return cliente;
    }

    public Cliente atualizar(Long id, Cliente atualizacao){
        Cliente cliente = repositorio.getById(id);
        ClienteAtualizador atualizador = new ClienteAtualizador();
        atualizador.atualizar(cliente, atualizacao);
        return repositorio.save(cliente);
    }

    public void deletar (Long id){
		repositorio.deleteById(id);
    }
}
