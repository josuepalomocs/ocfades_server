package com.palomo.josue.ocfades_server.repository;

import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAppointmentRepository extends CrudRepository<CustomerAppointment, Long> {

}
