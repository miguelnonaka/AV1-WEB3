package com.autobots.automanager.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepositorio repositorio;

    public Telefone cadastrar(Telefone cliente){
        return repositorio.save(cliente);
    } 

    public List<Telefone> listar(){
        List<Telefone> clientes = repositorio.findAll();
        return clientes;
    }

    public Telefone ListarByID(Long id){
        Telefone cliente = repositorio.findById(id).orElse(null);
        return cliente;
    }

    public Telefone atualizar(Long id, Telefone atualizacao){
        Telefone cliente = repositorio.getById(id);
        TelefoneAtualizador atualizador = new TelefoneAtualizador();
        atualizador.atualizar(cliente, atualizacao);
        return repositorio.save(cliente);
    }

    public void deletar (Long id){
		repositorio.deleteById(id);
    }
}
