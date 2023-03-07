package com.palomo.josue.ocfades_server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.jayway.jsonpath.JsonPath;
import com.palomo.josue.ocfades_server.entities.BarberService;
import com.palomo.josue.ocfades_server.repository.BarberServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.NoSuchElementException;

@Service
public class BarberServiceService {
    private final BarberServiceRepository barberServiceRepository;
    private ObjectMapper objectMapper;

    public BarberServiceService(BarberServiceRepository barberServiceRepository, ObjectMapper objectMapper) {
        this.barberServiceRepository = barberServiceRepository;
        this.objectMapper = objectMapper;
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
