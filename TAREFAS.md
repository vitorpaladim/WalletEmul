# Wallet Emu: tarefas de estudo (passo a passo)

Marque `[x]` quando terminar cada item. Uma tarefa por vez, sem pular.

---

## Fase 1: API sem banco de dados

### A FAZER
- [X] **1. Desligar o banco no `pom.xml`**
  - Comentar `spring-boot-starter-data-jpa`, `spring-boot-starter-flyway`, `flyway-database-postgresql` e `postgresql`.
  - Recarregar o Maven no IntelliJ.
  - ✅ Pronto quando: a aplicação roda e aparece `Started WalletEmuApplication`.

- [X] **2. Primeiro endpoint: `GET /hello`**
  - Criar a classe `HelloController` com `@RestController` e `@GetMapping`.
  - ✅ Pronto quando: `http://localhost:8080/hello` mostra um texto no navegador.

- [X] **3. Organizar em pacotes**
  - Criar o pacote `com.walletemu.hello` e mover o `HelloController` para ele.
  - ✅ Pronto quando: a aplicação continua funcionando depois da mudança.

- [X] **4. Criar o DTO de saída: `HelloResponse`**
  - Um `record` com `id` (UUID) e `nome` (String).
  - Fazer o `GET /hello` devolver um `HelloResponse` em vez de texto.
  - ✅ Pronto quando: o navegador mostra um JSON `{"id": "...", "nome": "..."}`.

- [X] **5. Criar o DTO de entrada: `HelloRequest`**
  - Um `record` com o campo `nome`.
  - ✅ Pronto quando: o projeto compila sem erro.

- [ ] **6. Criar `POST /api/v1/hello` guardando numa lista**
  - Usar `@PostMapping` e `@RequestBody`.
  - Gerar o id com `UUID.randomUUID()` e guardar numa `List` dentro do Controller.
  - ✅ Pronto quando: o `Invoke-RestMethod` com POST devolve o registro criado.

- [ ] **7. Criar `GET /api/v1/hello/{id}`**
  - Usar `@GetMapping("/{id}")` e `@PathVariable`.
  - Procurar o registro na lista.
  - ✅ Pronto quando: buscar o id criado no passo 6 devolve o registro.

- [ ] **8. Devolver os status certos**
  - POST responde `201 Created` (usar `ResponseEntity`).
  - GET de id inexistente responde `404`.
  - ✅ Pronto quando: os dois status aparecem no teste.

- [ ] **9. Validar o nome**
  - `@NotBlank` e `@Size(max = 50)` no `HelloRequest`, e `@Valid` no Controller.
  - ✅ Pronto quando: um nome vazio devolve `400`.

- [ ] **10. Separar em camadas: criar o `HelloService`**
  - Tirar a lista e a lógica do Controller e passar para um `@Service`.
  - O Controller só chama o Service.
  - ✅ Pronto quando: tudo continua funcionando igual.

---

## Fase 2: trocar a memória pelo banco de dados

### A FAZER
- [ ] **11. Ligar o PostgreSQL** (Serviços do Windows) e criar o usuário e o banco pelo DBeaver.
- [ ] **12. Religar as dependências de banco no `pom.xml`** e configurar o `application.properties`.
- [ ] **13. Criar a tabela com o Flyway** (`V1__create_hello_table.sql`) e vê-la no DBeaver.
- [ ] **14. Criar a Entity `Hello`.**
- [ ] **15. Criar o `HelloRepository`.**
- [ ] **16. Trocar a lista do Service pelo Repository.**
  - ✅ Pronto quando: o registro criado pelo POST aparece no DBeaver.
- [ ] **17. Reiniciar a aplicação e ver que os dados continuam lá.**

---

## Fase 3: qualidade

### A FAZER
- [ ] **18. Tratamento de erros padronizado** (`GlobalExceptionHandler`).
- [ ] **19. Primeiro teste de unidade** (`HelloServiceTest`).
- [ ] **20. Teste do Controller** (`HelloControllerTest`).

---

## FEITO
_(mova para cá o que você terminar, se quiser acompanhar o progresso)_
