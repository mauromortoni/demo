package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter implements Converter<ClienteDTO, Cliente> {

    @Override
    public Cliente convertFromDTO(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        EnderecoConverter enderecoConverter = new EnderecoConverter();

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(enderecoConverter.convertFromDTO(dto.getEnderecoDTO()));

        return cliente;
    }

    @Override
    public ClienteDTO convertFromEntity(Cliente entity) {
        if (entity == null) {
            return null;
        }
        EnderecoConverter enderecoConverter = new EnderecoConverter();

        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());

        dto.setEnderecoDTO(enderecoConverter.convertFromEntity(entity.getEndereco()));
        return dto;
    }
}
