# PetShop Máquina de Banho 🛁🐶

**Projeto de estudo em Java com foco em boas práticas, arquitetura limpa e evolução progressiva.**

Uma simples máquina automática de banho para pets que começou como exercício de POO e evoluiu para um código **profissional, organizado e pronto para produção**.

### Objetivo do Projeto

Praticar e consolidar conceitos fundamentais de Java de forma progressiva:

- Orientação a Objetos sólida
- Separação de responsabilidades (SOLID)
- Injeção de dependências manual
- Tratamento de erros com exceções personalizadas
- Logging profissional (SLF4J)
- Organização de constantes
- Gerenciamento de dependências com **Maven**

### Regras de Negócio da Máquina

- Apenas **1 pet por vez**
- Banho consome **10L de água** e **2L de shampoo**
- Capacidade máxima: **30L de água** e **10L de shampoo**
- Abastecimento adiciona **2L por vez**
- Pet retirado sujo → máquina precisa ser limpa antes do próximo uso
- Limpeza consome **3L de água** e **1L de shampoo**
- Não é possível limpar com pet dentro

### Arquitetura do Projeto (Clean Architecture)

```
src/main/java/br/com/zpx/petshop/
├── domain/          → Entidade pura (estado da máquina)
├── config/          → Constantes da máquina (classe final com construtor privado)
├── exception/       → Exceções personalizadas de domínio
├── service/         → Interface + Implementação (lógica de negócio + logging)
└── presentation/    → Main (orquestração e execução console)
```

### Tecnologias e Boas Práticas Utilizadas

- **Java 17**
- **Maven** (gerenciamento de build e dependências)
- **SLF4J** com implementação simple (logging profissional com níveis INFO/WARN/ERROR)
- **Injeção de Dependências** pelo construtor (manual – como o Spring faz por baixo dos panos)
- **Exceções personalizadas** para erros de operação e recurso
- **Constantes centralizadas** em classe dedicada
- **Programação para interfaces** (PetMachineService + Impl)

### Como Executar

```bash
# Compilar
mvn compile

# Executar
mvn exec:java -Dexec.mainClass="br.com.zpx.petshop.presentation.Main"
```

### Exemplo de Saída (logs)

```
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Abastecendo 2L de água. Nível atual: 30L
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Seu Pet foi colocado na Maquina com sucesso, e esta tranquilo!
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Maquina tocando: Tchau sujeira!
[main] INFO  br.com.zpx.petshop.service.PetMachineServiceImpl - Banho concluido com sucesso, volte sempre!
```

### Próximos Passos (em andamento/planejados)

- Transformar em API REST com Javalin (JSON, HTTP status, DTOs)
- Migrar para Spring Boot (@RestController, ResponseEntity, etc.)
- Adicionar testes unitários com JUnit 5
- Documentação OpenAPI/Swagger

---

**Feito com dedicação como parte da jornada de aprendizado em Java backend.**

Qualquer feedback ou sugestão é bem-vindo! 🚀

```

```
