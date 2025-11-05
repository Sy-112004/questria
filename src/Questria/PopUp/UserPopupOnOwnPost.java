package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class UserPopupOnOwnPost {

    private static final Color POPUP_BG  = new Color(0xCCDBFD);
    private static final int   ICON_SIZE = 22;

    // Fraunces if present; otherwise Serif
    private static final Font FRAUNCES_16B = loadFraunces();
    private static Font loadFraunces() {
        try (var in = UserPopupOnOwnPost.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf")) {
            if (in != null) {
                Font base = Font.createFont(Font.TRUETYPE_FONT, in);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(base);
                return base.deriveFont(Font.BOLD, 16f);
            }
        } catch (Exception ignored) {}
        return new Font("Serif", Font.BOLD, 16);
    }

    /** Build: Edit / Delete / Lock */
    public static JPopupMenu build(Runnable onEdit, Runnable onDelete, Runnable onLock) {
        RoundedPopupMenu popup = new RoundedPopupMenu(POPUP_BG, 18, 8);

        Icon editIcon   = loadIconSmart("edit.png", "pencil.png", "edit_pen.png");
        Icon deleteIcon = loadIconSmart("delete.png", "trash.png", "bin.png");
        Icon lockIcon   = loadIconSmart("lock.png", "padlock.png");

        popup.add(menuItem("Edit",   editIcon,   onEdit));
        popup.add(menuItem("Delete", deleteIcon, onDelete));
        popup.add(menuItem("Lock",   lockIcon,   onLock));

        return popup;
    }

    private static JMenuItem menuItem(String text, Icon icon, Runnable onClick) {
        JMenuItem it = new JMenuItem(text, icon);
        it.setFont(FRAUNCES_16B);
        it.setForeground(Color.BLACK);
        it.setOpaque(false);
        it.setBorder(new EmptyBorder(6, 8, 6, 8));
        it.setIconTextGap(10);
        it.addActionListener(e -> { if (onClick != null) onClick.run(); });
        return it;
    }

    // --------- SAFE ICON LOADER (no -1 width/height) ---------

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
                g2.setStroke(new BasicStroke(2f));
                g2.drawRoundRect(x + 2, y + 2, ICON_SIZE - 4, ICON_SIZE - 4, 6, 6);
                g2.dispose();
            }
        };
    }

    /** Draw the source icon into a new buffered image of the target size (never queries source width/height). */
    private static Icon scaleIcon(ImageIcon src, int targetW, int targetH) {
        BufferedImage out = new BufferedImage(targetW, targetH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = out.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(src.getImage(), 0, 0, targetW, targetH, null);
        g2.dispose();
        return new ImageIcon(out);
    }

    // --------- rounded popup card (NO WHITE RECTANGLE) ---------

    static class RoundedPopupMenu extends JPopupMenu {
        private final int arc, shadow;
        private final Color bg;
        private Shape clipShape;

        RoundedPopupMenu(Color bg, int arc, int shadow) {
            this.bg = bg;
            this.arc = arc;
            this.shadow = shadow;

            // make the popup window itself transparent
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
            setBorder(new EmptyBorder(12, 16, 12, 16));
        }

        @Override public boolean isOpaque() { return false; }

        @Override public void updateUI() {
            super.updateUI();
            // some LAFs reset opacity; force transparency again
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 0));
        }

        @Override protected void paintComponent(Graphics g) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // soft shadow
            for (int i = shadow; i > 0; i--) {
                float alpha = 0.07f * (i / (float) shadow);
                g2.setColor(new Color(0, 0, 0, Math.min(80, Math.round(255 * alpha))));
                g2.fillRoundRect(i, i, w - i * 2, h - i * 2, arc, arc);
            }

            // card
            int iw = w - shadow * 2;
            int ih = h - shadow * 2;
            g2.setColor(bg);
            g2.fillRoundRect(0, 0, iw, ih, arc, arc);

            // define clip for children so nothing paints outside rounded area
            clipShape = new RoundRectangle2D.Double(0, 0, iw, ih, arc, arc);
            g2.dispose();
        }

        @Override protected void paintChildren(Graphics g) {
            if (clipShape != null) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setClip(clipShape);
                super.paintChildren(g2);
                g2.dispose();
            } else {
                super.paintChildren(g);
            }
        }

        @Override public Insets getInsets() {
            Insets in = super.getInsets();
            // add space for the drawn shadow so content doesn't overlap it
            return new Insets(in.top + shadow, in.left + shadow, in.bottom + shadow, in.right + shadow);
        }
    }
}
