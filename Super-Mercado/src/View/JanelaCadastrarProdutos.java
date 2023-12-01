package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;;

public class JanelaCadastrarProdutos extends JPanel {

    private JTextField nomeProduto;
    private JTextField codigoBarra;
    private JTextField quantidade;
    private JTextField valor;
    private Color cinza = new Color(128, 128, 128);

    public JanelaCadastrarProdutos() {
        //Adicionando uma cor
        this.setBackground(cinza);

        //Instanciando os TextField
        nomeProduto = new JTextField();
    }
}
