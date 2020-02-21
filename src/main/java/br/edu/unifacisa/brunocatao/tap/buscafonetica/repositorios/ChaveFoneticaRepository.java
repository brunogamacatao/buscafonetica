package br.edu.unifacisa.brunocatao.tap.buscafonetica.repositorios;

import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.ChaveFonetica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaveFoneticaRepository extends JpaRepository<ChaveFonetica, Long> {
}
