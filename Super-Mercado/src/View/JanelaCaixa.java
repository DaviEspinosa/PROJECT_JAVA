package View;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

/**
 * JanelaCaixa
 */
import javax.swing.JTextField;

public class JanelaCaixa extends JPanel {
    private Color cinza = new Color(128, 128, 128);
    private JPanel informacoesVenda;// Total, compras, desconto aplicado, quantidade;
    private JTextField codigoBarras;
    private JTextField cliente;
    private JTextField descontoAplicado;
    private JTextField total;
    private JButton finalizarCompra, excluir;

    public JanelaCaixa() {
        // Cor de fundo da janela
        this.setBackground(cinza);

        // Instanciando os TextField
        codigoBarras = new JTextField(20);

        // Instanciando os painéis
        informacoesVenda = new JPanel();
        informacoesVenda.setLayout(new BorderLayout());
        informacoesVenda.add(codigoBarras, BorderLayout.EAST);

        // Adicionando eles há janela
        add(informacoesVenda);
    }
}