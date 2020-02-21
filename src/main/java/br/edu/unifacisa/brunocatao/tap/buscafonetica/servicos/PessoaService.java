package br.edu.unifacisa.brunocatao.tap.buscafonetica.servicos;

import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.Pessoa;

import java.util.List;

public interface PessoaService {
  Pessoa salvarPessoa(String nome, String endereco);
  List<Pessoa> buscarPessoas(String nome);
  List<Pessoa> getTodas();
}
