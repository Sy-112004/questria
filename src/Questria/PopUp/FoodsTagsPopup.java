package Questria.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

public class FoodsTagsPopup extends JDialog {

    // ---- Style ----
    private static final int DIALOG_W = 460;
    private static final int DIALOG_H = 340;
    private static final int DIALOG_ARC = 24;

    private static final Color BG = Color.WHITE;
    private static final Color STROKE = new Color(0xCCCCCC);
    private static final Color SUBTEXT = new Color(0x666666);
    private static final Color ADD_BTN_BG = new Color(0xBFD7F5);
    private static final Color ADD_BTN_FG = Color.BLACK;

    private static final Font FR_BOLD_18 = new Font("Fraunces 72pt", Font.BOLD, 18);
    private static final Font FR_REG_14  = new Font("Fraunces 72pt", Font.PLAIN, 14);
    private static final Font FR_REG_12  = new Font("Fraunces 72pt", Font.PLAIN, 12);

    // ---- State ----
    private final List<String> selectedTags = new ArrayList<>();
    private JPanel tagsPanel;

    public FoodsTagsPopup(JFrame parent) {
        super(parent, true);                 // modal
        setUndecorated(true);                // not draggable
        setSize(DIALOG_W, DIALOG_H);
        setLocationRelativeTo(parent);
        setBackground(new Color(0, 0, 0, 0)); // rounded paint

        // Rounded background + thin border
        JPanel background = new JPanel() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // soft shadow
                g2.setColor(new Color(0,0,0,32));
                g2.fillRoundRect(4, 6, getWidth() - 8, getHeight() - 10, DIALOG_ARC + 6, DIALOG_ARC + 6);

                // bg
                g2.setColor(BG);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 8, getHeight() - 10, DIALOG_ARC, DIALOG_ARC));

                // stroke
                g2.setColor(STROKE);
                g2.setStroke(new BasicStroke(1f));
                g2.draw(new RoundRectangle2D.Double(0.5, 0.5, getWidth() - 9, getHeight() - 11, DIALOG_ARC, DIALOG_ARC));
                g2.dispose();
            }
            @Override public Insets getInsets() { return new Insets(8,10,14,12); }
        };
        background.setOpaque(false);
        background.setLayout(new BorderLayout(0,0));
        setContentPane(background);

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(BorderFactory.createEmptyBorder(12, 16, 6, 12));

        JLabel title = new JLabel("Add tags");
        title.setFont(FR_BOLD_18);
        title.setForeground(Color.BLACK);

        JButton close = new JButton() {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int d = Math.min(getWidth(), getHeight());
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, d, d);
                g2.setColor(new Color(0,0,0,180));
                g2.setStroke(new BasicStroke(2f));
                int pad = 8;
                g2.drawLine(pad, pad, d - pad, d - pad);
                g2.drawLine(d - pad, pad, pad, d - pad);
                g2.dispose();
            }
        };
        close.setPreferredSize(new Dimension(28, 28));
        close.setOpaque(false);
        close.setContentAreaFilled(false);
        close.setBorderPainted(false);
        close.setFocusPainted(false);
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.addActionListener(e -> dispose());

        header.add(title, BorderLayout.WEST);
        header.add(close, BorderLayout.EAST);

        // Topic line
        JLabel topic = new JLabel("Topic: Foods");
        topic.setFont(FR_REG_14);
        topic.setForeground(SUBTEXT);
        JPanel topicWrap = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        topicWrap.setOpaque(false);
        topicWrap.setBorder(BorderFactory.createEmptyBorder(0, 16, 6, 16));
        topicWrap.add(topic);

        // Tags area
        tagsPanel = new JPanel();
        tagsPanel.setOpaque(false);
        tagsPanel.setLayout(new BoxLayout(tagsPanel, BoxLayout.Y_AXIS));
        tagsPanel.setBorder(BorderFactory.createEmptyBorder(6, 26, 6, 22));

        addTagRow("recipes",        new Color(0xF06B6B)); // red
        addTagRow("street foods",   new Color(0x5FA3E6)); // blue
        addTagRow("healthy eating", new Color(0xC2D4F2)); // light blue
        addTagRow("desserts",       new Color(0xF7B4D4)); // pink
        addTagRow("general",        new Color(0xB8E5B8)); // green

        JScrollPane scroll = new JScrollPane(tagsPanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        // Add button
        JButton addButton = new JButton("Add") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(ADD_BTN_BG);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        addButton.setOpaque(false);
        addButton.setContentAreaFilled(false);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addButton.setFont(FR_BOLD_18.deriveFont(14f));
        addButton.setForeground(ADD_BTN_FG);
        addButton.setPreferredSize(new Dimension(80, 34));
        addButton.addActionListener(e -> {
            System.out.println("Selected foods tags: " + selectedTags);
            dispose();
        });

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 14, 10));
        footer.setOpaque(false);
        footer.add(addButton);

        // Assemble
        JPanel top = new JPanel();
        top.setOpaque(false);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(header);
        top.add(topicWrap);

        background.add(top, BorderLayout.NORTH);
        background.add(scroll, BorderLayout.CENTER);
        background.add(footer, BorderLayout.SOUTH);
    }

    // Bullet + rounded pill chip
    private void addTagRow(String label, Color pillColor) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));
        row.setOpaque(false);

        JLabel bullet = new JLabel("•");
        bullet.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        bullet.setForeground(new Color(0x9A9A9A));

        TagChip chip = new TagChip(label, pillColor);
        chip.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                chip.toggle();
                if (chip.isSelected()) {
                    if (!selectedTags.contains(label)) selectedTags.add(label);
                } else {
                    selectedTags.remove(label);
                }
            }
            @Override public void mouseEntered(MouseEvent e) { chip.hover(true); }
            @Override public void mouseExited (MouseEvent e) { chip.hover(false); }
        });

        row.add(bullet);
        row.add(chip);
        tagsPanel.add(row);
    }

    public List<String> getSelectedTags() {
        return new ArrayList<>(selectedTags);
    }

    // Rounded pill component
    private static class TagChip extends JComponent {
        private final String text;
        private final Color base;
        private boolean selected = false;
        private boolean hover = false;

        TagChip(String text, Color base) {
            this.text = text;
            this.base = base;
            setFont(FR_REG_12);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setOpaque(false);
        }

        void toggle() { selected = !selected; repaint(); }
        boolean isSelected() { return selected; }
        void hover(boolean h) { hover = h; repaint(); }

        @Override public Dimension getPreferredSize() {
            FontMetrics fm = getFontMetrics(getFont());
            int w = fm.stringWidth(text) + 24;
            int h = Math.max(20, fm.getHeight() + 6);
            return new Dimension(w, h);
        }

        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();
            int r = h; // pill

            Color bg = (!selected && hover) ? base.brighter() : base;
            g2.setColor(bg);
            g2.fill(new RoundRectangle2D.Double(0, 0, w, h, r, r));

            g2.setStroke(new BasicStroke(selected ? 2.2f : 1.0f));
            g2.setColor(selected ? new Color(0x2E6CF5) : bg.darker());
            g2.draw(new RoundRectangle2D.Double(0.5, 0.5, w - 1, h - 1, r, r));

            g2.setFont(getFont());
            g2.setColor(Color.BLACK);
            FontMetrics fm = g2.getFontMetrics();
            int tx = (w - fm.stringWidth(text)) / 2;
            int ty = (h - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(text, tx, ty);

            g2.dispose();
        }
    }

    // Quick test
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame host = new JFrame();
            host.setSize(300,200);
            host.setLocationRelativeTo(null);
            host.setVisible(true);
            new FoodsTagsPopup(host).setVisible(true);
        });
    }
}
