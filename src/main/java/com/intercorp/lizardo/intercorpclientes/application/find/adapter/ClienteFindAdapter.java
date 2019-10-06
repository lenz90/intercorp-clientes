package com.intercorp.lizardo.intercorpclientes.application.find.adapter;

import com.intercorp.lizardo.intercorpclientes.application.find.ClienteMortandadResponse;
import com.intercorp.lizardo.intercorpclientes.domain.DetailCliente;

public final class ClienteFindAdapter {
    public static ClienteMortandadResponse detailToMortandad(DetailCliente detailCliente) {
        return new ClienteMortandadResponse(detailCliente.nombre(), detailCliente.apellido(), detailCliente.edad(),
                detailCliente.fechaNacimiento(), detailCliente.fechaPosibleFallecimiento());
    }
}
