package com.intercorp.lizardo.intercorpclientes.application.create;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public final class ClienteCreateService {

    private ClienteRepository clienteRepository;


    public ClienteCreateService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Mono<Void> crearCliente(CrearClienteRequest request) {
        Cliente cliente = new Cliente(UUID.randomUUID().toString(), request.nombre(), request.apellido(), request.fechaNacimiento());
        return clienteRepository.create(cliente);
    }
}
