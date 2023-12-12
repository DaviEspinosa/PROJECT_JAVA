package View;

import Controller.CadastrarProdutosControll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;;

public class JanelaCadastrarProdutos extends JPanel {

    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarProdutos() {
       
        CadastrarProdutosControll ProdutosControll = new CadastrarProdutosControll();

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

        // ----====Painel Top====----
        JPanel painelDados = new JPanel();
        JPanel painelAcoes = new JPanel();
        painelTop.setPreferredSize(new Dimension(500, 200));
        painelTop.add(painelDados);
        painelTop.add(painelAcoes);

        // Dentro de Painel Dados
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
        painelAcoes.add(cadastrarButton);
        painelAcoes.add(cancelarButton);
        cadastrarButton.setBackground(verdeClaro);
        cancelarButton.setBackground(vermelhoClaro);

        // ----====Painel Bottom====----
        painelBottom.setPreferredSize(new Dimension(700, 200));
        painelBottom.setLayout(new BoxLayout(painelBottom, BoxLayout.Y_AXIS));
        JTextField exibirErros = new JTextField(700);
        exibirErros.setBackground(new Color(175, 179, 177));
        painelBottom.add(exibirErros);

        this.add(painelNorte, BorderLayout.NORTH);
        this.add(painelPrincipal, BorderLayout.CENTER);
        this.setBackground(new Color(17, 68, 48));

    }
}