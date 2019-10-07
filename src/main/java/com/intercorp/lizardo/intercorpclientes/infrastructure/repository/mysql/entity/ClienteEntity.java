package com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.entity;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "fecnac")
    private LocalDate fechaNacimiento;
    @Column(name = "fecfal")
    private LocalDate fechaPosibleFallecimiento;

    public ClienteEntity(Long id, String nombre, String apellido, Integer edad, LocalDate fechaNacimiento, LocalDate fechaPosibleFallecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaPosibleFallecimiento = fechaPosibleFallecimiento;
    }

    public ClienteEntity() {

    }

    public Long id() {
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
