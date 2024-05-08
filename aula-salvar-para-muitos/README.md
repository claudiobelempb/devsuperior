## Salvar entidades associadas para-muitos

```
POST http://localhost:8080/products
{
    "name": "Produto novo",
    "price": 1000.0,
    "categories": [
        {
            "id": 2
        },
        {
            "id": 3
        }
    ]
}

```

## DTO

```
public record ProductDTO(
        Long id,
        String name,
        Double price,
        List<CategoryDTO> categories
) {
}
```

## ProductMapper

```
public final class ProductMapper {
    public static ProductDTO toDTO(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCategories().stream().map(category -> new CategoryDTO(category.getId(), category.getName())).collect(Collectors.toList())
        );
    }

    public static Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.name());
        entity.setPrice(dto.price());
        dto.categories().stream().map(c -> entity.getCategories().add(new Category(c.id(), c.name()))).collect(Collectors.toList());
        return entity;
    }

    public static Product toEntity(ProductDTO dto, CategoryRepository categoryRepository) {
        Product entity = new Product();
        entity.setName(dto.name());
        entity.setPrice(dto.price());
        dto.categories().stream().map(c -> entity.getCategories().add(categoryRepository.getReferenceById(c.id()))).collect(Collectors.toList());
        return entity;
    }
}
```

## ProductService

```
@Service
public class ProductCreateService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductCreateService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO execute(ProductDTO dto){
        Product entity = ProductMapper.toEntity(dto, categoryRepository);
        entity = productRepository.save(entity);
        return ProductMapper.toDTO(entity);
    }
}
```

## ProductController

```
@RestController
@RequestMapping(value = "/products")
public class ProductCreateController {

    private final ProductCreateService productCreateService;

    public ProductCreateController(ProductCreateService productCreateService) {
        this.productCreateService = productCreateService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@RequestBody ProductDTO dto) {
        ProductDTO response = productCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();
        return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
    }
}
```
