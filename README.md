# MathExp Interpreter

## Descrição
O projeto MathExp Interpreter é um laboratório experimental desenvolvido para explorar os conceitos de análise léxica e sintática em programação. Ele implementa um serviço de API REST que permite aos usuários avaliar expressões matemáticas fornecidas através de uma interface HTTP. O projeto é escrito em Java, utilizando Spring Boot para o servidor web e o serviço REST.

O objetivo do projeto é fornecer uma base prática para estudantes e desenvolvedores entenderem como os analisadores léxicos e sintáticos funcionam na prática, traduzindo expressões matemáticas de forma textual para estruturas que podem ser computacionalmente avaliadas.

## Funcionalidades
- Análise léxica de expressões matemáticas para identificar tokens.
- Análise sintática para construir uma Árvore Sintática Abstrata (AST) a partir dos tokens.
- Avaliação de expressões matemáticas com suporte para variáveis e operações básicas (+, -, *, /, ^).

## Instruções de Instalação
Para executar o MathExp Interpreter, você precisará de Java 17 e Maven configurado em seu ambiente. Siga os passos abaixo para configurar o projeto localmente:

1. Clone o repositório:
   ```bash
   git clone https://github.com/agnaldoanjos/mathexp-interpreter.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd mathexp-interpreter
   ```
3. Compile e execute o projeto usando Maven:
   ```bash
   mvn spring-boot:run
   ```

O serviço estará disponível em `http://localhost:8080`.

## API Endpoint

### POST /evaluate
Este endpoint aceita uma expressão matemática e um conjunto de variáveis, avalia a expressão e retorna o resultado.

#### Payload
```json
{
  "expression": "string",
  "variables": {
    "var1": value1,
    "var2": value2
  }
}
```

#### Exemplos de Uso
- **Requisição**:
  ```bash
  curl -X POST http://localhost:8080/api/v1/math/evaluate -H "Content-Type: application/json" -d '{"expression": "x+(k/y)", "variables": {"x": 3.0, "k": 4.0, "y": 2.0}}'
  ```

- **Resposta**:
  ```json
  {
    "result": 5.0
  }
  ```

## Contato
Para mais informações, entre em contato através de [email](mailto:agnaldo.anjos@gmail.com).
```