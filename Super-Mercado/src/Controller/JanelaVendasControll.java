package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.JanelaVendas;
import DAO.VendasDAO;

public class JanelaVendasControll {

    private JanelaVendas view;// Referência
    private VendasDAO vendasDAO;
    private DefaultListModel<String> listaCompraModel;

    public JanelaVendasControll(JanelaVendas view, VendasDAO vendasDAO, DefaultListModel<String> listaCompraModel) {
        this.view = view;
        this.vendasDAO = vendasDAO;
        this.listaCompraModel = listaCompraModel;

        // Lógica para o botão finalizar Compra
        JButton finalizarCompraButton = view.getFinalizarCompraButton();

        // Verifica se o botão foi inicializado corretamente
        if (finalizarCompraButton != null) {
            finalizarCompraButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    realizarCompra();
                }
            });
        } else {
            System.err.println("O botão finalizarCompra não foi inicializado corretamente.");
        }
    }

    public void realizarCompra() {
        JButton finalizarCompraButton = view.getFinalizarCompraButton();
        String codigoBarras = view.getCodigoBarrasTextField().getText();
        String cliente = view.getClienteTextField().getText();
        String quantidade = view.getQuantidadeTextField().getText();
        String descontoAplicado = view.getDescontoAplicadoTextField().getText();
        String total = view.getTotalTextField().getText();

        //Validando
        if (codigoBarras.isEmpty() || cliente.isEmpty() || quantidade.isEmpty() || descontoAplicado.isEmpty()
                || total.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos antes de finalizar a compra.",
                    "Campos Vazios", JOptionPane.WARNING_MESSAGE);
            return;
        }
        calcularTotal();

        // Chamando o método realizarVenda
        vendasDAO.realizarVenda(codigoBarras, cliente, quantidade, descontoAplicado, total);

        // Limpa os campos
        limparCampos();
    }

    private void calcularTotal() {
        // double precoUnitario = obterPrecoDoBancoDeDados(codigoBarras.getText());
        // int quantidade = Integer.parseInt(this.quantidade.getText());
        // double desconto = Double.parseDouble(descontoAplicado.getText());
        // double totalCalculado = calcularTotal(precoUnitario, quantidade, desconto);
        // total.setText(String.valueOf(totalCalculado));
    }

    private void adicionarLista() {
        if (!view.getCodigoBarrasTextField().getText().isEmpty() && !view.getQuantidadeTextField().getText().isEmpty()
                && !view.getClienteTextField().getText().isEmpty()) {

            String codigoBarras = view.getCodigoBarrasTextField().getText();
            double preco = obterPreco(codigoBarras);

            // Monta a string do item da lista
            String itemLista = String.format("%s - %s - %s", view.getCodigoBarrasTextField().getText(),
                    view.getQuantidadeTextField().getText(), preco);

            listaCompraModel.addElement(itemLista);

            double totalAtual = Double.parseDouble(view.getTotalTextField().getText());
            double novoTotal = totalAtual + preco;
                    view.getTotalTextField().setText(String.valueOf(novoTotal));
            limparCampos();
        }
    }

    private double obterPreco(String codigoBarras) {
        double preco = new VendasDAO().obterPrecoPorCodigoDeBarras(codigoBarras);

        return preco;
    }

    private void limparCampos() {
        view.getCodigoBarrasTextField().setText("");
        view.getClienteTextField().setText("");
        view.getQuantidadeTextField().setText("");
        view.getDescontoAplicadoTextField().setText("");
        view.getTotalTextField().setText("");
    }

}
