package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ClienteBDRepository  implements ClienteRepository {

    @Override
    public Mono<Void> create(Cliente cliente) {
        return Mono.empty();
    }

}
