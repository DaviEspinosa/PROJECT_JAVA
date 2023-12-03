package Controller;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class JanelaCadastrarProdutosControll {
    
    public JTextField createTextFieldWithPlaceholderProdutos(String placeholder){

        JTextField textFieldProdutos = new JTextField(placeholder);
        textFieldProdutos.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e){
                if (textFieldProdutos.getText().equals(placeholder)) {
                    textFieldProdutos.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (textFieldProdutos.getText().isEmpty()) {
                    textFieldProdutos.setText(placeholder);
                }
            }
        });
        return textFieldProdutos;
    }
    
}
