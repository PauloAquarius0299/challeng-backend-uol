package com.paulotech.gamers_registers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {
    String nome;
    String email;
    String codinome;
    String telefone;
    GrupoCodinome grupoCodinome;


}
