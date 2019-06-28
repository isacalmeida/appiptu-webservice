package br.edu.unoesc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.model.Simulacao;
import br.edu.unoesc.repository.SimulacaoRepository;

@Service
public class SimulacaoServiceImpl implements SimulacaoService {
	
	// == fields ==
	private SimulacaoRepository simulacaoRepository;
	
	// == constructors ==
	@Autowired
	public SimulacaoServiceImpl(SimulacaoRepository simulacaoRepository) {
		this.simulacaoRepository = simulacaoRepository;
	}
	
	// == override methods ==
	@Override
	public List<Simulacao> getAll() {
		return simulacaoRepository.findAll();
	}

	@Override
	public Optional<Simulacao> findOne(Long id) {
		return simulacaoRepository.findById(id);
	}

	@Override
	public Simulacao create(Simulacao simulacao) {
		return simulacaoRepository.save(simulacao);
	}

	@Override
	public Simulacao update(Simulacao simulacao) {
		return simulacaoRepository.save(simulacao);
	}

	@Override
	public void delete(Long id) {
		simulacaoRepository.deleteById(id);
	}
	
}
