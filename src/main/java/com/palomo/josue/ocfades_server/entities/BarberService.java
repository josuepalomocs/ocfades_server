package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class BarberService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "duration_in_minutes")
    private int durationInMinutes;
    @Column(name = "price_in_usd")
    private int priceInUSD;

    public BarberService() {

    }

    public BarberService(Long id, String name, int durationInMinutes, int priceInUSD) {
        this.id = id;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.priceInUSD = priceInUSD;
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

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(int priceInUSD) {
        this.priceInUSD = priceInUSD;
    }
}
