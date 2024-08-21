package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	ClienteDTO buscarPorId(Integer id);

	void inserir(ClienteDTO clienteDTO);

	void atualizar(Integer id, ClienteDTO clienteDTO);

	void deletar(Integer id);
}
