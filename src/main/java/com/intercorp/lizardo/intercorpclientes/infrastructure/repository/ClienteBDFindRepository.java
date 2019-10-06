package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

import com.intercorp.lizardo.intercorpclientes.domain.ClienteFindRepository;
import com.intercorp.lizardo.intercorpclientes.domain.DetailCliente;
import com.intercorp.lizardo.intercorpclientes.domain.Kpi;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClienteBDFindRepository implements ClienteFindRepository {

    @Override
    public Flux<DetailCliente> findAll() {
        return Flux.empty();
    }

    @Override
    public Mono<Kpi> calculateKpi() {
        return Mono.empty();
    }
}
