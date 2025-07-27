# Sistema de Almoxarifado com JavaFX e Spring Boot

![JavaFX Logo](https://raw.githubusercontent.com/github/explore/refs/heads/main/topics/javafx/javafx.png)

<img src="https://spring.io/img/projects/spring-boot.svg" width="300">

![MySQL Logo](https://www.mysql.com/common/logos/logo-mysql-170x115.png)

Este projeto é um **Sistema de Almoxarifado** em desenvolvimento, construído como parte de uma playlist de vídeos no YouTube para aprendizado prático e aprofundado. O objetivo é explorar tecnologias modernas como **JavaFX** para interfaces gráficas, **Spring Boot** para desenvolvimento back-end, e **MySQL** com **JPA** para persistência de dados, aplicando os princípios da **Clean Architecture**. O projeto gerencia entidades como `Usuários`, `Materiais`, `Pedidos` e `Movimentações`, servindo como um estudo de caso para boas práticas de desenvolvimento e uma adição robusta ao portfólio pessoal.

Ideal para quem deseja aprender o ecossistema Java, arquitetura de software, e desenvolvimento de sistemas desktop com persistência de dados.

---

## 🚀 Tecnologias Utilizadas

- **Java JDK 21**: Linguagem principal para desenvolvimento.
- **JavaFX 23.0.1**: Framework para interfaces gráficas (GUI).
    - **Scene Builder**: Ferramenta visual para design de layouts FXML.
    - **Ikonli (Material Design Icons)**: Biblioteca para ícones vetoriais.
- **Spring Boot 3.5.3**: Framework para desenvolvimento back-end com injeção de dependências e autoconfiguração.
    - **Spring Data JPA**: Abstração para persistência em bancos de dados relacionais.
- **MySQL Server 8.0**: Banco de dados relacional.
    - **MySQL Workbench**: Ferramenta para modelagem e administração do banco.
    - **mysql-connector-j**: Driver JDBC para conexão com MySQL.
- **MapStruct**: Biblioteca para mapeamento automático entre objetos (ViewModel, DTO, Entity), otimizando o desenvolvimento.
- **Lombok**: Reduz código boilerplate em classes Java.
- **Maven**: Gerenciamento de dependências e automação de build.
- **IntelliJ IDEA Community Edition**: IDE principal.
- **VS Code**: Usado para edição de arquivos CSS do JavaFX.

---

## 🏛️ Arquitetura do Projeto

O projeto segue os princípios da **Clean Architecture**, garantindo separação de responsabilidades, independência de frameworks, e manutenibilidade. Abaixo está a estrutura de pacotes e as decisões arquiteturais tomadas:

### **Estrutura de Pacotes**
```
com.almoxarifado
├── application
│   ├── dto
│   ├── usecase
│   └── usecase.impl
├── domain
│   ├── exception
│   ├── model
│   └── repository
└── infrastructure
    ├── gateway
    ├── config
    ├── database
    │   ├── entities
    │   └── repository
    └── javafx
        ├── controller
        └── viewModel
```

- **`application`**: Contém DTOs para transferência de dados entre camadas, interfaces de casos de uso (`usecase`) que definem a lógica de negócio, e suas implementações (`usecase.impl`).
- **`domain`**: Contém as entidades do negócio (`model`), interfaces de repositórios (`repository`) que definem contratos de acesso a dados, e exceções específicas do domínio (`exception`).
- **`infrastructure`**: Contém implementações específicas de frameworks:
    - `gateway`: Implementações dos repositórios que conectam os casos de uso ao banco de dados.
    - `database`: Entidades JPA (se separadas do domínio) e repositórios Spring Data JPA.
    - `javafx`: Controllers e ViewModels para a interface gráfica, com ViewModels em `infrastructure.javafx.viewModel` devido à sua dependência de propriedades do JavaFX (ex.: `StringProperty`).

### **Decisões Arquiteturais**
1. **Clean Architecture**:
    - Adotada para garantir que a lógica de negócio (casos de uso) seja independente de frameworks (JavaFX, Spring, JPA), facilitando testes e manutenção.
    - Cada camada tem uma responsabilidade clara:
        - **Controller**: Conecta a interface gráfica (JavaFX) aos casos de uso.
        - **UseCase**: Encapsula a lógica de negócio, recebendo e retornando DTOs.
        - **Gateway**: Abstrai o acesso a recursos externos (ex.: banco de dados).
        - **Repository**: Interface no domínio, com implementações na infraestrutura usando Spring Data JPA.
    - **Motivação**: Demonstrar boas práticas de arquitetura no portfólio, preparando o projeto para escalabilidade e mudanças futuras.

2. **ViewModel na camada de infraestrutura**:
    - Os ViewModels foram colocados em `infrastructure.javafx.viewModel`, pois são específicos do JavaFX, usando propriedades como `StringProperty` e `IntegerProperty` para data binding.
    - **Motivação**: Reforçar a separação entre a camada de apresentação (JavaFX) e as camadas de aplicação e domínio, mantendo a lógica de negócio independente.

3. **Mapeamento com MapStruct**:
    - Escolhido o **MapStruct** para mapeamento entre `ViewModel`, `DTO` e `Entity`, devido ao seu desempenho (geração de código em tempo de compilação), type-safety, e integração com Spring Boot.
    - **Motivação**: Reduzir código boilerplate, minimizar erros de mapeamento, e destacar no portfólio o uso de uma ferramenta moderna e amplamente adotada em projetos profissionais.
    - Exemplo de uso:
      ```java
      @Mapper(componentModel = "spring")
      public interface MaterialMapper {
          MaterialDTO viewModelToDto(MaterialViewModel viewModel);
          MaterialViewModel dtoToViewModel(MaterialDTO dto);
          Material dtoToEntity(MaterialDTO dto);
          MaterialDTO entityToDto(Material material);
      }
      ```

4. **Simplificações para projeto solo**:
    - Para reduzir o esforço em um projeto solo, considerou-se usar um único DTO por entidade (ex.: `MaterialDTO`) para entrada e saída em casos de uso simples, com validações claras (ex.: `@NotNull`) para diferenciar requisitos.
    - Entidades do domínio (`domain.model`) podem ser unificadas com entidades JPA (`infrastructure.database.entities`) se as regras de negócio permitirem, eliminando mapeamentos adicionais.
    - **Motivação**: Equilibrar a fidelidade à Clean Architecture com a produtividade, mantendo o projeto gerenciável para um desenvolvedor solo.

5. **Spring Data JPA**:
    - Usado para implementar repositórios, reduzindo o código necessário para operações CRUD.
    - Exemplo:
      ```java
      public interface MaterialRepositoryImpl extends JpaRepository<Material, Long> {
          Optional<Material> findByNome(String nome);
      }
      ```
    - **Motivação**: Simplificar a camada de persistência, permitindo foco na lógica de negócio e na interface gráfica.

---

## 🛠️ Configuração e Ambiente de Desenvolvimento

O projeto foi configurado para ser robusto e fácil de configurar:

- **JDK 21**: Necessário para compatibilidade com JavaFX e Spring Boot.
- **IntelliJ IDEA**: IDE recomendada, com suporte a Maven e Scene Builder.
- **Scene Builder**: Usado para criar e editar layouts FXML.
- **MySQL Server e Workbench**: Para gerenciamento do banco de dados.
- **Maven**: Gerencia dependências e build, com `pom.xml` configurado para JavaFX, Spring Boot, MapStruct, Lombok, e MySQL.

### **Passos para Configuração**
1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/JucieLima/almoxarifado.git
   cd almoxarifado
   ```
2. **Configure o Banco de Dados**:
    - Instale o MySQL Server 8.0.
    - Crie o banco de dados usando os scripts SQL gerados pelo MySQL Workbench.
    - Configure `src/main/resources/application.properties`:
      ```properties
      spring.application.name=almoxarifado
      spring.jpa.hibernate.ddl-auto=validate
      spring.datasource.url=jdbc:mysql://localhost:3306/almoxarifado_db
      spring.datasource.username=root
      spring.datasource.password=PlayListJavaFXDoZero
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
      #spring.jpa.show-sql: true
      ```
3. **Abra no IntelliJ IDEA**:
    - Configure o SDK para Java 21.
    - Certifique-se de que o Scene Builder está integrado (`File > Settings > Languages & Frameworks > JavaFX`).
    - O Maven baixará automaticamente as dependências.
4. **Execute a Aplicação**:
    - Execute a classe principal (`StartApplication.java`).

---

## 🎯 Funcionalidades Atuais (até o Vídeo 18)

O projeto abrange a configuração inicial, modelagem do banco de dados, e interfaces gráficas:

### 1. **Configuração de Ambiente e Projeto**
- Configuração do Java JDK, IntelliJ IDEA, Scene Builder, e Maven.
- Integração do Spring Boot com JavaFX, usando injeção de dependências nos controllers.
- Estrutura de diretórios para assets, estilos, e pacotes.

### 2. **Modelagem e Banco de Dados**
- Entidades planejadas: `Usuários`, `Materiais`, `Categorias`, `Pedidos`, `Itens de Pedido`, `Movimentações`.
- Tabelas criadas: `users`, `materials`, `categories`, `orders`, `order_movements`, com colunas, tipos de dados, restrições, e chaves estrangeiras.

### 3. **Interface Gráfica (JavaFX)**
- **Conceitos**: Uso de Containers (AnchorPane, VBox, etc.) e Controls (TextField, Button, TableView, etc.).
- **Estilização**: CSS inline e externo (`style.css`), com paletas de cores, gradientes, sombras, e efeitos de hover.
- **Ícones**: Integração com Ikonli e Material Design Icons.
- **Telas**:
    - **Login**: Campos de usuário e senha, com estilização e mensagens de erro.
    - **Dashboard**: AppBar com ícones, SideBar com menu dinâmico, e área central com cards, gráficos, e tabelas.
    - **Materiais**: Listagem com filtros, pesquisa, e paginação.
    - **Usuários**: Exibição de usuários com botões de ação.
    - **Cadastro de Usuários**: Formulário com campos e botão "Voltar".
    - **Relatórios**: GridPane com blocos de conteúdo e navegação tipo Breadcrumbs.
- **Eventos**: Ações de clique (`onMouseClicked`, `onAction`) vinculadas aos controllers via Scene Builder.

### 4. **Próximos Passos**
- Implementar o CRUD completo para `Materiais` e `Usuários`, seguindo a Clean Architecture.
- Configurar mapeamentos com MapStruct para ViewModels, DTOs, e entidades.
- Adicionar lógica de negócio para `Pedidos` e `Movimentações` (ex.: controle de estoque).

---

## 📺 Playlist no YouTube

Acompanhe o desenvolvimento completo na playlist:

**[Link da Playlist do YouTube](https://youtube.com/playlist?list=PL0jjh7ZB-bqa1_cfqgsyZWZ7Hjbf_rCCu&si=YxBMJJCRlcPaNjvd)**

---

## 🤝 Contribuição

Este é um projeto de aprendizado, e contribuições são bem-vindas! Para sugerir melhorias ou relatar problemas, abra uma issue ou envie um pull request.

---

## 📌 Decisões para um Projeto Solo

Para equilibrar a complexidade da Clean Architecture com a produtividade de um desenvolvedor solo:
- **Escopo inicial reduzido**: Foco inicial no CRUD de `Materiais` e `Usuários`, replicando padrões para outras entidades.
- **DTOs simplificados**: Uso de um único DTO por entidade para casos simples, com validações claras.
- **Unificação de entidades**: Avaliação de unificar entidades do domínio com entidades JPA para reduzir mapeamentos.
- **Ferramentas de produtividade**: Uso de MapStruct e Lombok para minimizar código boilerplate.

---

## 📚 Lições Aprendidas
- Aplicação prática da Clean Architecture em um projeto desktop.
- Integração de JavaFX com Spring Boot, usando injeção de dependências.
- Importância de ferramentas como MapStruct para otimizar mapeamentos.
- Balanceamento entre boas práticas e produtividade em projetos solo.