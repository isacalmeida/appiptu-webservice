package br.edu.unoesc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.model.Vistoria;
import br.edu.unoesc.repository.VistoriaRepository;

@Service
public class VistoriaServiceImpl implements VistoriaService {

	// == fields ==
	private VistoriaRepository vistoriaRepository;
	
	// == constructors ==
	@Autowired
	public VistoriaServiceImpl(VistoriaRepository vistoriaRepository) {
		this.vistoriaRepository = vistoriaRepository;
	}

	// == override methods ==
	@Override
	public List<Vistoria> getAll() {
		return vistoriaRepository.findAll();
	}

	@Override
	public Optional<Vistoria> findOne(Long id) {
		return vistoriaRepository.findById(id);
	}

	@Override
	public Vistoria create(Vistoria vistoria) {
		return vistoriaRepository.save(vistoria);
	}

	@Override
	public Vistoria update(Vistoria vistoria) {
		return vistoriaRepository.save(vistoria);
	}

	@Override
	public void delete(Long id) {
		vistoriaRepository.deleteById(id);
	}
}
