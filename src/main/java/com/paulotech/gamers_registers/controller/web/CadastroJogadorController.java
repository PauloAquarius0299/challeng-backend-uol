package com.paulotech.gamers_registers.controller.web;

import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.domain.Jogador;
import com.paulotech.gamers_registers.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro-jogador")
public class CadastroJogadorController {
    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public String paginaCadastroDoJogador(Model model, Jogador jogador) {
        model.addAttribute("jogador", jogador);
        model.addAttribute("grupoCodinome", GrupoCodinome.values());
        return "cadastro_jogador";
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
