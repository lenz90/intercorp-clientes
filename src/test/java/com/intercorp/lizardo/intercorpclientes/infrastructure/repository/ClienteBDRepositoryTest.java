package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.ClienteMysqlRepository;
import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.entity.ClienteEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ClienteBDRepositoryTest {

    @Mock
    private ClienteMysqlRepository repository;

    @InjectMocks
    ClienteBDRepository c = new ClienteBDRepository(repository);

    ClienteEntity e;
    Cliente cli;

    @Before
    public void setUp() {
        e = new ClienteEntity(1L, "Lizardo", "Mamani", 29, LocalDate.of(1990, 01, 20), LocalDate.now());
        cli = new Cliente("1", "Lizardo", "Mamani", LocalDate.of(1990, 01, 20));
    }

    @Test
    public void create() {
        when(repository.save(any())).thenReturn(e);
        Assert.assertTrue(c.create(cli).block().id().equals(e.id().toString()));
    }

    @Test
    public void updateFechaMortandad() {
        when(repository.updateFechaMortandad(any(), any())).thenReturn(1);
        c.updateFechaMortandad(e.fechaNacimiento(), "1");

        verify(repository, atLeastOnce()).updateFechaMortandad(any(), any());
    }
}