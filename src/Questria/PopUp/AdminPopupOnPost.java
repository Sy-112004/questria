package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AdminPopupOnPost {

    private static final Font FRAUNCES_16B = loadFraunces();
    private static final Color POPUP_BG = new Color(0xCCDBFD);
    private static final int ICON_SIZE = 22;

    private static Font loadFraunces() {
        try {
            var in = AdminPopupOnPost.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf");
            if (in != null) {
                Font base = Font.createFont(Font.TRUETYPE_FONT, in);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(base);
                return base.deriveFont(Font.BOLD, 16f);
            }
        } catch (Exception ignored) {}
        return new Font("Fraunces 72pt", Font.BOLD, 16); // fallback if Fraunces missing
    }

    /** Build the popup (no separators) */
    public static JPopupMenu build(Runnable onDelete, Runnable onLock, Runnable onMarkSafe) {
        RoundedPopupMenu popup = new RoundedPopupMenu(POPUP_BG, 18, 8);

        // Show confirmation dialog before actual delete
        popup.add(menuItem("Delete", loadIconFromAssets("delete.png"), () -> {
            DeleteConfirmationDialog.show(popup.getInvoker(), onDelete);
        }));
        popup.add(menuItem("Lock", loadIconFromAssets("lock.png"), () -> {
            LockConfirmationDialog.show(popup.getInvoker(), onLock);
        }));
        popup.add(menuItem("Mark as Safe", loadIconFromAssets("mark_safe.png"), () -> {
            MarkSafeConfirmationDialog.show(popup.getInvoker(), onMarkSafe);
        }));

        return popup;
    }

    private static JMenuItem menuItem(String text, Icon icon, Runnable onClick) {
        JMenuItem item = new JMenuItem(text, icon);
        item.setFont(FRAUNCES_16B);
        item.setForeground(Color.BLACK);
        item.setOpaque(false);
        item.setBorder(new EmptyBorder(6, 8, 6, 8));
        item.setIconTextGap(10);
        item.addActionListener(e -> { if (onClick != null) onClick.run(); });
        return item;
    }

    /** Loads icons from assets folder */
    private static Icon loadIconFromAssets(String filename) {
        try {
            // Print current working directory
            System.out.println("Working Directory: " + System.getProperty("user.dir"));
            System.out.println("Looking for icon: " + filename);

            // Try classpath first
            var url = AdminPopupOnPost.class.getResource("/assets/" + filename);
            System.out.println("Classpath /assets/" + filename + " = " + url);
            if (url != null) {
                ImageIcon raw = new ImageIcon(url);
                System.out.println("Loaded from classpath! Size: " + raw.getIconWidth() + "x" + raw.getIconHeight());
                Image scaled = raw.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
                return new ImageIcon(toBufferedImage(scaled));
            }

            // Try without leading slash
            url = AdminPopupOnPost.class.getResource("assets/" + filename);
            System.out.println("Classpath assets/" + filename + " = " + url);
            if (url != null) {
                ImageIcon raw = new ImageIcon(url);
                System.out.println("Loaded from classpath (no slash)! Size: " + raw.getIconWidth() + "x" + raw.getIconHeight());
                Image scaled = raw.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
                return new ImageIcon(toBufferedImage(scaled));
            }

            // Fall back to file system
            String[] possiblePaths = {
                    "assets/" + filename,
                    "src/assets/" + filename,
                    "../assets/" + filename,
                    "../../assets/" + filename,
                    "./Questria/assets/" + filename
            };

            for (String path : possiblePaths) {
                java.io.File file = new java.io.File(path);
                System.out.println("Trying file path: " + file.getAbsolutePath() + " exists=" + file.exists());
                if (file.exists()) {
                    ImageIcon raw = new ImageIcon(file.getAbsolutePath());

                    // Wait for image to load
                    if (raw.getImageLoadStatus() == MediaTracker.COMPLETE) {
                        System.out.println("SUCCESS! Loaded from file: " + file.getAbsolutePath()
                                + " Size: " + raw.getIconWidth() + "x" + raw.getIconHeight());

                        // Check if image loaded properly
                        if (raw.getIconWidth() > 0 && raw.getIconHeight() > 0) {
                            Image scaled = raw.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
                            return new ImageIcon(scaled); // Don't convert to BufferedImage yet
                        } else {
                            System.err.println("Image has invalid dimensions: " + raw.getIconWidth() + "x" + raw.getIconHeight());
                        }
                    } else {
                        System.err.println("Image failed to load or is corrupted");
                    }
                }
            }

            System.err.println("❌ Icon not found in any location: " + filename);
        } catch (Exception e) {
            System.err.println("❌ Exception loading icon: " + filename);
            e.printStackTrace();
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

    private static Image toBufferedImage(Image img) {
        if (img instanceof BufferedImage) return (BufferedImage) img;
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        return bimage;
    }

    // ---- Rounded popup ----
    static class RoundedPopupMenu extends JPopupMenu {
        private final int arc, shadow;
        private final Color bg;

        RoundedPopupMenu(Color bg, int arc, int shadow) {
            this.bg = bg;
            this.arc = arc;
            this.shadow = shadow;
            setOpaque(false);
            setBorder(new EmptyBorder(12, 16, 12, 16));
        }

        @Override protected void paintComponent(Graphics g) {
            int w = getWidth(), h = getHeight();
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // soft drop shadow
            for (int i = shadow; i > 0; i--) {
                float alpha = 0.07f * (i / (float) shadow);
                g2.setColor(new Color(0, 0, 0, Math.min(80, Math.round(255 * alpha))));
                g2.fillRoundRect(i, i, w - i * 2, h - i * 2, arc, arc);
            }

            // background
            g2.setColor(bg);
            g2.fillRoundRect(0, 0, w - shadow * 2, h - shadow * 2, arc, arc);
            g2.dispose();
        }

        @Override public Insets getInsets() {
            Insets in = super.getInsets();
            return new Insets(in.top + shadow, in.left + shadow, in.bottom + shadow, in.right + shadow);
        }
    }
}