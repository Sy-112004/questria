package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {
    private final int cornerRadius;
    private Color bgColor;
    private Color fgColor;
    private Color borderColor;
    private boolean hovered = false;
    private boolean pressed = false;

    public RoundedButton(String text, int cornerRadius, Color bgColor, Color fgColor) {
        super(text);
        this.cornerRadius = Math.max(0, cornerRadius);
        this.bgColor = bgColor == null ? getBackground() : bgColor;
        this.fgColor = fgColor == null ? getForeground() : fgColor;
        this.borderColor = bgColor.darker();

        setContentAreaFilled(false); // we paint our own background
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(this.fgColor);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(getFont().deriveFont(Font.BOLD, 16f));
        setMargin(new Insets(8, 20, 8, 20));
        setPreferredSize(new Dimension(160, 40));

        // simple hover/press visual feedback
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
                pressed = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
            }
        });
    }

    public void setBackgroundColor(Color c) {
        this.bgColor = c;
        this.borderColor = (c == null) ? null : c.darker();
        setForeground(contrastColor(c));
        repaint();
    }

    private Color contrastColor(Color c) {
        if (c == null) return Color.WHITE;
        double y = (299*c.getRed() + 587*c.getGreen() + 114*c.getBlue()) / 1000.0;
        return y >= 128 ? Color.BLACK : Color.WHITE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            // choose fill color according to state
            Color fill = bgColor;
            if (pressed) {
                // slightly darker when pressed
                fill = bgColor.darker();
            } else if (hovered) {
                // slightly brighter on hover
                fill = brighter(bgColor, 0.06f);
            }

            // background
            g2.setColor(fill);
            RoundRectangle2D bg = new RoundRectangle2D.Double(0, 0, w - 1, h - 1, cornerRadius, cornerRadius);
            g2.fill(bg);

            // optional border stroke
            if (borderColor != null) {
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(1.5f));
                g2.draw(bg);
            }

            // paint the label (text)
            super.paintComponent(g);
        } finally {
            g2.dispose();
        }
    }

    @Override
    public void paintBorder(Graphics g) {
        // no default border — we draw border in paintComponent
    }

    private Color brighter(Color c, float factor) {
        int r = Math.min(255, (int)(c.getRed() + 255 * factor));
        int g = Math.min(255, (int)(c.getGreen() + 255 * factor));
        int b = Math.min(255, (int)(c.getBlue() + 255 * factor));
        return new Color(r, g, b, c.getAlpha());
    }
}
