package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserEditCommentPage {
    public static void main(String[] args) {
        RegisteredUserEditCommentPage registeredUserEditCommentPage = new RegisteredUserEditCommentPage();
        registeredUserEditCommentPage.getRegisteredUserEditCommentPageFrame();

    }

    public JFrame getRegisteredUserEditCommentPageFrame(){
        JFrame registeredUserEditCommentPageFrame = new JFrame();
        registeredUserEditCommentPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserEditCommentPageFrame.pack();

        registeredUserEditCommentPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserEditCommentPageFrame.getWidth();
        int height = registeredUserEditCommentPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        editComment editCommentPanel = new editComment();
        editCommentPanel.getEditCommentPanel().setBounds(300,425,1050,200);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(295,630, width - 270, 130);


        registeredUserEditCommentPageFrame.setLayout(null);
        registeredUserEditCommentPageFrame.setTitle("Questria : Registered User Comment on Post Page");
        registeredUserEditCommentPageFrame.setResizable(false);

        registeredUserEditCommentPageFrame.add(viewPostPanel.getViewPostPanel());
        registeredUserEditCommentPageFrame.add(editCommentPanel.getEditCommentPanel());
        registeredUserEditCommentPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserEditCommentPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
//        registeredUserEditCommentPageFrame.add(commentOnPostPanel.getCommentOnPostPanel());
        registeredUserEditCommentPageFrame.add(replyPanel.getReplyPanel());
        registeredUserEditCommentPageFrame.setVisible(true);

        return registeredUserEditCommentPageFrame;
    }
}
