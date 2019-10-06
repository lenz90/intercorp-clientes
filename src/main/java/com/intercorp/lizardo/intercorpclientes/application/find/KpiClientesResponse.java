package com.intercorp.lizardo.intercorpclientes.application.find;

public class KpiClientesResponse {
    private Double promedioClientes;
    private Double desviacionEstandar;

    public KpiClientesResponse(Double promedioClientes, Double desviacionEstandar) {
        this.promedioClientes = promedioClientes;
        desviacionEstandar = desviacionEstandar;
    }

    public Double promedioClientes() {
        return promedioClientes;
    }

    public Double desviacionEstandar() {
        return desviacionEstandar;
    }
}
