package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserViewProfileDownvotedPage {
    public static void main(String[] args) {
        RegisteredUserViewProfileDownvotedPage registeredUserViewProfileDownvotedPage = new RegisteredUserViewProfileDownvotedPage();
        registeredUserViewProfileDownvotedPage.getRegisteredUserViewProfileDownvotedPageFrame();
    }

    public JFrame getRegisteredUserViewProfileDownvotedPageFrame(){
        JFrame registeredUserViewProfileDownvotedPageFrame = new JFrame();
        registeredUserViewProfileDownvotedPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserViewProfileDownvotedPageFrame.pack();

        registeredUserViewProfileDownvotedPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserViewProfileDownvotedPageFrame.getWidth();
        int height = registeredUserViewProfileDownvotedPageFrame.getHeight();

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

        registeredUserViewProfileDownvotedPageFrame.setLayout(null);
        registeredUserViewProfileDownvotedPageFrame.setTitle("Questria : registeredUserViewProfileDownvotedPageFrame");
        registeredUserViewProfileDownvotedPageFrame.setResizable(true);

        registeredUserViewProfileDownvotedPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserViewProfileDownvotedPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserViewProfileDownvotedPageFrame.add(viewProfilePanel.getViewProfilePanel());
        registeredUserViewProfileDownvotedPageFrame.add(postPanel.getPostPanel());
        registeredUserViewProfileDownvotedPageFrame.add(commentPanel.getCommentPanel());
        registeredUserViewProfileDownvotedPageFrame.add(replyPanel.getReplyPanel());

        registeredUserViewProfileDownvotedPageFrame.setVisible(true);

        return registeredUserViewProfileDownvotedPageFrame;
    }



}
