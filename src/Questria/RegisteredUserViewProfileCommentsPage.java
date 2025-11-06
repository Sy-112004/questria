package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserViewProfileCommentsPage {
    public static void main(String[] args) {
        RegisteredUserViewProfileCommentsPage registeredUserViewProfileCommentsPage = new RegisteredUserViewProfileCommentsPage();
        registeredUserViewProfileCommentsPage.getRegisteredUserViewProfileCommentsPageFrame();
    }

    public JFrame getRegisteredUserViewProfileCommentsPageFrame(){
        JFrame registeredUserViewProfileCommentsPageFrame = new JFrame();
        registeredUserViewProfileCommentsPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserViewProfileCommentsPageFrame.pack();

        registeredUserViewProfileCommentsPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserViewProfileCommentsPageFrame.getWidth();
        int height = registeredUserViewProfileCommentsPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewProfile viewProfilePanel = new ViewProfile();
        viewProfilePanel.getViewProfilePanel().setBounds(290, 125,1050,250);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,373,width - 260,150);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(280,573, width - 270, 130);

        registeredUserViewProfileCommentsPageFrame.setLayout(null);
        registeredUserViewProfileCommentsPageFrame.setTitle("Questria : registeredUserViewProfilePageFrame");
        registeredUserViewProfileCommentsPageFrame.setResizable(true);

        registeredUserViewProfileCommentsPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserViewProfileCommentsPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserViewProfileCommentsPageFrame.add(viewProfilePanel.getViewProfilePanel());
        registeredUserViewProfileCommentsPageFrame.add(commentPanel.getCommentPanel());
        registeredUserViewProfileCommentsPageFrame.add(replyPanel.getReplyPanel());

        registeredUserViewProfileCommentsPageFrame.setVisible(true);

        return registeredUserViewProfileCommentsPageFrame;
    }
}
