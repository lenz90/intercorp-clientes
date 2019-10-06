package com.intercorp.lizardo.intercorpclientes.domain;

import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface ClienteRepository {
    Mono<Cliente> create(Cliente cliente);
    Mono<Void> updateFechaMortandad(LocalDate fechaFallecimiento, String id);
}
