package br.com.zpx.petshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zpx.petshop.config.PetMachineConfig;
import br.com.zpx.petshop.domain.PetMachine;
import br.com.zpx.petshop.exception.OperacaoInvalidaException;

public class PetMachineServiceImp implements PetMachineService {

    private static final Logger LOG = LoggerFactory.getLogger(PetMachineServiceImp.class);

    // Obrigado Martin Fowler (um dos pais dos padrões de arquitetura moderna) em
    // 2004, no artigo famoso “Inversion of Control Containers and the Dependency
    // Injection pattern”.
    private final PetMachine maquina;

    public PetMachineServiceImp(PetMachine maquina) {
        this.maquina = maquina;
    }

    @Override
    public void darBanhoPet() {

    }

    @Override
    public void abastecerAgua() {
        if (maquina.getNivelAtualAgua() + PetMachineConfig.ABASTECER_AGUA > PetMachineConfig.CAP_MAX_AGUA) {
            throw new OperacaoInvalidaException("Desculpe seu nivel atual de agua ultrapassa o limite maximo de 30L");
        } else {

            maquina.setNivelAtualAgua(maquina.getNivelAtualAgua() + PetMachineConfig.ABASTECER_AGUA);

            LOG.info("Abastecendo 2L de água. Nível atual: " + maquina.getNivelAtualAgua() + "L");
        }
    }

    @Override
    public void abastecerShampoo() {
    }

    @Override
    public void colocarPetMaquina() {
    }

    @Override
    public void retirarPetMaquina() {
    }

    @Override
    public void limparMaquina() {
    }
}
