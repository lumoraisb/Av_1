package AV1.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AV1.example.demo.service.CandidatosTseService;

@Controller
public class CandidatosTseController {

    private final CandidatosTseService service;

    public CandidatosTseController(CandidatosTseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(
        @RequestParam(name = "cargo", required = false) String cargo,
        @RequestParam(name = "partido", required = false) String partido,
        @RequestParam(name = "texto", required = false) String texto,
        Model model) {
        model.addAttribute("candidatos", service.filtrar(cargo, partido, texto));
        model.addAttribute("cargos", service.listarCargos());
        model.addAttribute("partidos", service.listarPartidos());
        model.addAttribute("cargoSelecionado", cargo == null ? "" : cargo);
        model.addAttribute("partidoSelecionado", partido == null ? "" : partido);
        model.addAttribute("textoSelecionado", texto == null ? "" : texto);
        return "index";
    }
}

