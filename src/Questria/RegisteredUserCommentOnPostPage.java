package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserCommentOnPostPage {
    public static void main(String[] args) {
        RegisteredUserCommentOnPostPage registeredUserCommentOnPostPage = new RegisteredUserCommentOnPostPage();
        registeredUserCommentOnPostPage.getRegisteredUserCommentOnPostPageFrame();

    }

    public JFrame getRegisteredUserCommentOnPostPageFrame(){
        JFrame registeredUserCommentOnPostPageFrame = new JFrame();
        registeredUserCommentOnPostPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserCommentOnPostPageFrame.pack();

        registeredUserCommentOnPostPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserCommentOnPostPageFrame.getWidth();
        int height = registeredUserCommentOnPostPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        CommentOnPost commentOnPostPanel = new CommentOnPost();
        commentOnPostPanel.getCommentOnPostPanel().setBounds(300,425,1050,200);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,623,width - 260,150);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(295,773, width - 270, 130);

        registeredUserCommentOnPostPageFrame.setLayout(null);
        registeredUserCommentOnPostPageFrame.setTitle("Questria : Registered User Comment on Post Page");
        registeredUserCommentOnPostPageFrame.setResizable(false);

        registeredUserCommentOnPostPageFrame.add(viewPostPanel.getViewPostPanel());
        registeredUserCommentOnPostPageFrame.add(commentPanel.getCommentPanel());
        registeredUserCommentOnPostPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserCommentOnPostPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserCommentOnPostPageFrame.add(commentOnPostPanel.getCommentOnPostPanel());
        registeredUserCommentOnPostPageFrame.add(replyPanel.getReplyPanel());
        registeredUserCommentOnPostPageFrame.setVisible(true);

        return registeredUserCommentOnPostPageFrame;

    }
}
