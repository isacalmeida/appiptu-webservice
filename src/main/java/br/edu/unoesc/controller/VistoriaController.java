package br.edu.unoesc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.service.VistoriaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/vistoria")
public class VistoriaController {

	// == fields ==
	private VistoriaService vistoriaService;
	
	// == constructors ==
	@Autowired
	public VistoriaController(VistoriaService vistoriaService) {
		this.vistoriaService = vistoriaService;
	}
	
	// == public methods ==
	@GetMapping
	public String home(Model model){
		log.info("GetMapping / on VistoriaController");
		model.addAttribute("vistorias", vistoriaService.getAll());
		return "vistoria/index";
	}
}
