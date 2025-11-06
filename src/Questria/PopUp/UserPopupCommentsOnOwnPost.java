package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicPopupMenuUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class UserPopupCommentsOnOwnPost {

    // compact rounded card
    private static final int   ARC       = 16;
    private static final Color CARD_BG   = new Color(0xCCDBFD);
    private static final Color HOVER_BG  = new Color(0xE9EEF7);
    private static final int   ICON_SIZE = 20;

    private static final Font FRAUNCES_15B = loadFraunces(Font.BOLD, 15f);

    /** Report + Delete (stacked vertically), rounded, no white rectangle halo. */
    public static JPopupMenu build(Runnable onReport, Runnable onDelete) {
        RoundedPopupMenu popup = new RoundedPopupMenu(CARD_BG, ARC);

        // vertical stack container
        Box column = Box.createVerticalBox();
        column.setOpaque(false);
        column.setBorder(new EmptyBorder(10, 12, 10, 12));

        JButton reportBtn = pill("Report", loadIconSmart("reports.png", "report", "flag.png"));
        reportBtn.addActionListener(e -> { if (onReport != null) onReport.run(); });
        reportBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton deleteBtn = pill("Delete", loadIconSmart("delete.png", "trash.png", "bin.png"));
        deleteBtn.addActionListener(e -> { if (onDelete != null) onDelete.run(); });
        deleteBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        column.add(reportBtn);
        column.add(Box.createVerticalStrut(8));
        column.add(deleteBtn);

        popup.add(column);
        return popup;
    }

    // ---- UI helpers ----

    private static JButton pill(String text, Icon icon) {
        return new JButton(text, icon) {
            {
                setFont(FRAUNCES_15B);
                setForeground(Color.BLACK);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
                setOpaque(false);
                setIconTextGap(8);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setPreferredSize(new Dimension(130, 34));
                setMaximumSize(new Dimension(150, 34)); // keeps width consistent when centered
            }
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isRollover() || getModel().isPressed()) {
                    g2.setColor(HOVER_BG);
                    g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };
    }

    /** Rounded transparent popup; no white rectangle. */
    static class RoundedPopupMenu extends JPopupMenu {
        private final Color bg;
        private final int arc;

        RoundedPopupMenu(Color bg, int arc) {
            this.bg = bg;
            this.arc = arc;

            setOpaque(false);
            setBackground(new Color(0,0,0,0));
            setBorder(new EmptyBorder(0, 0, 0, 0));
            setBorderPainted(false);
            setLightWeightPopupEnabled(true);

            setUI(new BasicPopupMenuUI() {
                @Override public void installDefaults() {
                    super.installDefaults();
                    popupMenu.setOpaque(false);
                }
            });
        }

        @Override public Insets getInsets() { return new Insets(0,0,0,0); }
        @Override public boolean isOpaque() { return false; }

        @Override public void addNotify() {
            super.addNotify();
            Window w = SwingUtilities.getWindowAncestor(this);
            if (w != null) {
                w.setBackground(new Color(0,0,0,0));
                if (w instanceof JWindow jw) {
                    jw.getContentPane().setBackground(new Color(0,0,0,0));
                    if (jw.getContentPane() instanceof JComponent jc) jc.setOpaque(false);
                }
            }
            if (getParent() instanceof JComponent p) p.setOpaque(false);
        }

        @Override public void setVisible(boolean b) {
            if (b) {
                SwingUtilities.invokeLater(() -> {
                    Window w = SwingUtilities.getWindowAncestor(this);
                    if (w != null) w.setBackground(new Color(0,0,0,0));
                });
            }
            super.setVisible(b);
        }

        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();
            Shape clip = new RoundRectangle2D.Double(0, 0, w, h, arc, arc);

            g2.setColor(bg);
            g2.fill(clip);

            g2.setClip(clip);
            super.paintChildren(g2);

            g2.dispose();
        }

        @Override protected void paintChildren(Graphics g) {
            // children are painted in paintComponent with clipping; skip default
        }

        @Override protected void paintBorder(Graphics g) {
            // no border
        }
    }

    // ---- assets & fonts ----

    private static Font loadFraunces(int style, float size) {
        try (var in = UserPopupCommentsOnOwnPost.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf")) {
            if (in != null) {
                Font base = Font.createFont(Font.TRUETYPE_FONT, in);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(base);
                return base.deriveFont(style, size);
            }
        } catch (Exception ignored) {}
        Font f = new Font("Fraunces 72pt", style, (int) size);
        if (!"Fraunces 72pt".equals(f.getFamily())) f = new Font("Serif", style, (int) size);
        return f.deriveFont(size);
    }

    private static Icon loadIconSmart(String... names) {
        for (String n : names) {
            // classpath
            URL u1 = UserPopupCommentsOnOwnPost.class.getResource("/assets/" + n);
            if (u1 != null) {
                ImageIcon ii = new ImageIcon(u1);
                if (ii.getIconWidth() > 0 && ii.getIconHeight() > 0)
                    return scale(ii, ICON_SIZE, ICON_SIZE);
            }
            // filesystem
            File f1 = new File("assets", n);
            if (f1.exists()) {
                ImageIcon ii = new ImageIcon(f1.getAbsolutePath());
                if (ii.getIconWidth() > 0 && ii.getIconHeight() > 0)
                    return scale(ii, ICON_SIZE, ICON_SIZE);
            }
        }
        // safe placeholder
        return new Icon() {
            public int getIconWidth()  { return ICON_SIZE; }
            public int getIconHeight() { return ICON_SIZE; }
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.GRAY);
                g2.drawRoundRect(x+2, y+2, ICON_SIZE-4, ICON_SIZE-4, 8, 8);
                g2.dispose();
            }
        };
    }

    private static Icon scale(ImageIcon src, int w, int h) {
        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = out.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(src.getImage(), 0, 0, w, h, null);
        g2.dispose();
        return new ImageIcon(out);
    }
}
