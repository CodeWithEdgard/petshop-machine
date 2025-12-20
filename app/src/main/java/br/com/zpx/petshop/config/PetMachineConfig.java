package br.com.zpx.petshop.config;

import br.com.zpx.petshop.exception.OperacaoInvalidaException;

public final class PetMachineConfig {

    // O abastecimento de água e shampoo deve permitir 2 litros por vez;
    public static final int ABASTECER_AGUA = 2;
    public static final int ABASTECER_SHAMPOO = 2;

    // A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
    public static final int CAP_MAX_AGUA = 30;
    public static final int CAP_MAX_SHAMPOO = 10;

    // Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
    public static final int GASTO_AGUA_BANHO = 10;
    public static final int GASTO_SHAMPOO_BANHO = 2;

    public static final int GASTO_AGUA_LIMPEZA = 3;
    public static final int GASTO_SHAMPOO_LIMPEZA = 1;

    private PetMachineConfig() {
        throw new OperacaoInvalidaException("Não é possivel instanciar a Config");
    }

}
