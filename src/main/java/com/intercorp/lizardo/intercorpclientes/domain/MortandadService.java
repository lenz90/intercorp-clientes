package com.intercorp.lizardo.intercorpclientes.domain;

import java.time.LocalDate;

public interface MortandadService {
    LocalDate calcularMortandadCliente(Cliente cliente);
}
