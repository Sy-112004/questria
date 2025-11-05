package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestPopularPage {
    public static void main(String[] args) {
        GuestPopularPage guestPopularPageFrame = new GuestPopularPage();
        guestPopularPageFrame.getGuestPopularPageFrame();

    }
    public JFrame getGuestPopularPageFrame(){
        JFrame guestPopularPageFrame = new JFrame();
        guestPopularPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestPopularPageFrame.pack();

        guestPopularPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestPopularPageFrame.getWidth();
        int height = guestPopularPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,300,height - 123);

        PopularFilter popularFilterPanel = new PopularFilter();
        popularFilterPanel.getPopularFilterPanel().setBounds(305,130,width - 305, 50);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,175,width -300,125);


        guestPopularPageFrame.setLayout(null);
        guestPopularPageFrame.setTitle("Questria : Guest Popular Page");
        guestPopularPageFrame.setResizable(true);

        guestPopularPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestPopularPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestPopularPageFrame.add(popularFilterPanel.getPopularFilterPanel());
        guestPopularPageFrame.add(postPanel.getPostPanel());

        guestPopularPageFrame.setVisible(true);
        return guestPopularPageFrame;
    }
}
