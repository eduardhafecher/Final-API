Inclusao de tabelas/relacionamentos: Categoria, Cliente, Endereco, Pedido, PedidoProduto e Produto: ok;

Inclusao de classe StatusPedido enum: ok;

Documentacao Swagger: ok (Precisa ser melhor formatado o cabecalho);

Inclusao package exception com classe: ClientException, ControllerExceptionHandler e ErroResposta: ok;

Inclusao de endereco por cep consultando no viacep por (json): ok (service, repository, controller e dto);

Inclusao de cliente + endereco (cep) consultando no viacep por (json): ok (service, repository, controller e dto);

Inclusao de criptografia para a senha de clientes;

Exception Cliente capturando erros de email e cpf, com mensagem amigavel;

IMPORTANTE: para testar a inclusao de cliente, devera ser colocado o email e senha no arquivo application, linhas 24 e 25.

json para o postman:
 {
    "nome":"xxxxx",
    "email":"xxx@xxxx.com",
    "cpf":"xxxxxxxxxxx",
    "telefone":"22123456789",
    "senha":"123456",
    "cep":"12345678"
}
