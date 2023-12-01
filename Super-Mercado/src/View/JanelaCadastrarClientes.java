package View;

import Controller.JanelaCadastrarClientesControll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastrarClientes extends JPanel {

    private JTextField nome;
    private JTextField email;
    private JTextField cpf;
    private JTextField endereco;
    private JPanel cadastro;
    private JPanel acoesCadastro;
    private JButton cadastrar, cancelar;
    private Color cinza = new Color(128, 128, 128);
    private Color cinzaClaro = new Color(217, 217, 217);
    private Color branca = new Color(255, 255, 255);
    private Color verdeClaro = new Color(223, 250, 215);
    private Color vermelhoClaro = new Color(250, 215, 215);

    // Construtor
    public JanelaCadastrarClientes() {
        // Adicionando uma cor
        this.setBackground(cinza);

        // Instanciando o controlador da janela
        JanelaCadastrarClientesControll controlador = new JanelaCadastrarClientesControll();
        // Adicionando título

        // Instanciando os campos de entarda de dados
        nome = new JTextField("Nome", 20);
        email = new JTextField("Email", 20);
        cpf = new JTextField("Cpf", 20);
        endereco = new JTextField("Endereço", 20);

        nome = controlador.createTextFieldWithPlaceholder("Nome");
        email = controlador.createTextFieldWithPlaceholder("Email");
        cpf = controlador.createTextFieldWithPlaceholder("Cpf");
        endereco = controlador.createTextFieldWithPlaceholder("Endereço");

        // Adicionando cores
        nome.setBackground(cinzaClaro);
        email.setBackground(cinzaClaro);
        cpf.setBackground(cinzaClaro);
        endereco.setBackground(cinzaClaro);

        // Adicionando um tamanho para eles
        nome.setPreferredSize(new Dimension(100, 20));
        email.setPreferredSize(new Dimension(100, 20));
        cpf.setPreferredSize(new Dimension(100, 20));
        endereco.setPreferredSize(new Dimension(100, 20));

        // Adicionando uma fonte para eles
        Font fonteTextField = new Font("Arial", Font.BOLD, 18);
        nome.setFont(fonteTextField);
        email.setFont(fonteTextField);
        cpf.setFont(fonteTextField);
        endereco.setFont(fonteTextField);

        // Instanciando o painel cadastro
        cadastro = new JPanel();
        cadastro.setSize(600, 900);
        cadastro.setLayout(new BoxLayout(cadastro, BoxLayout.Y_AXIS));
        cadastro.setBackground(branca);
        cadastro.setPreferredSize(new Dimension(700, 400));

        // Adicionando ao painel cadastro
        cadastro.add(nome);
        cadastro.add(email);
        cadastro.add(cpf);
        cadastro.add(endereco);

        // Instanciando o painel acoesCadastro
        acoesCadastro = new JPanel();
        acoesCadastro.setLayout(new FlowLayout(FlowLayout.RIGHT));
        acoesCadastro.setBackground(branca);

        // Instanciando os botões(cadastrar, excluir)
        cadastrar = new JButton("Cadastrar");
        cancelar = new JButton("Cancelar");

        // Adicionando cores
        cadastrar.setBackground(verdeClaro);
        cancelar.setBackground(vermelhoClaro);

        // Adicionando uma fonte
        Font fonteBotoes = new Font("Arial", Font.BOLD, 18);
        cadastrar.setFont(fonteBotoes);
        cancelar.setFont(fonteBotoes);

        // Adicionando ao painel acoesCadastro
        acoesCadastro.add(cadastrar);
        acoesCadastro.add(cancelar);

        // Adicionando ao painel principal usando um container
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(cinzaClaro);
        container.add(cadastro, BorderLayout.CENTER);
        container.add(acoesCadastro, BorderLayout.EAST);
        container.setBounds(100, 200, 600, 600);
        add(container);
    }
}
