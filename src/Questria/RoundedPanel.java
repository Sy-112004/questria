package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;
    private Color borderColor;
    private int borderThickness;
    private boolean drawShadow;
    private int shadowOffset;
    private Color shadowColor;

    public RoundedPanel(int radius, Color bgColor, Color borderColor, int borderThickness, boolean drawShadow) {
        super();
        this.cornerRadius = Math.max(0, radius);
        this.backgroundColor = bgColor == null ? getBackground() : bgColor;
        this.borderColor = borderColor == null ? new Color(0,0,0,0) : borderColor;
        this.borderThickness = Math.max(0, borderThickness);
        this.drawShadow = drawShadow;
        this.shadowOffset = drawShadow ? 6 : 0;
        this.shadowColor = new Color(0, 0, 0, 40);
        setOpaque(false);
        setBorder(null);
    }

    /** convenience constructor: radius + bg only */
    public RoundedPanel(int radius, Color bgColor) {
        this(radius, bgColor, null, 0, false);
    }

    // ---- setters for reuse / runtime changes ----
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color == null ? getBackground() : color;
        repaint();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color == null ? new Color(0,0,0,0) : color;
        repaint();
    }

    public void setBorderThickness(int thickness) {
        this.borderThickness = Math.max(0, thickness);
        repaint();
    }

    public void setShadowEnabled(boolean enabled) {
        this.drawShadow = enabled;
        this.shadowOffset = enabled ? 6 : 0;
        repaint();
    }

    public void setShadowColor(Color color) {
        this.shadowColor = color == null ? new Color(0,0,0,40) : color;
        repaint();
    }

    @Override
    public void setBackground(Color bg) {
        // override Swing's setBackground so calls like myPanel.setBackground(...) also update our paint color
        setBackgroundColor(bg);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth();
            int h = getHeight();

            // shadow
            if (drawShadow && shadowOffset > 0) {
                RoundRectangle2D shadowRect = new RoundRectangle2D.Double(
                        shadowOffset,
                        shadowOffset,
                        Math.max(0, w - shadowOffset - 1),
                        Math.max(0, h - shadowOffset - 1),
                        cornerRadius,
                        cornerRadius
                );
                g2.setColor(shadowColor);
                g2.fill(shadowRect);
            }

            // background
            RoundRectangle2D bgRect = new RoundRectangle2D.Double(
                    0,
                    0,
                    Math.max(0, w - shadowOffset - 1),
                    Math.max(0, h - shadowOffset - 1),
                    cornerRadius,
                    cornerRadius
            );
            g2.setColor(backgroundColor);
            g2.fill(bgRect);

            // border
            if (borderThickness > 0) {
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(borderThickness));
                double inset = borderThickness / 2.0;
                RoundRectangle2D borderRect = new RoundRectangle2D.Double(
                        inset,
                        inset,
                        Math.max(0, w - shadowOffset - borderThickness),
                        Math.max(0, h - shadowOffset - borderThickness),
                        cornerRadius,
                        cornerRadius
                );
                g2.draw(borderRect);
            }
        } finally {
            g2.dispose();
        }
        super.paintComponent(g);
    }

    @Override
    public boolean isOpaque() { return false; }
}
