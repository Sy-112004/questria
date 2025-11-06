package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserViewProfileUpvotedPage {
    public static void main(String[] args) {
        RegisteredUserViewProfileUpvotedPage registeredUserViewProfileUpvotedPage = new RegisteredUserViewProfileUpvotedPage();
        registeredUserViewProfileUpvotedPage.getRegisteredUserViewProfileUpvotedPageFrame();
    }

    public JFrame getRegisteredUserViewProfileUpvotedPageFrame(){
        JFrame registeredUserViewProfileUpvotedPageFrame = new JFrame();
        registeredUserViewProfileUpvotedPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserViewProfileUpvotedPageFrame.pack();

        registeredUserViewProfileUpvotedPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserViewProfileUpvotedPageFrame.getWidth();
        int height = registeredUserViewProfileUpvotedPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewProfile viewProfilePanel = new ViewProfile();
        viewProfilePanel.getViewProfilePanel().setBounds(290, 125,1050,250);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,373, width - 280, 125 );

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,498,width - 260,150);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(280,648, width - 270, 130);

        registeredUserViewProfileUpvotedPageFrame.setLayout(null);
        registeredUserViewProfileUpvotedPageFrame.setTitle("Questria : registeredUserViewProfileUpvotedPageFrame");
        registeredUserViewProfileUpvotedPageFrame.setResizable(true);

        registeredUserViewProfileUpvotedPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserViewProfileUpvotedPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserViewProfileUpvotedPageFrame.add(viewProfilePanel.getViewProfilePanel());
        registeredUserViewProfileUpvotedPageFrame.add(postPanel.getPostPanel());
        registeredUserViewProfileUpvotedPageFrame.add(commentPanel.getCommentPanel());
        registeredUserViewProfileUpvotedPageFrame.add(replyPanel.getReplyPanel());

        registeredUserViewProfileUpvotedPageFrame.setVisible(true);

        return registeredUserViewProfileUpvotedPageFrame;

    }

}
