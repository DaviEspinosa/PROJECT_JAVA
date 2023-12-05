package View;

import javax.swing.JLabel;
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
    private JTextField lucro;
    private JTextField quantiaCaixa;
    private JTextField horario;
    private JTextField dia;
    private JLabel locroJLabel;
    private JLabel quantiaCaixLabel;
    private JLabel horarioJLabel;
    private JLabel diLabel;
    private JPanel invisivel;
    private JPanel titulo;
    private JButton salvar, cancelar;
    private JPanel fechamentoCaixa;
    private JPanel acoesFechamentoCaixa;
    private JPanel container;
    private Color transparente = new Color(0, 0, 0, 0);
    private Color branca = new Color(255, 255, 255);
    private Color verdeClaro = new Color(49, 201, 94);
    private Color vermelhoClaro = new Color(250, 215, 215);

    public JanelaFechamentoCaixa() {
        this.setBackground(verdeClaro);
        invisivel = new JPanel();
        invisivel.setLayout(new BorderLayout());
        invisivel.setBackground(transparente);
        invisivel.setPreferredSize(new Dimension(1400, 100));
        this.add(invisivel, BorderLayout.NORTH);

        // Configurando as Fonts
        Font fontLabel = new Font("Arial", Font.BOLD, 18);
        Font fontTextField = new Font("Arial", Font.BOLD, 15);

        // Instanciando os TextField
        lucro = new JTextField(60);
        quantiaCaixa = new JTextField(60);
        horario = new JTextField(60);
        dia = new JTextField(60);

        // Dando uma font para os TextField
        lucro.setFont(fontTextField);
        quantiaCaixa.setFont(fontTextField);
        horario.setFont(fontTextField);
        dia.setFont(fontTextField);

        // Dando um tamaho para eles
        lucro.setPreferredSize(new Dimension(400, 100));
        quantiaCaixa.setPreferredSize(new Dimension(400, 100));
        horario.setPreferredSize(new Dimension(400, 100));
        dia.setPreferredSize(new Dimension(400, 100));

        // Instanciando os JLabels
        locroJLabel = new JLabel("Lucro");
        quantiaCaixLabel = new JLabel("No Caixa");
        horarioJLabel = new JLabel("Horário");
        diLabel = new JLabel("Dia");

        // Dando uma font para oa Labels
        locroJLabel.setFont(fontLabel);
        quantiaCaixLabel.setFont(fontLabel);
        horarioJLabel.setFont(fontLabel);
        diLabel.setFont(fontLabel);

        // Instanciando os JButton
        salvar = new JButton("Salvar");
        cancelar = new JButton("Cancelar");

        // Dando uma cor para os JButton
        salvar.setBackground(verdeClaro);
        cancelar.setBackground(vermelhoClaro);

        // Instanciando os painéis
        titulo = new JPanel();
        fechamentoCaixa = new JPanel();
        acoesFechamentoCaixa = new JPanel();
        container = new JPanel(new BorderLayout());
        invisivel = new JPanel();

        // Configurando o layout dos painéis
        fechamentoCaixa.setLayout(new GridLayout(8, 1, 10, 2));
        acoesFechamentoCaixa.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Dando uma cor aos painéis
        acoesFechamentoCaixa.setBackground(branca);

        // Adicionando os componentes ao painel fechamentoCaixa
        fechamentoCaixa.add(locroJLabel);
        fechamentoCaixa.add(lucro);
        fechamentoCaixa.add(quantiaCaixLabel);
        fechamentoCaixa.add(quantiaCaixa);
        fechamentoCaixa.add(horarioJLabel);
        fechamentoCaixa.add(horario);
        fechamentoCaixa.add(diLabel);
        fechamentoCaixa.add(dia);

        // Adicionando os JButton ao painel acoesFechamentoCaixa
        acoesFechamentoCaixa.add(salvar);
        acoesFechamentoCaixa.add(cancelar);

        // Adicionando ao painel principal usando um container
        container.setPreferredSize(new Dimension(900, 700));
        container.add(fechamentoCaixa, BorderLayout.WEST);
        container.add(acoesFechamentoCaixa, BorderLayout.EAST);
        add(container);
    }

}
