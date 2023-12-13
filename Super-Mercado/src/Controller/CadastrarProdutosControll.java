package Controller;

import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ConnectionFactory;
import DAO.CadastrarProdutosDAO;
import Model.Produtos;
import View.JanelaCadastrarProdutos;

public class CadastrarProdutosControll {

    private JanelaCadastrarProdutos view;
    private CadastrarProdutosDAO cadastrarProdutosDAO;
    private List<Produtos> produtoList;
    private JTable table;
    private DefaultTableModel tableModel;

    public CadastrarProdutosControll(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtoList = produtoList;
        this.tableModel = tableModel;
        this.table = table;

    }

    // PlaceHolder
    public JTextField createTextFieldWithPlaceholderProdutos(String placeholder) {
        JTextField textFieldProdutos = new JTextField(placeholder);
        textFieldProdutos.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textFieldProdutos.getText().equals(placeholder)) {
                    textFieldProdutos.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldProdutos.getText().isEmpty()) {
                    textFieldProdutos.setText(placeholder);
                }
            }
        });
        return textFieldProdutos;
    }

    public void cadastrar(String nome, String preco, String quantidade, String codigoBarra) {
        new CadastrarProdutosDAO().cadastrar(nome, preco, quantidade, codigoBarra);

    }

    // Método atualizar Tabela
    private void atualizarTabela() {

        // Iniciar o tableModel
        if (tableModel != null) {
            // Ao iniciar as linhas existentes irão sumir
            tableModel.setRowCount(0);
            // puxa a lista de Carros do BD
            produtoList = new CadastrarProdutosDAO().listarTodos();

            // ele vai colocar no TableModel os carros que estão no banco de dados
            for (Produtos produtos : produtoList) {
                tableModel.addRow(new Object[] { produtos.getNome(), produtos.getPreco(), produtos.getQuantidade(), produtos.getCodigoBarra() });
            }
        }
        // Se tableModel não foi iniciado ele exibira uma menssagem
        else {
            System.out.println("tableModel não inicializado. Certifique-se de passá-lo ao construtor.");
        }
    }

    public void atualizar(String nome, String preco, String quantidade, String codigoBarra) {
        atualizarTabela();

    }

    public void cadastrarProdutos() {
        JButton cadastrarProduto = view.getCadastrarProdutoButton();
        JTextField inputNome = view.getInputNomeTextField();
        JTextField inputQuantidade = view.getInputQuantidadeTextField();
        JTextField inputCodBarras = view.getInputCodBarrasTextField();
        JTextField inputValor = view.getInputValorTextField();

        // Validandi
    if (inputNome.getText().equals("Produto:") || inputQuantidade.getText().equals("Quantidade:")
    || inputCodBarras.getText().equals("Código:") || inputValor.getText().equals("Valor:")) {
JOptionPane.showMessageDialog(view, "Preencha todos os campos antes de cadastrar um produto.",
        "Campos Vazios", JOptionPane.WARNING_MESSAGE);
return;
}
        cadastrarProdutosDAO.cadastrar(inputNome.getText(), inputValor.getText(), inputQuantidade.getText(), inputCodBarras.getText());

        limparCampos();
    }

    private void limparCampos() {
        view.getInputNomeTextField().setText("");
        view.getInputQuantidadeTextField().setText("");
        view.getInputCodBarrasTextField().setText("");
        view.getInputValorTextField().setText("");

    }
}
