# Sistema de gestão de Cadastro de Contatos
### Essa aplicação é  API REST desenvolvida em Java, utilizando Spring Boot que gerencia um sistema de cadastro de Pessoas e seus respectivos Contatos

### Principais tecnologias/bibliotecas utilizadas
- Spring Boot
- Maven
- Banco de dados PostgreSql 
- JPA 
- NHibernate
- Autenticação JWT
- Swagger

## EXECUÇÃO DA APLICAÇÃO
1. Um banco de dados PostgreSql está disponível e ativo acessando um container Docker, dispensando a necessidade de instalar um banco de dados local.
2. Clonar o projeto, e abrí-lo com uma das IDEs disponíveis no mercado no qual eu recomendo o Eclipse.
3. Baixar dependências via Maven.
4. Executar a aplicação com o banco de dados PostgreSQL disponível e ativo no Docker. 
5. As configurações necessárias para acessar o banco de dados PostgreSQL, como usuário e senha poderão ser verificadas no arquivo pom.xml da aplicação.
   
## UTILIZAÇÃO
1. Você poderá acessar a API e sua documentação Swagger no endpoint *[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)*
2. Para utilização obtenha primeiro um token de acesso em TOKEN "/token". É necessário apenas digitar um nome de usuário qualquer, por exemplo: "João";
3. Copie o token retornado e cole no topo da página clicando no cadeado "Authorize";
4. Cole o token no campo e clique em "Authorize";
5. Após isso você pode realizar as consultas diretamente na documentação Swagger seguindo as orientações de cada rota.
6. Se você for utilizar o Postman ou o Insomnia acesse as rotas em *[http://localhost:8080/](http://localhost:8080/)* e o restante do caminho descrito no Swagger junto com seus parâmetros


## Modelo do Banco de Dados
![Modelo do Banco de Dados](https://raw.githubusercontent.com/carlosdbrito/Assets/main/ModeloBancoDados.png)

## FACILITADORES PARA CONSULTAS

#### Página inicial do Swagger no endpoint *[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)*
![PaginaSwagger](https://raw.githubusercontent.com/carlosdbrito/Assets/main/SwaggerSistemaCadastroAPI.png)


### Exemplo de envio de objeto, payload, para rota de CRIAR Pessoa [POST]"api/pessoas"
<pre>
    {
        "id": 1,
        "nome": "João da Silva",
        "endereco": "Rua Itacolomi, 338",
        "cep": "01.541-020",
        "cidade": "São Paulo",
        "uf": "SP",
        "contatos": [
            {
                "id": 2,
                "tipoContato": "Celular",
                "contato": "(11) 94477-6544"
            }
        ]
    }
</pre>

---

### Exemplo de envio de objeto, payload, para rota de ATUALIZAR Pessoa [PUT]"api/pessoas/id"

<pre>
{
  "id": 0,
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string",
  "contatos": [
    {
      "id": 0,
      "tipoContato": "Telefone" ou "Celular" ou "Email" ou "RedeSocial",
      "contato": "string"
    }
  ]
}
</pre>

--- 

### Exemplo de envio de objeto, payload, para rota de ADICIONAR NOVO CONTATO a uma Pessoas [POST]"api/pessoas/id/contatos"
<pre>
{
  "id": 0,
  "tipoContato": "Telefone" ou "Celular" ou "Email" ou "RedeSocial",
  "contato": "(11) 3211-5577"
}
</pre>

--- 

### Exemplo de envio de objeto, payload, para rota de ATUALIZAR um Contato [PUT]"api/contatos"
<pre>
{
  "id": 27,
  "tipoContato": "Telefone",
  "contato": "(11) 3577-4788"
}
</pre>

