package com.intercorp.lizardo.intercorpclientes.infrastructure.service;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class MortandadCalculateServiceTest {

    Cliente c;
    MortandadCalculateService m = new MortandadCalculateService();


    @Before
    public void setUp() {
        c = new Cliente("1", "Lizardo", "Mamani", LocalDate.of(1990, 01, 20));
    }


    @Test
    public void calcularMortandadCliente() {
        Assert.assertTrue(m.calcularMortandadCliente(c).toString().equals(LocalDate.of(2056,10,17).toString()));
    }
}