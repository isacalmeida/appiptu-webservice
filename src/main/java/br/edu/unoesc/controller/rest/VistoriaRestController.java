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

import br.edu.unoesc.model.Vistoria;
import br.edu.unoesc.service.VistoriaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/rest/vistoria")
public class VistoriaRestController {

	// == fields ==
	private VistoriaService vistoriaService;
	
	// == constructors ==
	@Autowired
	public VistoriaRestController(VistoriaService vistoriaService) {
		this.vistoriaService = vistoriaService;
	}
	
	// == public methods ==
	@GetMapping
	public List<Vistoria> getAll(){
		log.info("GetMapping / on VistoriaRestController");
		return vistoriaService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable Long id) {
		log.info("GetMapping /{} on VistoriaRestController", id);
		
		Optional<Vistoria> vistoria = vistoriaService.findOne(id);
		
		if(vistoria.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(vistoria);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Vistoria vistoria){
		log.info("PostMapping / on VistoriaRestController - content={}", vistoria);
		
		if(vistoria == null) {
			return ResponseEntity.noContent().build();
		}
		else {
			Vistoria vistoriaCreated = vistoriaService.create(vistoria);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(vistoriaCreated.getId()).toUri();
			
			return ResponseEntity.created(location).body(vistoriaCreated);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Vistoria vistoria){
		log.info("PutMapping /{} on VistoriaRestController - content={}", id, vistoria);
		
		Optional<Vistoria> vistoriaUpdated = vistoriaService.findOne(id);
		
		if(vistoriaUpdated.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			if(vistoria == null) {
				return ResponseEntity.noContent().build();
			}
			else {
				vistoriaUpdated.get().setDataAgendamento(vistoria.getDataAgendamento());
				vistoriaUpdated.get().setEmail(vistoria.getEmail());
				vistoriaUpdated.get().setHoraAgendamento(vistoria.getHoraAgendamento());
				vistoriaUpdated.get().setNome(vistoria.getNome());
				vistoriaUpdated.get().setTelefone(vistoria.getTelefone());
				
				vistoria = vistoriaService.update(vistoriaUpdated.get());
				
				return ResponseEntity.ok(vistoria);
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		log.info("DeleteMapping /{} on VistoriaRestController", id);
		
		Optional<Vistoria> vistoriaDelete = vistoriaService.findOne(id);
		
		if(vistoriaDelete.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			vistoriaService.delete(id);
			return ResponseEntity.ok(id);
		}
	}
}
