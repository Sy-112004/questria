package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestTravelPage {
    public static void main(String[] args) {
        GuestTravelPage guestTravelPage = new GuestTravelPage();
        guestTravelPage.getGuestTravelPageFrame();
    }

    public JFrame getGuestTravelPageFrame(){
        JFrame guestTravelPageFrame = new JFrame();
        guestTravelPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestTravelPageFrame.pack();

        guestTravelPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestTravelPageFrame.getWidth();
        int height = guestTravelPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,300,height - 123);

        Travel travelPanel = new Travel();
        travelPanel.getTravelPanel().setBounds(300,130,width - 300, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,310,width -300,125);

        guestTravelPageFrame.setLayout(null);
        guestTravelPageFrame.setTitle("Questria: GuestTravelTopicPageFrame");
        guestTravelPageFrame.setResizable(true);

        guestTravelPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestTravelPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestTravelPageFrame.add(travelPanel.getTravelPanel());
        guestTravelPageFrame.add(postPanel.getPostPanel());

        guestTravelPageFrame.setVisible(true);
        return guestTravelPageFrame;

    }
}
