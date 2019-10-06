package com.intercorp.lizardo.intercorpclientes.application.find.adapter;

import com.intercorp.lizardo.intercorpclientes.application.find.ClienteMortandadResponse;
import com.intercorp.lizardo.intercorpclientes.application.find.KpiClientesResponse;
import com.intercorp.lizardo.intercorpclientes.domain.DetailCliente;
import com.intercorp.lizardo.intercorpclientes.domain.Kpi;

public final class ClienteFindAdapter {
    public static ClienteMortandadResponse detailToMortandad(DetailCliente detailCliente) {
        return new ClienteMortandadResponse(detailCliente.nombre(), detailCliente.apellido(), detailCliente.edad(),
                detailCliente.fechaNacimiento(), detailCliente.fechaPosibleFallecimiento());
    }

    public static KpiClientesResponse kpiToResponse(Kpi kpi) {
        return new KpiClientesResponse(kpi.promedioClientes(), kpi.DesviacionEstandar());
    }
}
