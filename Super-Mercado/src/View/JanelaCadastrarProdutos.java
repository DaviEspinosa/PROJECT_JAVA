package View;

import Controller.CadastrarProdutosControll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;;

public class JanelaCadastrarProdutos extends JPanel {

    private Color transparente = new Color(0, 0, 0, 0);
    private Color cinzaClaro = new Color(217, 217, 217);
    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarProdutos() {
        // // Adicionando uma cor
        // this.setBackground(verdeClaro);
        // // Instanciando o painel invisivel para deixar o container no centro da tela

        // // Instanciando o controlador da classe
        // CadastrarProdutosControll controladorProdutos = new
        // CadastrarProdutosControll();

        // // Instanciando os TextField
        // nomeProduto = new JTextField();
        // codigoBarra = new JTextField();
        // quantidade = new JTextField();
        // valor = new JTextField();

        // // Adicionando o placeholder aos TextField
        // nomeProduto =
        // controladorProdutos.createTextFieldWithPlaceholderProdutos("Nome do
        // Produto");
        // codigoBarra =
        // controladorProdutos.createTextFieldWithPlaceholderProdutos("Código de
        // barra");
        // quantidade =
        // controladorProdutos.createTextFieldWithPlaceholderProdutos("Quantidade");
        // valor = controladorProdutos.createTextFieldWithPlaceholderProdutos("Valor");

        // // Adicionando uma fonte para eles
        // Font fonteTextField = new Font("Arial", Font.BOLD, 13);
        // nomeProduto.setFont(fonteTextField);
        // codigoBarra.setFont(fonteTextField);
        // quantidade.setFont(fonteTextField);
        // valor.setFont(fonteTextField);

        // // Instanciando os painéis
        // cadastroProdutos = new JPanel();
        // acoesCadastroProdutos = new JPanel();

        // // Adicionando tamanho para eles
        // cadastroProdutos.setPreferredSize(new Dimension(500, 500));

        // // Configurando o layout
        // cadastroProdutos.setLayout(new BoxLayout(cadastroProdutos,
        // BoxLayout.Y_AXIS));
        // acoesCadastroProdutos.setLayout(new FlowLayout(FlowLayout.LEFT));

        // // Instanciando os botões
        // cadastrar = new JButton("Cadastrar");
        // cancelar = new JButton("Cancelar");

        // // Adicionando uma cor para eles
        // cadastrar.setBackground(verdeClaro);
        // cancelar.setBackground(vermelhoClaro);

        // // Adicionando os TextField aos painéis
        // cadastroProdutos.add(nomeProduto);
        // cadastroProdutos.add(codigoBarra);
        // cadastroProdutos.add(quantidade);
        // cadastroProdutos.add(valor);

        // // Adicionando os botões aos painéis
        // acoesCadastroProdutos.add(cadastrar);
        // acoesCadastroProdutos.add(cancelar);

        // // Adicionando ao painel principal usando um container
        // JPanel container = new JPanel(new BorderLayout());
        // container.setBackground(cinzaClaro);
        // container.add(cadastroProdutos, BorderLayout.CENTER);
        // container.add(acoesCadastroProdutos, BorderLayout.EAST);
        // add(container);
        CadastrarProdutosControll ProdutosControll = new CadastrarProdutosControll();

        JPanel painelPricipal = new JPanel(new GridLayout(2, 0));
        JPanel vazioNorte = new JPanel();
        JPanel vazioOeste = new JPanel();
        JPanel vazioLeste = new JPanel();
        JPanel vazioSul = new JPanel();

             vazioNorte.setPreferredSize(new Dimension(00, 500));


        // Painel dentro do Principal
        JPanel painelTop = new JPanel(new GridLayout(0, 2));
        JPanel painelBottom = new JPanel();

        // add ao painelPrincipal
        painelPricipal.add(painelTop);
        painelPricipal.add(painelBottom);

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
        painelBottom.add(exibirErros);

        this.add(vazioNorte, BorderLayout.NORTH);
        this.add(vazioOeste, BorderLayout.WEST);
        this.add(painelPricipal, BorderLayout.CENTER);
        this.add(vazioLeste, BorderLayout.EAST);
        this.add(vazioSul, BorderLayout.SOUTH);


        //         JPanel painelComBackground = new JPanel() {
        //     @Override
        //     protected void paintComponent(Graphics g) {
        //         super.paintComponent(g);

        //         // Carregue a imagem do arquivo (ajuste o caminho conforme necessário)
        //         ImageIcon imagemDeFundo = new ImageIcon("./../../assets");

        //         // Desenhe a imagem como background
        //         g.drawImage(imagemDeFundo.getImage(), 0, 0, getWidth(), getHeight(), this);
        //     }
        // };
  

    }
}