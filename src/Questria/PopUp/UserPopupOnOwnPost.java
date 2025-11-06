package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class UserPopupOnOwnPost {

    // Popup + button styling
    private static final int   ARC        = 14;
    private static final Color CARD_BG    = new Color(0xCCDBFD); // popup background
    private static final Color HOVER_BG   = new Color(0xE5EAF5); // hover gray
    private static final int   ICON_SIZE  = 22;

    private static final Font FRAUNCES_16B = loadFraunces(Font.BOLD, 16f);

    /** Rounded popup with three rounded pill-buttons (Edit / Delete / Lock), left-aligned, popup hugs content. */
    public static JPopupMenu build(Runnable onEdit, Runnable onDelete, Runnable onLock) {
        RoundedPopupMenu popup = new RoundedPopupMenu(CARD_BG, ARC);

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        // tiny padding so popup just fits the text
        content.setBorder(new EmptyBorder(6, 8, 6, 8));

        JButton editBtn   = pill("Edit",   loadIconSmart("edit.png", "pencil.png", "edit_pen.png"));
        JButton deleteBtn = pill("Delete", loadIconSmart("delete.png", "trash.png", "bin.png"));
        JButton lockBtn   = pill("Lock",   loadIconSmart("lock.png", "padlock.png"));

        if (onEdit   != null) editBtn.addActionListener(e -> onEdit.run());
        if (onDelete != null) deleteBtn.addActionListener(e -> DeleteConfirmationDialog.show(popup.getInvoker(), onDelete));
        if (onLock   != null) lockBtn.addActionListener(e -> LockConfirmationDialog.show(popup.getInvoker(), onLock));

        for (JButton b : new JButton[]{editBtn, deleteBtn, lockBtn}) {
            b.setAlignmentX(Component.LEFT_ALIGNMENT);           // left aligned text+icon
            b.setMaximumSize(b.getPreferredSize());              // let popup hug content
            content.add(b);
            content.add(Box.createVerticalStrut(4));             // small gap
        }
        // remove last gap
        content.remove(content.getComponentCount() - 1);

        popup.add(content);
        return popup;
    }

    // ---------- Pill button (rounded; default = same color as popup; hover = gray) ----------
    private static JButton pill(String text, Icon icon) {
        return new JButton(text, icon) {
            {
                setFont(FRAUNCES_16B);
                setForeground(Color.BLACK);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
                setOpaque(false);
                setHorizontalAlignment(SwingConstants.LEFT);
                setIconTextGap(8);
                // inner padding (keeps preferred size minimal)
                setBorder(new EmptyBorder(6, 10, 6, 10));
            }
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // default: same color as popup -> visually seamless
                g2.setColor(CARD_BG);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));

                // hover/press: gray highlight with rounded corner
                if (getModel().isRollover() || getModel().isPressed()) {
                    g2.setColor(HOVER_BG);
                    g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));
                }

                g2.dispose();
                super.paintComponent(g);
            }
        };
    }

    // ---------- Rounded, fully transparent popup (no white rectangle; hugs content) ----------
    static class RoundedPopupMenu extends JPopupMenu {
        private final Color bg;
        private final int arc;

        RoundedPopupMenu(Color bg, int arc) {
            this.bg = bg;
            this.arc = arc;
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));      // transparent container
            setBorder(new EmptyBorder(2, 2, 2, 2));    // tiny outer padding
            setBorderPainted(false);
            setLightWeightPopupEnabled(true);          // avoid heavyweight window halos
        }

        @Override public boolean isOpaque() { return false; }

        @Override protected void paintComponent(Graphics g) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // draw only the rounded card (no shadow -> no rectangular halo)
            Shape card = new RoundRectangle2D.Double(0, 0, w, h, arc, arc);
            g2.setColor(bg);
            g2.fill(card);

            // clip children inside rounded shape and paint them
            g2.setClip(card);
            super.paintChildren(g2);

            g2.dispose();
        }

        // children are painted with clipping above
        @Override protected void paintChildren(Graphics g) { /* no-op */ }
    }

    // ---------- Fonts ----------
    private static Font loadFraunces(int style, float size) {
        try (var in = UserPopupOnOwnPost.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf")) {
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

    // ---------- Safe icon loading & scaling ----------
    private static Icon loadIconSmart(String... candidateNames) {
        for (String name : candidateNames) {
            // classpath: /assets/name
            URL url = UserPopupOnOwnPost.class.getResource("/assets/" + name);
            if (url != null) {
                ImageIcon icon = new ImageIcon(url);
                if (icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
                    return scaleIcon(icon, ICON_SIZE, ICON_SIZE);
                }
            }
            // filesystem: ./assets/name
            File f = new File("assets", name);
            if (f.exists()) {
                ImageIcon icon = new ImageIcon(f.getAbsolutePath());
                if (icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
                    return scaleIcon(icon, ICON_SIZE, ICON_SIZE);
                }
            }
        }
        // fallback placeholder
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

    private static Icon scaleIcon(ImageIcon src, int w, int h) {
        BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = out.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(src.getImage(), 0, 0, w, h, null);
        g2.dispose();
        return new ImageIcon(out);
    }
}
