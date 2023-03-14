package com.palomo.josue.ocfades_server.service;

import com.palomo.josue.ocfades_server.entities.BarberBreak;
import com.palomo.josue.ocfades_server.entities.BarberDaySchedule;
import com.palomo.josue.ocfades_server.entities.BarberService;
import com.palomo.josue.ocfades_server.entities.CustomerAppointment;
import com.palomo.josue.ocfades_server.repository.BarberDayScheduleRepository;
import com.palomo.josue.ocfades_server.repository.BarberServiceRepository;
import com.palomo.josue.ocfades_server.repository.CustomerAppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerAppointmentService {
    private final CustomerAppointmentRepository customerAppointmentRepository;
    private final BarberDayScheduleRepository barberDayScheduleRepository;
    private final BarberServiceRepository barberServiceRepository;

    public CustomerAppointmentService(CustomerAppointmentRepository customerAppointmentRepository, BarberDayScheduleRepository barberDayScheduleRepository, BarberServiceRepository barberServiceRepository) {
        this.customerAppointmentRepository = customerAppointmentRepository;
        this.barberDayScheduleRepository = barberDayScheduleRepository;
        this.barberServiceRepository = barberServiceRepository;
    }

    public CustomerAppointment getCustomerAppointmentById(Long id) {
        try {
            return customerAppointmentRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Long createCustomerAppointment(CustomerAppointment customerAppointment) {
        if (!isCustomerAppointmentValid(customerAppointment)) {
            throw new Error("The provided customer appointment datetime is not valid.");
        }
        System.out.println("The provided customer appointment is valid and was stored in the DB!");
        CustomerAppointment queryResult = customerAppointmentRepository.save(customerAppointment);
        return queryResult.getId();
    }

    public void deleteCustomerAppointmentById(Long id) {
        customerAppointmentRepository.deleteById(id);
    }

    private boolean isCustomerAppointmentValid(CustomerAppointment customerAppointment) {
        try {
            BarberService customerAppointmentBarberService = barberServiceRepository.findById(customerAppointment.getBarberService().getId()).orElseThrow(EntityNotFoundException::new);
            LocalDateTime customerAppointmentStartLocalDateTime = LocalDateTime.of(customerAppointment.getDate(), customerAppointment.getTime());
            LocalDateTime customerAppointmentEndLocalDateTime = LocalDateTime.of(customerAppointment.getDate(), customerAppointment.getTime().plusMinutes(customerAppointmentBarberService.getDurationInMinutes()));
            BarberDaySchedule barberDaySchedule = barberDayScheduleRepository.getBarberDayScheduleByDayOfWeek_DayNumber(customerAppointmentStartLocalDateTime.getDayOfWeek().getValue());
            LocalDateTime shopOpenLocalDateTime = LocalDateTime.of(customerAppointmentStartLocalDateTime.toLocalDate(), barberDaySchedule.getOpenTime());
            LocalDateTime shopCloseLocalDateTime = LocalDateTime.of(barberDaySchedule.getOpenTime().compareTo(barberDaySchedule.getCloseTime()) < 0 ? customerAppointmentStartLocalDateTime.toLocalDate() : customerAppointmentStartLocalDateTime.plusDays(1).toLocalDate(), barberDaySchedule.getCloseTime());
            if (!isCustomerAppointmentWithinBusinessHours(customerAppointmentStartLocalDateTime, customerAppointmentEndLocalDateTime, shopOpenLocalDateTime, shopCloseLocalDateTime, barberDaySchedule.getBarberBreaks())) {
                return false;
            }
            if (!isOnMinuteInterval(customerAppointmentStartLocalDateTime, 15)) {
                return false;
            }
            return true;
        } catch(EntityNotFoundException e) {
            return false;
        }
    }

    private boolean isCustomerAppointmentWithinBusinessHours(LocalDateTime customerAppointmentStartLocalDateTime, LocalDateTime customerAppointmentEndLocalDateTime, LocalDateTime shopOpenLocalDateTime, LocalDateTime shopCloseLocalDateTime, List<BarberBreak> barberBreaks) {
        if (customerAppointmentStartLocalDateTime.isBefore(shopOpenLocalDateTime) || customerAppointmentEndLocalDateTime.isAfter(shopCloseLocalDateTime)) {
            return false;
        }
        for (BarberBreak barberBreak : barberBreaks) {
            LocalDateTime barberBreakStartDateTime = LocalDateTime.of(customerAppointmentStartLocalDateTime.toLocalDate(), barberBreak.getStartTime());
            LocalDateTime barberBreakEndDateTime = LocalDateTime.of(customerAppointmentStartLocalDateTime.toLocalDate(), barberBreak.getEndTime());
            if (isOverlapping(customerAppointmentStartLocalDateTime, customerAppointmentEndLocalDateTime, barberBreakStartDateTime, barberBreakEndDateTime)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOverlapping(LocalDateTime startA, LocalDateTime endA, LocalDateTime startB, LocalDateTime endB) {
        return startA.isBefore(endB) && endA.isAfter(startB);
    }


    public boolean isOnMinuteInterval(LocalDateTime dateTime, int minuteInterval) {
        int minute = dateTime.getMinute();
        return minute % minuteInterval == 0;
    }
}
