package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestMusicPage {
    public static void main(String[] args) {
        GuestMusicPage guestMusicPage = new GuestMusicPage();
        guestMusicPage.getGuestMusicPageFrame();

    }

    public JFrame getGuestMusicPageFrame(){
        JFrame guestMusicPageFrame = new JFrame();
        guestMusicPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestMusicPageFrame.pack();

        guestMusicPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestMusicPageFrame.getWidth();
        int height = guestMusicPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,280,height - 123);

        Music musicPanel = new Music();
        musicPanel.getMusicPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        guestMusicPageFrame.setLayout(null);
        guestMusicPageFrame.setTitle("Questria: guestMusicPageFrame");
        guestMusicPageFrame.setResizable(true);

        guestMusicPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestMusicPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestMusicPageFrame.add(musicPanel.getMusicPanel());
        guestMusicPageFrame.add(postPanel.getPostPanel());

        guestMusicPageFrame.setVisible(true);
        return guestMusicPageFrame;
    }
}
