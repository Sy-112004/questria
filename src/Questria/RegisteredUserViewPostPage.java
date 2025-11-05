package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserViewPostPage {
    public static void main(String[] args) {
        RegisteredUserViewPostPage registeredUserViewPostPage = new RegisteredUserViewPostPage();
        registeredUserViewPostPage.getRegisteredUserViewPostPageFrame();
    }

    public JFrame getRegisteredUserViewPostPageFrame(){
        JFrame registeredUserViewPostPage = new JFrame();
        registeredUserViewPostPage.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserViewPostPage.pack();

        registeredUserViewPostPage.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserViewPostPage.getWidth();
        int height = registeredUserViewPostPage.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,422,width - 260,150);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(295,573, width - 270, 130);

        registeredUserViewPostPage.setLayout(null);
        registeredUserViewPostPage.setTitle("Questria : Registered User View Post Page");
        registeredUserViewPostPage.setResizable(false);

        registeredUserViewPostPage.add(viewPostPanel.getViewPostPanel());
        registeredUserViewPostPage.add(commentPanel.getCommentPanel());
        registeredUserViewPostPage.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserViewPostPage.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserViewPostPage.add(replyPanel.getReplyPanel());
        registeredUserViewPostPage.setVisible(true);

        return registeredUserViewPostPage;
    }
}
