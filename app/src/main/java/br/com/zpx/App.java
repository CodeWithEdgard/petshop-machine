package br.com.zpx;

import br.com.zpx.petshop.domain.PetMachine;
import br.com.zpx.petshop.service.PetMachineService;
import br.com.zpx.petshop.service.PetMachineServiceImp;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        PetMachine petMachine = new PetMachine();
        PetMachineService service = new PetMachineServiceImp(petMachine);

        petMachine.setNivelAtualAgua(28);
        // petMachine.setNivelAtualShampoo(10);
        // petMachine.setQuantAtualPet(0);
        // petMachine.setPetEstaLimpo(false);

        service.abastecerAgua();
    }
}
