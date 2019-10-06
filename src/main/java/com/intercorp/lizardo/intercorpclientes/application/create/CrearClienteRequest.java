package com.intercorp.lizardo.intercorpclientes.application.create;

import java.time.LocalDate;

public final class CrearClienteRequest {
    private final String nombre;
    private final String apellido;
    private final LocalDate fechaNacimiento;

    public CrearClienteRequest(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public LocalDate fechaNacimiento() {
        return fechaNacimiento;
    }
}
