package Controller;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class ClientesVipControll {

    // PlaceHolder
   public JTextField createTextFieldWithPlaceholder(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
        return textField;
    }
}
