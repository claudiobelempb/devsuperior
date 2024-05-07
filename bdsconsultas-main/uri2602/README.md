## uri-2602
### Sua empresa está fazendo um levantamento de quantos clientes estão 
cadastrados nos estados, porém, faltou levantar os dados do estado do 
Rio Grande do Sul.
<sub>Então você deve Exibir o nome de todos os clientes cujo estado seja</sub>
```
SQL RAIZ
@Query(nativeQuery = true, value = "SELECT name FROM customers WHERE UPPER(state) = UPPER(:state) ")
    List<CustomerProjection> customerNameProjectionSql(String state);

SQL JPQL
@Query("SELECT new com.devsuperior.uri2602.reponses.CustomerResponse(obj.name) "
            + "FROM Customer obj "
            + "WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerResponse> customerNameProjectionJpql(String state);
      
SELECT name FROM customers
WHERE UPPER(STATE) = UPPER('rs');
```
