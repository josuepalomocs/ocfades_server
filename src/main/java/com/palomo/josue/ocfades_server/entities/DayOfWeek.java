package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "day_of_week")
public class DayOfWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "day_of_week")
    private int dayOfWeek;

    @OneToOne(mappedBy = "dayOfWeek")
    private BarberDaySchedule barberDaySchedule;

    public DayOfWeek() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public BarberDaySchedule getBarberDaySchedule() {
        return barberDaySchedule;
    }

    public void setBarberDaySchedule(BarberDaySchedule barberDaySchedule) {
        this.barberDaySchedule = barberDaySchedule;
    }
}
