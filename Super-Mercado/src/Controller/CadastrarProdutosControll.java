package Controller;

import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.FocusEvent;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
import Connection.ConnectionFactory;
import DAO.CadastrarProdutosDAO;
import Model.Produtos;

public class CadastrarProdutosControll {

    private List<Produtos> produtoList;
    private JTable table;
    private DefaultTableModel tableModel;
    
    // PlaceHolder
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

    public void cadastrar(String nome, String preco, String quantidade, String codigoBarra){
        new CadastrarProdutosDAO().cadastrar(nome,preco,quantidade,codigoBarra);
    }
    

}
