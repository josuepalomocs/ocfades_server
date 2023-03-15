package com.palomo.josue.ocfades_server.controller;

import com.palomo.josue.ocfades_server.entities.BarberBreak;
import com.palomo.josue.ocfades_server.entities.BarberService;
import com.palomo.josue.ocfades_server.service.BarberServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barber-services")
public class BarberServiceController {
    private final BarberServiceService barberServiceService;

    public BarberServiceController(BarberServiceService barberServiceService) {
        this.barberServiceService = barberServiceService;
    }

    @GetMapping
    public @ResponseBody List<BarberService> getBarberServices() {
        return barberServiceService.getBarberServices();
    }

    @GetMapping("/{id}")
    public @ResponseBody BarberService getBarberServiceById(@PathVariable Long id) {
        return barberServiceService.getBarberServiceById(id);
    }

    @PostMapping
    public @ResponseBody Long createBarberService(@RequestBody BarberService barberService) {
        return barberServiceService.createBarberService(barberService);
    }

    @PutMapping("/{id}")
    public @ResponseBody Long updateBarberService(@PathVariable Long id, @RequestBody BarberService barberService) {
        return barberServiceService.updateBarberService(id, barberService);
    }

    @DeleteMapping("/{id}")
    public void deleteBarberServiceById(@PathVariable Long id) {
        barberServiceService.deleteBarberServiceById(id);
    }
}
