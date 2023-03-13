package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.CustomerAppointmentStatus;
import com.palomo.josue.ocfades_server.repository.CustomerAppointmentStatusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerAppointmentStatusService {
    private final CustomerAppointmentStatusRepository customerAppointmentStatusRepository;

    public CustomerAppointmentStatusService(CustomerAppointmentStatusRepository customerAppointmentStatusRepository) {
        this.customerAppointmentStatusRepository = customerAppointmentStatusRepository;

        this.customerAppointmentStatusRepository.save(new CustomerAppointmentStatus(1L, "active", new ArrayList<>()));
        this.customerAppointmentStatusRepository.save(new CustomerAppointmentStatus(2L, "fulfilled", new ArrayList<>()));
        this.customerAppointmentStatusRepository.save(new CustomerAppointmentStatus(3L, "cancelled", new ArrayList<>()));
    }
}
