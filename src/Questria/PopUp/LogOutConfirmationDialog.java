package Questria.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LogOutConfirmationDialog {

    private static final Color BG_COLOR     = new Color(0xCCDBFD); // light blue card
    private static final Color BUTTON_COLOR = new Color(0x5DADE2); // blue button
    private static final int   DIALOG_WIDTH  = 360;                 // compact like your mock
    private static final int   DIALOG_HEIGHT = 170;
    private static final int   CORNER_RADIUS = 22;

    /**
     * Show the small "Logging out ?" confirmation.
     * @param parent any component in the window (can be null)
     * @param onConfirmLogout callback executed after clicking "Log Out"
     */
    public static void show(Component parent, Runnable onConfirmLogout) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(parent), true);
        dialog.setUndecorated(true);
        dialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);

        // center on screen
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation((screen.width - DIALOG_WIDTH) / 2, (screen.height - DIALOG_HEIGHT) / 2);
        dialog.setBackground(new Color(0, 0, 0, 0)); // transparent around rounded corners

        // Rounded card background
        JPanel mainPanel = new JPanel() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(BG_COLOR);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), CORNER_RADIUS, CORNER_RADIUS));
                g2.dispose();
            }
        };
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(14, 18, 16, 18)); // tight padding like the mock

        // Header: title + close
        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);

        JLabel title = new JLabel("Logging out ?");
        title.setFont(new Font("Fraunces", Font.BOLD, 18)); // same family/feel as your UI
        title.setForeground(Color.BLACK);
        top.add(title, BorderLayout.WEST);

        JButton closeBtn = new JButton("X") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, getWidth(), getHeight());
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("Arial", Font.BOLD, 12));
                FontMetrics fm = g2.getFontMetrics();
                int tx = (getWidth() - fm.stringWidth("X")) / 2;
                int ty = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString("X", tx, ty);
                g2.dispose();
            }
        };
        closeBtn.setPreferredSize(new Dimension(22, 22)); // small round X like the mock
        closeBtn.setContentAreaFilled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setFocusPainted(false);
        closeBtn.setOpaque(false);
        closeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> dialog.dispose());

        JPanel closeWrap = new JPanel(new BorderLayout());
        closeWrap.setOpaque(false);
        closeWrap.setPreferredSize(new Dimension(26, 26));
        closeWrap.add(closeBtn);
        top.add(closeWrap, BorderLayout.EAST);

        // Message
        JLabel msg = new JLabel("Are you sure you want to log out ?");
        msg.setFont(new Font("Serif", Font.PLAIN, 14));
        msg.setForeground(Color.BLACK);
        msg.setBorder(BorderFactory.createEmptyBorder(6, 0, 8, 0));

        // Log Out button (rounded)
        JButton logoutBtn = new JButton("Log Out") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed()
                        ? BUTTON_COLOR.darker()
                        : getModel().isRollover() ? BUTTON_COLOR.brighter() : BUTTON_COLOR);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        logoutBtn.setFont(new Font("Fraunces", Font.BOLD, 14));
        logoutBtn.setForeground(Color.BLACK);
        logoutBtn.setPreferredSize(new Dimension(100, 34));
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutBtn.addActionListener(e -> {
            dialog.dispose();
            if (onConfirmLogout != null) onConfirmLogout.run();
        });

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        actions.setOpaque(false);
        actions.add(logoutBtn);

        // Compose
        JPanel content = new JPanel(new BorderLayout());
        content.setOpaque(false);
        content.add(top, BorderLayout.NORTH);
        content.add(msg, BorderLayout.CENTER);
        content.add(actions, BorderLayout.SOUTH);

        mainPanel.add(content, BorderLayout.CENTER);
        dialog.setContentPane(mainPanel);
        dialog.setVisible(true);
    }
}
