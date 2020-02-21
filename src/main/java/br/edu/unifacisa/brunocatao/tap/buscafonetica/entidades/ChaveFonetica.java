package br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
public class ChaveFonetica {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String chave;
  @ManyToOne
  private Pessoa pessoa;
}
