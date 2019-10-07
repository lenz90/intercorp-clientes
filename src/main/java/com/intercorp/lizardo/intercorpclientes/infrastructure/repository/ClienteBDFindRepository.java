package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

import com.google.common.collect.Lists;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteFindRepository;
import com.intercorp.lizardo.intercorpclientes.domain.DetailCliente;
import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.ClienteMysqlRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Repository
public class ClienteBDFindRepository implements ClienteFindRepository {

    private ClienteMysqlRepository repository;

    public ClienteBDFindRepository(ClienteMysqlRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DetailCliente> findAll() {
        return Flux.fromIterable(Lists.newArrayList(repository.findAll()).parallelStream()
                .map(RepositoryAdapter::entityToDetail)
                .collect(Collectors.toList()));
    }


}
