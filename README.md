# AV1
Breve descrição de como rodar o projeto

## Como executar o projeto

### Passos

1. Clone o repositório:

2.1 Mude o application.properties para seu banco:
    ```
    Alterar a senha do banco para SUA senha do banco MySQL
    ```
3.1. Acesse a pasta do projeto e abra o arquivo:
 Acesse AV1\atvi-autobots-microservico-spring\automanager\src\main\java\com\autobots\automanager\AutomanagerApplication.java

3.2 Rode o projeto pelo vscode

3.3 Acesse as rotas no Insomnia (ou Parecidos para acessar e depurar as rotas API):
  Acessar por metodo Get todos os clientes:  localhost:8080/clientes
  Acessar por metodo Get cliente especifico: localhost:8080/cliente/numero do id

  Acesse por metodo Post para cadastrar um cliente: localhost:8080/cadastro
  com o corpo json nesse formato, *o padrão de dados tem que seguir o mesmo*:
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

  Acessar por metodo Put para atualizar algum cliente: localhost:8080/atualizar
  para atualizar apenas coloque no body um json, com o mesmo padrão de do metodo de cadastro e coloque apenas o que for necessario para trocar (Não precisa ser o body inteiro no formato do metodo Post)
  *Necessario colocar o id para achar funcionar*

  Acessar por metodo Delete: localhost:8080/excluir/numero do id
