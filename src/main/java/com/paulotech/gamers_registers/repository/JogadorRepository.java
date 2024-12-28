package com.paulotech.gamers_registers.repository;

import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.domain.Jogador;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JogadorRepository {
    private final JdbcClient jdbcClient;

    public JogadorRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public Jogador salvar(Jogador jogador){
        jdbcClient.sql("""
                INSERT INTO JOGADORES (nome, email, telefone, codinome, grupo_codinome)
                VALUES (:nome, :email, :telefone, :codinome, :grupo_codinome)
                """)
                .param("nome", jogador.getNome())
                .param("email", jogador.getEmail())
                .param("telefone", jogador.getTelefone())
                .param("codinome", jogador.getCodinome())
                .param("grupoCodinome", jogador.getGrupoCodinome())
                .update();
        return jogador;
    }

    public List<String> listarCodinomesPorGrupo(GrupoCodinome grupoCodinome) {
        return jdbcClient.sql("SELECT distinct(codinomes) FROM JOGADORES WHERE grupo_codinome = :grupoCodinome")
                .param("grupoCodinome", grupoCodinome.name())
                .query(String.class)
                .list();
    }
}
