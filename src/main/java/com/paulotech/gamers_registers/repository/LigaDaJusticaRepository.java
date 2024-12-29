package com.paulotech.gamers_registers.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.repository.dto.CodinomeDTO;
import com.paulotech.gamers_registers.repository.dto.LigaDaJusticaDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository{
    @Override
    public CodinomeDTO buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
        return ligaDaJustica;
    }
}
