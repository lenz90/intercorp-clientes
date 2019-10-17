package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

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
import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ClienteBDFindRepositoryTest {

    @Mock
    private ClienteMysqlRepository repository;

    @InjectMocks
    ClienteBDFindRepository c = new ClienteBDFindRepository(repository);


    ClienteEntity e;

    @Before
    public void setUp() {
        e = new ClienteEntity(1L, "Lizardo", "Mamani", 29, LocalDate.of(1990, 01, 20), LocalDate.now());
    }

    @Test
    public void findAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(e));
        Assert.assertTrue(c.findAll().blockFirst().nombre().equals(e.nombre()));
    }
}