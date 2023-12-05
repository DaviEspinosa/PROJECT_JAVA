package View;

import Controller.CadastrarProdutosControll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;;

public class JanelaCadastrarProdutos extends JPanel {

    private JTextField nomeProduto;
    private JTextField codigoBarra;
    private JTextField quantidade;
    private JTextField valor;
    private JPanel cadastroProdutos;
    private JPanel acoesCadastroProdutos;
    private JPanel invisivel;
    private JButton cadastrar, cancelar;
    private Color transparente = new Color(0, 0, 0, 0);
    private Color cinzaClaro = new Color(217, 217, 217);
    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarProdutos() {
        // Adicionando uma cor
        this.setBackground(verdeClaro);
        // Instanciando o painel invisivel para deixar o container no centro da tela
        invisivel = new JPanel();
        invisivel.setLayout(new BorderLayout());
        invisivel.setBackground(transparente);
        invisivel.setPreferredSize(new Dimension(1400, 200));
        this.add(invisivel, BorderLayout.NORTH);

        // Instanciando o controlador da classe
        CadastrarProdutosControll controladorProdutos = new CadastrarProdutosControll();

        // Instanciando os TextField
        nomeProduto = new JTextField();
        codigoBarra = new JTextField();
        quantidade = new JTextField();
        valor = new JTextField();

        // Adicionando o placeholder aos TextField
        nomeProduto = controladorProdutos.createTextFieldWithPlaceholderProdutos("Nome do Produto");
        codigoBarra = controladorProdutos.createTextFieldWithPlaceholderProdutos("Código de barra");
        quantidade = controladorProdutos.createTextFieldWithPlaceholderProdutos("Quantidade");
        valor = controladorProdutos.createTextFieldWithPlaceholderProdutos("Valor");

        // Adicionando cores aos TextField
        nomeProduto.setBackground(cinzaClaro);
        codigoBarra.setBackground(cinzaClaro);
        quantidade.setBackground(cinzaClaro);
        valor.setBackground(cinzaClaro);

        // Adicionando uma fonte para eles
        Font fonteTextField = new Font("Arial", Font.BOLD, 18);
        nomeProduto.setFont(fonteTextField);
        codigoBarra.setFont(fonteTextField);
        quantidade.setFont(fonteTextField);
        valor.setFont(fonteTextField);

        // Instanciando os painéis
        cadastroProdutos = new JPanel();
        acoesCadastroProdutos = new JPanel();

        // Adicionando tamanho para eles
        cadastroProdutos.setPreferredSize(new Dimension(700, 400));

        // Configurando o layout
        cadastroProdutos.setLayout(new BoxLayout(cadastroProdutos, BoxLayout.Y_AXIS));
        acoesCadastroProdutos.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Instanciando os botões
        cadastrar = new JButton("Cadastrar");
        cancelar = new JButton("Cancelar");

        // Adicionando uma cor para eles
        cadastrar.setBackground(verdeClaro);
        cancelar.setBackground(vermelhoClaro);

        // Adicionando uma fonte
        Font fonteBotoes = new Font("Arial", Font.BOLD, 18);
        cadastrar.setFont(fonteBotoes);
        cancelar.setFont(fonteBotoes);

        // Adicionando os TextField aos painéis
        cadastroProdutos.add(nomeProduto);
        cadastroProdutos.add(codigoBarra);
        cadastroProdutos.add(quantidade);
        cadastroProdutos.add(valor);

        // Adicionando os botões aos painéis
        acoesCadastroProdutos.add(cadastrar);
        acoesCadastroProdutos.add(cancelar);

        // Adicionando ao painel principal usando um container
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(cinzaClaro);
        container.add(cadastroProdutos, BorderLayout.CENTER);
        container.add(acoesCadastroProdutos, BorderLayout.EAST);
        add(container);

    }
}
