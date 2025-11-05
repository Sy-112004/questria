package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestHomepage {
    public static void main(String[] args) {
        GuestHomepage homepage = new GuestHomepage();
        homepage.getGuestHomePageFrame();
    }


    public JFrame getGuestHomePageFrame() {
            JFrame guestHomePageFrame = new JFrame();
            guestHomePageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
            guestHomePageFrame.pack();
//            guestHomePageFrame.setBackground(Color.white);
            guestHomePageFrame.getContentPane().setBackground(Color.WHITE);

            int width = guestHomePageFrame.getContentPane().getWidth();
            int height = guestHomePageFrame.getContentPane().getHeight();

//            GuestHomepage guestHomepagePanel = new GuestHomepage();
//            guestHomepagePanel.getGuestHomePageFrame().setBounds(0, 123, width, height - 123);

            GuestSideBar guestSideBarPanel = new GuestSideBar();
            guestSideBarPanel.getGuestSideBarPanel().setBounds(0, 123, 300, height - 123);

            GuestHeader guestHeaderPanel = new GuestHeader();
            guestHeaderPanel.getGuestHeaderPanel().setBounds(0, 0, width, 123);

            post postPanel = new post();
            postPanel.getPostPanel().setBounds(300,125,width -300,125);

//            post postPanel2 = new post();
//            postPanel2.getPostPanel().setBounds(300,246,width-300,125);
//
//            post postPanel3 = new post();
//            postPanel3.getPostPanel().setBounds(300,369,width-300,125);

            guestHomePageFrame.setLayout(null);
            guestHomePageFrame.setTitle("Questria : Guest HomePage");
            guestHomePageFrame.setResizable(false);



            guestHomePageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
            guestHomePageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
            guestHomePageFrame.add(postPanel.getPostPanel());
//            guestHomePageFrame.add(postPanel2.getPostPanel());
//            guestHomePageFrame.add(postPanel3.getPostPanel());
            guestHomePageFrame.setVisible(true);
            
            return guestHomePageFrame;
        }
    }


