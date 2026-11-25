# Sistema de Biblioteca

Projeto Java 17+ com Spring Boot, Thymeleaf, Spring Data JPA e banco H2.

## Importante: abrir como projeto Maven

Não compile `BibliotecaApplication.java` isoladamente com `javac`. As classes do Spring Boot são dependências externas e precisam ser baixadas pelo Maven.

### IntelliJ IDEA
1. Abra a pasta `biblioteca` (a pasta que contém este `pom.xml`).
2. Se necessário, clique com o botão direito em `pom.xml` e escolha **Add as Maven Project**.
3. Aguarde o Maven baixar as dependências.
4. Execute `src/main/java/com/biblioteca/biblioteca/BibliotecaApplication.java`.

### VS Code
1. Instale **Extension Pack for Java** e **Spring Boot Extension Pack**.
2. Abra a pasta `biblioteca` (não apenas `src`).
3. Na aba Maven, clique em **Reload Projects** e aguarde a resolução das dependências.
4. Execute a classe `BibliotecaApplication`.

### Terminal (Windows)
Abra o terminal dentro da pasta `biblioteca` e execute:

```powershell
.\mvnw.cmd clean spring-boot:run
```

### Terminal (Linux/macOS)
Abra o terminal dentro da pasta `biblioteca` e execute:

```bash
chmod +x ./mvnw
./mvnw clean spring-boot:run
```

Na primeira execução, o Maven Wrapper baixa o Maven e as dependências; é necessária conexão com a internet.

A aplicação fica disponível em http://localhost:8080/.
