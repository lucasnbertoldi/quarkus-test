# Teste com Quarkus

Este é apenas um projeto para testar o framework Quarkus e a sua integração com as seguintes tecnologias:
- Webservice REST;
- Hibernate e Panache;
- Mysql;
- Redis;
- Testes com JUnit e RestAssured.

Documentação do Quarkus: https://quarkus.io/ .

## Executar Aplicação em Modo Desenvolvedor com Live Reload

```shell script
./mvnw compile quarkus:dev
```

> **_Observação:_**  A execução de desenvolvedor dá acesso a um utilitário chamado DEV UI no endereço: http://localhost:8080/q/dev/.

## Empacotando para produção

```shell script
./mvnw package
```
Este comando produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`. Que pode ser executado em produção.