package Questria.PopUp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MusicTagsPopup extends JDialog {

    private static final int W = 420, H = 320, ARC = 22;

    private final List<String> selected = new ArrayList<>();
    private final Font fTitle = loadFraunces(Font.BOLD, 18f);
    private final Font fBody  = loadFraunces(Font.PLAIN, 12f);

    public MusicTagsPopup(JFrame parent) {
        super(parent, true);
        setUndecorated(true);                  // no OS titlebar -> not draggable
        setSize(W, H);
        setLocationRelativeTo(parent);
        setBackground(new Color(0,0,0,0));     // allow rounded corners

        // Rounded container
        JPanel chrome = new JPanel(new BorderLayout()) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, ARC, ARC));
                g2.setColor(new Color(0,0,0,35)); // soft outline
                g2.draw(new RoundRectangle2D.Double(0.5, 0.5, getWidth()-1, getHeight()-1, ARC, ARC));
                g2.dispose();
            }
        };
        chrome.setOpaque(false);
        chrome.setBorder(new EmptyBorder(12, 14, 12, 14));

        // ----- Header (title + X)
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JLabel title = new JLabel("Add tags");
        title.setFont(fTitle);
        title.setForeground(Color.BLACK);

        JButton close = new JButton("X") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillOval(0, 0, getWidth(), getHeight());
                g2.setColor(Color.BLACK);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int x = (getWidth() - fm.stringWidth("X")) / 2;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2.drawString("X", x, y);
                g2.dispose();
            }
        };
        close.setFont(loadFraunces(Font.BOLD, 14f));
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setFocusPainted(false);
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.setPreferredSize(new Dimension(28, 28));
        close.addActionListener(e -> dispose());

        header.add(title, BorderLayout.WEST);
        header.add(close, BorderLayout.EAST);

        // ----- Topic line
        JPanel topicLine = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        topicLine.setOpaque(false);
        JLabel topic = new JLabel("Topic: Music");
        topic.setFont(fBody);
        topic.setForeground(new Color(60,60,60));
        topicLine.add(topic);

        // ----- Tags list
        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.setOpaque(false);
        list.setBorder(new EmptyBorder(8, 10, 8, 10));

        addTag(list, "genres",       new Color(0xF28B8B));
        addTag(list, "artist",       new Color(0x77A9D8));
        addTag(list, "instruments",  new Color(0xB7C6EB));
        addTag(list, "lyrics",       new Color(0xF0A6CF));
        addTag(list, "song writing", new Color(0xF6E29A));
        addTag(list, "general",      new Color(0x8BCF77));

        // ----- Bottom bar (Add)
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        bottom.setOpaque(false);
        JButton addBtn = new JButton("Add") {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color base = new Color(0xC8D6FA);
                g2.setColor(getModel().isPressed() ? base.darker() : (getModel().isRollover() ? base.brighter() : base));
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 18, 18));
                g2.dispose();
                super.paintComponent(g);
            }
        };
        addBtn.setFont(loadFraunces(Font.BOLD, 12f));
        addBtn.setForeground(Color.BLACK);
        addBtn.setBorderPainted(false);
        addBtn.setContentAreaFilled(false);
        addBtn.setFocusPainted(false);
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.setPreferredSize(new Dimension(64, 28));
        addBtn.addActionListener(e -> dispose());
        bottom.add(addBtn);

        // ----- Layout
        JPanel top = new JPanel();
        top.setOpaque(false);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.add(header);
        top.add(Box.createVerticalStrut(4));
        top.add(topicLine);
        top.add(Box.createVerticalStrut(6));

        chrome.add(top, BorderLayout.NORTH);
        chrome.add(list, BorderLayout.CENTER);
        chrome.add(bottom, BorderLayout.SOUTH);
        setContentPane(chrome);
    }

    public List<String> getSelectedTags() {
        return new ArrayList<>(selected);
    }

    // ===== Helpers =====

    private static Font loadFraunces(int style, float size) {
        try {
            var in = MusicTagsPopup.class.getResourceAsStream("/fonts/Fraunces-Regular.ttf");
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

    private void addTag(JPanel list, String text, Color bg) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 2));
        row.setOpaque(false);

        JLabel bullet = new JLabel("•");
        bullet.setFont(loadFraunces(Font.BOLD, 18f));
        bullet.setForeground(new Color(170, 170, 170));

        PillTag chip = new PillTag(text, bg);
        chip.setFont(fBody);

        row.add(bullet);
        row.add(chip);
        list.add(row);
    }

    /** Custom rounded chip that paints its own pill background & border */
    private class PillTag extends JLabel {
        private final Color baseBg;
        private boolean on = false;

        PillTag(String text, Color bg) {
            super(text);
            this.baseBg = bg;
            setOpaque(false); // we paint background ourselves
            setBorder(new EmptyBorder(4, 12, 4, 12));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) {
                    on = !on;
                    if (on) {
                        if (!selected.contains(getText())) selected.add(getText());
                    } else {
                        selected.remove(getText());
                    }
                    repaint();
                }
                @Override public void mouseEntered(MouseEvent e) { repaint(); }
                @Override public void mouseExited (MouseEvent e) { repaint(); }
            });
        }

        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth(), h = getHeight();
            int arc = h; // full pill

            Color fill = (getMousePosition() != null && !on) ? baseBg.brighter() : baseBg;
            g2.setColor(fill);
            g2.fillRoundRect(0, 0, w, h, arc, arc);

            g2.setStroke(new BasicStroke(on ? 2f : 1f));
            g2.setColor(on ? new Color(0x4B80F5) : fill.darker());
            g2.drawRoundRect(0, 0, w-1, h-1, arc, arc);

            g2.dispose();
            super.paintComponent(g); // draw text
        }
    }
}
