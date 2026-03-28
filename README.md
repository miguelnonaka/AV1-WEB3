# AV1

Microserviço Spring Boot para gerenciamento de clientes, documentos, endereços e telefones.

---

## Como executar o projeto

### 1. Clone o repositório

---

### 2. Configuração do banco

#### 2.1 Configure o `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/generaldb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

#### 2.2 Importante

- Certifique-se de que o MySQL está rodando
- O banco `generaldb` será criado automaticamente

---

### 3. Execução do projeto

#### 3.1 Caminho da aplicação

```
AV1-WEB3\atvi-autobots-microservico-spring\automanager\src\main\java\com\autobots\automanager\AutomanagerApplication.java
```

#### 3.2 Execução

Execute pelo VSCode ou sua IDE de preferência.

---

### 4. Teste das rotas

Ferramentas recomendadas: Insomnia ou Postman

---

# CLIENTE

## GET

- Listar todos:
```
localhost:8080/clientes
```

- Buscar por ID:
```
localhost:8080/cliente/{id}
```

---

## POST

```
localhost:8080/cadastro
```

### Body (JSON)

```json
{
  "nome": "Nome",
  "nomeSocial": "Dom Quixote",
  "dataNascimento": "2002-06-15T00:00:00.000+00:00",
  "dataCadastro": "2026-03-25T00:00:00.000+00:00",
  "documentos": [
    {
      "tipo": "RG",
      "numero": "150"
    }
  ],
  "endereco": {
    "estado": "SP",
    "cidade": "Sao Jose dos Campos",
    "bairro": "Centro",
    "rua": "Avenida AT",
    "numero": "170",
    "codigoPostal": "220124001",
    "informacoesAdicionais": "Fatec"
  },
  "telefones": [
    {
      "ddd": "12",
      "numero": "981234576"
    }
  ]
}
```

---

## PUT

```
localhost:8080/atualizar
```

### Regras

- Sempre incluir o `id`
- Não é necessário enviar todos os campos

```json
{
  "id": 1,
  "nome": "Nome",
  "nomeSocial": "Dom Quixote",
  "dataNascimento": "2002-06-15T00:00:00.000+00:00",
  "dataCadastro": "2026-03-25T00:00:00.000+00:00",
  "documentos": [
    {
      "tipo": "RG",
      "numero": "150"
    }
  ],
  "endereco": {
    "estado": "SP",
    "cidade": "Sao Jose dos Campos",
    "bairro": "Centro",
    "rua": "Avenida AT",
    "numero": "170",
    "codigoPostal": "220124001",
    "informacoesAdicionais": "Fatec"
  },
  "telefones": [
    {
      "ddd": "12",
      "numero": "981234576"
    }
  ]
}
```

---

## DELETE

```
localhost:8080/excluir/{id}
```

---

# DOCUMENTO

Base: `/documento`

## GET

```
localhost:8080/documento
localhost:8080/documento/{id}
```

## POST

```
localhost:8080/documento/cadastro
```

```json
{
  "tipo": "RG",
  "numero": "150"
}
```

## PUT

```
localhost:8080/documento/atualizar
```

```json
{
  "id": 2,
  "tipo": "RG",
  "numero": "150"
}
```

## DELETE

```
localhost:8080/documento/excluir/{id}
```

---

# ENDEREÇO

Base: `/endereco`

## GET

```
localhost:8080/endereco
localhost:8080/endereco/{id}
```

## POST

```
localhost:8080/endereco/cadastro
```

```json
{
  "estado": "SP",
  "cidade": "Sao Jose dos Campos",
  "bairro": "Centro",
  "rua": "Avenida AT",
  "numero": "170",
  "codigoPostal": "220124001",
  "informacoesAdicionais": "Fatec"
}
```

## PUT

```
localhost:8080/endereco/atualizar
```

```json
{
  "id": 67,
  "cidade": "Nova Cidade"
}
```

## DELETE

```
localhost:8080/endereco/excluir/{id}
```

---

# TELEFONE

Base: `/telefone`

## GET

```
localhost:8080/telefone
localhost:8080/telefone/{id}
```

## POST

```
localhost:8080/telefone/cadastro
```

```json
{
  "ddd": "12",
  "numero": "981234576"
}
```

## PUT

```
localhost:8080/telefone/atualizar
```

```json
{
  "id": 3,
  "numero": "999999999"
}
```

## DELETE

```
localhost:8080/telefone/excluir/{id}
```

---

# Observações importantes

- Não deletar entidades relacionadas diretamente (ex: Documento)
- OrphanRemoval não funciona ao deletar diretamente via repository

---
