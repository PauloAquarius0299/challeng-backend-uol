package com.paulotech.gamers_registers.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.repository.dto.CodinomeDTO;
import com.paulotech.gamers_registers.repository.dto.VingadoresDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
public class VingadoresRepository implements CodinomeRepository{

    @Override
    public CodinomeDTO buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient
                .builder()
                .baseUrl(GrupoCodinome.VIGADORES.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codinomes, VingadoresDTO.class);

        return vingadores;
    }
}
