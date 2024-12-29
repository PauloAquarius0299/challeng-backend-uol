package com.paulotech.gamers_registers.controller.web;

import com.paulotech.gamers_registers.domain.GrupoCodinome;
import com.paulotech.gamers_registers.domain.Jogador;
import com.paulotech.gamers_registers.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro-jogador")
public class CadastroJogadorController {
    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public String paginaCadastroDoJogador(Model model) {
        return getViewAndModel(model, new Jogador(null,null,null,null,null));
    }

    @PostMapping
    public String cadastrarJogador(@ModelAttribute @Valid Jogador jogador, BindingResult result, Model model) throws Exception {
        if(result.hasErrors())
            return getViewAndModel(model, jogador);

        jogadorService.registrarJogador(jogador);
        return "redirect:/cadastro-jogador";
    }

    private String getViewAndModel(Model model, Jogador jogador){
        model.addAttribute("jogador", jogador);
        model.addAttribute("grupoCodinome", GrupoCodinome.values());
        return "cadastro_jogador";
    }
}
