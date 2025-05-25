# Sistema mini Aluguel de Carros (Backend)

Este projeto é uma aplicação backend para um sistema de aluguel de carros, desenvolvida utilizando Spring Boot. Ele permite o gerenciamento de carros e clientes, com um foco na relação de aluguel.

---

## 🚀 Tecnologias Utilizadas

A aplicação foi construída com as seguintes tecnologias:

* **Spring Boot**: Framework para o desenvolvimento rápido de aplicações Java.
* **Banco de Dados H2**: Um banco de dados em memória, ideal para desenvolvimento e testes, facilitando o setup inicial.
* **Flyway**: Gerenciamento de migrações de banco de dados, garantindo que o esquema do banco esteja sempre atualizado.
* **JPA (Java Persistence API)**: Padrão para mapeamento objeto-relacional, simplificando a interação com o banco de dados.
* **Spring Data JPA**: Abstração que facilita ainda mais a criação de repositórios e a interação com o banco de dados.
* **Maven**: Ferramenta para gerenciamento de dependências e build do projeto.
* **SQL**: Linguagem padrão para manipulação do banco de dados.
* **Git**: Sistema de controle de versão distribuído.
* **GitHub**: Plataforma para hospedagem de repositório e colaboração de código.

---

## 🏛️ Design do Banco de Dados

O esquema do banco de dados foi projetado com as seguintes entidades e relacionamentos:

* **`Carro`**:
    * `id` (Chave Primária)
    * `marca`
    * `modelo`
    * `status` (Indicando se está disponível, alugado, etc.)
    * **Relacionamento**: Um `Carro` pode ser alugado por **apenas um** `Cliente`.

* **`Cliente`**:
    * `id` (Chave Primária)
    * `nome`
    * `email`
    * **Relacionamento**: Um `Cliente` pode alugar **vários** `Carros`.

Isso estabelece uma relação de **um-para-muitos** de `Cliente` para `Carro`.

---

## ⚙️ Como Rodar o Projeto

Siga os passos abaixo para colocar o projeto em funcionamento na sua máquina local:

### Pré-requisitos

Certifique-se de ter o seguinte instalado:

* **Java Development Kit (JDK) 17** ou superior
* **Maven**
* **Git**

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git](https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git)
    cd SEU_REPOSITORIO
    ```
    *(Substitua `SEU_USUARIO` e `SEU_REPOSITORIO` pelos dados corretos do seu projeto no GitHub)*

2.  **Compile o projeto com Maven:**
    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

A aplicação será iniciada e o banco de dados H2 será criado em memória. Você poderá acessar a console do H2 (se configurado para isso) e os endpoints da API (geralmente em `http://localhost:8080`).

---

## 🤝 Contribuição

Fique à vontade para contribuir com este projeto! Se você encontrar bugs, tiver sugestões de melhoria ou quiser adicionar novas funcionalidades, por favor:

1.  Faça um fork do repositório.
2.  Crie uma nova branch (`git checkout -b feature/sua-feature`).
3.  Faça suas alterações e commit (`git commit -m 'feat: adiciona nova funcionalidade'`).
4.  Envie para a branch (`git push origin feature/sua-feature`).
5.  Abra um Pull Request.

---

## 📄 Licença

Este projeto está licenciado sob a licença [Nome da Licença, por exemplo, MIT License]. Consulte o arquivo `LICENSE` para mais detalhes. *(Crie um arquivo LICENSE no seu repositório se ainda não tiver um!)*
