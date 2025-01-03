package com.paulotech.gamers_registers.service;

import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.domain.Jogador;
import com.paulotech.gamers_registers.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    public JogadorService(JogadorRepository jogadorRepository, CodinomeService codinomeService) {
        this.jogadorRepository = jogadorRepository;
        this.codinomeService = codinomeService;
    }

    public Jogador registrarJogador(Jogador jogador) throws Exception {
        var codinomeEmUso = listarCodinomeEmUso(jogador.grupoCodinome());
        var novoCodinome = codinomeService.gerarCodinome(jogador.grupoCodinome(), codinomeEmUso);

        var novoJogador = new Jogador(
                jogador.nome(),
                jogador.email(),
                jogador.codinome(),
                novoCodinome,
                jogador.grupoCodinome());
        return jogadorRepository.salvar(novoJogador);
    }

    public List<Jogador> listaJogadores(){
        return jogadorRepository.listaJogador();
    }

    private List<String> listarCodinomeEmUso(GrupoCodinome grupoCodinome) {
        return jogadorRepository.listarCodinomesEmUso(grupoCodinome);
    }


}
