package com.paulotech.gamers_registers.domain;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Jogador(
        @NotBlank String nome, @NotBlank @Email String email, String telefone, String codinome,
        @NotNull GrupoCodinome grupoCodinome) {

    public Jogador withCodinome(String codinome) {
        return new Jogador(nome, email, telefone, codinome, grupoCodinome);
    }
}
