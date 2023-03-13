package com.palomo.josue.ocfades_server.repository;

import com.palomo.josue.ocfades_server.entities.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long> {}
