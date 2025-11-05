package Questria;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

public class GuestFoodsPage {
    public static void main(String[] args) {
        GuestFoodsPage guestFoodsPage = new GuestFoodsPage();
        guestFoodsPage.getGuestFoodsPageFrame();

    }
    public JFrame getGuestFoodsPageFrame(){
        JFrame guestFoodsPageFrame = new JFrame();
        guestFoodsPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestFoodsPageFrame.pack();

        guestFoodsPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestFoodsPageFrame.getWidth();
        int height = guestFoodsPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,280,height - 123);

        Foods foodsPanel = new Foods();
        foodsPanel.getFoodsPanel().setBounds(280,130, width - 280, 190);
        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        guestFoodsPageFrame.setLayout(null);
        guestFoodsPageFrame.setTitle("Questria: GuestGamesTopicPageFrame");
        guestFoodsPageFrame.setResizable(true);

        guestFoodsPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestFoodsPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestFoodsPageFrame.add(foodsPanel.getFoodsPanel());
        guestFoodsPageFrame.add(postPanel.getPostPanel());

        guestFoodsPageFrame.setVisible(true);
        return guestFoodsPageFrame;

    }
}
