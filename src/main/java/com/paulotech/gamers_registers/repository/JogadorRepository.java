package com.paulotech.gamers_registers.repository;

import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.domain.Jogador;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JogadorRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JogadorRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Jogador salvar(Jogador jogador) {
        String sql = """
            INSERT INTO JOGADORES (nome, email, telefone, codinome, grupo_codinome)
            VALUES (:nome, :email, :telefone, :codinome, :grupoCodinome)
        """;
        Map<String, Object> params = Map.of(
                "nome", jogador.getNome(),
                "email", jogador.getEmail(),
                "telefone", jogador.getTelefone(),
                "codinome", jogador.getCodinome(),
                "grupoCodinome", jogador.getGrupoCodinome().name()
        );
        jdbcTemplate.update(sql, params);
        return jogador;
    }

    public List<String> listarCodinomesPorGrupo(GrupoCodinome grupoCodinome) {
        String sql = "SELECT DISTINCT codinome FROM JOGADORES WHERE grupo_codinome = :grupoCodinome";
        Map<String, Object> params = Map.of("grupoCodinome", grupoCodinome.name());
        return jdbcTemplate.queryForList(sql, params, String.class);
    }
}

