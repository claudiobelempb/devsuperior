package com.devsuperior.aula.controller;

import com.devsuperior.aula.dto.DepartmentCustomDTO;
import com.devsuperior.aula.service.DepartamentCreateService;
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
@RequestMapping(value = "/departaments")
public class DepartamentCreateController {
    private final DepartamentCreateService departamentCreateService;

    public DepartamentCreateController(DepartamentCreateService departamentCreateService) {
        this.departamentCreateService = departamentCreateService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<DepartmentCustomDTO>> handle(@RequestBody DepartmentCustomDTO request) {
        DepartmentCustomDTO response = departamentCreateService.execute(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
    }


}
