package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

import java.util.List;

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
    private int priceInUsd;

    @OneToMany(mappedBy = "barberService")
    private List<CustomerAppointment> customerAppointments;

    public BarberService() {}

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

    public int getPriceInUsd() {
        return priceInUsd;
    }

    public void setPriceInUSD(int priceInUsd) {
        this.priceInUsd = priceInUsd;
    }

    public List<CustomerAppointment> getCustomerAppointments() {
        return customerAppointments;
    }

    public void setCustomerAppointments(List<CustomerAppointment> customerAppointments) {
        this.customerAppointments = customerAppointments;
    }
}
