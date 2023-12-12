package Controller;

import java.awt.List;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

import DAO.ClientesVipDAO;
import Model.Clientes;

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
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
        return textField;
    }

    // Cadastrar clientes
    public void cadastrarCliente(String cpf, String telefone, String email, String endereco) {
        new ClientesVipDAO().cadastrarClientes(cpf, telefone, email, endereco);
    }

    // Apagar clientes
    public void apagarCliente(String cpf) {
        new ClientesVipDAO().apagarCliente(cpf);
    }

    //Atualizar dados do cliente
    public void atualizarClientes(String cpf, String telefone, String email, String endereco){
        new ClientesVipDAO().atualizarClientes(cpf, telefone, email, endereco);
    }

    //Listar clientes
    public void listarTodosClientes(){
        ClientesVipDAO clientesVipDAO = new ClientesVipDAO();
   
    }

    
}
