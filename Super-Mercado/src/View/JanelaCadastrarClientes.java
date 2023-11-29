package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
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
    private Color cinzaClaro = new Color(217,217,217);
    private Color branca = new Color(255, 255, 255);

    // Construtor
    public JanelaCadastrarClientes() {
        // this.setBounds(100, 120, 1200, 900);
        this.setBackground(cinza);

        //Adicionando título
        
        // Instanciando os campos de entarda de dados
        nome = new JTextField(20);
        email = new JTextField(20);
        cpf = new JTextField(20);
        endereco = new JTextField(20);

        nome.setBackground(cinzaClaro);
        email.setBackground(cinzaClaro);
        cpf.setBackground(cinzaClaro);
        endereco.setBackground(cinzaClaro);

        nome.setPreferredSize(new Dimension(100, 20));
        email.setPreferredSize(new Dimension(100, 20));
        cpf.setPreferredSize(new Dimension(100, 20));
        endereco.setPreferredSize(new Dimension(100, 20));

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

        //Instanciando o painel acoesCadastro
        acoesCadastro = new JPanel();
        acoesCadastro.setLayout(new BoxLayout(acoesCadastro, BoxLayout.Y_AXIS));
        acoesCadastro.setBackground(branca);

        //Instanciando os botões(cadastrar, excluir)
        cadastrar = new JButton("Cadastrar");
        cancelar = new JButton("Cancelar");

        //Adicionando ao painel acoesCadastro
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
