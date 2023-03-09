package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

@Entity
public class BarberDaySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "day")
    private int day;
    @Column(name = "open_time")
    private int openTime;
    @Column(name = "close_time")
    private int closeTime;

    public BarberDaySchedule() {

    }

    public BarberDaySchedule(Long id, int day, int openTime, int closeTime) {
        this.id = id;
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }
}
