package br.com.zpx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.zpx.petshop.domain.PetMachine;
import br.com.zpx.petshop.exception.OperacaoInvalidaException;
import br.com.zpx.petshop.service.PetMachineServiceImpl;

// mvn test = para executar os testes

public class PetMachineServiceImplTest {

    private PetMachine maquina;
    private PetMachineServiceImpl service;

    @BeforeEach
    void setUp() {
        // Arrange - Preparar o cenário
        maquina = new PetMachine();
        service = new PetMachineServiceImpl(maquina);
    }

    @Test
    @DisplayName("Deve abastecer de Agua se tiver espaço")
    void deveAbastecerAguaComEspaco() {

        // Act - Executar a ação que queremos testar
        service.abastecerAgua();

        // Assert - Verificar se o resultado está correto
        assertEquals(2, maquina.getNivelAtualAgua());
    }

    @Test
    @DisplayName("Verifica se ultrapassando o limite de abastecer Agua e  lança exceção")
    void deveLancarExcecaQuandoAbastecerAguaExcederCapacidade() {

        // Arrange
        for (int i = 0; i < 15; i++) {
            service.abastecerAgua();
        }

        // Act + Assert
        OperacaoInvalidaException excecao = assertThrows(OperacaoInvalidaException.class,
                () -> service.abastecerAgua());

        // verifica se a mensagem está correta
        assertTrue(excecao.getMessage().contains("ultrapassa"));
    }

    @Test
    @DisplayName("Quando estiver vazia colocar o pet com sucesso")
    void deveColocarPetQuandoVazia() {

        // Act
        service.colocarPetMaquina();

        assertEquals(1, maquina.getQuantAtualPet());
        assertFalse(maquina.getPetEstaLimpo());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar colocar pet com máquina ocupada")
    void deveLancarExcecaoAoColocarSegundoPet() {

        service.colocarPetMaquina();

        OperacaoInvalidaException excecao = assertThrows(OperacaoInvalidaException.class,
                () -> service.colocarPetMaquina());

        assertTrue(excecao.getMessage().contains("entrada"));
    }

    @Test
    @DisplayName("Deve dar banho com sucesso quando tem pet e recursos suficientes")
    void deveDarBanhoComSucesso() {

        for (int i = 0; i < 15; i++) {

            service.abastecerAgua();
        }

        for (int i = 0; i < 5; i++) {

            service.abastecerShampoo();
        }

        service.colocarPetMaquina();

        service.darBanhoPet();

        assertTrue(maquina.getPetEstaLimpo());
        assertEquals(30 - 10, maquina.getNivelAtualAgua());
        assertEquals(10 - 2, maquina.getNivelAtualShampoo());
    }

    @Test
    @DisplayName("Deve lançar exceção ao dar banho sem pet na máquina")
    void deveLancarExcecaoDarBanhoSemPet() {

        OperacaoInvalidaException excecao = assertThrows(
                OperacaoInvalidaException.class,
                () -> service.darBanhoPet());

        assertTrue(excecao.getMessage().contains("Não há pet"));
    }

}
