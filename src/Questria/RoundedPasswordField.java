package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPasswordField extends JPasswordField {
    private final int cornerRadius;
    private Color borderColor;

    // simple constructor: uses default background + border
    public RoundedPasswordField(int cornerRadius) {
        this(cornerRadius, new Color(0xE6E6E6), new Color(0xB4B4B4));
    }

    // full constructor: allows specifying background and border color
    public RoundedPasswordField(int cornerRadius, Color backgroundColor, Color borderColor) {
        super();
        this.cornerRadius = Math.max(0, cornerRadius);
        this.borderColor = borderColor == null ? backgroundColor.darker() : borderColor;
        setOpaque(false); // we paint the rounded background ourselves
        setBackground(backgroundColor);
        setForeground(Color.BLACK);
        setCaretColor(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10)); // internal padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth();
            int h = getHeight();

            // Fill rounded background with current background color (so setBackground works)
            g2.setColor(getBackground());
            Shape bg = new RoundRectangle2D.Double(0, 0, w - 1, h - 1, cornerRadius, cornerRadius);
            g2.fill(bg);

            // Draw border
            if (borderColor != null) {
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(1f));
                g2.draw(bg);
            }
        } finally {
            g2.dispose();
        }

        // Paint the text/caret on top
        super.paintComponent(g);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    // optional setter for border color if you want to change it later
    public void setBorderColor(Color c) {
        this.borderColor = c;
        repaint();
    }
}
