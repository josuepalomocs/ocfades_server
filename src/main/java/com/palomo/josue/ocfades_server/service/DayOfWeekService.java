package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.repository.DayOfWeekRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class DayOfWeekService {
    private DayOfWeekRepository dayOfWeekRepository;

    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;

        for(int dayOfWeekIndex = 1; dayOfWeekIndex < 8; dayOfWeekIndex++) {
            com.palomo.josue.ocfades_server.entities.DayOfWeek dayOfWeek = new com.palomo.josue.ocfades_server.entities.DayOfWeek();
            dayOfWeek.setDayNumber(dayOfWeekIndex);
            dayOfWeek.setDayName(DayOfWeek.of(dayOfWeekIndex).name());
            this.dayOfWeekRepository.save(dayOfWeek);
        }
    }
}
