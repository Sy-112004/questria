package Questria;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedTextPane extends JTextPane {
    private final int arc;
    private Color borderColor = new Color(0xCCCCCC); // light gray
    private Color backgroundColor = Color.WHITE;

    public RoundedTextPane() { this(20); }
    public RoundedTextPane(int arc) {
        this.arc = arc;
        setOpaque(false);
        setBorder(new EmptyBorder(8, 10, 8, 10)); // inner padding so text doesn’t touch the border
    }

    public void setBorderColor(Color c) { this.borderColor = c; repaint(); }
    public void setBackgroundColor(Color c) { this.backgroundColor = c; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // fill background
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);

            // draw border
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);
        } finally {
            g.dispose();
        }
        super.paintComponent(g); // draw the text after background
    }
}
