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
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.servicos.ClienteService;

@RestController
public class ClienteControle {

	@Autowired
	private ClienteService servico;

	@GetMapping("/cliente/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		return servico.ListarByID(id);
	}

	@GetMapping("/clientes")
	public List<Cliente> obterClientes() {
		List<Cliente> clientes = servico.listar();
		return clientes;
	}

	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
		servico.cadastrar(cliente);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente Cadastrado", HttpStatus.OK);
		return resposta;
	}

	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizarCliente(@RequestBody Cliente atualizacao) {
		servico.atualizar(atualizacao.getId(), atualizacao);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente atualizado", HttpStatus.OK);
		return resposta;
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
		servico.deletar(id);
		ResponseEntity<String> resposta = new ResponseEntity<>("Cliente deletado", HttpStatus.OK);
		return resposta;
	}
}
