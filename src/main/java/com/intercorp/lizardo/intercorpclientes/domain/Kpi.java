package com.intercorp.lizardo.intercorpclientes.domain;

public final class Kpi {

    private Double promedioClientes;
    private Double DesviacionEstandar;

    public Kpi(Double promedioClientes, Double desviacionEstandar) {
        this.promedioClientes = promedioClientes;
        DesviacionEstandar = desviacionEstandar;
    }

    public Double promedioClientes() {
        return promedioClientes;
    }

    public Double DesviacionEstandar() {
        return DesviacionEstandar;
    }
}
