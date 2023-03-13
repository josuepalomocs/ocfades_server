package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class CustomerAppointmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "status")
    private List<CustomerAppointment> customerAppointments;

    public CustomerAppointmentStatus() {}

    public CustomerAppointmentStatus(Long id, String status, List<CustomerAppointment> customerAppointments) {
        this.id = id;
        this.status = status;
        this.customerAppointments = customerAppointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CustomerAppointment> getCustomerAppointments() {
        return customerAppointments;
    }

    public void setCustomerAppointments(List<CustomerAppointment> customerAppointments) {
        this.customerAppointments = customerAppointments;
    }
}
