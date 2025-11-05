package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserGamesPage {
    public static void main(String[] args) {
        RegisteredUserGamesPage registeredUserGamesPage = new RegisteredUserGamesPage();
        registeredUserGamesPage.getRegisteredUserGamesPageFrame();
    }
    public JFrame getRegisteredUserGamesPageFrame(){
        JFrame registeredUserGamesPageFrame = new JFrame();
        registeredUserGamesPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserGamesPageFrame.pack();

        registeredUserGamesPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserGamesPageFrame.getWidth();
        int height = registeredUserGamesPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        Games gamesPanel = new Games();
        gamesPanel.getGamesPanel().setBounds(300,120,width-300,190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,310,width -300,125);

        registeredUserGamesPageFrame.setLayout(null);
        registeredUserGamesPageFrame.setTitle("Questria: registeredGamesTopicPageFrame");
        registeredUserGamesPageFrame.setResizable(true);

        registeredUserGamesPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserGamesPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserGamesPageFrame.add(gamesPanel.getGamesPanel());
        registeredUserGamesPageFrame.add(postPanel.getPostPanel());

        registeredUserGamesPageFrame.setVisible(true);
        return registeredUserGamesPageFrame;
    }
}
