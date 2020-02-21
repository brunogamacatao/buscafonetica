package br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pessoa {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String nome;
  private String endereco;
  @OneToMany(mappedBy = "pessoa")
  private List<ChaveFonetica> chavesFoneticas = new ArrayList<>();

  public String toString() {
    return "Nome: " + nome + " - Endereço: " + endereco;
  }
}
