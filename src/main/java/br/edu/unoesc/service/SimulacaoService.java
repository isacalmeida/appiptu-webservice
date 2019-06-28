package br.edu.unoesc.service;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.model.Simulacao;

public interface SimulacaoService {

	// == crud default ==
	List<Simulacao> getAll();
	
	Optional<Simulacao> findOne(Long id);
	
	Simulacao create(Simulacao simulacao);
	
	Simulacao update(Simulacao simulacao);
	
	void delete(Long id);
}
