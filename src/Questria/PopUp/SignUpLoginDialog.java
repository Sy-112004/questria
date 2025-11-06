package Questria.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SignUpLoginDialog {

    private static final Color BG_COLOR = new Color(0xCCDBFD);
    private static final Color BUTTON_COLOR = new Color(0x5DADE2);
    private static final int DIALOG_WIDTH = 400;
    private static final int DIALOG_HEIGHT = 200;
    private static final int CORNER_RADIUS = 30;

    /**
     * Shows a dialog prompting user to sign up or log in
     * @param parent The parent component (can be null)
     * @param onSignUp Callback to run when user clicks Sign Up
     * @param onLogIn Callback to run when user clicks Log In
     */
    public static void show(Component parent, Runnable onSignUp, Runnable onLogIn) {
        // Create custom dialog
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(parent), true);
        dialog.setUndecorated(true);
        dialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);

        // Center on screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - DIALOG_WIDTH) / 2;
        int y = (screenSize.height - DIALOG_HEIGHT) / 2;
        dialog.setLocation(x, y);

        // Make dialog rounded
        dialog.setBackground(new Color(0, 0, 0, 0));

        // Main panel with rounded corners
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw rounded background
                g2.setColor(BG_COLOR);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), CORNER_RADIUS, CORNER_RADIUS));
                g2.dispose();
            }
        };
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

        // Close button (X) - top right
        JButton closeBtn = new JButton("X");
        closeBtn.setFont(new Font("Arial", Font.BOLD, 18));
        closeBtn.setForeground(Color.BLACK);
        closeBtn.setFocusPainted(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> dialog.dispose());
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtn.setForeground(new Color(100, 100, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtn.setForeground(Color.BLACK);
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        topPanel.setOpaque(false);
        topPanel.add(closeBtn);

        // Title
        JLabel titleLabel = new JLabel("Sign Up or Log In to Follow Topics");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);

        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // Sign Up button
        JButton signUpBtn = createRoundedButton("Sign Up", onSignUp, dialog);

        // Log In button
        JButton logInBtn = createRoundedButton("Log In", onLogIn, dialog);

        buttonsPanel.add(signUpBtn);
        buttonsPanel.add(logInBtn);

        // Content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.add(titlePanel, BorderLayout.CENTER);
        contentPanel.add(buttonsPanel, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        dialog.add(mainPanel);
        dialog.setVisible(true);
    }

    private static JButton createRoundedButton(String text, Runnable onClick, JDialog dialog) {
        JButton button = new JButton(text) {
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

                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setForeground(Color.BLACK);
        button.setPreferredSize(new Dimension(160, 50));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> {
            dialog.dispose();
            if (onClick != null) {
                onClick.run();
            }
        });
        return button;
    }
}