package View;

import java.awt.Color;

import javax.swing.JPanel;

public class JanelaProdutos extends JPanel {
    private Color verdeClaro = new Color(49, 201, 94);

    public JanelaProdutos() {
        this.setBounds(100, 120, 1200, 900);
        this.setBackground(verdeClaro);
    }
}
