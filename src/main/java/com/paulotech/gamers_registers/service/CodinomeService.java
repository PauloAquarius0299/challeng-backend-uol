package com.paulotech.gamers_registers.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.exceptions.GrupoCodinomeIndisposiveisException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodinomeService {
    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }

    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> codinomesEmEnum) throws Exception {
        var codinomesDisponiveis = listarCodinomesDisponiveis(grupoCodinome, codinomesEmEnum);
        if(codinomesDisponiveis.isEmpty())
            throw new GrupoCodinomeIndisposiveisException();

        var codinomeSorteado = sortearCodinome(codinomesDisponiveis);
        return codinomeSorteado;
    }

    private List<String> listarCodinomesDisponiveis(GrupoCodinome grupoCodinome, List<String> codinomesEmEnum) throws JsonProcessingException {
        var codinomes = buscarCodinomes(grupoCodinome);

        var codinomesDisponiveis = codinomes
                .stream()
                .filter(codinome -> !codinomesEmEnum.contains(codinome))
                .toList();
        return codinomesDisponiveis;
    }

    private List<String> buscarCodinomes(GrupoCodinome grupoCodinome) throws JsonProcessingException {
        var codinomeRepository = codinomeRepositoryFactory.create(grupoCodinome);
        return codinomeRepository.buscarCodinomes().getCodinomes();
    }

    private String sortearCodinome(List<String> codinomesDisponiveis) {
        return codinomesDisponiveis
                .get((int) (Math.random() * codinomesDisponiveis.size()));
    }
}
