package com.intercorp.lizardo.intercorpclientes.application.create;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteRepository;
import com.intercorp.lizardo.intercorpclientes.domain.MortandadService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public final class ClienteCreateService {

    private ClienteRepository clienteRepository;

    private MortandadService mortandadService;

    public ClienteCreateService(ClienteRepository clienteRepository, MortandadService mortandadService) {
        this.clienteRepository = clienteRepository;
        this.mortandadService = mortandadService;
    }

    public Mono<Void> crearCliente(CrearClienteRequest request) {
        Cliente cliente = new Cliente(UUID.randomUUID().toString(), request.nombre(), request.apellido(), request.fechaNacimiento());
        return clienteRepository.create(cliente).flatMap(x->clienteRepository.updateFechaMortandad(
                mortandadService.calcularMortandadCliente(x),
                x.id()));
    }
}
