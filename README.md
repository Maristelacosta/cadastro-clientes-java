# ☕ Cadastro de Clientes Java

## 📖 Sobre o Projeto
O Cadastro de Clientes Java é uma aplicação desenvolvida para praticar conceitos fundamentais da linguagem Java e da Programação Orientada a Objetos (POO). O sistema permite gerenciar informações de clientes de forma simples e organizada, simulando funcionalidades básicas utilizadas em sistemas empresariais.

## 🎯 Objetivos
- Praticar Programação Orientada a Objetos (POO)
- Desenvolver lógica de programação em Java
- Trabalhar com estruturas de dados e tratamento de exceções
- Implementar operações completas de cadastro, consulta, atualização e exclusão (CRUD)
- Aplicar boas práticas de arquitetura dividindo responsabilidades

## 🚀 Tecnologias Utilizadas
- Java
- Programação Orientada a Objetos (POO)
- Git e GitHub

## ✅ Funcionalidades
- Cadastro de clientes com validação de dados
- Consulta de clientes cadastrados (geral e por ID)
- Atualização de informações
- Exclusão de registros
- Tratamento de erros de entrada do usuário

## 📁 Estrutura do Projeto
cadastro-clientes-java/
│
├── src/
│   ├── Cliente.java
│   ├── ClienteService.java
│   └── Main.java
│
└── README.md

## 📚 Aprendizados
Durante o desenvolvimento deste projeto foram praticados conceitos como:
- Classes, Objetos e Encapsulamento
- Métodos e Atributos
- Estruturas de decisão e repetição
- Tratamento de exceções (`try-catch`, `IllegalArgumentException`)
- Organização de código em Java dividindo regras de negócio e interface
- Versionamento com Git e GitHub

## 🛠️ Como Executar o Projeto
1. Certifique-se de ter o **Java JDK** instalado em sua máquina.
2. Clone o repositório ou baixe os arquivos em formato ZIP.
3. Abra o terminal (PowerShell ou CMD) na pasta raiz do projeto.
4. Execute os comandos abaixo para compilar e rodar:

```bash
mkdir bin
javac -d bin src/Cliente.java src/ClienteService.java src/Main.java
java -cp bin Main
