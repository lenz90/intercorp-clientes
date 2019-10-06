package com.intercorp.lizardo.intercorpclientes.infrastructure.service;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.MortandadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public final class MortandadCalculateService implements MortandadService {


    @Override
    public LocalDate calcularMortandadCliente(Cliente cliente) {
        return LocalDate.now(); //Por el momento
    }

}
