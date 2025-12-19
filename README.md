# Máquina de Banho para Petshop 🛁🐶

Projeto simples em Java para simular o controle de uma máquina automática de banho para pets em um petshop.

Este é um exercício de lógica orientada a objetos que implementa regras de negócio específicas, praticando conceitos como:

- Encapsulamento
- Validação de estado
- Tratamento de erros com exceções
- Logging profissional (SLF4J)

## Regras da Máquina

- Permite apenas **1 pet por vez**
- Banho consome **10L de água** e **2L de shampoo**
- Capacidade máxima: **30L de água** e **10L de shampoo**
- Abastecimento adiciona **2L por vez** (água ou shampoo)
- Se o pet for retirado **sem estar limpo**, a máquina precisa ser limpa
- Limpeza consome **3L de água** e **1L de shampoo**
- Não é possível limpar com pet dentro

## Operações Disponíveis

- `colocarPet()`
- `retirarPet()`
- `darBanho()`
- `abastecerAgua()`
- `abastecerShampoo()`
- `limparMaquina()`
- Consultas de nível e status

## Tecnologias Utilizadas

- Java 17+ (ou a versão que você estiver usando)
- SLF4J para logging (boas práticas)
- Exceções personalizadas ou `IllegalStateException` para validações

## Como Executar

```bash
javac com/petshop/maquina/*.java
java com.petshop.maquina.Main
```
