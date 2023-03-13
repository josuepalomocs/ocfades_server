package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.DayOfWeek;
import com.palomo.josue.ocfades_server.repository.DayOfWeekRepository;
import org.springframework.stereotype.Service;

@Service
public class DayOfWeekService {
    private DayOfWeekRepository dayOfWeekRepository;

    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;

        for(int dayOfWeekIndex = 0; dayOfWeekIndex < 7; dayOfWeekIndex++) {
            DayOfWeek dayOfWeek = new DayOfWeek();
            dayOfWeek.setDayOfWeek(dayOfWeekIndex);
            this.dayOfWeekRepository.save(dayOfWeek);
        }
    }
}
