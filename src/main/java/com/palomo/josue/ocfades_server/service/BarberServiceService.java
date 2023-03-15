package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.BarberService;
import com.palomo.josue.ocfades_server.repository.BarberServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberServiceService {
    private final BarberServiceRepository barberServiceRepository;

    public BarberServiceService(BarberServiceRepository barberServiceRepository) {
        this.barberServiceRepository = barberServiceRepository;
    }

    public List<BarberService> getBarberServices() {
        return barberServiceRepository.findAll();
    }

    public BarberService getBarberServiceById(Long id) {
        try {
            return barberServiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long createBarberService(BarberService barberService) {
        BarberService queryResult = barberServiceRepository.save(barberService);
        return queryResult.getId();
    }

    public Long updateBarberService(Long id, BarberService barberService) {
        try {
            BarberService queryResult = barberServiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            barberService.setId(queryResult.getId());
            BarberService queryResult2 = barberServiceRepository.save(barberService);
            return queryResult2.getId();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void deleteBarberServiceById(Long id) {
        barberServiceRepository.deleteById(id);
    }
}
