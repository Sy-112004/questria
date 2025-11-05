package Questria;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CreatePost1 {
    private JPanel createPost1Panel;
    private JLabel backLbl;
    private JLabel profileLbl;
    private JButton pointsBtn;
    private JComboBox anonymousComboBox;
    private JComboBox topicComboBox;
    private JTextField titleTextField;
    private JButton tagsButton;
    private JButton postBtn;
    private JButton cancelBtn;
    private JLabel fileUploadLbl;
    private JLabel mediaUploadLbl;
    private JLabel imageUploadLbl;
    private JScrollPane bodyScrollPane;
    private JTextArea bodyTextArea;

    ImageIcon backIcon = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon imageUploadIcon = new ImageIcon(new ImageIcon("assets/picture.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon fileUploadIcon = new ImageIcon(new ImageIcon("assets/file.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon mediaUploadIcon = new ImageIcon(new ImageIcon("assets/video.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public JPanel getCreatePost1Panel(){
        backLbl.setIcon(backIcon);
        profileLbl.setIcon(profileIcon);
        imageUploadLbl.setIcon(imageUploadIcon);
        fileUploadLbl.setIcon(fileUploadIcon);
        mediaUploadLbl.setIcon(mediaUploadIcon);
        return createPost1Panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (postBtn == null) postBtn = new RoundedButton("Post", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (cancelBtn == null) cancelBtn = new RoundedButton("Cancel", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (pointsBtn == null) pointsBtn = new RoundedButton("", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (tagsButton == null) tagsButton = new RoundedButton("", 30, Color.decode("#F5F5F5"), Color.WHITE);

        if (titleTextField == null) {
            titleTextField = new RoundedTextField(35);
//            titleTextField.setBorder(new LineBorder(new Color(0xCCCCCC), 1, true)); // gray, 1px, rounded
        }

        if (topicComboBox == null){
            topicComboBox = new RoundedComboBox<>(45);
        }

        if (anonymousComboBox == null ){
            anonymousComboBox = new RoundedComboBox<>(45);
        }

        if(bodyTextArea == null){
            bodyTextArea = new RoundedTextArea(35);
            bodyTextArea.setBackground(Color.WHITE); // or any color you want
            bodyTextArea.setForeground(Color.BLACK);
            bodyTextArea.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(0xCCCCCC), 1, true),
                    BorderFactory.createEmptyBorder(8, 10, 8, 10)
            ));
        }


        // put it in a scroll pane but remove the rectangular scrollpane border
        bodyScrollPane = new JScrollPane(bodyTextArea);
        bodyScrollPane.setBorder(BorderFactory.createEmptyBorder()); // no rectangular frame
        bodyScrollPane.setViewportBorder(null);
        bodyScrollPane.setOpaque(false);
        bodyScrollPane.getViewport().setOpaque(false);

        // if you want the scrollbars to be visible only when needed:
        bodyScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

    }
}
