# primeira-api
Primeira API com Spring Boot

## Endpoits

### Listar usuários (/listar) - Retorna todos os usuários - GET
### A resposta é a lista de todos os registros salvos e o Status Http OK (200)
https://primeira-api-production.up.railway.app/primeiroprojeto/listar

### Listar usuários por nome (/buscarPorNome) - Retorna todos os usuários que contém uma sequencia de caracteres em seu nome - GET
### A resposta é a lista de todos os registros salvos que responda a condição e o Status Http OK (200)
Deve ser enviado em um form, a chave nome e seu valor.
https://primeira-api-production.up.railway.app/primeiroprojeto/buscarPorNome

### Listar usuário por id (/buscarPorId) - Retorna todos os usuários que contém uma sequencia de caracteres em seu nome - GET
### A resposta é o usuário que responda a condição e o Status Http OK (200)
Deve ser enviado em um form, a chave id e seu valor.
https://primeira-api-production.up.railway.app/primeiroprojeto/buscarPorNome

### Salvar usuários (/salvar) - Salva um usuário - POST
### A resposta é o retorno do registro salvo e o Status Http CREATED (201)
{
    "nome":"Mateus Elias",
    "idade":23
}
https://primeira-api-production.up.railway.app/primeiroprojeto/salvar


### Atualizar usuários (/atualizar) - Atualiza um usuário, deve ser informado o id do usuário - PUT
### A resposta é o retorno do registro atualizado e o Status Http CREATED (201)
{
    "id":1
    "nome":"Mateus Elias Vieira",
    "idade":23
}
https://primeira-api-production.up.railway.app/primeiroprojeto/atualizar

### Deletar usuários (/deletar) - Deleta um usuário, deve ser informado o id do usuário que será deletado - DELETE
### A resposta é uma mensagem de sucesso e o Status Http OK (200)
Deve ser enviado em um form, a chave id e seu valor.
https://primeira-api-production.up.railway.app/primeiroprojeto/deletar
