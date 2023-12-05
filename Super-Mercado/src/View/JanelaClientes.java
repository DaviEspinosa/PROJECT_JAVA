package View;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class JanelaClientes extends JPanel {

  private Color verdeClaro = new Color(49, 201, 94);

    //Construtor
    public JanelaClientes() {
      this.setBounds(100, 120, 1200, 900);
      this.setBackground(verdeClaro);
    }
}
