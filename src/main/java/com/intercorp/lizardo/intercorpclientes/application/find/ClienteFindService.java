package com.intercorp.lizardo.intercorpclientes.application.find;

import com.google.common.math.Stats;
import com.intercorp.lizardo.intercorpclientes.application.find.adapter.ClienteFindAdapter;
import com.intercorp.lizardo.intercorpclientes.domain.ClienteFindRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class ClienteFindService {

    private ClienteFindRepository findRepository;

    public ClienteFindService(ClienteFindRepository findRepository) {
        this.findRepository = findRepository;
    }

    public Flux<ClienteMortandadResponse> findAllDetail() {
        return findRepository.findAll().map(ClienteFindAdapter::detailToMortandad);
    }

    public Mono<KpiClientesResponse> obtenerKpis() {


        return findRepository.findAll().map(x -> x.edad()).collectList().map(x -> {
            Stats s = Stats.of(x);
            if(x.size()>0) {
                return new KpiClientesResponse(s.mean(), s.populationStandardDeviation());
            }
            else {
                return new KpiClientesResponse(0.0,0.0);
            }

        });
    }

}
