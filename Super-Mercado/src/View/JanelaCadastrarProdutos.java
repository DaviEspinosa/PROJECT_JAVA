package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import Controller.CadastrarProdutosControll;
import DAO.CadastrarProdutosDAO;
import Model.Produtos;

public class JanelaCadastrarProdutos extends JPanel {

    private int linhaSelecionada = -1;
    private List<Produtos> produtos;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel labelNome;
    private JLabel labelValor;
    private JLabel labelQuantidade;
    private JLabel labelCodBarras;
    private JTextField inputNome;
    private JTextField inputQuantidade;
    private JTextField inputCodBarras;
    private JTextField inputValor;
    private JButton cadastrarButton;
    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarProdutos() {

        CadastrarProdutosControll produtosControll = new CadastrarProdutosControll(produtos, tableModel, table);

        JPanel painelPrincipal = new JPanel(new GridLayout(2, 0));
        JPanel painelNorte = new JPanel();
        painelNorte.setPreferredSize(new Dimension(00, 700));

        // Painel dentro do Principal
        JPanel painelTop = new JPanel(new GridLayout(0, 2));
        JPanel painelBottom = new JPanel();

        // add ao painelPrincipal
        painelPrincipal.add(painelTop);
        painelPrincipal.add(painelBottom);
        painelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(28, 97, 70), 20));
        painelPrincipal.setPreferredSize(new Dimension(500, 400));

        // ----====Painel Top====----
        JPanel painelDados = new JPanel();
        JPanel painelAcoes = new JPanel();
        painelTop.setPreferredSize(new Dimension(500, 200));
        painelTop.add(painelDados);
        painelTop.add(painelAcoes);

        // Dentro de Painel Dados
        labelNome = new JLabel("Nome:");
        labelQuantidade = new JLabel("Quantidade:");
        labelCodBarras = new JLabel("Código:");
        labelValor = new JLabel("Preço:");
        inputNome = new JTextField(10);
        inputQuantidade = new JTextField(10);
        inputCodBarras = new JTextField(10);
        inputValor = new JTextField(10);
        // inputs com placeholder (método dentro de produtosControll)
        // inputNome =
        // produtosControll.createTextFieldWithPlaceholderProdutos("Produto:");
        // inputQuantidade =
        // produtosControll.createTextFieldWithPlaceholderProdutos("Quantidade:");
        // inputCodBarras =
        // produtosControll.createTextFieldWithPlaceholderProdutos("Código:");
        // inputValor =
        // produtosControll.createTextFieldWithPlaceholderProdutos("Valor:");

        painelDados.setLayout(new BoxLayout(painelDados, BoxLayout.Y_AXIS));
        painelDados.add(labelNome);
        painelDados.add(inputNome);
        painelDados.add(labelQuantidade);
        painelDados.add(inputQuantidade);
        painelDados.add(labelCodBarras);
        painelDados.add(inputCodBarras);
        painelDados.add(labelValor);
        painelDados.add(inputValor);

        // Dentro de Painel Ações
        cadastrarButton = new JButton("Cadastrar");
        JButton cancelarButton = new JButton("Cancelar");
        JButton editarButton = new JButton("Editar");
        JButton apagarButton = new JButton("Apagar");
        painelAcoes.add(cadastrarButton);
        painelAcoes.add(cancelarButton);
        painelAcoes.add(editarButton);
        painelAcoes.add(apagarButton);
        cadastrarButton.setBackground(verdeClaro);
        cancelarButton.setBackground(vermelhoClaro);

        // ----====Painel Bottom====----
        painelBottom.setLayout(new BoxLayout(painelBottom, BoxLayout.Y_AXIS));
        // tabela
        JScrollPane jSPane = new JScrollPane();
        painelBottom.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Preço", "Quantidade", "Código" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
        new CadastrarProdutosDAO().criarTabela();
        atualizarTabela();

        // Tratamento de eventos
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtosControll.cadastrar(inputNome.getText(), inputValor.getText(), inputQuantidade.getText(),
                        inputCodBarras.getText());

                if (inputNome.getText().isEmpty() || inputValor.getText().isEmpty()
                        || inputQuantidade.getText().isEmpty() || inputCodBarras.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");

                    return;
                }

                inputNome.setText("");
                inputValor.setText("");
                inputQuantidade.setText("");
                inputCodBarras.setText("");
            }
        });

        this.add(painelNorte, BorderLayout.NORTH);
        this.add(painelPrincipal, BorderLayout.CENTER);
        this.setBackground(new Color(17, 68, 48));
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        produtos = new CadastrarProdutosDAO().listarTodos();

        for (Produtos produto : produtos) {
            tableModel.addRow(new Object[]{produto.getNome(),produto.getPreco(), produto.getCodigoBarra(), produto.getQuantidade()});
            
        }

    }

    public JTextField getInputNomeTextField() {
        return inputNome;
    }

    public JTextField getInputQuantidadeTextField() {
        return inputQuantidade;
    }

    public JTextField getInputCodBarrasTextField() {
        return inputCodBarras;
    }

    public JTextField getInputValorTextField() {
        return inputValor;
    }

    public JButton getCadastrarProdutoButton() {
        return cadastrarButton;
    }
}
