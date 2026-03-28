package com.autobots.automanager.servicos;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepositorio repositorio;

    public Documento cadastrar(Documento cliente){
        return repositorio.save(cliente);
    } 

    public List<Documento> listar(){
        List<Documento> clientes = repositorio.findAll();
        return clientes;
    }

    public Documento ListarByID(Long id){
        Documento cliente = repositorio.findById(id).orElse(null);
        return cliente;
    }

    public Documento atualizar(Long id, Documento atualizacao){
        Documento cliente = repositorio.getById(id);
        DocumentoAtualizador atualizador = new DocumentoAtualizador();
        atualizador.atualizar(cliente, atualizacao);
        return repositorio.save(cliente);
    }

    public void deletar (Long id){
		repositorio.deleteById(id);
    }
}
