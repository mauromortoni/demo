package com.example.demo.converter;

/**
 * Interface genérica para conversão entre DTOs e entidades.
 *
 * @param <D> o tipo do DTO
 * @param <E> o tipo da entidade
 */
public interface Converter<D, E> {

    /**
     * Converte um DTO para uma entidade.
     *
     * @param dto o DTO a ser convertido
     * @return a entidade correspondente
     */
    E convertFromDTO(D dto);

    /**
     * Converte uma entidade para um DTO.
     *
     * @param entity a entidade a ser convertida
     * @return o DTO correspondente
     */
    D convertFromEntity(E entity);
}
