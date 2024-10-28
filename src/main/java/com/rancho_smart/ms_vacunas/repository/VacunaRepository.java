package com.rancho_smart.ms_vacunas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_vacunas.entity.Vacuna;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Long>{

}
