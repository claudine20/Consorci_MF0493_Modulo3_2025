package com.ironhack.car.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Car {
    private Long id;

    @NotBlank(message = "El modelo no puede estar vacío")
    private String model;

    @NotBlank(message = "La marca no puede estar vacía")
    private String brand;

    @NotNull(message = "El año es obligatorio")
    @Min(value = 1990, message = "El año debe ser posterior a 1990")
    private Integer year;

    public Car() {
    }

    public Car(Long id, String model, String brand, Integer year) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
