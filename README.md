# Baozi Store - API REST

Projeto desenvolvido como atividade prática do curso de Análise e Desenvolvimento de Sistemas.

A proposta foi criar uma API REST para uma loja fictícia chamada Baozi Store, especializada na venda de baozi, um alimento tradicional da culinária chinesa.

O sistema foi desenvolvido em Java com Spring Boot e permite realizar operações básicas de cadastro, consulta e exclusão de clientes, produtos e pedidos.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Banco de dados H2
- Maven
- Postman para os testes da API

## Funcionalidades

A API possui três partes principais:

**Clientes**
- Cadastrar clientes
- Listar clientes cadastrados
- Consultar cliente pelo ID
- Excluir cliente

**Produtos**
- Cadastrar produtos com nome, preço e disponibilidade em estoque
- Listar produtos
- Consultar produto pelo ID
- Excluir produto

**Pedidos**
- Cadastrar pedidos informando cliente, produto e quantidade
- Listar pedidos
- Consultar pedido pelo ID
- Excluir pedido

## Como executar

Para executar o projeto, é necessário ter o Java 21 instalado.

1. Baixar ou clonar o repositório.
2. Abrir o projeto no IntelliJ IDEA ou em outra IDE compatível.
3. Aguardar o Maven carregar as dependências.
4. Executar a classe `BaoziStoreApplication.java`.

A aplicação utiliza a porta 8080.

Os endpoints podem ser testados pelo Postman, utilizando o endereço `http://localhost:8080`.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | /clientes | Cadastrar cliente |
| GET | /clientes | Listar clientes |
| GET | /clientes/{id} | Consultar cliente |
| DELETE | /clientes/{id} | Excluir cliente |
| POST | /produtos | Cadastrar produto |
| GET | /produtos | Listar produtos |
| GET | /produtos/{id} | Consultar produto |
| DELETE | /produtos/{id} | Excluir produto |
| POST | /pedidos | Cadastrar pedido |
| GET | /pedidos | Listar pedidos |
| GET | /pedidos/{id} | Consultar pedido |
| DELETE | /pedidos/{id} | Excluir pedido |

## Testes

Os testes foram realizados no Postman, verificando as operações de cadastro, consulta, listagem e exclusão dos registros.

O banco H2 foi utilizado para armazenar os dados durante o desenvolvimento e os testes.

## Autor

Renan Pinheiro

Curso de Análise e Desenvolvimento de Sistemas.
