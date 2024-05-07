package com.devsuperior.aula.controller;

import com.devsuperior.aula.dto.PersonDepartmentCustomDTO;
import com.devsuperior.aula.service.PersonCreateService;
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
@RequestMapping(value = "/people")
public class PersonCreateController {

    private final PersonCreateService personCreateService;

    public PersonCreateController(PersonCreateService personCreateService) {
        this.personCreateService = personCreateService;
    }


    /*@PostMapping
    public CompletableFuture<ResponseEntity<PersonCustomDTO>> handle(@RequestBody PersonCustomDTO request) {
        PersonCustomDTO response = personCreateService.execute(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
    }*/

    @PostMapping
    public CompletableFuture<ResponseEntity<PersonDepartmentCustomDTO>> handle(@RequestBody PersonDepartmentCustomDTO request) {
        PersonDepartmentCustomDTO response = personCreateService.execute(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
    }
}
