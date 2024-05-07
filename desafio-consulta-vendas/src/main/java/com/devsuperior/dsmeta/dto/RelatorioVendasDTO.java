package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.time.LocalDate;

public class RelatorioVendasDTO {
    private Long id;
    private LocalDate date;
    private Integer deals;
    private String name;

    public RelatorioVendasDTO() {
    }

    public RelatorioVendasDTO(Long id, LocalDate date, Integer deals, String name) {
        this.id = id;
        this.date = date;
        this.deals = deals;
        this.name = name;
    }

    public RelatorioVendasDTO(Sale entity) {
        id = entity.getId();
        date = entity.getDate();
        deals = getDeals();
        name = entity.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
