# Finance Manager (Java)

Projeto simples em Java para gerenciar entradas e saídas financeiras, com foco em **organização de código**, **orientação a objetos** e **separação de responsabilidades**.

O objetivo principal não é interface gráfica, mas aprender a estruturar um sistema de forma correta.

---

## Funcionalidades

- Registrar receitas (Income)
- Registrar despesas (Expense)
- Calcular saldo total
- Armazenar transações em memória

---

## Conceitos praticados

- Programação Orientada a Objetos (POO)
- Imutabilidade de entidades
- Separação de responsabilidades
- Repository Pattern (em memória)
- Service Layer
- Injeção de dependência manual
- Uso de `enum` para evitar valores inválidos

---

## Estrutura do projeto

- **Transaction**
  - Entidade imutável que representa uma transação financeira
- **TransactionType**
  - Enum que define o tipo da transação (INCOME ou EXPENSE)
- **TransactionRepository**
  - Responsável por armazenar e fornecer transações
- **FinanceService**
  - Contém as regras de negócio (validação, criação de transações e cálculo de saldo)
- **Main**
  - Ponto de entrada da aplicação, responsável apenas por iniciar o sistema

---

## Como executar

1. Clone o repositório
2. Compile os arquivos Java
3. Execute a classe `Main`

Exemplo:
```bash
javac *.java
java Main
