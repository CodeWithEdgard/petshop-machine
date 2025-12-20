package entities;

import exception.OperacaoInvalidaException;
import exception.RecursoInsuficienteException;

public class PetMachine {

    private int nivelAtualAgua = 0;
    private int nivelAtualShampoo = 0;
    private int quantAtualPet = 0;
    private boolean petEstaLimpo = false;

    // O abastecimento de água e shampoo deve permitir 2 litros por vez;
    final int ABASTECER_AGUA = 2;
    final int ABASTECER_SHAMPOO = 2;

    // A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
    final int CAP_MAX_AGUA = 30;
    final int CAP_MAX_SHAMPOO = 10;

    // Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
    final int GASTO_AGUA_BANHO = 10;
    final int GASTO_SHAMPOO_BANHO = 2;

    private static final int GASTO_AGUA_LIMPEZA = 3;
    private static final int GASTO_SHAMPOO_LIMPEZA = 1;

    public void darBanhoPet() {
        if (quantAtualPet == 0) {
            throw new OperacaoInvalidaException("Não há pet na máquina para dar banho.");
        }

        if (nivelAtualAgua < GASTO_AGUA_BANHO) {
            throw new RecursoInsuficienteException(
                    "Água insuficiente para banho. Necessário: 10L, disponível: " + nivelAtualAgua + "L");
        }
        if (nivelAtualShampoo < GASTO_SHAMPOO_BANHO) {
            throw new RecursoInsuficienteException(
                    "Shampoo insuficiente para banho. Necessário: 2L, disponível: " + nivelAtualShampoo + "L");
        }

        nivelAtualAgua -= GASTO_AGUA_BANHO;
        nivelAtualShampoo -= GASTO_SHAMPOO_BANHO;
        petEstaLimpo = true;

        System.out.println("Maquina tocando: Tchau sujeira!\nAdeus cheirinho de suor! 🐶");
        System.out.println("Banho concluído com sucesso!");
    }

    public void abastecerAgua() {

        if (nivelAtualAgua + ABASTECER_AGUA > CAP_MAX_AGUA) {

            throw new OperacaoInvalidaException("Desculpe seu nivel atual de agua ultrapassa o limite maximo de 30L");

        } else {

            nivelAtualAgua += ABASTECER_AGUA;
            System.out.println("Abastecendo 2L de água. Nível atual: " + nivelAtualAgua + "L");

        }

    }

    public void abastecerShampoo() {

        if (nivelAtualShampoo + ABASTECER_SHAMPOO > CAP_MAX_SHAMPOO) {

            throw new OperacaoInvalidaException(
                    "Desculpe seu nivel atual de shampoo ultrapassa o limite maximo de 10L");

        } else {

            nivelAtualShampoo += ABASTECER_SHAMPOO;
            System.out.println("Abastecendo 2L de shampoo. Nível atual: " + nivelAtualShampoo + "L");

        }
    }

    public void verificarNivelAgua() {

        System.out.println("Nivel atual de agua: " + nivelAtualAgua);

    }

    public void verificarNivelShampoo() {

        System.out.println("Nivel atula de Shampoo: " + nivelAtualShampoo);
    }

    public void colocarPetMaquina() {

        // A maquina de banho deve permitir somente 1 pet por vez;
        if (quantAtualPet >= 1) {

            throw new OperacaoInvalidaException("Desculpe só e permitido a entrada de 1 pet por vez");

        } else {

            quantAtualPet = 1;
            petEstaLimpo = false;
            System.out.println("Pet colocado na máquina com sucesso!");

        }

    }

    public void retirarPetMaquina() {

        if (quantAtualPet == 0) {
            throw new OperacaoInvalidaException("Não há pet na máquina para retirar.");
        }

        if (!petEstaLimpo) {
            System.out.println("Atenção: Pet retirado sujo! A máquina precisa ser limpa antes do próximo uso.");
        } else {
            System.out.println("Pet limpo retirado com sucesso!");
        }

        quantAtualPet = 0;
        System.out.println("Retirando o Pet de dentro da Maquina!");

    }

    public void limparMaquina() {
        if (quantAtualPet > 0) {
            throw new OperacaoInvalidaException("Não é possível limpar a máquina com um pet dentro.");
        }
        if (nivelAtualAgua < GASTO_AGUA_LIMPEZA) {
            throw new RecursoInsuficienteException("Água insuficiente para limpeza (precisa de 3L).");
        }
        if (nivelAtualShampoo < GASTO_SHAMPOO_LIMPEZA) {
            throw new RecursoInsuficienteException("Shampoo insuficiente para limpeza (precisa de 1L).");
        }

        nivelAtualAgua -= GASTO_AGUA_LIMPEZA;
        nivelAtualShampoo -= GASTO_SHAMPOO_LIMPEZA;
        System.out.println("Limpeza da máquina concluída com sucesso!");
    }

}