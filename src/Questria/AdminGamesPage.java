package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminGamesPage {
    public static void main(String[] args) {
        AdminGamesPage adminGamesPage = new AdminGamesPage();
        adminGamesPage.getAdminGamesPageFrame();

    }

    public JFrame getAdminGamesPageFrame(){
        JFrame adminGamesPageFrame = new JFrame();
        adminGamesPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminGamesPageFrame.pack();

        adminGamesPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminGamesPageFrame.getWidth();
        int height = adminGamesPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        Games gamesPanel = new Games();
        gamesPanel.getGamesPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        adminGamesPageFrame.setLayout(null);
        adminGamesPageFrame.setTitle("Questria: AdminGamesTopicPageFrame");
        adminGamesPageFrame.setResizable(false);

        adminGamesPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminGamesPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminGamesPageFrame.add(gamesPanel.getGamesPanel());
        adminGamesPageFrame.add(postPanel.getPostPanel());

        adminGamesPageFrame.setVisible(true);
        return adminGamesPageFrame;




    }
}
