package br.com.zpx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zpx.petshop.domain.PetMachine;
import br.com.zpx.petshop.exception.OperacaoInvalidaException;
import br.com.zpx.petshop.exception.RecursoInsuficienteException;
import br.com.zpx.petshop.service.PetMachineService;
import br.com.zpx.petshop.service.PetMachineServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        final Logger LOG = LoggerFactory.getLogger(App.class);

        try {

            PetMachine petMachine = new PetMachine();
            PetMachineService service = new PetMachineServiceImpl(petMachine);

            // APENAS PARA TESTES SIMPLES
            petMachine.setNivelAtualAgua(28);
            petMachine.setNivelAtualShampoo(8);
            petMachine.setQuantAtualPet(0);

            // UTILIZANDO O SERVICE
            service.abastecerAgua();
            service.abastecerShampoo();
            service.colocarPetMaquina();
            service.retirarPetMaquina();
            service.limparMaquina();
            service.colocarPetMaquina();
            service.darBanhoPet();

        } catch (OperacaoInvalidaException | RecursoInsuficienteException exception) {

            LOG.info("Operação bloqueada: " + exception.getMessage());

        }

    }
}
