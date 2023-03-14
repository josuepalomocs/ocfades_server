package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "day_of_week")
public class DayOfWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "day_number")
    private int dayNumber;

    @Column(name = "day_name")
    private String dayName;

    @OneToOne(mappedBy = "dayOfWeek")
    private BarberDaySchedule barberDaySchedule;

    public DayOfWeek() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayOfWeek) {
        this.dayNumber = dayOfWeek;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public BarberDaySchedule getBarberDaySchedule() {
        return barberDaySchedule;
    }

    public void setBarberDaySchedule(BarberDaySchedule barberDaySchedule) {
        this.barberDaySchedule = barberDaySchedule;
    }
}
