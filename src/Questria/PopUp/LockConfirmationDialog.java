package Questria.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LockConfirmationDialog {

    private static final Color BG_COLOR = new Color(0xCCDBFD);
    private static final Color BUTTON_COLOR = new Color(0x5DADE2);
    private static final int DIALOG_WIDTH = 420;
    private static final int DIALOG_HEIGHT = 220;
    private static final int CORNER_RADIUS = 30;

    public static void show(Component parent, Runnable onConfirmLock) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(parent), true);
        dialog.setUndecorated(true);
        dialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - DIALOG_WIDTH) / 2;
        int y = (screenSize.height - DIALOG_HEIGHT) / 2;
        dialog.setLocation(x, y);
        dialog.setBackground(new Color(0, 0, 0, 0));

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(BG_COLOR);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), CORNER_RADIUS, CORNER_RADIUS));
                g2.dispose();
            }
        };
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 40, 40));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Lock Post?");
        titleLabel.setFont(new Font("Fraunces", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        topPanel.add(titleLabel, BorderLayout.WEST);

        // Close Button
        JButton closeBtn = new JButton("X") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, getWidth(), getHeight());
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("Arial", Font.BOLD, 22));
                FontMetrics fm = g2.getFontMetrics();
                String xText = "X";
                int textX = (getWidth() - fm.stringWidth(xText)) / 2;
                int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString(xText, textX, textY);
                g2.dispose();
            }
        };
        closeBtn.setPreferredSize(new Dimension(40, 40));
        closeBtn.setContentAreaFilled(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setFocusPainted(false);
        closeBtn.setOpaque(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> dialog.dispose());

        JPanel closeBtnPanel = new JPanel(new BorderLayout());
        closeBtnPanel.setOpaque(false);
        closeBtnPanel.setPreferredSize(new Dimension(50, 50));
        closeBtnPanel.add(closeBtn);

        topPanel.add(closeBtnPanel, BorderLayout.EAST);

        JLabel messageLabel = new JLabel("Once you lock this post, it can't be unlocked.");
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JButton lockBtn = new JButton("Lock") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed()) {
                    g2.setColor(BUTTON_COLOR.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(BUTTON_COLOR.brighter());
                } else {
                    g2.setColor(BUTTON_COLOR);
                }
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        lockBtn.setFont(new Font("Serif", Font.BOLD, 18));
        lockBtn.setForeground(Color.BLACK);
        lockBtn.setPreferredSize(new Dimension(120, 45));
        lockBtn.setContentAreaFilled(false);
        lockBtn.setBorderPainted(false);
        lockBtn.setFocusPainted(false);
        lockBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lockBtn.addActionListener(e -> {
            dialog.dispose();
            if (onConfirmLock != null) onConfirmLock.run();
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setOpaque(false);
        bottomPanel.add(lockBtn);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(messageLabel, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.add(contentPanel);
        dialog.add(mainPanel);
        dialog.setVisible(true);
    }
}