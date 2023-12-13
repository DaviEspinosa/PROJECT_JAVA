package View;

import Controller.JanelaVendasControll;
import DAO.VendasDAO;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class JanelaVendas extends JPanel {
    private Color verdeClaro = new Color(49, 201, 94);
    private Color verdeCreme = new Color(68, 201, 82);
    private Color vermelhoClaro = new Color(199, 59, 59);
    private Color branca = new Color(255, 255, 255);
    private Color transparente = new Color(0, 0, 0, 0);
    private DefaultListModel<String> listaComprasModel;
    private JList<String> listCompras;
    private JPanel informacoesVenda;
    private JPanel invisivel;
    private JPanel acoesInformacoesVenda;
    private JPanel painelFinalizarCompras;
    private JPanel container;
    private JPanel codigoBarrasPanel;
    private JPanel clientesPanel;
    private JPanel descontoPanel;
    private JPanel totalPanel;
    private JPanel quantidadePanel;
    private JLabel codigoBarrasLabel;
    private JLabel clientesLabel;
    private JLabel descontoLabel;
    private JLabel totalLabel;
    private JLabel quantidadeLabel;
    private JTextField codigoBarras;
    private JTextField quantidade;
    private JTextField cliente;
    private JTextField descontoAplicado;
    private JTextField total;
    private JButton finalizarCompra, excluir;

    public JanelaVendas() {

        VendasDAO vendasDAO = new VendasDAO();
        JanelaVendasControll controll = new JanelaVendasControll(this, vendasDAO);

        listaComprasModel = new DefaultListModel<>();
        listCompras = new JList<>(listaComprasModel);
        // Cor de fundo da janela
        this.setBackground(verdeClaro);

         // Instanciando o painel invisivel para deixar o container no centro da tela
         invisivel = new JPanel();
         invisivel.setLayout(new BorderLayout());
         invisivel.setBackground(transparente);
         invisivel.setPreferredSize(new Dimension(1400, 150));
         this.add(invisivel, BorderLayout.NORTH);

        // Instanciando os TextField
        codigoBarras = new JTextField(30);
        quantidade = new JTextField(30);
        cliente = new JTextField(30);
        descontoAplicado = new JTextField(30);
        total = new JTextField(30);

        //Definindo uma cor para as bordas
        codigoBarras.setBorder(BorderFactory.createLineBorder(branca));
        quantidade.setBorder(BorderFactory.createLineBorder(branca));
        cliente.setBorder(BorderFactory.createLineBorder(branca));
        descontoAplicado.setBorder(BorderFactory.createLineBorder(branca));
        total.setBorder(BorderFactory.createLineBorder(branca));


        // Instanciando os paineis dos TextField
        codigoBarrasPanel = new JPanel(new BorderLayout());
        clientesPanel = new JPanel(new BorderLayout());
        descontoPanel = new JPanel(new BorderLayout());
        totalPanel = new JPanel(new BorderLayout());
        quantidadePanel = new JPanel(new BorderLayout());

        // Instanciando os labels dos TextField
        codigoBarrasLabel = new JLabel("CÓDIGO BARRAS:  ");
        clientesLabel = new JLabel("CLIENTES:    ");
        descontoLabel = new JLabel("DESCONTO APLICADO:  ");
        totalLabel = new JLabel("TOTAL:       ");
        quantidadeLabel = new JLabel("QUANTIDADE:   ");

        //Configurando os TextField
        codigoBarrasPanel.add(codigoBarrasLabel, BorderLayout.WEST);
        codigoBarrasPanel.add(codigoBarras, BorderLayout.CENTER);
        quantidadePanel.add(quantidadeLabel, BorderLayout.WEST);
        quantidadePanel.add(quantidade, BorderLayout.CENTER);
        clientesPanel.add(clientesLabel, BorderLayout.WEST);
        clientesPanel.add(cliente, BorderLayout.CENTER);
        descontoPanel.add(descontoLabel, BorderLayout.WEST);
        descontoPanel.add(descontoAplicado, BorderLayout.CENTER);
        totalPanel.add(totalLabel, BorderLayout.WEST);
        totalPanel.add(total, BorderLayout.CENTER);

        //Definindo uma cor para eles
        codigoBarrasPanel.setBackground(branca);
        quantidadePanel.setBackground(branca);
        clientesPanel.setBackground(branca);
        descontoPanel.setBackground(branca);
        totalPanel.setBackground(branca);

        // Instanciando os painéis e definindo os layout
        informacoesVenda = new JPanel();
        informacoesVenda.setLayout(new GridLayout(0,1,0,10));
        acoesInformacoesVenda = new JPanel();
        acoesInformacoesVenda.setLayout(new BorderLayout());
        painelFinalizarCompras = new JPanel();
        painelFinalizarCompras.setLayout(new FlowLayout(FlowLayout.CENTER));
        container = new JPanel();
        container.setLayout(new BorderLayout());

        // Definindo um tamanho para o container
        container.setPreferredSize(new Dimension(600, 500));

        // Instanciando os botões
        finalizarCompra = new JButton("FINALIZAR COMPRA");
        excluir = new JButton("EXCLUIR");

        //Definindo uma cor para eles
        finalizarCompra.setBackground(verdeClaro);
        excluir.setBackground(vermelhoClaro);

        //Definindo uma borda para eles
        finalizarCompra.setBorder(BorderFactory.createLineBorder(verdeCreme));
        finalizarCompra.setPreferredSize(new Dimension(200,60));

        // Adicionando os TextField ao painel informacoesVenda
        informacoesVenda.add(codigoBarrasPanel);
        informacoesVenda.add(clientesPanel);
        informacoesVenda.add(quantidadePanel);
        informacoesVenda.add(descontoPanel);
        informacoesVenda.add(totalPanel);
        informacoesVenda.add(painelFinalizarCompras);

        // Adicionando o botão finalizarCompra ao seu painel

        painelFinalizarCompras.add(finalizarCompra);

        // Definindo um tamanho para eles
        informacoesVenda.setPreferredSize(new Dimension(300, 400));

        // Adicionando ao painel acoesInformacoesVenda
        acoesInformacoesVenda.add(excluir, BorderLayout.NORTH);
        acoesInformacoesVenda.add(listCompras, BorderLayout.CENTER);

        finalizarCompra.addActionListener(e -> controll.realizarCompra());

        // Adicionando ao painel principal usando um container
        container.add(informacoesVenda, BorderLayout.WEST);
        container.add(acoesInformacoesVenda, BorderLayout.CENTER);
        this.add(container);
    }

    public JButton getFinalizarCompraButton() {
        return finalizarCompra;
    }

    public JTextField getCodigoBarrasTextField() {
        return codigoBarras;
    }

    public JTextField getClienteTextField() {
        return cliente;
    }

    public JTextField getQuantidadeTextField() {
        return quantidade;
    }

    public JTextField getDescontoAplicadoTextField() {
        return descontoAplicado;
    }

    public JTextField getTotalTextField() {
        return total;
    }

    
}
