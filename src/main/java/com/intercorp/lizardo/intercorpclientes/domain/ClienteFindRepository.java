package com.intercorp.lizardo.intercorpclientes.domain;

import reactor.core.publisher.Flux;

public interface ClienteFindRepository {
    Flux<DetailCliente> findAll();
}
