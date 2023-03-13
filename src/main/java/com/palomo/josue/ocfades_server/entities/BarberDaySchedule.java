package com.palomo.josue.ocfades_server.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class BarberDaySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "day_of_week_id")
    private DayOfWeek dayOfWeek;
    @Column(name = "open_time")
    private LocalTime openTime;
    @Column(name = "close_time")
    private LocalTime closeTime;
    @OneToMany(mappedBy = "barberDaySchedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BarberBreak> barberBreaks;

    public BarberDaySchedule() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public List<BarberBreak> getBarberBreaks() {
        return barberBreaks;
    }

    public void setBarberBreaks(List<BarberBreak> barberBreaks) {
        this.barberBreaks = barberBreaks;
    }
}
