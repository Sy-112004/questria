package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminMusicPage {
    public static void main(String[] args) {
        AdminMusicPage adminMusicPage = new AdminMusicPage();
        adminMusicPage.getAdminMusicPageFrame();

    }

    public JFrame getAdminMusicPageFrame(){
        JFrame adminMusicPageFrame = new JFrame();
        adminMusicPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminMusicPageFrame.pack();

        adminMusicPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminMusicPageFrame.getWidth();
        int height = adminMusicPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        Music musicPanel = new Music();
        musicPanel.getMusicPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        adminMusicPageFrame.setLayout(null);
        adminMusicPageFrame.setTitle("Questria: AdminMusicPageFrame");
        adminMusicPageFrame.setResizable(false);

        adminMusicPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminMusicPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminMusicPageFrame.add(musicPanel.getMusicPanel());
        adminMusicPageFrame.add(postPanel.getPostPanel());

        adminMusicPageFrame.setVisible(true);
        return adminMusicPageFrame;
    }
}
