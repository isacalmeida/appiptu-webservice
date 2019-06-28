package br.edu.unoesc.controller.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unoesc.model.Simulacao;
import br.edu.unoesc.service.SimulacaoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/rest/simulacao")
public class SimulacaoRestController {

	// == fields ==
	private SimulacaoService simulacaoService;
	
	// == constructors ==
	@Autowired
	public SimulacaoRestController(SimulacaoService simulacaoService) {
		this.simulacaoService = simulacaoService;
	}
	
	// == public methods ==
	@GetMapping
	public List<Simulacao> getAll(){
		log.info("GetMapping / on SimulacaoRestController");
		return simulacaoService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable Long id) {
		log.info("GetMapping /{} on SimulacaoRestController", id);
		
		Optional<Simulacao> simulacao = simulacaoService.findOne(id);
		
		if(simulacao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(simulacao);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Simulacao simulacao){
		log.info("PostMapping / on SimulacaoRestController - content={}", simulacao);
		
		if(simulacao == null) {
			return ResponseEntity.noContent().build();
		}
		else {
			Simulacao simulacaoCreated = simulacaoService.create(simulacao);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(simulacaoCreated.getId()).toUri();
			
			return ResponseEntity.created(location).body(simulacaoCreated);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Simulacao simulacao){
		log.info("PutMapping /{} on SimulacaoRestController - content={}", id, simulacao);
		
		Optional<Simulacao> simulacaoUpdated = simulacaoService.findOne(id);
		
		if(simulacaoUpdated.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			if(simulacao == null) {
				return ResponseEntity.noContent().build();
			}
			else {
				simulacaoUpdated.get().setCategoria(simulacao.getCategoria());
				simulacaoUpdated.get().setDataSimulacao(simulacao.getDataSimulacao());
				simulacaoUpdated.get().setDesconto(simulacao.getDesconto());
				simulacaoUpdated.get().setHoraSimulacao(simulacao.getHoraSimulacao());
				simulacaoUpdated.get().setNomeCompleto(simulacao.getNomeCompleto());
				simulacaoUpdated.get().setPontuacao(simulacao.getPontuacao());
				
				simulacao = simulacaoService.update(simulacaoUpdated.get());
				
				return ResponseEntity.ok(simulacao);
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		log.info("DeleteMapping /{} on SimulacaoRestController", id);
		
		Optional<Simulacao> simulacaoDelete = simulacaoService.findOne(id);
		
		if(simulacaoDelete.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			simulacaoService.delete(id);
			return ResponseEntity.ok(id);
		}
	}
}
