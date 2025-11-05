package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestGamesPage {
    public static void main(String[] args) {
        GuestGamesPage guestGamesPage = new GuestGamesPage();
        guestGamesPage.getGuestGamesPageFrame();
    }
    public JFrame getGuestGamesPageFrame(){
        JFrame guestGamesPageFrame = new JFrame();
        guestGamesPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestGamesPageFrame.pack();

        guestGamesPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestGamesPageFrame.getWidth();
        int height = guestGamesPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,280,height - 123);

        Games gamesPanel = new Games();
        gamesPanel.getGamesPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        guestGamesPageFrame.setLayout(null);
        guestGamesPageFrame.setTitle("Questria: GuestGamesTopicPageFrame");
        guestGamesPageFrame.setResizable(true);

        guestGamesPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestGamesPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestGamesPageFrame.add(gamesPanel.getGamesPanel());
        guestGamesPageFrame.add(postPanel.getPostPanel());

        guestGamesPageFrame.setVisible(true);
        return guestGamesPageFrame;
    }
}
