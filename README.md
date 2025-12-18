# 💰 Finance Manager (Java CLI)

Finance Manager é uma aplicação **CLI (Command Line Interface)** escrita em Java para gerenciar **receitas e despesas pessoais**.  
O foco do projeto **não é interface gráfica**, mas sim **arquitetura, organização de código e boas práticas**.

Este projeto foi desenvolvido como exercício prático para consolidar conceitos fundamentais de **Programação Orientada a Objetos** e **estruturação de sistemas**.

---

## ✨ Funcionalidades

- Registrar receitas (`income`)
- Registrar despesas (`expanse`)
- Calcular saldo total
- Visualizar histórico de transações
- Interface interativa via terminal (CLI)

---

## 🧠 Conceitos praticados

- Programação Orientada a Objetos (POO)
- Entidades imutáveis
- Separação de responsabilidades
- Repository Pattern (em memória)
- Service Layer (regras de negócio)
- Injeção de dependência manual
- Uso de `enum` para evitar valores inválidos
- Validação de entrada do usuário
- Organização em pacotes (`model`, `repository`, `service`, `cli`, `app`)

---


### Descrição das camadas

- **Transaction**
  - Entidade imutável que representa uma transação financeira
- **TransactionType**
  - Enum que define o tipo da transação (`INCOME` ou `EXPANSE`)
- **TransactionRepository**
  - Responsável por armazenar e fornecer transações (em memória)
- **FinanceService**
  - Contém as regras de negócio (validação, criação de transações e cálculo de saldo)
- **CliController**
  - Responsável por interpretar comandos digitados pelo usuário
- **Main**
  - Ponto de entrada da aplicação

---

## 🧾 Comandos disponíveis

```text
add income <amount> <category> <description>
add expanse <amount> <category> <description>
balance
history
help

---

## Exemplos

add income 1500 salario pagamento mensal
add expanse 45 comida almoço
balance
history

---

## Executar

1- Clone o Repositorio

git clone https://github.com/onlyvitor/finance-manager.git
cd finance-manager

2- Compile o projeto

javac src/**/*.java

3-Execute a aplicação

java app.Main
