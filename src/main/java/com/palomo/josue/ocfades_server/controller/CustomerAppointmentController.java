package com.palomo.josue.ocfades_server.controller;

import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import com.palomo.josue.ocfades_server.service.CustomerAppointmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer-appointments")
public class CustomerAppointmentController {
    private final CustomerAppointmentService customerAppointmentService;

    public CustomerAppointmentController(CustomerAppointmentService customerAppointmentService) {
        this.customerAppointmentService = customerAppointmentService;
    }

    @GetMapping("/{id}")
    public @ResponseBody CustomerAppointment getCustomerAppointmentById(@PathVariable Long id) {
        return customerAppointmentService.getCustomerAppointmentById(id);
    }
}
