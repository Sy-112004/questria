package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserReplyOnCommentPage {
    public static void main(String[] args) {
        RegisteredUserReplyOnCommentPage registeredUserReplyOnCommentPage = new RegisteredUserReplyOnCommentPage();
        registeredUserReplyOnCommentPage.getRegisteredUserReplyOnCommentPageFrame();
    }

    public JFrame getRegisteredUserReplyOnCommentPageFrame(){
        JFrame registeredUserReplyOnCommentPageFrame = new JFrame();
        registeredUserReplyOnCommentPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserReplyOnCommentPageFrame.pack();

        registeredUserReplyOnCommentPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserReplyOnCommentPageFrame.getWidth();
        int height = registeredUserReplyOnCommentPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,422,width - 260,150);

        ReplyOnComment replyOnCommentPanel = new ReplyOnComment();
        replyOnCommentPanel.getReplyOnCommentPanel().setBounds(350,573,900,200);

        registeredUserReplyOnCommentPageFrame.setLayout(null);
        registeredUserReplyOnCommentPageFrame.setTitle("Questria : Registered User Reply on Comment Page");
        registeredUserReplyOnCommentPageFrame.setResizable(true);

        registeredUserReplyOnCommentPageFrame.add(viewPostPanel.getViewPostPanel());
        registeredUserReplyOnCommentPageFrame.add(commentPanel.getCommentPanel());
        registeredUserReplyOnCommentPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserReplyOnCommentPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserReplyOnCommentPageFrame.add(replyOnCommentPanel.getReplyOnCommentPanel());
//        registeredUserReplyOnCommentPageFrame.add(replyPanel.getReplyPanel());
        registeredUserReplyOnCommentPageFrame.setVisible(true);

        return registeredUserReplyOnCommentPageFrame;


    }
}
