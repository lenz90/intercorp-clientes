package com.intercorp.lizardo.intercorpclientes.infrastructure.service;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.MortandadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public final class MortandadCalculateService implements MortandadService {


    @Override
    public LocalDate calcularMortandadCliente(Cliente cliente) {

        return LocalDate.now().plusYears(calcularEdad(cliente.edad())); //Por el momento
    }

    /****
     *
     * Este método se cambiará por algun servicio que calcule validando la tasa de mortandad real en el Perú
     *
     */
    private Integer calcularEdad(Integer edadActual) {
        double prom = 0;
        if(edadActual>=70) {
            prom = 0.2;
        }else if(edadActual>=60){
            prom = 0.5;
        }else if(edadActual>=50){
            prom = 0.7;
        }else if(edadActual>=50){
            prom = 0.9;
        }else if(edadActual>=50){
            prom = 1.1;
        }else if(edadActual>=50){
            prom = 1.3;
        }else{
            prom = 1.5;
        }
        return new Double(edadActual * prom).intValue();
    }

}
