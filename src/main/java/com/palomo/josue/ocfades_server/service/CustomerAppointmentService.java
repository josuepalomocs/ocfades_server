package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import com.palomo.josue.ocfades_server.repository.CustomerAppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerAppointmentService {
    private final CustomerAppointmentRepository customerAppointmentRepository;

    public CustomerAppointmentService(CustomerAppointmentRepository customerAppointmentRepository) {
        this.customerAppointmentRepository = customerAppointmentRepository;
    }

    public CustomerAppointment getCustomerAppointmentById(Long id) {
        try {
            return customerAppointmentRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
