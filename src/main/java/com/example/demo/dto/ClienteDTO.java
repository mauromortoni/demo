package com.example.demo.dto;

import com.example.demo.annotation.Coluna;
import com.example.demo.annotation.TipoDadoEngineEnum;

/**
 * Representa um Data Transfer Object (DTO) para a entidade Cliente.
 * Contém os dados necessários para transferir informações sobre um cliente.
 */
public class ClienteDTO {
    @Coluna(nome="id",
            anulavel=true,
            tipo=TipoDadoEngineEnum.INTEGER)
    private Integer id;

    @Coluna(nome="nome",
            min=5,
            max=50,
            tipo=TipoDadoEngineEnum.CHARACTER)
    private String nome;

    @Coluna(nome="email",
            min=5,
            max=100,
            tipo=TipoDadoEngineEnum.CHARACTER,
            regexp=".+@.+\\.[a-z]+",
            mensagem="Endereço de e-mail inválido!")
    private String email;

    private EnderecoDTO enderecoDTO;

    /**
     * Obtém o ID do cliente.
     *
     * @return o ID do cliente
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do cliente.
     *
     * @param id o ID do cliente
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return o nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nome o nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o EnderecoDTO associado ao cliente.
     *
     * @return o EnderecoDTO
     */
    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    /**
     * Define o EnderecoDTO associado ao cliente.
     *
     * @param enderecoDTO o EnderecoDTO
     */
    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
}
