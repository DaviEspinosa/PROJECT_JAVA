package View;

import Controller.ClientesVipControll;
import DAO.CadastrarProdutosDAO;
import DAO.ClientesVipDAO;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Model.Clientes;
import Model.Produtos;

public class JanelaCadastrarClientes extends JPanel {


    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField inputUserName;
    private JTextField inputUserEmail;
    private JTextField inputUserCpf;
    private JTextField inputUserTelefone;
    private JLabel labelUserName;
    private JLabel labelUserEmail;
    private JLabel labelUserCpf;
    private JLabel labelUserTelefone;

    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaCadastrarClientes() {

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
        labelUserName = new JLabel("Nome:");
        labelUserEmail = new JLabel("E-mail:");
        labelUserCpf = new JLabel("CPF:");
        labelUserTelefone = new JLabel("Telefone:");
        inputUserName = new JTextField(10);
        inputUserEmail = new JTextField(10);
        inputUserCpf = new JTextField(10);
        inputUserTelefone = new JTextField(10);
        // JTextField InputUserName = new JTextField(20);
        // InputUserName = ClientesControll.createTextFieldWithPlaceholder("Nome:");
        // JTextField InputEmail = new JTextField(20);
        // InputEmail = ClientesControll.createTextFieldWithPlaceholder("E-mail:");
        // JTextField InputCpf = new JTextField(20);
        // InputCpf = ClientesControll.createTextFieldWithPlaceholder("Cpf:");
        // JTextField InputEndereco = new JTextField(20);
        // InputEndereco = ClientesControll.createTextFieldWithPlaceholder("Endereço:");
        painelDados.setLayout(new BoxLayout(painelDados, BoxLayout.Y_AXIS));
        painelDados.add(labelUserName);
        painelDados.add(inputUserName);
        painelDados.add(labelUserEmail);
        painelDados.add(inputUserEmail);
        painelDados.add(labelUserCpf);
        painelDados.add(inputUserCpf);
        painelDados.add(labelUserTelefone);
        painelDados.add(inputUserTelefone);

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

        // tabela
        JScrollPane jSPane = new JScrollPane();
        painelBottom.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "E-mail", "CPF", "Telefone" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
        new ClientesVipDAO().criarTabelaCliente();
        atualizarTabela();

                //Tratamento de eventos
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ClientesControll.cadastrarCliente(inputUserName.getText(), inputUserEmail.getText(), inputUserCpf.getText(), inputUserTelefone.getText());


                if (inputUserName.getText().isEmpty() || inputUserEmail.getText().isEmpty() || inputUserCpf.getText().isEmpty() || inputUserTelefone.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
                    
                    return;
                }
  
                inputUserName.setText("");
                inputUserEmail.setText("");
                inputUserCpf.setText("");
                inputUserTelefone.setText("");
            }
        });

        

        this.add(vazioNorte, BorderLayout.NORTH);
        this.add(painelPrincipal, BorderLayout.CENTER);
        this.setBackground(new Color(17, 68, 48));
    }

        private void atualizarTabela() {
        tableModel.setRowCount(0);
        clientes = new ClientesVipDAO().listarTodosClientes();

        for (Clientes cliente : clientes) {
            tableModel.addRow(new Object[]{cliente.getCpf(),cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco()});
            
        }

    }
}
