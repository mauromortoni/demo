package com.example.demo.chainofresponsibility.impl;

import com.example.demo.chainofresponsibility.Validator;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.handler.CampoObrigatorioException;

public class NomeValidator implements Validator<ClienteDTO> {
    private Validator<ClienteDTO> next;

    @Override
    public Validator<ClienteDTO> setNext(Validator<ClienteDTO> next) {
        this.next = next;
        return next;
    }

    @Override
    public void validate(ClienteDTO clienteDTO) throws CampoObrigatorioException {
        if (clienteDTO.getNome() == null || clienteDTO.getNome().isEmpty()) {
            throw new CampoObrigatorioException("Nome");
        }
        if (next != null) {
            next.validate(clienteDTO);
        }
    }
}
