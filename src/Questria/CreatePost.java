package Questria;

import Questria.PopUp.EducationTagsPopup;
import Questria.PopUp.TravelTagsPopup;
import Questria.PopUp.MoviesTvTagsPopup;
import Questria.PopUp.GamesTagsPopup;
import Questria.PopUp.FoodsTagsPopup;
import Questria.PopUp.MusicTagsPopup;   // ← NEW

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CreatePost {
    private JPanel createPostPanel;
    private JLabel backLbl;
    private JLabel profileLbl;
    private JButton pointsBtn;
    private JComboBox<String> anonymousComboBox;
    private JButton tagsButton;
    private JTextField titleTextField;
    private JTextPane bodyTextPane;
    private JLabel imageUploadLbl;
    private JLabel fileUploadLbl;
    private JLabel mediaUploadLbl;
    private JButton postBtn;
    private JButton cancelBtn;
    private JScrollPane bodyScrollPane;
    private JTextArea bodyTextArea;
    private JComboBox<String> topicComboBox;

    private boolean listenersWired = false;

    ImageIcon backIcon       = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon profileIcon    = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon imageUploadIcon= new ImageIcon(new ImageIcon("assets/picture.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon fileUploadIcon = new ImageIcon(new ImageIcon("assets/file.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon mediaUploadIcon= new ImageIcon(new ImageIcon("assets/video.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    PageBuilder pageBuilder = new PageBuilder();

    public JPanel getCreatePostPanel(){
        backLbl.setIcon(backIcon);
        profileLbl.setIcon(profileIcon);
        imageUploadLbl.setIcon(imageUploadIcon);
        fileUploadLbl.setIcon(fileUploadIcon);
        mediaUploadLbl.setIcon(mediaUploadIcon);

        setupListeners(); // guarded so it only wires once
        return createPostPanel;
    }

    // Wire once
    private void setupListeners() {
        if (listenersWired) return;
        listenersWired = true;

        // Enable/disable "Add tags" depending on topic
        topicComboBox.addActionListener(e -> {
            String topic = (String) topicComboBox.getSelectedItem();
            boolean enable =
                    "Education".equals(topic) ||
                            "Travel".equals(topic) ||
                            "Movies & TV".equals(topic) ||
                            "Games".equals(topic) ||
                            "Foods".equals(topic) ||
                            "Music".equals(topic);          // ← NEW
            tagsButton.setEnabled(enable);
        });

        // Show the correct tags popup
        tagsButton.addActionListener(e -> {
            String topic = (String) topicComboBox.getSelectedItem();
            Window w = SwingUtilities.getWindowAncestor(createPostPanel);
            JFrame parent = (w instanceof JFrame) ? (JFrame) w : null;

            java.util.List<String> tags = java.util.Collections.emptyList();

            if ("Education".equals(topic)) {
                EducationTagsPopup dlg = new EducationTagsPopup(parent);
                dlg.setVisible(true);
                tags = dlg.getSelectedTags();
            } else if ("Travel".equals(topic)) {
                TravelTagsPopup dlg = new TravelTagsPopup(parent);
                dlg.setVisible(true);
                tags = dlg.getSelectedTags();
            } else if ("Movies & TV".equals(topic)) {
                MoviesTvTagsPopup dlg = new MoviesTvTagsPopup(parent);
                dlg.setVisible(true);
                tags = dlg.getSelectedTags();
            } else if ("Games".equals(topic)) {
                GamesTagsPopup dlg = new GamesTagsPopup(parent);
                dlg.setVisible(true);
                tags = dlg.getSelectedTags();
            } else if ("Foods".equals(topic)) {
                FoodsTagsPopup dlg = new FoodsTagsPopup(parent);
                dlg.setVisible(true);
                tags = dlg.getSelectedTags();
            } else if ("Music".equals(topic)) {       // ← NEW
                MusicTagsPopup dlg = new MusicTagsPopup(parent);
                dlg.setVisible(true);
                tags = dlg.getSelectedTags();
            }

            if (!tags.isEmpty()) {
                System.out.println("Selected tags: " + tags);
                // TODO: render these as chips on your form if you have a container for them
            }
        });
    }

    private void createUIComponents() {
        if (postBtn == null)   postBtn   = new RoundedButton("Post",   30, Color.decode("#59A5D8"), Color.WHITE);
        if (cancelBtn == null) cancelBtn = new RoundedButton("Cancel", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (pointsBtn == null) pointsBtn = new RoundedButton("",       30, Color.decode("#59A5D8"), Color.WHITE);

        if (tagsButton == null) {
            tagsButton = new RoundedButton("Add tags", 30, Color.decode("#F5F5F5"), Color.decode("#333333"));
            tagsButton.setEnabled(false); // enabled by topic selection
        }

        // Topic selector
        topicComboBox = new RoundedComboBox<>(20);
        topicComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "Select topic…", "Education", "Travel", "Movies & TV", "Games", "Foods", "Music"
        }));
        topicComboBox.setPreferredSize(new Dimension(160, 36));
        topicComboBox.setMaximumSize(topicComboBox.getPreferredSize());
        topicComboBox.setEditable(false);

        if (anonymousComboBox == null) anonymousComboBox = new RoundedComboBox<>(20);
        if (titleTextField == null)     titleTextField = new RoundedTextField(35);

        if (bodyTextArea == null) {
            bodyTextArea = new RoundedTextArea(35);
            bodyTextArea.setBackground(Color.WHITE);
            bodyTextArea.setForeground(Color.BLACK);
            bodyTextArea.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(0xCCCCCC), 10, true),
                    BorderFactory.createEmptyBorder(8, 10, 8, 10)
            ));
        }

        bodyScrollPane = new JScrollPane(bodyTextArea);
        bodyScrollPane.setBorder(BorderFactory.createEmptyBorder());
        bodyScrollPane.setViewportBorder(null);
        bodyScrollPane.setOpaque(false);
        bodyScrollPane.getViewport().setOpaque(false);
        bodyScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        try { createPostPanel.setBackground(Color.WHITE); } catch (Exception ignored) {}
    }
}
