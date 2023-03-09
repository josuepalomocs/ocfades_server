package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.BarberDaySchedule;
import com.palomo.josue.ocfades_server.repository.BarberDayScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BarberDayScheduleService {
    private final BarberDayScheduleRepository barberDayScheduleRepository;

    public BarberDayScheduleService(BarberDayScheduleRepository barberDayScheduleRepository) {
        this.barberDayScheduleRepository = barberDayScheduleRepository;
    }

    public BarberDaySchedule getBarberDayScheduleById(Long id) {
        try {
            return barberDayScheduleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long createBarberDaySchedule(BarberDaySchedule barberDaySchedule) {
        BarberDaySchedule queryResult = barberDayScheduleRepository.save(barberDaySchedule);
        return queryResult.getId();
    }

    public Long updateBarberDaySchedule(Long id, BarberDaySchedule barberDaySchedule) {
        try {
            BarberDaySchedule queryResult = barberDayScheduleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            barberDaySchedule.setId(queryResult.getId());
            BarberDaySchedule queryResult2 = barberDayScheduleRepository.save(barberDaySchedule);
            return queryResult2.getId();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void deleteBarberDayScheduleById(Long id) {
        barberDayScheduleRepository.deleteById(id);
    }
}
