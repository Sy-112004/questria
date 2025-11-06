package Questria;

import Questria.PopUp.EducationTagsPopup;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePost {
    private JPanel createPostPanel;
    private JLabel backLbl;
    private JLabel profileLbl;
    private JButton pointsBtn;
    private JComboBox anonymousComboBox;
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
    private JComboBox topicComboBox;

    ImageIcon backIcon = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon imageUploadIcon = new ImageIcon(new ImageIcon("assets/picture.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon fileUploadIcon = new ImageIcon(new ImageIcon("assets/file.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon mediaUploadIcon = new ImageIcon(new ImageIcon("assets/video.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public JPanel getCreatePostPanel(){
        backLbl.setIcon(backIcon);
        profileLbl.setIcon(profileIcon);
        imageUploadLbl.setIcon(imageUploadIcon);
        fileUploadLbl.setIcon(fileUploadIcon);
        mediaUploadLbl.setIcon(mediaUploadIcon);

        // Add listeners after panel is created
        setupListeners();

        return createPostPanel;
    }

    // NEW METHOD: Setup listeners for ComboBox and Button
    private void setupListeners() {
        // ComboBox listener - enable tagsButton only when Education is selected
        topicComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTopic = (String) topicComboBox.getSelectedItem();
                tagsButton.setEnabled("Education".equals(selectedTopic));
            }
        });

        // Tags button listener - show popup when clicked
        tagsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTopic = (String) topicComboBox.getSelectedItem();
                if ("Education".equals(selectedTopic)) {
                    // Get parent frame
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(createPostPanel);

                    // Show popup
                    EducationTagsPopup popup = new EducationTagsPopup(parentFrame);
                    popup.setVisible(true);

                    // Get selected tags after popup closes
                    java.util.List<String> tags = popup.getSelectedTags();
                    if (!tags.isEmpty()) {
                        System.out.println("Selected tags: " + tags);
                        // You can store these tags or display them somewhere
                    }
                }
            }
        });
    }

    private void createUIComponents() {
        // ... your existing code ...

        if (postBtn == null) postBtn = new RoundedButton("Post", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (cancelBtn == null) cancelBtn = new RoundedButton("Cancel", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (pointsBtn == null) pointsBtn = new RoundedButton("", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (tagsButton == null) {
            tagsButton = new RoundedButton("Add tags", 30, Color.decode("#F5F5F5"), Color.decode("#333333"));
            tagsButton.setEnabled(false); // Initially disabled
        }

        topicComboBox = new RoundedComboBox<>(20);
        if (anonymousComboBox == null){ anonymousComboBox = new RoundedComboBox<>(20);}
        if (topicComboBox == null) topicComboBox = new RoundedComboBox<>(20);

        topicComboBox.setPreferredSize(new Dimension(140, 36));
        topicComboBox.setMaximumSize(topicComboBox.getPreferredSize());
        topicComboBox.setEditable(false);

        if (titleTextField == null) {
            titleTextField = new RoundedTextField(35);
        }

        if(bodyTextArea == null){
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

        try {
            createPostPanel.setBackground(Color.WHITE);
        } catch (Exception ignored) {}
    }
}