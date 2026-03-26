# AV1

Breve descrição de como rodar o projeto

## Como executar o projeto

### 1. Clone o repositório

------------------------------------------------------------------------

### 2. Configuração do banco

**2.1** Mude o `application.properties` para seu banco:

    Alterar a senha do banco para SUA senha do banco MySQL

------------------------------------------------------------------------

### 3. Execução do projeto

**3.1** Acesse a pasta do projeto e abra o arquivo:
AV1-WEB3\atvi-autobots-microservico-spring\automanager\src\main\java\com\autobots\automanager\AutomanagerApplication.java

**3.2** Rode o projeto pelo vscode

------------------------------------------------------------------------

### 4. Teste das rotas (Insomnia ou similares)

#### GET

-   Acessar todos os clientes:\
    `localhost:8080/clientes`

-   Acessar cliente específico:\
    `localhost:8080/cliente/numero do id`

------------------------------------------------------------------------

#### POST

-   Cadastrar um cliente:\
    `localhost:8080/cadastro`

-   Corpo JSON (seguir exatamente o padrão):

```
<!-- -->
```
    {
      "nome": "Nome",
      "nomeSocial": "Dom Quixote",
      "dataNascimento": "2002-06-15T25:58:07.966+00:00",
      "dataCadastro": "2026-03-25T23:58:07.966+00:00",
      "documentos": [
        {
          "tipo": "RG",
          "numero": "150"
        },
        {
          "tipo": "RG",
          "numero": "000000001"
        }
      ],
      "endereco": {
        "estado": "SP",
        "cidade": "Sanja",
        "bairro": "Não sei",
        "rua": "Avenida AT",
        "numero": "170",
        "codigoPostal": "220124001",
        "informacoesAdicionais": "Fatec castelo"
      },
      "telefones": [
        {
          "ddd": "21",
          "numero": "981234576"
        }
      ]
    }

------------------------------------------------------------------------

#### PUT

-   Atualizar cliente:\
    `localhost:8080/atualizar`

-   Regras:

    -   Coloque no body um JSON com o mesmo padrão do método de
        cadastro\
    -   Não precisa enviar o body completo\
    -   *Necessario colocar o id para achar funcionar*

------------------------------------------------------------------------

#### DELETE

-   Excluir cliente:\
    `localhost:8080/excluir/numero do id`
