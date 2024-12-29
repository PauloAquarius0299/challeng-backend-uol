package com.paulotech.gamers_registers.exceptions;


public class GrupoCodinomeIndisposiveisException extends IllegalArgumentException {

    public GrupoCodinomeIndisposiveisException(){
        super("Não há codinomes disponíveis para o grupo selecionado");
    }
}
