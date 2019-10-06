package com.intercorp.lizardo.intercorpclientes.domain;

import java.time.LocalDate;

public final class DetailCliente {

    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDate fechaNacimiento;
    private LocalDate fechaPosibleFallecimiento;

    public DetailCliente(String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaPosibleFallecimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaPosibleFallecimiento = fechaPosibleFallecimiento;
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public Integer edad() {
        return edad;
    }

    public LocalDate fechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate fechaPosibleFallecimiento() {
        return fechaPosibleFallecimiento;
    }
}
