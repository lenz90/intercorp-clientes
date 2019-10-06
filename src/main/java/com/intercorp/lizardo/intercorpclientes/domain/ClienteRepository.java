package com.intercorp.lizardo.intercorpclientes.domain;

import reactor.core.publisher.Mono;

public interface ClienteRepository {
    Mono<Void> create(Cliente cliente);

}
