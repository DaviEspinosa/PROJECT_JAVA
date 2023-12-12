package View;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.ClientesVipControll;
import Model.Produtos;

public class JanelaProdutos extends JPanel {

    private List<Produtos> produtos;
    private JTable table;
    private DefaultTableModel tableModel;

    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);

    public JanelaProdutos() {

        // new ClientesVipDAO().criarTabelaCliente();
        ClientesVipControll ClientesControll = new ClientesVipControll();

        JPanel painelPrincipal = new JPanel();
        JPanel vazioNorte = new JPanel();
        vazioNorte.setPreferredSize(new Dimension(00, 700));


        // add ao painelPrincipal
        painelPrincipal.setBorder(BorderFactory.createLineBorder(new Color(28, 97, 70), 20));

        // ----====Painel Top====----
        

        // Dentro de Painel Dados


        // Dentro de Painel Ações


        // ----====Painel Bottom====----



        this.setBackground(new Color(17, 68, 48));
    }
}

