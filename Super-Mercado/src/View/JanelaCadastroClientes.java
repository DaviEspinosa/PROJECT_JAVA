package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
// import javax.swing.table.DefaultTableModel;

import Model.Clientes;

public class JanelaCadastroClientes extends JPanel{
//cores//
private Color black = new Color(00,00,00);
private Color letteColor = new Color(00,00,00);

private List<Clientes> cliente;
private JTable table;
// private DefaultTableModel tableModel;
private int linhaSelecionada = -1;

public JanelaCadastroClientes() {

//Paineis invisiveis (dar espaçamento)
JPanel painelVazioNorte = new JPanel();    
JPanel painelVazioOeste = new JPanel();    
JPanel painelVazioLeste = new JPanel();    
JPanel painelVazioSul   = new JPanel();    
//painel principal
JPanel panelPrincipal = new JPanel();

this.add(panelPrincipal, BorderLayout.CENTER);
this.add(painelVazioNorte, BorderLayout.NORTH);
this.add(painelVazioOeste, BorderLayout.WEST);
this.add(painelVazioLeste, BorderLayout.EAST);
this.add(painelVazioSul, BorderLayout.EAST);


}

}