package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

public class ReportConfirmationDialog {

    // Visual constants (kept consistent with your Lock dialog)
    private static final Color BG_COLOR       = new Color(0xCCDBFD);
    private static final Color BTN_PRIMARY    = new Color(0x5DADE2); // Report
    private static final Color BTN_PRIMARY_HI = new Color(0x6EB9F0);
    private static final Color BTN_PRIMARY_PR = new Color(0x4D97CA);

    private static final Color BTN_GHOST      = new Color(0xE9EEF7); // Cancel ghost style
    private static final Color BTN_GHOST_HI   = new Color(0xF2F5FA);
    private static final Color BTN_GHOST_PR   = new Color(0xD6DEEB);

    private static final int DIALOG_WIDTH  = 420;
    private static final int DIALOG_HEIGHT = 220;
    private static final int CORNER_RADIUS = 30;

    public static void show(Component parent, Runnable onConfirmReport) {
        // Owner-safe: works if parent is in a JFrame or JDialog
        Window owner = SwingUtilities.getWindowAncestor(parent);
        final JDialog dialog = new JDialog(owner, Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setUndecorated(true);
        dialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        dialog.setBackground(new Color(0, 0, 0, 0)); // fully transparent window, no white corners

        // Center on screen (or relative to owner if you prefer)
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation((ss.width - DIALOG_WIDTH) / 2, (ss.height - DIALOG_HEIGHT) / 2);

        // Root rounded panel
        JPanel root = new JPanel(new BorderLayout()) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(BG_COLOR);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), CORNER_RADIUS, CORNER_RADIUS));
                g2.dispose();
            }
        };
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(28, 36, 32, 36));

        // Header (title + X)
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JLabel title = new JLabel("Report?");
        title.setFont(loadFraunces(Font.BOLD, 22f));
        title.setForeground(Color.BLACK);

        JButton closeBtn = new JButton("X") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, getWidth(), getHeight());
                g2.setColor(Color.BLACK);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                String x = "X";
                int tx = (getWidth() - fm.stringWidth(x)) / 2;
                int ty = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString(x, tx, ty);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        closeBtn.setFont(new Font("Arial", Font.BOLD, 18));
        closeBtn.setPreferredSize(new Dimension(36, 36));
        closeBtn.setContentAreaFilled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setFocusPainted(false);
        closeBtn.setOpaque(false);
        closeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> dialog.dispose());

        header.add(title, BorderLayout.WEST);
        header.add(closeBtn, BorderLayout.EAST);

        // Message
        JLabel msg = new JLabel("Are you sure you want to report this content?");
        msg.setFont(loadFraunces(Font.PLAIN, 16f));
        msg.setForeground(Color.BLACK);
        msg.setBorder(new EmptyBorder(10, 0, 0, 0));

        // Buttons (right-aligned): Cancel (ghost), Report (primary)
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        actions.setOpaque(false);

        JButton cancel = roundedButton("Cancel", BTN_GHOST, BTN_GHOST_HI, BTN_GHOST_PR);
        JButton report = roundedButton("Report", BTN_PRIMARY, BTN_PRIMARY_HI, BTN_PRIMARY_PR);

        cancel.addActionListener(e -> dialog.dispose());
        report.addActionListener(e -> {
            dialog.dispose();
            if (onConfirmReport != null) onConfirmReport.run();
        });

        actions.add(cancel);
        actions.add(report);

        // Layout stack
        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);
        center.add(msg, BorderLayout.CENTER);

        root.add(header, BorderLayout.NORTH);
        root.add(center, BorderLayout.CENTER);
        root.add(actions, BorderLayout.SOUTH);

        dialog.setContentPane(root);

        // Keyboard shortcuts: ESC = cancel, ENTER = report
        JRootPane rp = dialog.getRootPane();
        rp.setDefaultButton(report);
        rp.registerKeyboardAction(e -> dialog.dispose(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        dialog.setVisible(true);
    }

    // Rounded pill button with hover/press colors (never turns white)
    private static JButton roundedButton(String text, Color base, Color hover, Color pressed) {
        return new JButton(text) {
            {
                setFont(loadFraunces(Font.BOLD, 16f));
                setForeground(Color.BLACK);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
                setOpaque(false);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                setPreferredSize(new Dimension(120, 44));
            }
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color c = getModel().isPressed() ? pressed : (getModel().isRollover() ? hover : base);
                g2.setColor(c);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
                g2.dispose();
                super.paintComponent(g);
            }
        };
    }

    // Fraunces loader with safe fallback to "Fraunces 72pt" or Serif
    private static Font loadFraunces(int style, float size) {
        try {
            var in = ReportConfirmationDialog.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf");
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
}
