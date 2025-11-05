package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserFollowingPage {
    public static void main(String[] args) {
        RegisteredUserFollowingPage registeredUserFollowingPage = new RegisteredUserFollowingPage();
        registeredUserFollowingPage.getRegisteredUserFollowingPageFrame();

    }
    public JFrame getRegisteredUserFollowingPageFrame(){
        JFrame registeredUserFollowingPageFrame = new JFrame();
        registeredUserFollowingPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserFollowingPageFrame.pack();

        registeredUserFollowingPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserFollowingPageFrame.getWidth();
        int height = registeredUserFollowingPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        UserHomeBtns userHomeBtnsPanel = new UserHomeBtns();
        userHomeBtnsPanel.getUserHomeBtnsPanel().setBounds(300,130,width-300,70);

        following followingPanel = new following();
        followingPanel.getFollowingPanel().setBounds(800,185,width-800,50);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,243,width -300,125);

        registeredUserFollowingPageFrame.setLayout(null);
        registeredUserFollowingPageFrame.setTitle("Questria : RegisteredUserFollowingPage");
        registeredUserFollowingPageFrame.setResizable(true);

        registeredUserFollowingPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserFollowingPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserFollowingPageFrame.add(followingPanel.getFollowingPanel());
        registeredUserFollowingPageFrame.add(userHomeBtnsPanel.getUserHomeBtnsPanel());
        registeredUserFollowingPageFrame.add(postPanel.getPostPanel());

        registeredUserFollowingPageFrame.setVisible(true);

        return registeredUserFollowingPageFrame;
    }
}
