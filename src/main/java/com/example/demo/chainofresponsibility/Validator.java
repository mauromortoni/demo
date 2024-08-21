package com.example.demo.chainofresponsibility;

import com.example.demo.handler.CampoObrigatorioException;

public interface Validator<T> {
    Validator<T> setNext(Validator<T> next);

    void validate(T obj) throws CampoObrigatorioException;
}
