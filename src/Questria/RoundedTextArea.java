package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextArea extends JTextArea {
    private final int arc;

    /** Create with default rows/cols and a corner arc radius in pixels. */
    public RoundedTextArea(int arc) {
        super();
        this.arc = arc;
        init();
    }

    /** Create with rows, cols and a corner arc radius in pixels. */
    public RoundedTextArea(int rows, int cols, int arc) {
        super(rows, cols);
        this.arc = arc;
        init();
    }

    private void init() {
        setOpaque(false); // we paint our own background
        setLineWrap(true);
        setWrapStyleWord(true);
        // padding inside the rounded area
        setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();

        // smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // background (fill)
        Shape round = new RoundRectangle2D.Float(0, 0, width, height, arc, arc);
        g2.setColor(getBackground());
        g2.fill(round);

        // clip to rounded area so caret/selection is confined
        g2.clip(round);

        // move to super to paint caret, selection and text inside clipped area
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // optional: draw a subtle border around the rounded rect
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0xCCCCCC)); // border color
        g2.setStroke(new BasicStroke(1f));
        g2.draw(new RoundRectangle2D.Float(0.5f, 0.5f, getWidth()-1f, getHeight()-1f, arc, arc));
        g2.dispose();
    }
}
