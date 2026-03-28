package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.servicos.TelefoneService;

@RestController

@RequestMapping("/telefone")
public class TelefoneControle {
    @Autowired
	private TelefoneService servico;

	@GetMapping("/{id}")
	public Telefone obterTelefone(@PathVariable long id) {
		return servico.ListarByID(id);
	}

	@GetMapping
	public List<Telefone> obtertTelefones() {
		List<Telefone> telefones = servico.listar();
		return telefones;
	}

	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarTelefone(@RequestBody Telefone cliente) {
		servico.cadastrar(cliente);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente Cadastrado", HttpStatus.OK);
		return resposta;
	}

	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizarTelefone(@RequestBody Telefone atualizacao) {
		servico.atualizar(atualizacao.getId(), atualizacao);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente atualizado", HttpStatus.OK);
		return resposta;
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirTelefone(@PathVariable Long id) {
		servico.deletar(id);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente deletado", HttpStatus.OK);
		return resposta;
	}  
}
