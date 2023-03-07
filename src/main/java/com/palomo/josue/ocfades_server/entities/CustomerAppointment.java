package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class CustomerAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start_date_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDateTime;
    @Column(name = "barber_service_id")
    private Long barberServiceId;
    @Column(name = "customer_first_name")
    private String customerFirstName;
    @Column(name = "customer_last_name")
    private String customerLastName;
    @Column(name = "customer_email_address")
    private String customerEmailAddress;
    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    public CustomerAppointment() {

    }

    public CustomerAppointment(Long id, Date startDateTime, Long barberServiceId, String customerFirstName, String customerLastName, String customerEmailAddress, String customerPhoneNumber) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.barberServiceId = barberServiceId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Long getBarberServiceId() {
        return barberServiceId;
    }

    public void setBarberServiceId(Long barberServiceId) {
        this.barberServiceId = barberServiceId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
