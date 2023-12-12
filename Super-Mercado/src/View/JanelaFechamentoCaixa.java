package View;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class JanelaFechamentoCaixa extends JPanel {
    private Color verdeClaro = new Color(49, 201, 94);
    private Color verdeCreme = new Color(68, 201, 82);
    private Color vermelhoClaro = new Color(199, 59, 59);
    private Color branca = new Color(255, 255, 255);
    private Color transparente = new Color(0, 0, 0, 0);
    private JTextField lucro;
    private JTextField quantiaCaixa;
    private JTextField horario;
    private JTextField dia;
    private JPanel invisivel;
    private JPanel lucroPanel;
    private JPanel quantiaCaixaPanel;
    private JPanel horarioPanel;
    private JPanel diaPanel;
    private JLabel lucroLabel;
    private JLabel quantiaCaixaLabel;
    private JLabel horarioLabel;
    private JLabel diaLabel;
    private JPanel fechamentoCaixa;
    private JPanel acoesFechamentoCaixa;
    private JPanel container;
    private JButton fecharCaixa, cancelar;

    //Construtor
    public JanelaFechamentoCaixa() {
        // Cor de fundo da janela
        this.setBackground(verdeClaro);
        this.setSize(600, 400);

        // Instanciando o painel invisivel para deixar o container no centro da tela
        invisivel = new JPanel();
        invisivel.setLayout(new BorderLayout());
        invisivel.setBackground(transparente);
        invisivel.setPreferredSize(new Dimension(1400, 150));
        this.add(invisivel, BorderLayout.NORTH);
        
        //Instanciando os painéis
        lucroPanel = new JPanel(new BorderLayout());
        quantiaCaixaPanel = new JPanel(new BorderLayout());
        horarioPanel = new JPanel(new BorderLayout());
        diaPanel = new JPanel(new BorderLayout());
        fechamentoCaixa = new JPanel();
        acoesFechamentoCaixa = new JPanel();
        invisivel = new JPanel();
        container = new JPanel(new BorderLayout());
        

        //Definindo seus tamanhos
        container.setPreferredSize(new Dimension(600, 500));

        //Definindo seus layouts
        fechamentoCaixa.setLayout(new GridLayout(0,1,0,20));
        
        //Instanciando os botões
        fecharCaixa = new JButton("FECHAR CAIXA");
        cancelar = new JButton("CANCELAR");

        //Definindo uma cor para os botões
        fecharCaixa.setBackground(verdeClaro);
        cancelar.setBackground(vermelhoClaro);

        //Instanciando os labels
        lucroLabel = new JLabel("LUCRO:   ");
        quantiaCaixaLabel = new JLabel("QUANTIA CAIXA:  ");
        horarioLabel = new JLabel("HORÁRIO:   ");
        diaLabel = new JLabel("DIA:     ");

        //Instanciando os TextField
        lucro = new JTextField(30);
        quantiaCaixa = new JTextField(30);
        horario = new JTextField(30);
        dia = new JTextField(30);

        //Definindo uma borda para os TextField
        lucro.setBorder(BorderFactory.createLineBorder(branca));
        quantiaCaixa.setBorder(BorderFactory.createLineBorder(branca));
        horario.setBorder(BorderFactory.createLineBorder(branca));
        dia.setBorder(BorderFactory.createLineBorder(branca));

        //Configurando TextField
        lucroPanel.add(lucroLabel, BorderLayout.WEST);
        lucroPanel.add(lucro, BorderLayout.CENTER);
        quantiaCaixaPanel.add(quantiaCaixaLabel, BorderLayout.WEST);
        quantiaCaixaPanel.add(quantiaCaixa, BorderLayout.CENTER);
        horarioPanel.add(horarioLabel, BorderLayout.WEST);
        horarioPanel.add(horario, BorderLayout.CENTER);
        diaPanel.add(diaLabel, BorderLayout.WEST);
        diaPanel.add(dia, BorderLayout.CENTER);

        //Definindo uma cor para os painéis
        lucroPanel.setBackground(branca);
        quantiaCaixaPanel.setBackground(branca);
        horarioPanel.setBackground(branca);
        diaPanel.setBackground(branca);

        //Adicionando ao painel fechamentoCaixa
        fechamentoCaixa.add(lucroPanel);
        fechamentoCaixa.add(quantiaCaixaPanel);
        fechamentoCaixa.add(horarioPanel);
        fechamentoCaixa.add(diaPanel);

        //Adicionando um tamanho para o painel fechamentoCaixa
        fechamentoCaixa.setPreferredSize(new Dimension(300, 400));

        //Adicionando os botões ao painel acoesFechamentoCaixa
        acoesFechamentoCaixa.add(fecharCaixa);
        acoesFechamentoCaixa.add(cancelar);

        //Adicionando usando um container
        container.add(fechamentoCaixa, BorderLayout.WEST);
        container.add(acoesFechamentoCaixa, BorderLayout.CENTER);
        this.add(container);
    }
    

}
