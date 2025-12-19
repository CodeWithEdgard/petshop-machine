package entities;

public class PetMachine {

    private int nivelAtualAgua = 0;
    private int nivelAtualShampoo = 0;
    private int quantAtualPet = 0;

    private boolean petEstaLimpo = false;

    public int getNivelAtualAgua() {
        return this.nivelAtualAgua;
    }

    public void darBanhoPet() {

        final int GASTO_AGUA = 10;
        final int GASTO_SHAMPOO = 2;

        if (nivelAtualAgua < GASTO_AGUA) {

            System.out.println("Desculpe o seu nivel de agua esta abaixo do permitido para dar banho!");
            return;

        } else if (nivelAtualShampoo < GASTO_SHAMPOO) {

            System.out.println("Desculpe o seu nivel de shampoo esta abaixo do permitido para dar banho!");
            return;

        } else if (quantAtualPet == 0) {

            System.out.println("Desculpe a maquina esta vazia, adicionar o pet para dar banho");

        } else {

            System.out.println("Dando banho no pet: au au");
            nivelAtualAgua -= 10;
            nivelAtualShampoo -= 2;
            petEstaLimpo = true;

        }

    }

    // O abastecimento de água e shampoo deve permitir 2 litros por vez que for
    // acionado;
    public void abastecerAgua() {

        final int ABASTECER_AGUA = 2;
        final int CAP_MAX_AGUA = 30;

        if (nivelAtualAgua > CAP_MAX_AGUA) {

            getNivelAtualAgua();

            System.out.println("Desculpe seu nivel atual de agua ultrapassa o limite maximo de 30");
            return;

        } else {

            System.out.println("Voce esta abastecendo de agua:");

            nivelAtualAgua += ABASTECER_AGUA;

            System.out.println("Nivel atual de agua: " + getNivelAtualAgua());

        }

    }

    public void abastecerShampoo() {

        // O abastecimento de água e shampoo deve permitir 2 litros por vez que for
        // acionado;
        final int CAP_MAX_SHAMPOO = 10;
        final int ABASTECER_SHAMPOO = 2;

        if (nivelAtualShampoo > CAP_MAX_SHAMPOO) {

            System.out.println("Desculpe seu nivel atual de shampoo ultrapassa o limite maximo de 10");
            return;

        } else {

            System.out.println("abastecendo o nivel de shampoo");
            nivelAtualShampoo += ABASTECER_SHAMPOO;
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

            System.out.println("Desculpe só e permitido a entrada de 1 pet por vez");
            return;

        } else {

            System.out.println("Colocando pet dentro da maquina!");

            quantAtualPet = +1;

        }

    }

    public void retirarPetMaquina() {
        // Se o pet for retirado da maquina sem estar limpo será necessário limpar a
        // máquina para permitir a entrada de outro pet;
        if (quantAtualPet == 1) {
            quantAtualPet -= 1;
        }

        if (!petEstaLimpo) {
            System.out.println("Pet esta sujo, retirando e limpando a maquina");
            return;
        }

        System.out.println("retirando o pet");
        quantAtualPet -= 1;

    }

    public void limparMaquina() {

        if (quantAtualPet == 1) {
            System.out.println("Desculpe para limpar a maquina não pode ter nenhum pet dentro");
        }

        // A limpeza da máquina ira consumir 3 litros de água e 1 litro de shampoo;
        nivelAtualAgua -= 3;
        nivelAtualShampoo -= 1;
        System.out.println("Limpeza da Maquina concluida com sucesso!");
    }

}