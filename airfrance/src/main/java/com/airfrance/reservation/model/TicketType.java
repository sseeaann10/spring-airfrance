package com.airfrance.reservation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    private double additionalCost;

    public TicketType() {
    }

    public TicketType(String name, String description, double additionalCost) {
        this.name = name;
        this.description = description;
        this.additionalCost = additionalCost;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }
}
