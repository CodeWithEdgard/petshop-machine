import entities.PetMachine;
import exception.OperacaoInvalidaException;
import exception.RecursoInsuficienteException;

public class Main {
    public static void main(String[] args) throws Exception {

        PetMachine petMachine = new PetMachine();

        try {

            petMachine.verificarNivelAgua();
            petMachine.verificarNivelShampoo();

            petMachine.abastecerAgua();
            petMachine.abastecerAgua();
            petMachine.abastecerAgua();
            petMachine.abastecerAgua();
            petMachine.abastecerAgua();
            petMachine.abastecerShampoo();

            petMachine.verificarNivelAgua();
            petMachine.verificarNivelShampoo();

            petMachine.colocarPetMaquina();
            petMachine.darBanhoPet();
            petMachine.retirarPetMaquina();
            petMachine.limparMaquina();

        } catch (OperacaoInvalidaException | RecursoInsuficienteException e) {
            System.out.println("");
            System.out.println("Operação bloqueada:" + e.getMessage());
        }

    }
}
