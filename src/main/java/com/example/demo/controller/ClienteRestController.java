package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	//	CRUD
	@PostMapping
	public ResponseEntity<ClienteDTO> inserir(@RequestBody ClienteDTO clienteDTO) {
		clienteService.inserir(clienteDTO);

		return ResponseEntity.ok(clienteDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
		clienteService.atualizar(id, clienteDTO);

		return ResponseEntity.ok(clienteDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
