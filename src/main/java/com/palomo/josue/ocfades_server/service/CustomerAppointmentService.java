package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import com.palomo.josue.ocfades_server.repository.CustomerAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerAppointmentService {
    private final CustomerAppointmentRepository customerAppointmentRepository;

    public CustomerAppointmentService(CustomerAppointmentRepository customerAppointmentRepository) {
        this.customerAppointmentRepository = customerAppointmentRepository;
    }

    public Optional<CustomerAppointment> getCustomerAppointmentById(Long id) {
        return customerAppointmentRepository.findById(id);
    }
}
