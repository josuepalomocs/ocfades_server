package com.palomo.josue.ocfades_server.controller;

import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import com.palomo.josue.ocfades_server.service.CustomerAppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer-appointments")
public class CustomerAppointmentController {
    private final CustomerAppointmentService customerAppointmentService;

    public CustomerAppointmentController(CustomerAppointmentService customerAppointmentService) {
        this.customerAppointmentService = customerAppointmentService;
    }

    @GetMapping("/{id}")
    public Optional<CustomerAppointment> getCustomerAppointmentById(@PathVariable Long id) {
        return customerAppointmentService.getCustomerAppointmentById(id);
    }
}
