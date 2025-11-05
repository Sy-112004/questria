package Questria;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedComboBox<E> extends JComboBox<E> {
    private final int arc;                 // corner radius
    private Color borderColor = new Color(0xC1C1C1); // default border
    private int borderWidth = 1;

    // NEW: optional fixed width to prevent layout from expanding the combo when popup opens
    private Integer fixedWidth = null;

    public RoundedComboBox(int arc) {
        super();
        this.arc = arc;
        setOpaque(false);                   // we paint our own background
        setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        // Install custom UI so arrow button is styled
        setUI(new RoundedComboBoxUI());
    }

    public void setBorderColor(Color c) { this.borderColor = c; repaint(); }
    public void setBorderWidth(int w) { this.borderWidth = w; repaint(); }

    /** Set a fixed width (pixels). If null, natural width is used. */
    public void setFixedWidth(Integer width) {
        this.fixedWidth = width;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            // fill rounded background using current background color
            g2.setColor(getBackground());
            RoundRectangle2D bg = new RoundRectangle2D.Double(0, 0, w - 1, h - 1, arc, arc);
            g2.fill(bg);

            // border
            if (borderColor != null && borderWidth > 0) {
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(borderWidth));
                g2.draw(bg);
            }
        } finally {
            g2.dispose();
        }

        // Let JComboBox paint the renderer text/icon on top.
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.height = Math.max(d.height, arc + 10);

        if (fixedWidth != null) {
            d.width = fixedWidth;
        }
        return d;
    }

    /** Prevent layout managers from expanding the combo beyond preferred width. */
    @Override
    public Dimension getMaximumSize() {
        Dimension pref = getPreferredSize();
        Dimension max = super.getMaximumSize();
        // keep preferred height but allow default max height
        return new Dimension(pref.width, max.height);
    }

    private class RoundedComboBoxUI extends BasicComboBoxUI {
        @Override
        protected void installDefaults() {
            super.installDefaults();
            // don't let BasicComboBoxUI paint a background rectangle
            comboBox.setOpaque(false);
            if (listBox != null) {
                listBox.setOpaque(true);
            }
        }

        @Override
        protected JButton createArrowButton() {
            JButton b = new JButton("\u25BE"); // small down-triangle
            b.setFocusable(false);
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorder(BorderFactory.createEmptyBorder());
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            // tweak size to fit nicely; fall back if preferred size is not ready
            int h = comboBox.getPreferredSize().height;
            if (h <= 0) h = 36;
            b.setPreferredSize(new Dimension(36, h));
            return b;
        }

        // Prevent BasicComboBoxUI from drawing its own current value background
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            // intentionally empty - we paint background in combo's paintComponent
        }

        // Ensure list properties are set when the popup is actually created
        @Override
        protected ComboPopup createPopup() {
            BasicComboPopup popup = (BasicComboPopup) super.createPopup();
            JList<?> list = popup.getList();
            if (list != null) {
                list.setOpaque(true);
            }
            return popup;
        }
    }
}
