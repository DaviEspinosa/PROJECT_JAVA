package View;

import Controller.JanelaPrincipalControll;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame{
    
    private JTabbedPane JTPane;

    public JanelaPrincipal() {
        JTPane = new JTabbedPane();
        JTPane.setUI(new JanelaPrincipalControll());
        add(JTPane);

        //Adicionando as tabs

        //Janela Caixa
        JanelaCaixa tab1 = new JanelaCaixa();
        JTPane.add("CAIXA", tab1);

        //Janela Produto(estoque)
        JanelaProdutos tab2 = new JanelaProdutos();
        JTPane.add("ESTOQUE", tab2);

        //Janela Cadastrar Produtos(estoque)
        JanelaCadastrarProdutos tab3 = new JanelaCadastrarProdutos();
        JTPane.add("CADASTRAR PRODUTOS", tab3);

        //Janela Clientes
        JanelaClientes tab4 = new  JanelaClientes();
        JTPane.add("CLIENTES", tab4);

        //Janela Cadastrar Clientes
        JanelaCadastrarClientes tab5 = new JanelaCadastrarClientes();
        JTPane.add("CADASTRAR CLIENTES", tab5);

        //Janela Fechamento de Caixa
        JanelaFechamentoCaixa tab6 = new JanelaFechamentoCaixa();
        JTPane.add("FECHAR CAIXA", tab6);

        //Tamanho da janela
        setBounds(100, 100, 1200, 900);
    }
    public void run(){
        this.setVisible(true);
    }
}
