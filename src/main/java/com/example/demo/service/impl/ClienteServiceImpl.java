package com.example.demo.service.impl;

import java.util.Optional;

import com.example.demo.chainofresponsibility.Validator;
import com.example.demo.chainofresponsibility.impl.CepValidator;
import com.example.demo.chainofresponsibility.impl.EmailValidator;
import com.example.demo.chainofresponsibility.impl.NomeValidator;
import com.example.demo.converter.impl.ClienteConverter;
import com.example.demo.converter.impl.EnderecoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.ViaCepService;
import com.example.demo.dto.ClienteDTO;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	@Autowired
	ClienteConverter clienteConverter;
	@Autowired
	EnderecoConverter enderecoConverter;

	private final Validator<ClienteDTO> validator;

	public ClienteServiceImpl() {
		// Configurando a cadeia de validadores
		Validator<ClienteDTO> nomeValidator = new NomeValidator();
		Validator<ClienteDTO> emailValidator = new EmailValidator();
		Validator<ClienteDTO> cepValidator = new CepValidator();

		// Encadear validadores
		nomeValidator.setNext(emailValidator).setNext(cepValidator);

		validator = nomeValidator;
	}

	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public ClienteDTO buscarPorId(Integer id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);

		return clienteConverter.convertFromEntity(cliente.get());
	}

	@Override
	public void inserir(ClienteDTO clienteDTO) {
		// Validação - Chain of Responsibility
		validator.validate(clienteDTO);

		Cliente cliente = clienteConverter.convertFromDTO(clienteDTO);

		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Integer id, ClienteDTO clienteDTO) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			// Validação - Chain of Responsibility
			validator.validate(clienteDTO);

			Cliente cliente = clienteConverter.convertFromDTO(clienteDTO);

			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Integer id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}
}
