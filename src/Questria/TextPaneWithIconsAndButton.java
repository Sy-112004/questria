package Questria;
import javax.swing.*;
import java.awt.*;

public class TextPaneWithIconsAndButton extends JFrame {

    public TextPaneWithIconsAndButton() {
        setTitle("Text Input with Icons and Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 150);
        setLocationRelativeTo(null);

        // Main panel with padding and rounded border
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw rounded background
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        setContentPane(mainPanel);

        // Text pane (transparent for rounded background)
        JTextPane textPane = new JTextPane();
        textPane.setOpaque(false);
        textPane.setBorder(null);
        textPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Scroll pane without border and with transparent viewport
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel for icons at top right
        JPanel iconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        iconsPanel.setOpaque(false);

        // Sample icons (using built-in icons or placeholders)
        iconsPanel.add(new JLabel(new ImageIcon(getClass().getResource("/icons/image_icon.png"))));
        iconsPanel.add(new JLabel(new ImageIcon(getClass().getResource("/icons/document_icon.png"))));
        iconsPanel.add(new JLabel(new ImageIcon(getClass().getResource("/icons/link_icon.png"))));

        mainPanel.add(iconsPanel, BorderLayout.NORTH);

        // Panel for Comment button aligned bottom right
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        JButton commentBtn = new JButton("Comment");
        commentBtn.setBackground(new Color(90, 165, 240));
        commentBtn.setForeground(Color.WHITE);
        commentBtn.setFocusPainted(false);
        commentBtn.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
        commentBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        commentBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        commentBtn.setBorderPainted(false);
        commentBtn.setOpaque(true);
        commentBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Comment button clicked"));

        buttonPanel.add(commentBtn);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // To size the overall window nicely
        setMinimumSize(new Dimension(450, 150));
    }

    public static void main(String[] args) {
        // To run GUI in Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            TextPaneWithIconsAndButton frame = new TextPaneWithIconsAndButton();
            frame.setVisible(true);
        });
    }
}
