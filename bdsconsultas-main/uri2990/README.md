# uri-2602
### Sua empresa está fazendo um levantamento de quantos clientes estão 
cadastrados nos estados, porém, faltou levantar os dados do estado do 
Rio Grande do Sul.
<sub>Então você deve Exibir o nome de todos os clientes cujo estado seja</sub>
```
SELECT name FROM customers
WHERE UPPER(STATE) = UPPER('rs');
```
