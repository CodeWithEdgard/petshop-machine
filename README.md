<div align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit 5">
  <img src="https://img.shields.io/badge/JaCoCo-3775A9?style=for-the-badge&logo=jacoco&logoColor=white" alt="JaCoCo">
  <img src="https://img.shields.io/badge/SLF4J-Logging-blue?style=for-the-badge" alt="SLF4J">
</div>

# PetShop Máquina de Banho 🛁🐶

**Simulador simples de uma máquina automática de banho para pets em Java.**

Projeto de estudo criado para praticar programação orientada a objetos e boas práticas de desenvolvimento backend. Começou como um exercício básico e virou um código organizado, testado e fácil de entender.

Qualquer pessoa consegue compreender o que faz, e recrutadores veem rapidamente as habilidades técnicas aplicadas.

[Índice](#índice) • [O que faz](#o-que-o-projeto-faz) • [Regras](#regras-simplificadas) • [Tecnologias](#tecnologias) • [Estrutura](#estrutura-do-código) • [Como rodar](#como-rodar) • [Testes](#testes) • [Contato](#contato)

## Índice

- [O que o projeto faz](#o-que-o-projeto-faz)
- [Regras simplificadas](#regras-simplificadas)
- [Tecnologias usadas](#tecnologias-usadas)
- [Estrutura do código](#estrutura-do-código)
- [Como rodar o projeto](#como-rodar-o-projeto)
- [Testes e cobertura](#testes-e-cobertura)
- [Contato e feedback](#contato-e-feedback)

## O que o projeto faz

Simula uma máquina automática de banho para pets (cães e gatos). Você pode:

- Abastecer água e shampoo
- Colocar um pet para tomar banho
- Iniciar o banho
- Retirar o pet (sujo ou limpo)
- Limpar a máquina quando necessário

A máquina tem regras realistas: não dá banho sem água ou shampoo suficiente, não limpa com pet dentro, etc. Tudo é validado automaticamente.

Ótimo exemplo de como modelar um sistema pequeno com regras de negócio claras.

## Regras simplificadas

- Só **1 pet por vez** dentro da máquina.
- Cada banho usa **10 litros de água** e **2 litros de shampoo**.
- Capacidade máxima: **30L de água** e **10L de shampoo**.
- Abastecimento adiciona **2L por vez** (de água ou shampoo).
- Se o pet sair **sujo** (banho não concluído), a máquina fica suja e precisa ser limpa antes do próximo uso.
- Limpeza gasta **3L de água** e **1L de shampoo**.
- Não é possível limpar com um pet dentro.

O código impede ações inválidas e avisa com mensagens claras.

## Tecnologias usadas

- **Java 17** → linguagem principal
- **Maven** → organiza o projeto e as dependências
- **SLF4J** → logs profissionais no console
- **JUnit 5** → testes unitários automáticos
- **JaCoCo** → mede a cobertura de testes

Boas práticas aplicadas:

- Princípios SOLID
- Injeção de dependências manual
- Exceções personalizadas
- Constantes centralizadas
- Programação para interfaces
- Arquitetura limpa (Clean Architecture)

## Estrutura do código

Tudo bem separado para facilitar a leitura e manutenção:

```

src/main/java/br/com/zpx/petshop/
├── domain/ → Classe principal da máquina (guarda o estado)
├── config/ → Constantes do sistema
├── exception/ → Erros personalizados
├── service/ → Regras de negócio + logs
└── presentation/ → DemoConsole (exemplo de uso no terminal)

```

## Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/petshop-maquina-banho.git
   cd petshop-maquina-banho
   ```

````

2. Rode os testes (sempre bom verificar):

   ```bash
   mvn clean test
   ```

3. Execute a demonstração no console:
   ```bash
   mvn exec:java -Dexec.mainClass="br.com.zpx.petshop.presentation.DemoConsole"
   ```

Você verá logs como estes:

```
[INFO] Abastecendo 2L de água. Nível atual: 30L
[INFO] Seu Pet foi colocado na Maquina com sucesso!
[INFO] Maquina tocando: Tchau sujeira!
[INFO] Banho concluido com sucesso, volte sempre!
```

Siga as opções no menu para testar todos os cenários!

## Testes e cobertura

Todas as regras importantes estão cobertas por testes unitários.
Cobertura alta nas partes críticas do código.

Para ver o relatório localmente:

```bash
mvn clean test jacoco:report
```

Abra o arquivo `target/site/jacoco/index.html` no navegador.

````
