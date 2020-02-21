package br.edu.unifacisa.brunocatao.tap.buscafonetica;

import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.ChaveFonetica;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.Pessoa;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.gui.BuscaFoneticaGUI;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.repositorios.ChaveFoneticaRepository;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.repositorios.PessoaRepository;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.servicos.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class BuscafoneticaApplication implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(BuscafoneticaApplication.class);

  @Autowired
  private PessoaService pessoaService;

  @Override
  public void run(String... args) throws Exception {
    BuscaFoneticaGUI.exibirFrame(pessoaService);
    logger.info("Aplicação em execução - pressione Ctrl+C para encerrar");
    Thread.currentThread().join();
  }

  private Pessoa createPessoa(String nome, String endereco) {
    Pessoa p = new Pessoa();
    p.setNome(nome);
    p.setEndereco(endereco);
    return p;
  }

  private ChaveFonetica createChaveFonetica(String chave) {
    ChaveFonetica c = new ChaveFonetica();
    c.setChave(chave);
    return c;
  }

  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(BuscafoneticaApplication.class);
    builder.headless(false);
    ConfigurableApplicationContext context = builder.run(args);
  }
}
