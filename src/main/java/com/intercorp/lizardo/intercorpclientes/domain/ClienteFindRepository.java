package com.intercorp.lizardo.intercorpclientes.domain;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteFindRepository {
    Flux<DetailCliente> findAll();
    Mono<Kpi> calculateKpi();
}
