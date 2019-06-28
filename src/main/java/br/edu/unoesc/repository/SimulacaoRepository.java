package br.edu.unoesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.model.Simulacao;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long>{

}
