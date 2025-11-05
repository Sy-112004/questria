package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserEditProfilePage {
    public static void main(String[] args) {
        RegisteredUserEditProfilePage registeredUserEditProfilePage = new RegisteredUserEditProfilePage();
        registeredUserEditProfilePage.getRegisteredUserEditProfilePageFrame();

    }

    public JFrame getRegisteredUserEditProfilePageFrame(){
        JFrame registeredUserEditProfilePageFrame = new JFrame();
        registeredUserEditProfilePageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserEditProfilePageFrame.pack();

        registeredUserEditProfilePageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserEditProfilePageFrame.getWidth();
        int height = registeredUserEditProfilePageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        editProfile editProfilePanel = new editProfile();
        editProfilePanel.getEditProfilePanel().setBounds(290,125,1050,height - 123);

        registeredUserEditProfilePageFrame.setLayout(null);
        registeredUserEditProfilePageFrame.setTitle("Questria : Registered User Edit Profile Page Frame");
        registeredUserEditProfilePageFrame.setResizable(true);

        registeredUserEditProfilePageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserEditProfilePageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserEditProfilePageFrame.add(editProfilePanel.getEditProfilePanel());

        registeredUserEditProfilePageFrame.setVisible(true);

        return registeredUserEditProfilePageFrame;
    }
}
