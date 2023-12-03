package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class JanelaPrincipalControll extends BasicTabbedPaneUI {
    private Color azul = new Color(117, 190, 250);
    private static final int ARC_SIZE = 16;

    @Override
    protected void installDefaults() {
        super.installDefaults();
        tabAreaInsets.right = ARC_SIZE;
        selectedTabPadInsets = new Insets(0, 0, 0, ARC_SIZE);
        contentBorderInsets = new Insets(0, 0, 0, ARC_SIZE);
    }

    @Override
    protected void paintTabBackground(Graphics graphics, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelect) {
        Graphics2D graphics2d = (Graphics2D) graphics.create();

        // Preenchimento do fundo da aba selecionada
        if (isSelect) {
            graphics2d.setColor(azul);
            graphics2d.fillRoundRect(x, y, w, h, ARC_SIZE, ARC_SIZE);

            graphics2d.dispose();
        }
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        // Evita desenhar a borda padrão
}
}
