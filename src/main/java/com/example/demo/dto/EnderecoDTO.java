package com.example.demo.dto;

/**
 * Representa um Data Transfer Object (DTO) para a entidade Endereço.
 * Contém os dados necessários para transferir informações sobre um endereço.
 */
public class EnderecoDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;

    private String siafi;

    /**
     * Retorna o CEP do endereço.
     *
     * @return o CEP do endereço
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o CEP do endereço.
     *
     * @param cep o novo CEP do endereço
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna o logradouro do endereço.
     *
     * @return o logradouro do endereço
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Define o logradouro do endereço.
     *
     * @param logradouro o novo logradouro do endereço
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * Retorna o complemento do endereço.
     *
     * @return o complemento do endereço
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço.
     *
     * @param complemento o novo complemento do endereço
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Retorna o bairro do endereço.
     *
     * @return o bairro do endereço
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do endereço.
     *
     * @param bairro o novo bairro do endereço
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Retorna a localidade (cidade) do endereço.
     *
     * @return a localidade do endereço
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Define a localidade do endereço.
     *
     * @param localidade a nova localidade do endereço
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Retorna a Unidade Federativa (UF) do endereço.
     *
     * @return a UF do endereço
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define a Unidade Federativa (UF) do endereço.
     *
     * @param uf a nova UF do endereço
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Retorna o código do município (IBGE).
     *
     * @return o código IBGE do município
     */
    public String getIbge() {
        return ibge;
    }

    /**
     * Define o código do município (IBGE).
     *
     * @param ibge o novo código IBGE do município
     */
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    /**
     * Retorna o código GIA do endereço.
     *
     * @return o código GIA do endereço
     */
    public String getGia() {
        return gia;
    }

    /**
     * Define o código GIA do endereço.
     *
     * @param gia o novo código GIA do endereço
     */
    public void setGia(String gia) {
        this.gia = gia;
    }

    /**
     * Retorna o código DDD da localidade.
     *
     * @return o código DDD da localidade
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * Define o código DDD da localidade.
     *
     * @param ddd o novo código DDD da localidade
     */
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    /**
     * Retorna o código SIAFI da localidade.
     *
     * @return o código SIAFI da localidade
     */
    public String getSiafi() {
        return siafi;
    }

    /**
     * Define o código SIAFI da localidade.
     *
     * @param siafi o novo código SIAFI da localidade
     */
    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
