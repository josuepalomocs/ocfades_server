package com.palomo.josue.ocfades_server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.palomo.josue.ocfades_server.entities.BarberService;
import com.palomo.josue.ocfades_server.service.BarberServiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barber-services")
public class BarberServiceController {
    private final BarberServiceService barberServiceService;

    public BarberServiceController(BarberServiceService barberServiceService) {
        this.barberServiceService = barberServiceService;
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
    public @ResponseBody Long patchBarberService(@PathVariable Long id, @RequestBody BarberService barberService) {
        return barberServiceService.updateBarberService(id, barberService);
    }


    @DeleteMapping("/{id}")
    public void deleteBarberServiceById(@PathVariable Long id) {
        barberServiceService.deleteBarberServiceById(id);
    }
}
