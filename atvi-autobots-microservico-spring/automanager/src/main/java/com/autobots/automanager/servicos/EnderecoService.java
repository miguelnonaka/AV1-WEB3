package com.autobots.automanager.servicos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepositorio repositorio;

    public Endereco cadastrar(Endereco cliente){
        return repositorio.save(cliente);
    } 

    public List<Endereco> listar(){
        List<Endereco> clientes = repositorio.findAll();
        return clientes;
    }

    public Endereco ListarByID(Long id){
        Endereco cliente = repositorio.findById(id).orElse(null);
        return cliente;
    }

    public Endereco atualizar(Long id, Endereco atualizacao){
        Endereco cliente = repositorio.getById(id);
        EnderecoAtualizador atualizador = new EnderecoAtualizador();
        atualizador.atualizar(cliente, atualizacao);
        return repositorio.save(cliente);
    }

    public void deletar (Long id){
		repositorio.deleteById(id);
    }
}
