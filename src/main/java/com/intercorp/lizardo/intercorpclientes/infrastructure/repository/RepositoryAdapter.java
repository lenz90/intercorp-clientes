package com.intercorp.lizardo.intercorpclientes.infrastructure.repository;

import com.intercorp.lizardo.intercorpclientes.domain.Cliente;
import com.intercorp.lizardo.intercorpclientes.domain.DetailCliente;
import com.intercorp.lizardo.intercorpclientes.infrastructure.repository.mysql.entity.ClienteEntity;

public final class RepositoryAdapter {
    public static ClienteEntity clienteToEntity(Cliente cliente) {
        return new ClienteEntity(cliente.id(), cliente.nombre(), cliente.apellido(), cliente.edad(),
                cliente.fechaNacimiento(), null);
    }

    public static DetailCliente entityToDetail(ClienteEntity entity) {
        return new DetailCliente(entity.nombre(), entity.apellido(), entity.edad(), entity.fechaNacimiento(),
                entity.fechaPosibleFallecimiento());
    }
}
