package com.devsuperior.aula.controllers.product;

import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.services.product.ProductCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

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
