package View;

import Controller.ClientesVipControll;
import DAO.ClientesVipDAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastrarClientes extends JPanel {

    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarClientes() {
        // new ClientesVipDAO().criarTabelaCliente();
        ClientesVipControll ClientesControll = new ClientesVipControll();

        JPanel painelPrincipal = new JPanel(new GridLayout(2, 0));
        JPanel vazioNorte = new JPanel();
        vazioNorte.setPreferredSize(new Dimension(00, 700));


        // Painel dentro do Principal
        JPanel painelTop = new JPanel(new GridLayout(0, 2));
        JPanel painelBottom = new JPanel();

        // add ao painelPrincipal
        painelPrincipal.add(painelTop);
        painelPrincipal.add(painelBottom);
        painelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(28, 97, 70), 20));

        // ----====Painel Top====----
        JPanel painelDados = new JPanel();
        JTextField exibirErros = new JTextField(200);
        exibirErros.setBackground(new Color(175, 179, 177));
        painelTop.setPreferredSize(new Dimension(500, 200));
        painelTop.add(painelDados);
        painelTop.add(exibirErros);

        // Dentro de Painel Dados
        JTextField InputUserName = new JTextField(20);
        InputUserName = ClientesControll.createTextFieldWithPlaceholder("Nome:");
        JTextField InputEmail = new JTextField(20);
        InputEmail = ClientesControll.createTextFieldWithPlaceholder("E-mail:");
        JTextField InputCpf = new JTextField(20);
        InputCpf = ClientesControll.createTextFieldWithPlaceholder("Cpf:");
        JTextField InputEndereco = new JTextField(20);
        InputEndereco = ClientesControll.createTextFieldWithPlaceholder("Endereço:");
        painelDados.setLayout(new BoxLayout(painelDados, BoxLayout.Y_AXIS));
        painelDados.add(InputUserName);
        painelDados.add(InputEmail);
        painelDados.add(InputCpf);
        painelDados.add(InputEndereco);

        // Dentro de Painel Ações
        JPanel painelAcoes = new JPanel();
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton cancelarButton = new JButton("Cancelar");
        painelAcoes.add(cadastrarButton);
        painelAcoes.add(cancelarButton);
        cadastrarButton.setBackground(verdeClaro);
        cancelarButton.setBackground(vermelhoClaro);

        // ----====Painel Bottom====----
        painelBottom.setPreferredSize(new Dimension(200, 50));
        painelBottom.setLayout(new BoxLayout(painelBottom, BoxLayout.Y_AXIS));
        painelBottom.add(painelAcoes);


        this.add(vazioNorte, BorderLayout.NORTH);
        this.add(painelPrincipal, BorderLayout.CENTER);
        this.setBackground(new Color(17, 68, 48));
    }
           


    }
