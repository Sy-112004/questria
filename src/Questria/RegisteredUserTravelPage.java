package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserTravelPage {
    public static void main(String[] args) {
        RegisteredUserTravelPage registeredUserTravelPage = new RegisteredUserTravelPage();
        registeredUserTravelPage.getRegisteredUserTravelPageFrame();

    }

    public JFrame getRegisteredUserTravelPageFrame(){
        JFrame registeredUserTravelPageFrame = new JFrame();
        registeredUserTravelPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserTravelPageFrame.pack();

        registeredUserTravelPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserTravelPageFrame.getWidth();
        int height = registeredUserTravelPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        Travel travelPanel = new Travel();
        travelPanel.getTravelPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        registeredUserTravelPageFrame.setLayout(null);
        registeredUserTravelPageFrame.setTitle("Questria: registeredTravelTopicPageFrame");
        registeredUserTravelPageFrame.setResizable(true);

        registeredUserTravelPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserTravelPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserTravelPageFrame.add(travelPanel.getTravelPanel());
        registeredUserTravelPageFrame.add(postPanel.getPostPanel());

        registeredUserTravelPageFrame.setVisible(true);
        return registeredUserTravelPageFrame;
    }
}
