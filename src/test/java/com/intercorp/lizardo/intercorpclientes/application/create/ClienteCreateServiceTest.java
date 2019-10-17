package com.intercorp.lizardo.intercorpclientes.application.create;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteRepository;
import com.intercorp.lizardo.intercorpclientes.domain.MortandadService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.mockito.Mockito.*;


@RunWith(value = SpringRunner.class)
public class ClienteCreateServiceTest {

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private MortandadService mortandadService;


    @InjectMocks
    private ClienteCreateService createService = new ClienteCreateService(clienteRepository, mortandadService);

    Cliente c;
    CrearClienteRequest cr;

    @Before
    public void setUp() {
        c = new Cliente("1", "Lizardo", "Mamani", LocalDate.of(1990, 01, 20));
        cr = new CrearClienteRequest("Lizardo", "Mamani", LocalDate.of(1990, 01, 20));
    }

    @Test
    public void crearCliente() {
        when(clienteRepository.create(any())).thenReturn(Mono.just(c));
        when(mortandadService.calcularMortandadCliente(any())).thenReturn(LocalDate.now());
        when(clienteRepository.updateFechaMortandad(any(),any())).thenReturn(Mono.empty());
        createService.crearCliente(cr).block();
        verify(clienteRepository, atLeastOnce()).create(any());
    }
}