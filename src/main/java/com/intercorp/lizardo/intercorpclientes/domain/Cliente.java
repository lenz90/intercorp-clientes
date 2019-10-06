package com.intercorp.lizardo.intercorpclientes.domain;

import java.time.LocalDate;
import java.time.Period;

public final class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDate fechaNacimiento;

    public Cliente(String id, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
