package br.com.ada.caixa.locacaoveiculo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundo {

    @GetMapping("/ola-mundo")
    public String olaMundo(){
        return "Ola, Mundo!";
    }
}
