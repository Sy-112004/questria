package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminViewProfilePage {
    public static void main(String[] args) {
        AdminViewProfilePage adminViewProfilePage = new AdminViewProfilePage();
        adminViewProfilePage.getAdminViewProfilePageFrame();

    }

    public JFrame getAdminViewProfilePageFrame(){
        JFrame adminViewProfilePageFrame = new JFrame();
        adminViewProfilePageFrame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        adminViewProfilePageFrame.pack();

        adminViewProfilePageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminViewProfilePageFrame.getWidth();
        int height = adminViewProfilePageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        AdminViewProfile adminViewProfilePanel = new AdminViewProfile();
        adminViewProfilePanel.getAdminViewProfilePanel().setBounds(290,125,1050, height - 123);

        adminViewProfilePageFrame.setLayout(null);
        adminViewProfilePageFrame.setTitle("Questria : Admin View Profile Page Frame");
        adminViewProfilePageFrame.setResizable(false);

        adminViewProfilePageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminViewProfilePageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminViewProfilePageFrame.add(adminViewProfilePanel.getAdminViewProfilePanel());

        adminViewProfilePageFrame.setVisible(true);

        return adminViewProfilePageFrame;

    }
}
