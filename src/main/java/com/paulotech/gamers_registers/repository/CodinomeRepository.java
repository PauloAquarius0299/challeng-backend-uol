package com.paulotech.gamers_registers.repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CodinomeRepository {
    List<String> bsucarCodinomes() throws JsonProcessingException;
}
