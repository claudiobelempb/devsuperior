## Salvando entidade associada para um 

```
VERSION 01
POST http://localhost:8080/people
{
    "name": "Nova Pessoa",
    "salary": 8000.0,
    "department": {
        "id": 1
    }
}

VERSION 02
POST http://localhost:8080/people
{
    "name": "Nova Pessoa",
    "salary": 8000.0,
    "departmentId": 1
}
```
