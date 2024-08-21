package com.example.demo.chainofresponsibility.impl;

import com.example.demo.chainofresponsibility.Validator;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.handler.CampoObrigatorioException;

public class CepValidator implements Validator<ClienteDTO> {
    private Validator next;

    @Override
    public Validator setNext(Validator next) {
        this.next = next;
        return next;
    }

    @Override
    public void validate(ClienteDTO dto) throws CampoObrigatorioException {
        if (dto.getEnderecoDTO().getCep() == null || dto.getEnderecoDTO().getCep().isEmpty()) {
            throw new CampoObrigatorioException("CEP");
        }

        if (next != null) {
            next.validate(dto);
        }
    }
}
