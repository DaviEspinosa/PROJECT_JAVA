package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.JanelaVendas;
import DAO.VendasDAO;

public class JanelaVendasControll {

    private JanelaVendas view;// Referência
    private VendasDAO vendasDAO;

    public JanelaVendasControll(JanelaVendas view, VendasDAO vendasDAO) {
        this.view = view;
        this.vendasDAO = vendasDAO;
        // Lógica para o botão finalizar Compra

        view.getFinalizarCompraButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCompra();
            }
        });
    }

    public void realizarCompra() {
        String codigoBarras = view.getCodigoBarrasTextField().getText();
        String cliente = view.getClienteTextField().getText();
        String quantidade = view.getQuantidadeTextField().getText();
        String descontoAplicado = view.getDescontoAplicadoTextField().getText();
        String total = view.getTotalTextField().getText();

        // Valide seus dados antes de chamar o método no DAO
        if (codigoBarras.isEmpty() || cliente.isEmpty() || quantidade.isEmpty() || descontoAplicado.isEmpty()
                || total.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos antes de finalizar a compra.",
                    "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Chamando o método realizarVenda
        vendasDAO.realizarVenda(codigoBarras, cliente, quantidade, descontoAplicado, total);

        //Limpa os campos 
        limparCampos();
    }

    private void limparCampos() {
        view.getCodigoBarrasTextField().setText("");
        view.getClienteTextField().setText("");
        view.getQuantidadeTextField().setText("");
        view.getDescontoAplicadoTextField().setText("");
        view.getTotalTextField().setText("");
    }
}
