package com.paulotech.gamers_registers.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.repository.dto.VingadoresDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import java.util.List;

@Repository
public class VingadoresRepository implements CodinomeRepository{

    @Override
    public List<String> buscarCodinomes() throws JsonProcessingException {
        var codinomes = RestClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(GrupoCodinome.VIGADORES.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);
        var objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codinomes, VingadoresDTO.class);

        return vingadores.getCodinomes();
    }
}
