package View;

import Controller.CadastrarProdutosControll;
import DAO.CadastrarProdutosDAO;
import Model.Produtos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;;

public class JanelaCadastrarProdutos extends JPanel {

    private int linhaSelecionada = -1;
    private List<Produtos> produtos;
    private JTable table;
    private DefaultTableModel tableModel;
    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarProdutos() {
       
        CadastrarProdutosControll ProdutosControll = new CadastrarProdutosControll(produtos, tableModel, table);

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
        //inputs com placeholder (metodo dentro de produtos controller)
        JTextField InputNome = new JTextField(20);
        InputNome = ProdutosControll.createTextFieldWithPlaceholderProdutos("Produto:");
        JTextField InputQuantidade = new JTextField(20);
        InputQuantidade = ProdutosControll.createTextFieldWithPlaceholderProdutos("Quantidade:");
        JTextField InputCodBarras = new JTextField(20);
        InputCodBarras = ProdutosControll.createTextFieldWithPlaceholderProdutos("Código:");
        JTextField InputValor = new JTextField(20);
        InputValor = ProdutosControll.createTextFieldWithPlaceholderProdutos("Valor:");
        painelDados.setLayout(new BoxLayout(painelDados, BoxLayout.Y_AXIS));
        painelDados.add(InputNome);
        painelDados.add(InputQuantidade);
        painelDados.add(InputCodBarras);
        painelDados.add(InputValor);

        // Dentro de Painel Ações
        JButton cadastrarButton = new JButton("Cadastrar");
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
        // //tabela
        JScrollPane jSPane = new JScrollPane();
        painelBottom.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Preço", "Quantidade", "Código" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
        new CadastrarProdutosDAO().criarTabela();



        // table.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseClicked(MouseEvent evt) {
        //         linhaSelecionada = table.rowAtPoint(evt.getPoint());
        //         if (linhaSelecionada != -1) {
        //             InputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
        //             InputQuantidade.setText((String) table.getValueAt(linhaSelecionada, 1));
        //             InputCodBarras.setText((String) table.getValueAt(linhaSelecionada, 2));
        //             InputValor.setText((String) table.getValueAt(linhaSelecionada, 3));
                    
        //             cadastrarButton.setEnabled(false);
        //             editarButton.setEnabled(true);
        //         } else {
                    
        //             // Ativa o botão
        //             cadastrarButton.setEnabled(true);
        //             //desativa botão
        //             editarButton.setEnabled(false);
        //         }
        //     }
        // });

        //Ação para cadastrar
        // // cadastrarButton.addActionListener(new ActionListener() {
        // //     @Override

        // //     public void actionPerformed(ActionEvent e){
        // //         ProdutosControll.cadastrar(InputNome.getText(), InputQuantidade.getText(), InputCodBarras.getText(), InputValor.getText());
                
        // //         //limpando inputs
        // //         InputNome.setText("");
        // //         InputQuantidade.setText("");
        // //         InputCodBarras.setText("");
        // //         InputValor.setText("");
                
        // //         ProdutosControll.atualizar(nome, preco, name, name);
        // //     }
        // });

        this.add(painelNorte, BorderLayout.NORTH);
        this.add(painelPrincipal, BorderLayout.CENTER);
        this.setBackground(new Color(17, 68, 48));

    }
}