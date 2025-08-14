santanderDevWeek2025

Java RESTful API criada para a Santander Dev Week 2025

# Santander Dev Week 2025
Java RESTfull API Criada para Santander Dev Week

## Diagrama de Classes

```mermaid

classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
    }

    class Account {
        -String number
        -String agency
        -Decimal balance
        -Decimal limit
    }

    class Feature {
        -String icon
        -String description
    }

    class Card {
        -String number
        -Number limit
    }

    class News {
        -String icon
        -String description
    }

    User "1" <-- "1" Account
    User "1" <-- "1...N" Feature
    User "1" <-- "1" Card
    User "1" <-- "1...N" News

```
