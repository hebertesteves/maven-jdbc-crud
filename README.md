# 🛢️ Maven JDBC CRUD  

Projeto desenvolvido como estudo de **JDBC com MySQL** e boas práticas de desenvolvimento backend em Java. Ele implementa um CRUD completo (Create, Read, Update e Delete) para a entidade **Cadastro**, utilizando conexão direta via JDBC e organização em camadas (Model, Repository, Sistema). 🚀  

---

## 📌 Índice  
- [Sobre o projeto](#-sobre-o-projeto)  
- [Como rodar](#-como-rodar)  
- [Funcionalidades](#-funcionalidades)  
- [Tecnologias utilizadas](#-tecnologias-utilizadas)  
- [Estrutura do projeto](#-estrutura-do-projeto)  
- [Exemplos de uso](#-exemplos-de-uso)  
- [Licença](#-licença)  

---

## 🔗 Sobre o projeto  

O **Maven JDBC CRUD** é uma aplicação simples em **Java + JDBC**, projetada para gerenciar cadastros de pessoas em um banco de dados **MySQL**.  

O projeto foi construído seguindo boas práticas de separação de responsabilidades:  

- **FabricaConexao** para abstrair a conexão com o banco.  
- **CadastroRepository** para implementar as operações CRUD.  
- **Cadastro** como classe de modelo (entidade).  
- **SistemaCadastro** como aplicação principal para testar as operações.  

---

## 🔧 Como rodar  

### Pré-requisitos  
- **Java 17+** ☕  
- **Maven** instalado  
- **MySQL** rodando localmente  

### Passos  

1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/maven-jdbc-crud.git
   cd maven-jdbc-crud
   ```

2. Crie o banco e tabela no MySQL:  
   ```sql
   CREATE DATABASE rocket_db;

   USE rocket_db;

   CREATE TABLE tab_cadastro (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100) NOT NULL,
       idade INT NOT NULL
   );
   ```

3. Configure usuário/senha do MySQL no arquivo `FabricaConexao.java`.  

4. Compile e rode:  
   ```bash
   mvn clean compile exec:java
   ```

---

## ✅ Funcionalidades  

- **Incluir** novo cadastro.  
- **Alterar** dados de um cadastro existente.  
- **Excluir** um cadastro pelo ID.  
- **Listar** todos os cadastros.  
- **Buscar** cadastro por ID.  

---

## 🛠️ Tecnologias utilizadas  

- **Java 17**  
- **Maven**  
- **MySQL**  
- **JDBC**  

---

## 📂 Estrutura do projeto  

```
maven-jdbc-crud/
 ┣ 📂 src/main/java
 ┃ ┣ Cadastro.java           → Classe de modelo
 ┃ ┣ CadastroRepository.java → CRUD com JDBC
 ┃ ┣ FabricaConexao.java     → Gerenciamento da conexão
 ┃ ┣ SistemaCadastro.java    → Classe principal para testes
 ┣ pom.xml                   → Dependências do Maven
 ┣ .gitignore
```

---

## 🔀 Exemplos de uso  

### Inserir cadastro  
```java
repository.incluir(new Cadastro("Maria", 17));
```

### Listar todos  
```java
List<Cadastro> cadastros = repository.listar();
```

### Buscar por ID  
```java
Cadastro c = repository.buscar(1);
```

### Alterar  
```java
Cadastro c = new Cadastro(1, "João", 25);
repository.alterar(c);
```

### Excluir  
```java
repository.excluir(1);
```

---

## 📜 Licença  

Este projeto está sob a licença **MIT** – sinta-se livre para usar, estudar e contribuir.  
