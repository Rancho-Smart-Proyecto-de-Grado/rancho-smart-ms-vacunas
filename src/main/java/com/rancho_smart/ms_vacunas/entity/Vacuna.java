package com.rancho_smart.ms_vacunas.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VACUNA")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacuna;

    @Column(name = "ID_HISTORIAL_MEDICO", nullable = false)
    private Long idHistorialMedico;

    @Column(name = "ID_TRATAMIENTO")
    private Long idTratamiento;

    @Column(nullable = false, name = "NOMBRE")
    private String nombre;

    @Column(name = "CANTIDAD_DOSIS", nullable = false)
    private int cantidadDosis;

    @Column(name = "VACUNACION_COMPLETADA", nullable = false)
    private boolean vacunacionCompletada;

    @Column(name = "FECHA_ADMINISTRACION")
    private LocalDate fechaAdministracion;

    @Column(name = "FECHA_PROXIMA_DOSIS")
    private LocalDate fechaProximaDosis;

    public Vacuna(Long idHistorialMedico, Long idTratamiento, String nombre, int cantidadDosis,
            boolean vacunacionCompletada, LocalDate fechaAdministracion, LocalDate fechaProximaDosis) {
        this.idHistorialMedico = idHistorialMedico;
        this.idTratamiento = idTratamiento;
        this.nombre = nombre;
        this.cantidadDosis = cantidadDosis;
        this.vacunacionCompletada = vacunacionCompletada;
        this.fechaAdministracion = fechaAdministracion;
        this.fechaProximaDosis = fechaProximaDosis;
    }

    public Vacuna() {
    }

    public Long getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Long idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Long getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(Long idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public Long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDosis() {
        return cantidadDosis;
    }

    public void setCantidadDosis(int cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    public boolean isVacunacionCompletada() {
        return vacunacionCompletada;
    }

    public void setVacunacionCompletada(boolean vacunacionCompletada) {
        this.vacunacionCompletada = vacunacionCompletada;
    }

    public LocalDate getFechaAdministracion() {
        return fechaAdministracion;
    }

    public void setFechaAdministracion(LocalDate fechaAdministracion) {
        this.fechaAdministracion = fechaAdministracion;
    }

    public LocalDate getFechaProximaDosis() {
        return fechaProximaDosis;
    }

    public void setFechaProximaDosis(LocalDate fechaProximaDosis) {
        this.fechaProximaDosis = fechaProximaDosis;
    }
}