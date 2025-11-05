package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserCreatePostPage {
    public static void main(String[] args) {
        RegisteredUserCreatePostPage registeredUserCreatePostPage = new RegisteredUserCreatePostPage();
        registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame();
    }

    public JFrame getRegisteredUserCreatePostPageFrame(){
        JFrame registeredUserCreatePostPageFrame = new JFrame();
        registeredUserCreatePostPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserCreatePostPageFrame.pack();

        registeredUserCreatePostPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserCreatePostPageFrame.getWidth();
        int height = registeredUserCreatePostPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        CreatePost createPostPanel = new CreatePost();
        createPostPanel.getCreatePostPanel().setBounds(300,123,width - 300, height -123);

        registeredUserCreatePostPageFrame.setLayout(null);
        registeredUserCreatePostPageFrame.setTitle("Questria: registeredUserCreatePostPageFrame");
        registeredUserCreatePostPageFrame.setResizable(false);

        registeredUserCreatePostPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserCreatePostPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserCreatePostPageFrame.add(createPostPanel.getCreatePostPanel());

        registeredUserCreatePostPageFrame.setVisible(true);
        return registeredUserCreatePostPageFrame;
    }
}
