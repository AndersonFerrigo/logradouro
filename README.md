# Logradouro

# Projeto de API para Consulta de CEP

Este repositório contém uma API desenvolvida em Java 11+ que utiliza o WireMock para simular uma API de consulta de CEP e o MySQL para armazenar os dados.

#Tecnologias Utilizadas

Java 11+: Linguagem de programação utilizada para desenvolver a API.

WireMock: Usado para mockar a API de consulta de CEP.

MySQL: Banco de dados utilizado para armazenar os dados das consultas.

#Instruções de Uso

1. Criando o database no MySql

```
create database buscacep;
use buscacep;

```
2. Realizar o clone do projeto.

```
git clone https://github.com/AndersonFerrigo/logradouro.git

```


3. Configurando o WireMock
Primeiramente, você precisa iniciar o WireMock em modo standalone. Para isso, execute o seguinte comando no terminal da ide, lembrando que você deve estar na raiz do projeto:

```
java -jar wiremock-standalone-3.9.2.jar --port 8080

```
3. Verificando o WireMock
Após iniciar o WireMock, você pode verificar se ele está funcionando corretamente acessando o seguinte endpoint no seu navegador ou usando uma ferramenta como o Postman:

```
http://localhost:8080/cep/09195-340

```

Se tudo estiver configurado corretamente, você deverá receber uma resposta simulada da API de CEP.


4. Iniciando a API
Em seguida, você pode subir a API que realiza a chamada para o WireMock. Certifique-se de que a aplicação está rodando na porta 8089.

4. Realizando Consultas com o Postman
Para testar a funcionalidade da sua API, você pode fazer uma chamada via Postman com o seguinte endpoint:

# Metodo: GET

```
http://localhost:8089/api/endereco/09195-340
```

Essa chamada deve retornar os dados relacionados ao CEP consultado.

#Estrutura do Projeto

src/: Código fonte da API.

src/resources: Scripts para criação da tabela MySQL e configurações para a conexão com o banco.

mappings/: Configurações e respostas mockadas do WireMock.

# Informações adicionais

Anexado junto ao projeto imagens da representação do fluxo do projeto.
