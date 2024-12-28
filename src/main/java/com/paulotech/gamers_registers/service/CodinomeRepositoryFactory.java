package com.paulotech.gamers_registers.service;

import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.repository.CodinomeRepository;
import com.paulotech.gamers_registers.repository.LigaDaJusticaRepository;
import com.paulotech.gamers_registers.repository.VingadoresRepository;
import org.springframework.stereotype.Component;

@Component
public class CodinomeRepositoryFactory {
    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository,
                                     VingadoresRepository vingadoresRepository){
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome){
        return switch (grupoCodinome){
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case VIGADORES -> vingadoresRepository;
        };
    }
}
