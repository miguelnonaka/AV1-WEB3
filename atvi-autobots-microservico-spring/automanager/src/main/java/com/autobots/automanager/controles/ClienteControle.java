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

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.servicos.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {

	@Autowired
	private ClienteService servico;

	@Autowired
	private ClienteSelecionador selecionador;

	@GetMapping("/cliente/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = servico.listar();
		return selecionador.selecionar(clientes, id);
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
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = servico.ListarByID(atualizacao);
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		servico.cadastrar(cliente);
	}

	@DeleteMapping("/excluir")
	public void excluirCliente(@RequestBody Cliente exclusao) {
		servico.deletar(exclusao);
	}
}
