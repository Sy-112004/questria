package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserViewProfilePage {
    public static void main(String[] args) {
        RegisteredUserViewProfilePage registeredUserViewProfilePage = new RegisteredUserViewProfilePage();
        registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame();

    }

    public JFrame getRegisteredUserViewProfilePageFrame(){
        JFrame registeredUserViewProfilePageFrame = new JFrame();
        registeredUserViewProfilePageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserViewProfilePageFrame.pack();

        registeredUserViewProfilePageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserViewProfilePageFrame.getWidth();
        int height = registeredUserViewProfilePageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewProfile viewProfilePanel = new ViewProfile();
        viewProfilePanel.getViewProfilePanel().setBounds(290, 125,1050,250);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,373, width - 280, 125 );

        registeredUserViewProfilePageFrame.setLayout(null);
        registeredUserViewProfilePageFrame.setTitle("Questria : registeredUserViewProfilePageFrame");
        registeredUserViewProfilePageFrame.setResizable(true);

        registeredUserViewProfilePageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserViewProfilePageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserViewProfilePageFrame.add(viewProfilePanel.getViewProfilePanel());
        registeredUserViewProfilePageFrame.add(postPanel.getPostPanel());

        registeredUserViewProfilePageFrame.setVisible(true);

        return registeredUserViewProfilePageFrame;

    }
}
