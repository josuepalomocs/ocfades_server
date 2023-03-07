package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import com.palomo.josue.ocfades_server.repository.CustomerAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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

    public Long createCustomerAppointment(CustomerAppointment customerAppointment) {
        CustomerAppointment queryResult = customerAppointmentRepository.save(customerAppointment);
        return queryResult.getId();
    }
}
