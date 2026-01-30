# Sistema mini Aluguel de Carros (Backend)

Este projeto é uma aplicação backend para um sistema de aluguel de carros, desenvolvida utilizando Spring Boot. Ele permite o gerenciamento de carros e clientes, com um foco na relação de aluguel. Agora também inclui uma API de busca de vagas de emprego.

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
    * `ano`
    * `imagem`
    * **Relacionamento**: Um `Carro` pode ser alugado por **apenas um** `Cliente`.

* **`Cliente`**:
    * `id` (Chave Primária)
    * `nome`
    * `email`
    * **Relacionamento**: Um `Cliente` pode alugar **vários** `Carros`.

* **`Job`**:
    * `id` (Chave Primária)
    * `title`
    * `company`
    * `location`
    * `description`
    * `type`
    * `level`

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

## 📋 API de Vagas de Emprego

A aplicação inclui endpoints para gerenciar e buscar vagas de emprego, especialmente focada em vagas de Front End no Brasil.

### Endpoints disponíveis:

* **GET** `/job/` - Mensagem de boas-vindas
* **GET** `/job/listar` - Lista todas as vagas
* **GET** `/job/listar/{id}` - Busca uma vaga específica por ID
* **GET** `/job/buscar/localizacao/{location}` - Busca vagas por localização (ex: `/job/buscar/localizacao/Brazil`)
* **GET** `/job/buscar/titulo/{title}` - Busca vagas por título (ex: `/job/buscar/titulo/front`)
* **POST** `/job/adicionar` - Adiciona uma nova vaga
* **PUT** `/job/alterar/{id}` - Atualiza uma vaga existente
* **DELETE** `/job/deletar/{id}` - Remove uma vaga

### Exemplo de uso:

```bash
# Buscar vagas de Front End no Brasil
curl http://localhost:8080/job/buscar/titulo/front

# Buscar vagas no Brasil
curl http://localhost:8080/job/buscar/localizacao/Brazil

# Adicionar uma nova vaga
curl -X POST http://localhost:8080/job/adicionar \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Front End Developer",
    "company": "Tech Brasil LTDA",
    "location": "São Paulo, Brazil",
    "description": "Desenvolvedor Front End para trabalhar com React",
    "type": "Full-time",
    "level": "Pleno"
  }'
```

---

## 🤝 Contribuição

Fique à vontade para contribuir com este projeto! Se você encontrar bugs, tiver sugestões de melhoria ou quiser adicionar novas funcionalidades, por favor:

1.  Faça um fork do repositório.
2.  Crie uma nova branch (`git checkout -b feature/sua-feature`).
3.  Faça suas alterações e commit (`git commit -m 'feat: adiciona nova funcionalidade'`).
4.  Envie para a branch (`git push origin feature/sua-feature`).
5.  Abra um Pull Request.

---

