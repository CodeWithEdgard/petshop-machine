package br.com.zpx.petshop.service;

import br.com.zpx.petshop.exception.OperacaoInvalidaException;
import br.com.zpx.petshop.exception.RecursoInsuficienteException;

public interface PetMachineService {

    public void darBanhoPet() throws OperacaoInvalidaException, RecursoInsuficienteException;

    public void abastecerAgua() throws OperacaoInvalidaException;

    public void abastecerShampoo() throws OperacaoInvalidaException;

    public void colocarPetMaquina() throws OperacaoInvalidaException;

    public void retirarPetMaquina() throws OperacaoInvalidaException;

    public void limparMaquina() throws OperacaoInvalidaException, RecursoInsuficienteException;

}
