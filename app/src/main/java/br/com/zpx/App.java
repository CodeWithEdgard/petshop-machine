package br.com.zpx;

import br.com.zpx.petshop.domain.PetMachine;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        PetMachine petMachine = new PetMachine();

        petMachine.setNivelAtualAgua(30);
        petMachine.setNivelAtualShampoo(10);
        petMachine.setQuantAtualPet(0);
        petMachine.setPetEstaLimpo(false);
    }
}
