package com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "fec-nac")
    private LocalDate fechaNacimiento;
    @Column(name = "fec-fal")
    private LocalDate fechaPosibleFallecimiento;

    public ClienteEntity(String id, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaPosibleFallecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaPosibleFallecimiento = fechaPosibleFallecimiento;
    }

    public String id() {
        return id;
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
