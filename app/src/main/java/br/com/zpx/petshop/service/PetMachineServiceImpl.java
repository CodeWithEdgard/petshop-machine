package br.com.zpx.petshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zpx.petshop.config.PetMachineConfig;
import br.com.zpx.petshop.domain.PetMachine;
import br.com.zpx.petshop.exception.OperacaoInvalidaException;
import br.com.zpx.petshop.exception.RecursoInsuficienteException;

public class PetMachineServiceImpl implements PetMachineService {

    private static final Logger LOG = LoggerFactory.getLogger(PetMachineServiceImpl.class);

    // Obrigado Martin Fowler (um dos pais dos padrões de arquitetura moderna) em
    // 2004, no artigo famoso “Inversion of Control Containers and the Dependency
    // Injection pattern”.
    private final PetMachine maquina;

    public PetMachineServiceImpl(PetMachine maquina) {
        this.maquina = maquina;
    }

    @Override
    public void darBanhoPet() {

        if (maquina.getQuantAtualPet() == 0) {

            throw new OperacaoInvalidaException("Não há pet na máquina para dar banho.");

        } else if (maquina.getNivelAtualAgua() < PetMachineConfig.GASTO_AGUA_BANHO) {

            throw new RecursoInsuficienteException(
                    "Água insuficiente para banho. Necessário: 10L, disponível: " + maquina.getNivelAtualAgua() + "L");

        } else if (maquina.getNivelAtualShampoo() < PetMachineConfig.GASTO_SHAMPOO_BANHO) {

            throw new RecursoInsuficienteException(
                    "Shampoo insuficiente para banho. Necessário: 2L, disponível: " + maquina.getNivelAtualShampoo()
                            + "L");

        }

        maquina.setNivelAtualAgua(maquina.getNivelAtualAgua() - PetMachineConfig.GASTO_AGUA_BANHO);
        maquina.setNivelAtualShampoo(maquina.getNivelAtualShampoo() - PetMachineConfig.GASTO_SHAMPOO_BANHO);
        maquina.setPetEstaLimpo(true);

        LOG.info("Maquina tocando: Tchau sujeira!\nAdeus cheirinho de suor!");
        LOG.info("Banho concluido com sucesso, volte sempre!");

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

        if (maquina.getNivelAtualShampoo() + PetMachineConfig.ABASTECER_SHAMPOO > PetMachineConfig.CAP_MAX_SHAMPOO) {

            throw new OperacaoInvalidaException(
                    "Desculpe seu nivel atual de shampoo ultrapassa o limite maximo de 10L");

        } else {

            maquina.setNivelAtualShampoo(maquina.getNivelAtualShampoo() + PetMachineConfig.ABASTECER_SHAMPOO);
            LOG.info("Abastecendo 2L de shampoo. Nível atual: " + maquina.getNivelAtualShampoo() + "L");

        }
    }

    @Override
    public void colocarPetMaquina() {

        if (maquina.getQuantAtualPet() >= 1) {

            throw new OperacaoInvalidaException("Desculpe só e permitido a entrada de 1 pet por vez");

        } else {

            maquina.setQuantAtualPet(1);
            maquina.setPetEstaLimpo(false);

            LOG.info("Seu Pet foi colocado na Maquina com sucesso, e esta tranquilo!");

        }

    }

    @Override
    public void retirarPetMaquina() {

        if (maquina.getQuantAtualPet() == 0) {

            throw new OperacaoInvalidaException("Não tem nenhum pet na máquina para retirar.");
        }

        if (!maquina.getPetEstaLimpo()) {

            LOG.info("Atenção: Pet retirado sujo! A máquina precisa ser limpa antes do próximo uso.");

        } else {

            LOG.info("Pet limpo retirado com sucesso!");

        }

        maquina.setQuantAtualPet(0);
        LOG.info("Seu Pet foi Retirado de dentro da Maquina!");

    }

    @Override
    public void limparMaquina() {

        if (maquina.getQuantAtualPet() > 0) {

            throw new OperacaoInvalidaException("Não é possível limpar a máquina com um pet dentro.");

        } else if (maquina.getNivelAtualAgua() < PetMachineConfig.GASTO_AGUA_LIMPEZA) {

            throw new RecursoInsuficienteException("Água insuficiente para limpeza (precisa de 3L).");

        } else if (maquina.getNivelAtualShampoo() < PetMachineConfig.GASTO_SHAMPOO_LIMPEZA) {

            throw new RecursoInsuficienteException("Shampoo insuficiente para limpeza (precisa de 1L).");

        }

        maquina.setNivelAtualAgua(maquina.getNivelAtualAgua() - PetMachineConfig.GASTO_AGUA_LIMPEZA);
        maquina.setNivelAtualShampoo(maquina.getNivelAtualShampoo() - PetMachineConfig.GASTO_SHAMPOO_LIMPEZA);

        LOG.info("Limpeza da máquina concluída com sucesso!");

    }
}
