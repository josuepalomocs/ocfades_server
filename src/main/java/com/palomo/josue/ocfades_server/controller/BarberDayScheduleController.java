package com.palomo.josue.ocfades_server.controller;

import com.palomo.josue.ocfades_server.entities.BarberDaySchedule;
import com.palomo.josue.ocfades_server.service.BarberDayScheduleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barber-day-schedules")
public class BarberDayScheduleController {
    private final BarberDayScheduleService barberDayScheduleService;

    public BarberDayScheduleController(BarberDayScheduleService barberDayScheduleService) {
        this.barberDayScheduleService = barberDayScheduleService;
    }

    @GetMapping("/{id}")
    public @ResponseBody BarberDaySchedule getBarberDayScheduleById(@PathVariable Long id) {
        return barberDayScheduleService.getBarberDayScheduleById(id);
    }

    @PostMapping
    public @ResponseBody Long createBarberDaySchedule(@RequestBody BarberDaySchedule barberDaySchedule) {
        return barberDayScheduleService.createBarberDaySchedule(barberDaySchedule);
    }

    @PutMapping("/{id}")
    public @ResponseBody Long updateBarberDaySchedule(@PathVariable Long id, @RequestBody BarberDaySchedule barberDaySchedule) {
        return barberDayScheduleService.updateBarberDaySchedule(id, barberDaySchedule);
    }

    @DeleteMapping("/{id}")
    public void deleteBarberDayScheduleById(@PathVariable Long id) {
        barberDayScheduleService.deleteBarberDayScheduleById(id);
    }
}
