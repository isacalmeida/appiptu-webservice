package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.service.SimulacaoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/simulacao")
public class SimulacaoController {

	// == fields ==
	private SimulacaoService simulacaoService;
	
	// == constructors ==
	@Autowired
	public SimulacaoController(SimulacaoService simulacaoService) {
		this.simulacaoService = simulacaoService;
	}
	
	// == public methods ==
	@GetMapping
	public String home(Model model){
		log.info("GetMapping / on SimulacaoController");
		model.addAttribute("simulacoes", simulacaoService.getAll());
		return "simulacao/index";
	}
}
