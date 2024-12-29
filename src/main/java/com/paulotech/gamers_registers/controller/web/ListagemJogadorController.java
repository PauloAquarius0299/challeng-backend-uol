package com.paulotech.gamers_registers.controller.web;

import com.paulotech.gamers_registers.service.JogadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listagem-jogadores")
public class ListagemJogadorController {
    private final JogadorService jogadorService;


    public ListagemJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public String listagemJogadores(Model model){
        model.addAttribute("jogadores", jogadorService.listaJogadores());
        return "listagem_jogadores";
    }
}
