# uri-2609 GROUP BY
### Produtos por Categorias
<sub>Como de costume o setor de vendas está fazendo uma análise de quantos produtos temos em estoque, e você poderá ajudar eles.

Então seu trabalho será exibir o nome e a quantidade de produtos de cada uma categoria.</sub>
```
SELECT categories.name, SUM(products.amount) FROM categories
INNER JOIN products
ON products.id_categories = categories.id
GROUP BY categories.name

SQL RAIZ
String sql = "SELECT categories.name, SUM(products.amount) " +
        "FROM categories " +
        "INNER JOIN products " +
        "ON products.id_categories = categories.id " +
        "GROUP BY categories.name";
@Query(nativeQuery = true, value = sql)
List<CategorySumProjection> searchSql();

JPQL
String jpql = "SELECT new com.devsuperior.uri2609.response.CategorySumResponse(obj.category.name, SUM(obj.amount)) " +
        "FROM Product obj " +
        "GROUP BY obj.category.name";
@Query(jpql)
List<CategorySumResponse> searchJpql();

```
