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

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.servicos.DocumentoService;

@RestController

@RequestMapping("/documento")
public class DocumentoControle {
    @Autowired
	private DocumentoService servico;

	@GetMapping("/{id}")
	public Documento obterDocumento(@PathVariable long id) {
		return servico.ListarByID(id);
	}

	@GetMapping
	public List<Documento> obterDocumentos() {
		List<Documento> documentos = servico.listar();
		return documentos;
	}

	@PostMapping("/cadastro")
	public ResponseEntity<String> cadastrarDocumento(@RequestBody Documento cliente) {
		servico.cadastrar(cliente);
		ResponseEntity<String> resposta = new ResponseEntity<>("Docuemnto Cadastrado", HttpStatus.OK);
		return resposta;
	}

	@PutMapping("/atualizar")
	public ResponseEntity<String> atualizarDocumento(@RequestBody Documento atualizacao) {
		servico.atualizar(atualizacao.getId(), atualizacao);
		ResponseEntity<String> resposta = new ResponseEntity<>("Documento atualizado", HttpStatus.OK);
		return resposta;
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirDocumento(@PathVariable Long id) {
		servico.deletar(id);
		ResponseEntity<String> resposta = new ResponseEntity<>("Documento deletado", HttpStatus.OK);
		return resposta;
	}
}
