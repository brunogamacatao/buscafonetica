package br.edu.unifacisa.brunocatao.tap.buscafonetica.servicos;

import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.ChaveFonetica;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.Pessoa;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.repositorios.ChaveFoneticaRepository;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.repositorios.PessoaRepository;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.util.PhoneticEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {
  private PessoaRepository pessoaRepository;
  private ChaveFoneticaRepository chaveFoneticaRepository;

  @Override
  public Pessoa salvarPessoa(String nome, String endereco) {
    Pessoa p = new Pessoa();

    p.setNome(nome);
    p.setEndereco(endereco);

    p = pessoaRepository.save(p);
    gerarChavesFoneticas(p);

    return p;
  }

  private void gerarChavesFoneticas(Pessoa p) {
    Arrays.stream(p.getNome().toUpperCase().trim().split("\\s+")).filter(x -> x.length() > 2).forEach(x -> {
      ChaveFonetica c = new ChaveFonetica();
      c.setChave(PhoneticEncoder.encode(x));
      c.setPessoa(p);
      chaveFoneticaRepository.save(c);
    });
  }

  @Override
  public List<Pessoa> buscarPessoas(String nome) {
    return pessoaRepository.findAllByChave(PhoneticEncoder.encode(nome.toUpperCase()));
  }

  @Override
  public List<Pessoa> getTodas() {
    return pessoaRepository.findAll();
  }
}
