package com.intercorp.lizardo.intercorpclientes.application.find;

import com.intercorp.lizardo.intercorpclientes.domain.ClienteFindRepository;
import com.intercorp.lizardo.intercorpclientes.domain.DetailCliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.mockito.Mockito.when;


@RunWith(value = SpringRunner.class)
public class ClienteFindServiceTest {

    @Mock
    private ClienteFindRepository findRepository;

    @InjectMocks
    ClienteFindService c = new ClienteFindService(findRepository);

    DetailCliente d;

    @Before
    public void setUp() {
        d = new DetailCliente("Lizardo", "Mamani", 29, LocalDate.of(1990, 01, 20), LocalDate.now());
    }

    @Test
    public void findAllDetail() {
        when(findRepository.findAll()).thenReturn(Flux.just(d));
        Assert.assertEquals(c.findAllDetail().blockFirst().nombre(), d.nombre());
    }

    @Test
    public void obtenerKpis() {
        when(findRepository.findAll()).thenReturn(Flux.just(d));
        Assert.assertEquals(c.obtenerKpis().block().promedioClientes(), Double.valueOf(d.edad()));
    }

    @Test
    public void obtenerKpisVacio() {
        when(findRepository.findAll()).thenReturn(Flux.empty());
        Assert.assertEquals(c.obtenerKpis().block().promedioClientes(), Double.valueOf(0.0));
    }
}