package com.example.demo.converter.impl;

import com.example.demo.converter.Converter;
import com.example.demo.dto.EnderecoDTO;
import com.example.demo.model.Endereco;
import org.springframework.stereotype.Component;

/**
 * Implementação da interface Converter para EnderecoDTO e Endereco.
 */
@Component
public class EnderecoConverter implements Converter<EnderecoDTO, Endereco> {

    @Override
    public Endereco convertFromDTO(EnderecoDTO dto) {
        if (dto == null) {
            return null;
        }

        Endereco endereco = new Endereco();
        endereco.setCep(dto.getCep());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setComplemento(dto.getComplemento());
        endereco.setBairro(dto.getBairro());
        endereco.setLocalidade(dto.getLocalidade());
        endereco.setUf(dto.getUf());
        endereco.setIbge(dto.getIbge());
        endereco.setGia(dto.getGia());
        endereco.setDdd(dto.getDdd());
        endereco.setSiafi(dto.getSiafi());

        return endereco;
    }

    @Override
    public EnderecoDTO convertFromEntity(Endereco entity) {
        if (entity == null) {
            return null;
        }

        EnderecoDTO dto = new EnderecoDTO();
        dto.setCep(entity.getCep());
        dto.setLogradouro(entity.getLogradouro());
        dto.setComplemento(entity.getComplemento());
        dto.setBairro(entity.getBairro());
        dto.setLocalidade(entity.getLocalidade());
        dto.setUf(entity.getUf());
        dto.setIbge(entity.getIbge());
        dto.setGia(entity.getGia());
        dto.setDdd(entity.getDdd());
        dto.setSiafi(entity.getSiafi());

        return dto;
    }
}
