package br.edu.unoesc.service;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.model.Vistoria;

public interface VistoriaService {

	// == crud default ==
	List<Vistoria> getAll();
	
	Optional<Vistoria> findOne(Long id);
	
	Vistoria create(Vistoria vistoria);
	
	Vistoria update(Vistoria vistoria);
	
	void delete(Long id);
}
