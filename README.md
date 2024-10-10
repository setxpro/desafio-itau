# Simple Transactions

Esta é a documentação da API de Transações. A API permite a criação e manipulação de transações financeiras.

## Installation

1. Clone do repositório

````sh
 git clone https://github.com/setxpro/btg-pactual-backend-challenge.git
````

2. Instalação das dependências
````sh
  mvn clean install
````

3. Instalação com Docker
````sh
    docker-compose up
````

## Technologies used

- [Java 21](https://www.oracle.com/br/java/technologies/downloads/#java21)
- [Spring boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Open API (Swagger)](https://swagger.io/)
- [Spring Actuator (Health)](https://www.baeldung.com/spring-boot-actuators)
- [Docker](https://www.docker.com/products/docker-desktop/)

## Database 
 
- [Postgres](https://www.postgresql.org/)

## Base URL
````http://localhost:8080````

## Endpoints

### 1. Criar uma Nova Transação

- **Endpoint:** `POST /transaction`
- **Descrição:** Cria uma nova transação.
- **Requisição:**
    - **Cabeçalhos:**
        - `Content-Type: application/json`
    - **Corpo da Requisição:**
      ```json
      {
          "amount": 100.00,
          "dateHour": "2024-10-10T11:15:00Z"
      }
      ```
    - **Parâmetros:**
        - `amount` (BigDecimal): O valor da transação.
        - `dateHour` (OffsetDateTime): A data e hora da transação.

- **Respostas:**
    - **201 Created**
        - **Corpo da Resposta:**
          ```json
          {
              "amount": 100.00,
              "dateHour": "2024-10-10T11:15:00Z"
          }
          ```
    - **400 Bad Request** - Se os parâmetros estiverem ausentes ou inválidos.

### 2. Deletar Todas as Transações

- **Endpoint:** `DELETE /transaction`
- **Descrição:** Deleta todas as transações.
- **Respostas:**
    - **204 No Content** - Se as transações forem deletadas com sucesso.
    - **404 Not Found** - Se não houver transações para deletar.


### 3. Obter Estatísticas de Transações

- **Endpoint:** `GET /statistics`
- **Descrição:** Retorna estatísticas das transações com base no intervalo de tempo especificado.
- **Parâmetros de Consulta:**
    - `type` (String): O tipo de intervalo de tempo. Pode ser "seconds", "minutes" ou "hours".
    - `time` (Integer): O valor do intervalo de tempo a ser considerado.

- **Exemplo de Requisição:**
- **Respostas:**
- **200 OK**
    - **Corpo da Resposta:**
      ```json
      {
          "count": 5,
          "sum": 500.00,
          "min": 100.00,
          "max": 200.00,
          "average": 100.00
      }
      ```

### 4. Verificação de Saúde (Health Check)

- **Endpoint:** `GET /actuator/health`
- **Descrição:** Verifica a saúde da aplicação.
- **Respostas:**
  - **200 OK**
      - **Corpo da Resposta:**
        ```json
        {
            "status": "UP",
                  "components": {
                    "db": {
                      "status": "UP",
                      "details": {
                      "database": "PostgreSQL",
                      "validationQuery": "isValid()"
                  }
                },
                "discoveryComposite": {
                  "description": "Discovery Client not initialized",
                  "status": "UNKNOWN",
                  "components": {
                    "discoveryClient": {
                      "description": "Discovery Client not initialized",
                      "status": "UNKNOWN"
                    }
                  }
                },
                "diskSpace": {
                  "status": "UP",
                  "details": {
                    "total": 491707691008,
                    "free": 70802849792,
                    "threshold": 10485760,
                    "path": "/app/.",
                    "exists": true
                  }
                },
                "ping": {
                  "status": "UP"
                },
                "refreshScope": {
                  "status": "UP"
                }
            }
         }
        ```

### 5. Documentação do Swagger

- **Endpoint:** `http://localhost:8080/swagger-ui/index.html`
- **Descrição:** Acesse a interface do Swagger para explorar a API, ver a documentação e testar os endpoints.

## Exemplo de Uso

### Criar uma Transação

```bash
curl -X POST http://localhost:8080/transaction \
-H "Content-Type: application/json" \
-d '{"amount": 100.00, "dateHour": "2024-10-10T11:15:00Z"}'#
