package br.edu.unifacisa.brunocatao.tap.buscafonetica.gui;

import br.edu.unifacisa.brunocatao.tap.buscafonetica.entidades.Pessoa;
import br.edu.unifacisa.brunocatao.tap.buscafonetica.servicos.PessoaService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class BuscaFoneticaGUI {
  private JTabbedPane tabbedPane1;
  private JPanel rootPanel;
  private JList cadastroList;
  private JTextField cadastroNomeTF;
  private JTextField cadastroEnderecoTF;
  private JButton adicionarButton;
  private JTextField buscaNomeTF;
  private JList buscaList;

  public static void exibirFrame(PessoaService pessoaService) {
    final BuscaFoneticaGUI gui = new BuscaFoneticaGUI();

    gui.cadastroList.setModel(new ListModel() {
      @Override
      public int getSize() {
        return pessoaService.getTodas().size();
      }

      @Override
      public Object getElementAt(int i) {
        return pessoaService.getTodas().get(i);
      }

      @Override
      public void addListDataListener(ListDataListener listDataListener) {
        // faz nada
      }

      @Override
      public void removeListDataListener(ListDataListener listDataListener) {
        // faz nada
      }
    });

    gui.adicionarButton.addActionListener((actionEvent) -> {
      pessoaService.salvarPessoa(gui.cadastroNomeTF.getText(), gui.cadastroEnderecoTF.getText());
      gui.cadastroNomeTF.setText("");
      gui.cadastroEnderecoTF.setText("");
      gui.cadastroNomeTF.requestFocus();
      SwingUtilities.updateComponentTreeUI(gui.cadastroList);
    });

    gui.buscaNomeTF.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent keyEvent) {
        final List<Pessoa> pessoas = pessoaService.buscarPessoas(gui.buscaNomeTF.getText());
        gui.buscaList.setModel(new ListModel() {
          @Override
          public int getSize() {
            return pessoas.size();
          }

          @Override
          public Object getElementAt(int i) {
            return pessoas.get(i);
          }

          @Override
          public void addListDataListener(ListDataListener listDataListener) {
            // faz nada
          }

          @Override
          public void removeListDataListener(ListDataListener listDataListener) {
            // faz nada
          }
        });
      }
    });

    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Busca Fonética");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(gui.rootPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
}
