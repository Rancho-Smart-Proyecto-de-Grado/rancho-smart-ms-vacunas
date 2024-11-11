package com.rancho_smart.ms_vacunas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_vacunas.entity.Vacuna;
import java.util.List;


@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Long>{
    public List<Vacuna> findByIdTratamiento(Long idTratamiento);
    public List<Vacuna> findByIdHistorialMedico(Long idHistorialMedico);
}
