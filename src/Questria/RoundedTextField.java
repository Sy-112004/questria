package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {
    private final int cornerRadius;

    public RoundedTextField(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false); // we paint the background ourselves
        setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        setForeground(Color.BLACK);
        setCaretColor(Color.BLACK);
        // DO NOT call setBackground(...) here with a fixed color
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();
            RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, w - 1, h - 1, cornerRadius, cornerRadius);

            // Use the current background value (whatever you set from outside)
            Color bg = getBackground();
            if (bg == null) bg = new Color(0xDEE8FE); // fallback
            g2.setColor(bg);
            g2.fill(rounded);

            // border (example medium gray)
            g2.setColor(new Color(180, 180, 180));
            g2.setStroke(new BasicStroke(1.5f));
            g2.draw(rounded);
        } finally {
            g2.dispose();
        }

        super.paintComponent(g); // paint text and caret on top
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
