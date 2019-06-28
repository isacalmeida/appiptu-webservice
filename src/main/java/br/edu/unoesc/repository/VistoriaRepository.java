package br.edu.unoesc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.model.Vistoria;

@Repository
public interface VistoriaRepository extends JpaRepository<Vistoria, Long>{

}
