package com.rancho_smart.ms_vacunas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_vacunas.entity.Vacuna;
import com.rancho_smart.ms_vacunas.repository.VacunaRepository;

@Service
public class VacunaService {

    @Autowired
    private VacunaRepository vacunaRepository;

    public List<Vacuna> getVacunas() {
        return vacunaRepository.findAll();
    }

    public List<Vacuna> getVacunasByIdTratamiento(Long idTratamiento) {
        List<Vacuna> vacunasTratamiento = this.vacunaRepository.findByIdTratamiento(idTratamiento);
        return vacunasTratamiento;
    }

    public List<Vacuna> getVacunasByIdHistorial(Long idHistorialMedico) {
        List<Vacuna> vacunasHistorial = this.vacunaRepository.findByIdHistorialMedico(idHistorialMedico);
        return vacunasHistorial.stream()
                .filter(vacuna -> vacuna.getIdTratamiento() == null)
                .collect(Collectors.toList());
    }

    public Optional<Vacuna> getVacuna(Long id) {
        return vacunaRepository.findById(id);
    }

    public Vacuna saveVacuna(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }

    public Optional<Vacuna> updateVacuna(Long id, Vacuna vacunaDetails) {
        return vacunaRepository.findById(id)
                .map(vacuna -> {
                    vacuna.setIdHistorialMedico(vacunaDetails.getIdHistorialMedico());
                    vacuna.setNombre(vacunaDetails.getNombre());
                    vacuna.setCantidadDosis(vacunaDetails.getCantidadDosis());
                    vacuna.setVacunacionCompletada(vacunaDetails.isVacunacionCompletada());
                    vacuna.setFechaAdministracion(vacunaDetails.getFechaAdministracion());
                    vacuna.setFechaProximaDosis(vacunaDetails.getFechaProximaDosis());
                    return vacunaRepository.save(vacuna);
                });
    }

    public boolean deleteVacuna(Long id) {
        return vacunaRepository.findById(id)
                .map(vacuna -> {
                    vacunaRepository.delete(vacuna);
                    return true;
                })
                .orElse(false);
    }
}