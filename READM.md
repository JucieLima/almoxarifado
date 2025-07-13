# Sistema de Almoxarifado com JavaFX e Spring Boot

![JavaFX Logo](https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/javafx/javafx.png) 

<img src="https://spring.io/img/projects/spring-boot.svg" width="300">

![MySQL Logo](https://www.mysql.com/common/logos/logo-mysql-170x115.png)

Este projeto é um **Sistema de Almoxarifado** em desenvolvimento, construído passo a passo através de uma playlist de vídeos no YouTube. O objetivo principal é proporcionar um aprendizado prático e aprofundado em **JavaFX** para a criação de interfaces gráficas, além de integrar e explorar outras tecnologias modernas como **Spring Boot**, **MySQL** e **JPA** para a construção de uma aplicação robusta e escalável.

Ideal para quem busca aprender o ecossistema Java para desenvolvimento de sistemas desktop com persistência de dados e uma arquitetura organizada.

---

## 🚀 Tecnologias Utilizadas

* **Java JDK 21**: Linguagem de programação principal.
* **JavaFX 23.0.1**: Framework para construção de interfaces gráficas de usuário (GUI).
    * **Scene Builder**: Ferramenta visual para design de layouts FXML.
    * **Ikonli (Material Design Icons)**: Biblioteca para integração fácil de ícones vetoriais.
* **Spring Boot 3.5.3**: Framework para facilitar o desenvolvimento de aplicações Java, provendo autoconfiguração e injeção de dependências.
    * **Spring Data JPA**: Abstração para persistência de dados em bancos de dados relacionais.
* **MySQL Server 8.0**: Sistema de gerenciamento de banco de dados relacional.
    * **MySQL Workbench**: Ferramenta visual para modelagem e administração de bancos de dados MySQL.
    * **`mysql-connector-j`**: Driver JDBC para conexão com MySQL.
* **Lombok**: Biblioteca que reduz o código boilerplate (repetitivo) em classes Java.
* **Maven**: Ferramenta de automação de construção e gerenciamento de dependências.
* **IntelliJ IDEA Community Edition**: IDE principal de desenvolvimento.
* **VS Code**: Utilizado para edição e estilização de arquivos CSS com suporte a JavaFX.

---

## 🛠️ Configuração e Ambiente de Desenvolvimento

O projeto foi configurado com foco em um ambiente de desenvolvimento robusto e eficiente.

* **JDK 21**: Certifique-se de ter o Java Development Kit versão 21 instalado.
* **IntelliJ IDEA**: É a IDE recomendada para o desenvolvimento do projeto.
* **Scene Builder**: Essencial para a criação e edição das telas FXML. Deve ser configurado para funcionar com o IntelliJ IDEA.
* **MySQL Server e Workbench**: Instale o MySQL para gerenciar o banco de dados.

O arquivo `pom.xml` já vem configurado com todas as dependências necessárias, incluindo JavaFX, Spring Boot JPA, MySQL Connector e Lombok, além dos plugins Maven para execução e empacotamento.

---

## 🎯 Funcionalidades Atuais (até o Vídeo 18)

Até o momento, o projeto abrange as seguintes áreas, focando principalmente na construção das interfaces de usuário e na configuração da infraestrutura:

### 1. **Configuração de Ambiente e Projeto**
* Instalação e configuração do Java JDK, IntelliJ IDEA e Scene Builder.
* Criação e configuração inicial do projeto JavaFX com Maven.
* Integração do Spring Boot ao projeto JavaFX, permitindo a injeção de dependências nos controllers.
* Estruturação de diretórios para assets, estilos, imagens e pacotes.

### 2. **Modelagem e Banco de Dados**
* Planejamento detalhado das entidades do banco de dados: `Usuários`, `Materiais`, `Categorias`, `Pedidos`, `Itens de Pedido` e `Movimentações`.
* Criação do banco de dados e modelagem das tabelas (`users`, `materials`, `categories`, `orders`, `order_movements`) utilizando MySQL Workbench.
* Definição de colunas, tipos de dados, restrições e chaves estrangeiras.

### 3. **Interface Gráfica (JavaFX)**
* **Conceitos Fundamentais**: Utilização de Containers (AnchorPane, Pane, VBox, HBox, StackPane, BorderPane, GridPane) e Controls (Label, TextField, Button, TextArea, TableView, Pagination, RadioButton, ComboBox).
* **Estilização Avançada**: Aplicação de CSS inline e externos (`style.css`), uso de paletas de cores personalizadas, gradientes, sombras (`DropShadow`), efeitos de hover e personalização de elementos.
* **Integração de Ícones**: Uso da biblioteca Ikonli e Material Design Icons para enriquecer a interface visual.
* **Estrutura de Telas**:
    * **Tela de Login**: Interface inicial com campos de usuário e senha, estilização de botões e mensagens de erro ocultas.
    * **Dashboard**: Layout principal com barra superior (AppBar) com ícones interativos, painel lateral (SideBar) com menu dinâmico, e área central para cards informativos, gráficos (linha e pizza) e tabelas.
    * **Tela de Materiais**: Interface para listagem de materiais, com filtros, campo de pesquisa e paginação.
    * **Tela de Usuários**: Exibição de usuários com campos específicos e botões de ação.
    * **Tela de Cadastro de Usuários**: Formulário para inserção de novos usuários com campos detalhados e botão "Voltar".
    * **Tela de Relatórios**: Design inicial com GridPane para organizar múltiplos blocos de conteúdo e barra de navegação tipo Breadcrumbs.
* **Eventos e Interatividade**: Programação de ações de clique (`onMouseClicked`, `onAction`) em menus e botões, vinculação de métodos de eventos no Scene Builder aos controllers Java.

---

## ⚙️ Como Executar o Projeto

1.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/JucieLima/almoxarifado.git](https://github.com/JucieLima/almoxarifado.git)
    cd almoxarifado
    ```
2.  **Configure o Banco de Dados:**
    * Certifique-se de ter o MySQL Server 8.0 instalado e funcionando.
    * Crie um banco de dados conforme a modelagem explicada nos vídeos (ou execute os scripts SQL gerados pelo MySQL Workbench).
    * No arquivo `src/main/resources/application.properties`, configure as credenciais do seu banco de dados:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_seu_banco
        spring.datasource.username=seu_usuario
        spring.datasource.password=sua_senha
        spring.jpa.hibernate.ddl-auto=update # ou none, se você já tiver o schema
        ```
3.  **Abra no IntelliJ IDEA:**
    * Abra o projeto no IntelliJ IDEA.
    * O Maven deverá baixar automaticamente todas as dependências listadas no `pom.xml`.
    * Garanta que o SDK do projeto esteja configurado para o **Java 21**.
4.  **Configure o Scene Builder:**
    * No IntelliJ, vá em `File > Settings > Languages & Frameworks > JavaFX`.
    * Certifique-se de que o caminho para o Scene Builder esteja configurado corretamente.
5.  **Remova `module-info.java`:** Conforme o vídeo 18, para integração com Spring Boot, o arquivo `module-info.java` pode ser removido ou seus `exports` e `opens` ajustados.
6.  **Execute a Aplicação:**
    * Execute a classe principal da sua aplicação (geralmente `StartApplication.java`).
    * Você também pode usar o comando Maven: `mvn clean javafx:run`

---

## 📺 Playlist no YouTube

Acompanhe o desenvolvimento completo deste sistema e aprenda JavaFX e Spring Boot do zero na playlist:

**[Link da Playlist do YouTube aqui](https://youtube.com/playlist?list=PL0jjh7ZB-bqa1_cfqgsyZWZ7Hjbf_rCCu&si=YxBMJJCRlcPaNjvd)**

---

## 🤝 Contribuição

Este projeto é uma jornada de aprendizado. Contribuições, sugestões e feedback são bem-vindos! Se você encontrar algum problema ou tiver ideias para melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

---

## 📄 Licença

[Defina a licença do seu projeto aqui, por exemplo: MIT License]