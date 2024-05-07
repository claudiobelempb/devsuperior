# uri-2621 LIKE e BETWEEN
### Quantidades Entre 10 e 20

<sub>Na hora de entregar o relatório de quantos produtos a empresa tem em estoque, uma parte do relatório ficou corrompida, por isso o responsável do estoque lhe pediu uma ajuda, ele quer que você exiba os seguintes dados para ele.

Exiba o nome dos produtos cujas quantidades estejam entre 10 e 20 e cujo nome do fornecedor inicie com a letra ‘P’.</sub>
```
SELECT products.name
FROM products
INNER JOIN providers
ON products.id_providers = providers.id
WHERE products.amount BETWEEN 10 AND 20
AND providers.name LIKE UPPER('P%')

SQL RAIZ
String sql = "SELECT products.name " +
        "FROM products " +
        "INNER JOIN providers " +
        "ON products.id_providers = providers.id " +
        "WHERE products.amount BETWEEN :min AND :max " +
        "AND UPPER(providers.name) LIKE CONCAT(UPPER(:name), '%')";
@Query(nativeQuery = true, value = sql)
List<ProductNameProjection> searchSql(Integer min, Integer max, String name);

JPQL
@Query("SELECT new com.devsuperior.uri2621.responses.ProductNameResponse(obj.name) " +
        "FROM Product obj " +
        "WHERE obj.amount BETWEEN :min AND :max " +
        "AND UPPER(obj.provider.name) LIKE CONCAT(UPPER(:name), '%')"
)
List<ProductNameResponse> searchJpql(Integer min, Integer max, String name);
```
