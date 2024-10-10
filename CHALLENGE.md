# Itaú Unibanco - Desafio de Programação

## 1. Introdução

Sua missão, caso você aceite, é criar uma API REST que recebe Transações e
retorna Estatísticas sob essas transações. Para este desafio, a API deve ser
criada utilizando-se de Java ou Kotlin e Spring Boot.

## 2. Definição do desafio

Neste desafio você deve criar uma API REST no GitHub ou GitLab. Leia com atenção todas as instruções a seguir!

## 3.Endpoints da API

A seguir serão especificados os endpoints que devem estar presentes na sua API e a funcionalidade esperada de cada um deles.

2.2.1. Receber Transações: ````POST /transaction````

Este é o endpoint que irá receber as Transações. Cada transação consiste
de um valor e uma dataHora de quando ela aconteceu:

````json
{
    "valor": 300.0,
    "dataHora": "2024-10-10T15:43:58Z"
}
````

Os campos no JSON acima significam o seguinte:

| Campo      | Significado                                                   | Obrigatório? |
|------------|---------------------------------------------------------------|--------------|
| `amount`   | **Valor em decimal com ponto flutuante** da transação         | Sim          |
| `dateHour` | **Data/Hora no padrão ISO 8601** em que a transação aconteceu | Sim          |

A API só aceitará transações que:

1. Tenham os campos `amount` e `dateHour` preenchidos
2. A transação **NÃO DEVE** acontecer no futuro
3. A transação **DEVE** ter acontecido a qualquer momento no passado
4. A transação **NÃO DEVE** ter valor negativo
5. A transação **DEVE** ter valor maior que `0` (zero)

Como resposta, espera-se que este endpoint responda com:

- `201 Created` sem nenhum corpo
    - A transação foi aceita (ou seja foi validada, está válida e foi registrada)
- `422 Unprocessable Entity` sem nenhum corpo
    - A transação **não** foi aceita por qualquer motivo (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que `0`)
- `400 Bad Request` sem nenhum corpo
    - A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)

#### 2.2.2. Limpar Transações: `DELETE /transaction`

Este endpoint simplesmente **apaga todos os dados de transações** que estejam armazenados.

Como resposta, espera-se que este endpoint responda com:

- `200 OK` sem nenhum corpo
- ⚡ Adaptação:
    - Tratamento de exceções.
    - Mensagem customizada.

- Todas as informações foram apagadas com sucesso

#### 2.2.3. Calcular Estatísticas: `GET /statistics`

Este endpoint deve retornar estatísticas das transações que **aconteceram nos últimos 60 segundos (1 minuto)**. As estatísticas que devem ser calculadas são:

## ⚡ adaptações

````
/statistics?type=seconds?time=60 -> ultimos 60 segundos
/statistics?type=minutes?time=4 -> ultimos 4 minutos
/statistics?type=hours?time=4 -> ultimas 4 horas
````

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

Os campos no JSON acima significam o seguinte:

|  Campo  | Significado                                                   | Obrigatório? |
|---------|---------------------------------------------------------------|--------------|
| `count` | **Quantidade de transações** nos últimos 60 segundos          | Sim          |
| `sum`   | **Soma total do valor** transacionado nos últimos 60 segundos | Sim          |
| `avg`   | **Média do valor** transacionado nos últimos 60 segundos      | Sim          |
| `min`   | **Menor valor** transacionado nos últimos 60 segundos         | Sim          |
| `max`   | **Maior valor** transacionado nos últimos 60 segundos         | Sim          |

>**Dica:** Há um objeto no Java 8+ chamado `DoubleSummaryStatistics` que pode lhe ajudar ou servir de inspiração.

Como resposta, espera-se que este endpoint responda com:

- `200 OK` com os dados das estatísticas
    - Um JSON com os campos `count`, `sum`, `avg`, `min` e `max` todos preenchidos com seus respectivos valores
    - **Atenção!** Quando não houverem transações nos últimos 60 segundos considere todos os valores como `0` (zero)

## 4. Extras

Vamos propôr a seguir alguns desafios extras caso você queira testar seus conhecimentos ao máximo! Nenhum desses requisitos é obrigatório, mas são desejados e podem ser um diferencial!

1. **Testes automatizados:** Sejam unitários e/ou funcionais, testes automatizados são importantes e ajudam a evitar problemas no futuro. Se você fizer testes automatizados, atente-se na efetividade dos seus testes! Por exemplo, testar apenas os "caminhos felizes" não é muito efetivo. (PROGRESS)
2. **Containerização:** Você consegue criar meios para disponibilizar sua aplicação como um container? _OBS: Não é necessário publicar o container da sua aplicação!_
3. **Logs:** Sua aplicação informa o que está acontecendo enquanto ela trabalha? Isso é útil para ajudar as pessoas desenvolvedoras a solucionar eventuais problemas que possam ocorrer.(PROGRESS)
4. **Observabilidade:** Sua API tem algum endpoint para verificação da saúde da aplicação (healthcheck)?
5. **Performance:** Você consegue estimar quanto tempo sua aplicação gasta para calcular as estatísticas?
6. **Tratamento de Erros:** O Spring Boot dá às pessoas desenvolvedoras ferramentas para se melhorar o tratamento de erros padrão. Você consegue alterar os erros padrão para retornar _quais_ erros ocorreram?
7. **Documentação da API:** Você consegue documentar sua API? Existem [ferramentas](https://swagger.io/) e [padrões](http://raml.org/) que podem te ajudar com isso!
8. **Documentação do Sistema:** Sua aplicação provavelmente precisa ser construída antes de ser executada. Você consegue documentar como outra pessoa que pegou sua aplicação pela primeira vez pode construir e executar sua aplicação?
9. **Configurações:** Você consegue deixar sua aplicação configurável em relação a quantidade de segundos para calcular as estatísticas? Por exemplo: o padrão é 60 segundos, mas e se o usuário quiser 120 segundos?