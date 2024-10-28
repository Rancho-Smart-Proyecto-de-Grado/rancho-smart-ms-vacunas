package com.rancho_smart.ms_vacunas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Vacuna> getAllVacunas() {
        return vacunaService.getAllVacunas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacuna> getVacunaById(@PathVariable Long id) {
        return vacunaService.getVacunaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vacuna createVacuna(@RequestBody Vacuna vacuna) {
        return vacunaService.createVacuna(vacuna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacuna> updateVacuna(@PathVariable Long id, @RequestBody Vacuna vacunaDetails) {
        return vacunaService.updateVacuna(id, vacunaDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacuna(@PathVariable Long id) {
        if (vacunaService.deleteVacuna(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}