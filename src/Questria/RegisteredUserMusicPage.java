package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserMusicPage {
    public static void main(String[] args) {
        RegisteredUserMusicPage registeredUserMusicPage = new RegisteredUserMusicPage();
        registeredUserMusicPage.getRegisteredUserMusicPageFrame();
    }

    public JFrame getRegisteredUserMusicPageFrame(){
        JFrame registeredUserMusicPageFrame = new JFrame();
        registeredUserMusicPageFrame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        registeredUserMusicPageFrame.pack();

        registeredUserMusicPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserMusicPageFrame.getWidth();
        int height = registeredUserMusicPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        Music musicPanel = new Music();
        musicPanel.getMusicPanel().setBounds(300,130,width - 300, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,310,width -300,125);

        registeredUserMusicPageFrame.setLayout(null);
        registeredUserMusicPageFrame.setTitle("Questria: registeredUserMusicPageFrame");
        registeredUserMusicPageFrame.setResizable(true);

        registeredUserMusicPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserMusicPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserMusicPageFrame.add(musicPanel.getMusicPanel());
        registeredUserMusicPageFrame.add(postPanel.getPostPanel());

        registeredUserMusicPageFrame.setVisible(true);
        return registeredUserMusicPageFrame;

    }
}
