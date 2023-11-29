package View;

import javax.swing.JPanel;
import java.awt.Color;

public class JanelaFechamentoCaixa extends JPanel{
    private Color cinza = new Color(128, 128, 128);
    
    public JanelaFechamentoCaixa() {
        this.setBounds(100, 120, 1200, 900);
        this.setBackground(cinza); 
    }
}
