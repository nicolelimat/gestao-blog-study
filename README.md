# Blog Spring Boot Application

Este é um estudo de Spring Boot em desenvolvimento com a orientação do professor **Fellipe Rey** para a disciplina de **Gestão do Ciclo de Vida da Aplicação** da [Universidade Federal de Alfenas-MG](https://www.unifal-mg.edu.br/portal/index/). O objetivo é criar um blog básico para demonstrar os conceitos fundamentais do Spring Boot e sua integração com banco de dados.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para criação de aplicativos em Java.
- **Spring Data JPA**: Facilita o acesso a dados relacionais em aplicativos baseados no Spring.
- **Thymeleaf**: Framework de template para construção de interfaces web.
- **MySQL Connector**: Driver JDBC para comunicação com o MySQL.
- **JUnit 5**: Framework de testes.

## Como Executar

### Pré-requisitos

- Java JDK 11 ou superior instalado.
- MySQL instalado e configurado.
- IDE de sua preferência (IntelliJ IDEA, Eclipse, etc.).

### Passos

1. Clone este repositório:
   ```bash
   git clone https://github.com/nicolelimat/blog.git
   ```

2. Importe o projeto na sua IDE como um projeto Gradle.

3. Configure as informações de conexão com o banco de dados no arquivo `application.yaml` ou `application.properties`.

4. Execute a classe principal `BlogApplication.java`.

5. Acesse o aplicativo em `http://localhost:8080`.

## Funcionalidades Disponíveis

- Cadastro e visualização de usuários.
<!--
- Criação, edição e exclusão de posts.
- Adição de comentários aos posts.
- Visualização de posts e seus comentários.
-->

## Estrutura do Projeto

- **`src/main/java`**: Contém os pacotes e classes Java.
  - `br.com.unifal.blog.controller`: Controladores.
  - `br.com.unifal.blog.entity`: Entidades do banco de dados.
  - `br.com.unifal.blog.repository`: Repositórios JPA.
  - `br.com.unifal.blog.service`: Lógica de negócios e serviços.

- **`src/main/resources`**: Recursos estáticos e arquivos de configuração.
  - `application.yaml`: Configurações do Spring Boot e conexão com o banco de dados.
  <!--- `data.sql`: Script para inicialização do banco de dados.-->

## Contribuindo

- Sinta-se à vontade para fazer um fork do projeto e contribuir com melhorias, correções de bugs ou novos recursos.
- Crie uma branch específica para a sua alteração: `git checkout -b feature/nova-feature`.
- Faça o commit de suas mudanças: `git commit -m 'feat: Adicionando nova feature'`.
- Realize o push para a branch: `git push origin feature/nova-feature`.
- Abra um Pull Request explicando suas alterações.
