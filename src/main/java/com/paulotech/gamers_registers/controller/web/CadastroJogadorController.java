package com.paulotech.gamers_registers.controller.web;

import com.paulotech.gamers_registers.domain.Jogador;
import com.paulotech.gamers_registers.service.JogadorService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {
    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute Jogador jogador){
        try {
            jogadorService.registrarJogador(jogador);
            return "redirect:/cadastro-jogador";
        }catch (Exception e){
            return "redirect:/cadastro-jogador";
        }
    }
}
