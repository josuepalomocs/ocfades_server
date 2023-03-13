package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class BarberBreak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barber_day_schedule_id", nullable = true)
    private BarberDaySchedule barberDaySchedule;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    public BarberBreak() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BarberDaySchedule getBarberDaySchedule() {
        return barberDaySchedule;
    }

    public void setBarberDaySchedule(BarberDaySchedule barberDaySchedule) {
        this.barberDaySchedule = barberDaySchedule;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
