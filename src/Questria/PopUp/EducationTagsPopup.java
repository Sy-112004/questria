package Questria.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// Education Tags Popup Dialog
public class EducationTagsPopup extends JDialog {
    private List<String> selectedTags;
    private JPanel tagsPanel;

    public EducationTagsPopup(JFrame parent) {
        super(parent, "Add tags", true);
        selectedTags = new ArrayList<>();

        setLayout(new BorderLayout(10, 10));
        setSize(350, 280);
        setLocationRelativeTo(parent);
        setResizable(false);

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 5, 20));
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Add tags");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JButton closeButton = new JButton("×");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> dispose());

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(closeButton, BorderLayout.EAST);

        // Topic label
        JPanel topicPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topicPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 5, 20));
        topicPanel.setBackground(Color.WHITE);
        JLabel topicLabel = new JLabel("Topics: Education");
        topicLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        topicLabel.setForeground(Color.GRAY);
        topicPanel.add(topicLabel);

        // Tags panel with checkboxes
        tagsPanel = new JPanel();
        tagsPanel.setLayout(new BoxLayout(tagsPanel, BoxLayout.Y_AXIS));
        tagsPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        tagsPanel.setBackground(Color.WHITE);

        addTagCheckbox("math", new Color(255, 182, 193));
        addTagCheckbox("sciences", new Color(135, 206, 250));
        addTagCheckbox("CET", new Color(173, 216, 230));
        addTagCheckbox("scholarship", new Color(255, 192, 203));
        addTagCheckbox("study tips", new Color(220, 220, 220));
        addTagCheckbox("general", new Color(144, 238, 144));

        // Bottom panel with Add button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 15, 20));
        bottomPanel.setBackground(Color.WHITE);

        JButton addButton = new JButton("Add");
        addButton.setForeground(new Color(0, 122, 255));
        addButton.setFont(new Font("Arial", Font.PLAIN, 13));
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.addActionListener(e -> {
            System.out.println("Selected tags: " + selectedTags);
            dispose();
        });

        bottomPanel.add(addButton);

        // Combine header and topic
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(topicPanel, BorderLayout.CENTER);

        // Add all panels to dialog
        add(topPanel, BorderLayout.NORTH);
        add(tagsPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.WHITE);
    }

    private void addTagCheckbox(String tag, Color bgColor) {
        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        checkboxPanel.setBackground(Color.WHITE);
        checkboxPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        JCheckBox checkbox = new JCheckBox();
        checkbox.setBackground(Color.WHITE);
        checkbox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        checkbox.addActionListener(e -> {
            if (checkbox.isSelected()) {
                selectedTags.add(tag);
            } else {
                selectedTags.remove(tag);
            }
        });

        JLabel tagLabel = new JLabel(tag);
        tagLabel.setOpaque(true);
        tagLabel.setBackground(bgColor);
        tagLabel.setForeground(Color.BLACK);
        tagLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        tagLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Round corners effect
        tagLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bgColor, 1, true),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        // Make label clickable
        tagLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkbox.doClick();
            }
        });

        checkboxPanel.add(checkbox);
        checkboxPanel.add(tagLabel);

        tagsPanel.add(checkboxPanel);
    }

    public List<String> getSelectedTags() {
        return new ArrayList<>(selectedTags);
    }
}