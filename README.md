# PetShop Máquina de Banho 🛁🐶

**Projeto de estudo em Java com arquitetura limpa, boas práticas e testes unitários.**

Uma máquina automática de banho para pets que começou como exercício simples de POO e evoluiu para código **testado e organizado**.

### Objetivo do Projeto

Consolidar conceitos fundamentais de Java de forma progressiva:

- Orientação a Objetos sólida
- Princípios SOLID e separação de responsabilidades
- Injeção de dependências manual (construtor)
- Tratamento de erros com exceções personalizadas
- Logging profissional com SLF4J
- Organização de constantes
- Gerenciamento de dependências e build com **Maven**
- **Testes unitários automatizados** com JUnit 5
- Relatório de cobertura com **JaCoCo**

### Regras de Negócio da Máquina

- Apenas **1 pet por vez**
- Banho consome **10L de água** e **2L de shampoo**
- Capacidade máxima: **30L de água** e **10L de shampoo**
- Abastecimento adiciona **2L por vez**
- Pet retirado sujo → máquina deve ser limpa antes do próximo uso
- Limpeza consome **3L de água** e **1L de shampoo**
- Não é possível limpar com pet dentro

### Arquitetura do Projeto (Clean Architecture)

```
src/main/java/br/com/zpx/petshop/
├── domain/          → Entidade pura (estado da máquina)
├── config/          → Constantes (classe final com construtor privado)
├── exception/       → Exceções personalizadas de domínio
├── service/         → Interface + Implementação (lógica de negócio + logging)
└── presentation/    → DemoConsole (exemplo de uso manual)
```

### Tecnologias e Boas Práticas

- **Java 17**
- **Maven** (build e dependências)
- **SLF4J + simple** (logging com níveis INFO/WARN/ERROR)
- **JUnit 5** (testes unitários)
- **JaCoCo** (cobertura de testes)
- Injeção de dependências manual
- Programação para interfaces
- Exceções personalizadas
- Constantes centralizadas

### Cobertura de Testes (JaCoCo)

> (Gerado localmente com `mvn clean test jacoco:report`)

### Como Executar

```bash
# Rodar testes unitários
mvn clean test

# Executar demo no console
mvn exec:java -Dexec.mainClass="br.com.zpx.petshop.presentation.DemoConsole"
```

### Exemplo de Logs (demo console)

```
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Abastecendo 2L de água. Nível atual: 30L
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Seu Pet foi colocado na Maquina com sucesso!
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Maquina tocando: Tchau sujeira!
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Banho concluido com sucesso, volte sempre!
```

### Próximos Passos Planejados

- Transformar em API REST com Javalin (JSON, HTTP status, DTOs)
- Migrar para Spring Boot completo
- Adicionar testes de integração
- Documentação com OpenAPI/Swagger

---

**Projeto feito com dedicação como parte da jornada de aprendizado em Java backend.**

Feedback e sugestões são super bem-vindos! 🚀
