package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteRepository;
import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.ClienteMysqlRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public class ClienteBDRepository implements ClienteRepository {

    private ClienteMysqlRepository repository;

    public ClienteBDRepository(ClienteMysqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Cliente> create(Cliente cliente) {
        return Mono.just(repository.save(RepositoryAdapter.clienteToEntity(cliente))).map(x -> cliente);

    }

    @Override
    public Mono<Void> updateFechaMortandad(LocalDate fechaFallecimiento, String id) {
        repository.updateFechaMortandad(fechaFallecimiento, id);
        return Mono.empty();
    }

}
