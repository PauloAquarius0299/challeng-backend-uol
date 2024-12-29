package com.paulotech.gamers_registers.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paulotech.gamers_registers.repository.dto.CodinomeDTO;

public interface CodinomeRepository {
    CodinomeDTO buscarCodinomes() throws JsonProcessingException;
}
