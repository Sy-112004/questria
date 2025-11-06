package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewProfile {
    private JPanel viewProfilePanel;
    private JLabel profileLbl;
    private JButton postBtn;
    private JButton commentsButton;
    private JLabel usernameLbl;
    private JButton upvotedBtn;
    private JButton downvotedBtn;
    private JLabel pointsLbl;
    private JLabel badgeLbl;

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT));
    ImageIcon editIcon = new ImageIcon(new ImageIcon("assets/edit.png").getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH));
    ImageIcon badgeSilverIcon = new ImageIcon(new ImageIcon("assets/badge_silver.png").getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH));

    PageBuilder pageBuilder = new PageBuilder();

//    public ViewProfile() {
//        postBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pageBuilder.showRegisteredUserViewProfile();
//            }
//        });
//        commentsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pageBuilder.showRegisteredUserViewProfileCommentsPage();
//            }
//        });
//        upvotedBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pageBuilder.showRegisteredUserViewProfileUpvotedPage();
//            }
//        });
//        downvotedBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pageBuilder.showRegisteredUserViewProfileDownvotedPage();
//            }
//        });
//    }

    public JPanel getViewProfilePanel() {
        profileLbl.setIcon(profileIcon);
        usernameLbl.setIcon(editIcon);
        badgeLbl.setIcon(badgeSilverIcon);

        usernameLbl.setIcon(editIcon);
        usernameLbl.setHorizontalTextPosition(SwingConstants.LEFT); // text is left of icon -> icon appears right
        usernameLbl.setIconTextGap(6);// spacing between text and icon

        return viewProfilePanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (postBtn == null) postBtn = new RoundedButton("Post", 45, Color.decode("#C1C1C1"), Color.WHITE);
        if (commentsButton == null) commentsButton = new RoundedButton("Comments", 45, Color.decode("#C1C1C1"), Color.WHITE);
        if (upvotedBtn == null) upvotedBtn = new RoundedButton("Upvoted", 45, Color.decode("#C1C1C1"), Color.WHITE);
        if (downvotedBtn == null) downvotedBtn = new RoundedButton("Downvoted", 45, Color.decode("#C1C1C1"), Color.WHITE);

    }
}
