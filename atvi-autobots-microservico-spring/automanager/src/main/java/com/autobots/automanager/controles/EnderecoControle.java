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

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.servicos.EnderecoService;

@RestController

@RequestMapping("/endereco")
public class EnderecoControle {
    @Autowired
	private EnderecoService servico;

	@GetMapping("/{id}")
	public Endereco obterEndereco(@PathVariable long id) {
		return servico.ListarByID(id);
	}

	@GetMapping
	public List<Endereco> obteEnderecos() {
		List<Endereco> endereco = servico.listar();
		return endereco;
	}

	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarEndereco(@RequestBody Endereco cliente) {
		servico.cadastrar(cliente);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente Cadastrado", HttpStatus.OK);
		return resposta;
	}

	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizarEndereco(@RequestBody Endereco atualizacao) {
		servico.atualizar(atualizacao.getId(), atualizacao);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente atualizado", HttpStatus.OK);
		return resposta;
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirEndereco(@PathVariable Long id) {
		servico.deletar(id);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente deletado", HttpStatus.OK);
		return resposta;
	}
}
