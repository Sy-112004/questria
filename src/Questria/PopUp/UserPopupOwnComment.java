package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class UserPopupOwnComment {

    private static final int   ARC       = 14;
    private static final Color CARD_BG   = new Color(0xCCDBFD);
    private static final Color HOVER_BG  = new Color(0xE9EEF7);
    private static final int   ICON_SIZE = 20;

    private static final Font FRAUNCES_15B = loadFraunces(Font.BOLD, 15f);

    /** Existing flexible builder (kept, in case you still need it). */
    public static JPopupMenu build(Runnable onEdit, Runnable onDelete) {
        RoundedPopupMenu popup = new RoundedPopupMenu(CARD_BG, ARC);

        JPanel body = new JPanel();
        body.setOpaque(false);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBorder(new EmptyBorder(6, 8, 6, 8));

        JButton editBtn   = pill("Edit",   loadIconSmart("edit.png", "pencil.png", "edit_pen.png"));
        JButton deleteBtn = pill("Delete", loadIconSmart("delete.png", "trash.png", "bin.png"));

        if (onEdit   != null) editBtn.addActionListener(e -> { popup.setVisible(false); onEdit.run(); });
        if (onDelete != null) deleteBtn.addActionListener(e -> { popup.setVisible(false); onDelete.run(); });

        body.add(editBtn);
        body.add(Box.createVerticalStrut(4));
        body.add(deleteBtn);

        popup.add(body);
        return popup;
    }

    /**
     * Convenience builder that:
     *  - Opens EditPostPage on “Edit”
     *  - Shows DeleteConfirmationDialog on “Delete”
     *  - You can plug your actual delete logic inside the confirmation callback
     */
    public static JPopupMenu buildForOwnComment(Component parentForDialogs) {
        return build(
                // EDIT → open EditPostPage
                () -> SwingUtilities.invokeLater(() -> {
                    try {
                        // Replace with your actual edit page class if different
                        Questria.EditPostPage page = new Questria.EditPostPage();
                        JFrame f = page.getEditPostPageFrame();
                        f.setVisible(true);
                    } catch (Throwable t) {
                        t.printStackTrace();
                        JOptionPane.showMessageDialog(parentForDialogs, "Unable to open Edit page.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }),

                // DELETE → show confirmation, then run your delete
                () -> DeleteConfirmationDialog.show(parentForDialogs, () -> {
                    // TODO: put your real delete logic here
                    System.out.println("Comment deleted!");
                })
        );
    }

    // ---- UI helpers ----

    private static JButton pill(String text, Icon icon) {
        return new JButton(text, icon) {

            private final int padL = 12, padR = 12, gap = 8, minH = 28;

            {
                setAlignmentX(Component.LEFT_ALIGNMENT);

                setFont(FRAUNCES_15B);
                setForeground(Color.BLACK);

                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
                setOpaque(false);

                setHorizontalAlignment(SwingConstants.LEFT);
                setHorizontalTextPosition(SwingConstants.RIGHT);
                setVerticalTextPosition(SwingConstants.CENTER);
                setIconTextGap(gap);

                setBorder(new EmptyBorder(0, padL, 0, padR));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isRollover() || getModel().isPressed()) {
                    g2.setColor(HOVER_BG);
                    g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 16, 16));
                }
                g2.dispose();
                super.paintComponent(g);
            }

            @Override
            public Dimension getPreferredSize() {
                FontMetrics fm = getFontMetrics(getFont());
                int textW = (getText() == null) ? 0 : fm.stringWidth(getText());
                int textH = fm.getHeight();

                int iconW = (getIcon() == null) ? 0 : getIcon().getIconWidth();
                int iconGap = (getIcon() == null || getText() == null || getText().isEmpty()) ? 0 : gap;

                int w = padL + iconW + iconGap + textW + padR;
                int h = Math.max(minH, textH + 10);
                return new Dimension(w, h);
            }

            @Override public Dimension getMaximumSize() { return getPreferredSize(); }
            @Override public Dimension getMinimumSize() { return getPreferredSize(); }
        };
    }

    /** Rounded transparent popup; children are clipped to the rounded shape (no white rectangle). */
    static class RoundedPopupMenu extends JPopupMenu {
        private final Color bg;
        private final int arc;

        RoundedPopupMenu(Color bg, int arc) {
            this.bg = bg;
            this.arc = arc;
            setOpaque(false);
            setBackground(new Color(0,0,0,0));
            setBorder(new EmptyBorder(2, 2, 2, 2));
            setBorderPainted(false);
            setLightWeightPopupEnabled(true);
        }

        @Override public boolean isOpaque() { return false; }

        @Override
        protected void paintComponent(Graphics g) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Shape clip = new RoundRectangle2D.Double(0, 0, w, h, arc, arc);
            g2.setColor(bg);
            g2.fill(clip);

            g2.setClip(clip);
            super.paintChildren(g2);
            g2.dispose();
        }

        @Override protected void paintChildren(Graphics g) { /* already painted with clip */ }
    }

    // ---- assets & fonts ----

    private static Font loadFraunces(int style, float size) {
        try (var in = UserPopupOwnComment.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf")) {
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
            URL u1 = UserPopupOwnComment.class.getResource("/assets/" + n);
            if (u1 != null) {
                ImageIcon ii = new ImageIcon(u1);
                if (ii.getIconWidth() > 0 && ii.getIconHeight() > 0)
                    return scale(ii, ICON_SIZE, ICON_SIZE);
            }
            File f1 = new File("assets", n);
            if (f1.exists()) {
                ImageIcon ii = new ImageIcon(f1.getAbsolutePath());
                if (ii.getIconWidth() > 0 && ii.getIconHeight() > 0)
                    return scale(ii, ICON_SIZE, ICON_SIZE);
            }
        }
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
