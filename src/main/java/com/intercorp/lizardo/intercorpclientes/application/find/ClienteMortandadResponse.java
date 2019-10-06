package com.intercorp.lizardo.intercorpclientes.application.find;

import java.time.LocalDate;
import java.util.Objects;

public final class ClienteMortandadResponse {

    private String nombre;
    private String apellido;
    private Integer edad;
    private LocalDate fechaNacimiento;
    private LocalDate fechaPosibleFallecimiento;

    public ClienteMortandadResponse(String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaPosibleFallecimiento) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteMortandadResponse that = (ClienteMortandadResponse) o;
        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(edad, that.edad) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(fechaPosibleFallecimiento, that.fechaPosibleFallecimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, edad, fechaNacimiento, fechaPosibleFallecimiento);
    }
}
