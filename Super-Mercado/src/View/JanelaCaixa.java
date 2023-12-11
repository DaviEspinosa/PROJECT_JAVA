package View;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class JanelaCaixa extends JPanel {
    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(199, 59, 59);
    private JPanel informacoesVenda; // Total, compras, desconto aplicado, quantidade;
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

    public JanelaCaixa() {
        // Cor de fundo da janela
        this.setBackground(verdeClaro);
        this.setSize(600, 400);

        // Instanciando os TextField
        codigoBarras = new JTextField(30);
        quantidade = new JTextField(30);
        cliente = new JTextField(30);
        descontoAplicado = new JTextField(30);
        total = new JTextField(30);


        // Instanciando os paineis dos TextField
        codigoBarrasPanel = new JPanel(new BorderLayout());
        clientesPanel = new JPanel(new BorderLayout());
        descontoPanel = new JPanel(new BorderLayout());
        totalPanel = new JPanel(new BorderLayout());
        quantidadePanel = new JPanel(new BorderLayout());

        // Instanciando os labels dos TextField
        codigoBarrasLabel = new JLabel("CÓDIGO BARRAS");
        clientesLabel = new JLabel("CLIENTES");
        descontoLabel = new JLabel("DESCONTO APLICADO");
        totalLabel = new JLabel("TOTAL");
        quantidadeLabel = new JLabel("QUANTIDADE");


        // Instanciando os painéis e definindo os layout
        informacoesVenda = new JPanel();
        informacoesVenda.setLayout(new BoxLayout(informacoesVenda, BoxLayout.Y_AXIS));
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

        // Definindo uma cor para eles
        //Definindo uma cor para eles
        finalizarCompra.setBackground(verdeClaro);
        excluir.setBackground(vermelhoClaro);

        // Adicionando os TextField ao painel informacoesVenda
        informacoesVenda.add(codigoBarras);
        informacoesVenda.add(cliente);
        informacoesVenda.add(descontoAplicado);
        informacoesVenda.add(total);
        informacoesVenda.add(quantidade);
        informacoesVenda.add(painelFinalizarCompras);

        // Adicionando o botão finalizarCompra ao seu painel

        painelFinalizarCompras.add(finalizarCompra);

        // Definindo um tamanho para eles
        informacoesVenda.setPreferredSize(new Dimension(300, 400));

        // Adicionando ao painel acoesInformacoesVenda
        acoesInformacoesVenda.add(excluir, BorderLayout.NORTH);

        // Adicionando ao painel principal usando um container
        container.add(informacoesVenda, BorderLayout.WEST);
        container.add(acoesInformacoesVenda, BorderLayout.CENTER);
        this.add(container);
    }
}
