package com.rancho_smart.ms_vacunas.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_vacunas.entity.Vacuna;
import com.rancho_smart.ms_vacunas.service.VacunaService;

@RestController
@RequestMapping("/vacunas")
public class VacunaRESTController {

    @Autowired
    private VacunaService vacunaService;

    @GetMapping
    public ResponseEntity<List<Vacuna>> getVacunas() {
        List<Vacuna> listado = vacunaService.getVacunas();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacuna> getVacuna(@PathVariable Long id) {
        Optional<Vacuna> vacuna = vacunaService.getVacuna(id);
        return vacuna.map(ResponseEntity::ok)
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tratamiento/{idTratamiento}")
    public ResponseEntity<List<Vacuna>> getVacunasByIdTratamiento(@PathVariable Long idTratamiento){
        List<Vacuna> vacunasTratamiento = this.vacunaService.getVacunasByIdTratamiento(idTratamiento);
        return new ResponseEntity<>(vacunasTratamiento, HttpStatus.OK);
    }

    @GetMapping("/historial/{idHistorialMedico}")
    public ResponseEntity<List<Vacuna>> getVacunasByIdHistorial(@PathVariable Long idHistorialMedico){
        List<Vacuna> vacunasHistorial = this.vacunaService.getVacunasByIdHistorial(idHistorialMedico);
        return new ResponseEntity<>(vacunasHistorial, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vacuna> saveVacuna(@RequestBody Vacuna vacuna) {
        Vacuna vacunaCreada = vacunaService.saveVacuna(vacuna);
        return new ResponseEntity<>(vacunaCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacuna> updateVacuna(@PathVariable Long id, @RequestBody Vacuna vacuna) {
        if (!vacunaService.getVacuna(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            vacuna.setIdVacuna(id);
            Vacuna vacunaActualizada = vacunaService.saveVacuna(vacuna);
            return new ResponseEntity<>(vacunaActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacuna(@PathVariable Long id) {
        if (!vacunaService.getVacuna(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            vacunaService.deleteVacuna(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}