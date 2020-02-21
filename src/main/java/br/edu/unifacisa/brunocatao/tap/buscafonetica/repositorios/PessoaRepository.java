package br.edu.unifacisa.brunocatao.tap.buscafonetica.repositorios;

import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
  @Query(value="SELECT DISTINCT p FROM Pessoa p INNER JOIN p.chavesFoneticas c WHERE c.chave LIKE CONCAT('%',:chave,'%')")
  List<Pessoa> findAllByChave(@Param("chave") String chave);
}
