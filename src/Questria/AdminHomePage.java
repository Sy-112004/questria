package Questria;

import Questria.PopUp.AdminPopupOnPost;

import javax.swing.*;
import java.awt.*;

public class AdminHomePage {
    public static void main(String[] args) {
        AdminHomePage adminHomePage = new AdminHomePage();
        adminHomePage.getAdminHomePageFrame();

    }

    public JFrame getAdminHomePageFrame(){
        JFrame adminHomePageFrame = new JFrame();
        adminHomePageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminHomePageFrame.pack();

        adminHomePageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminHomePageFrame.getWidth();
        int height = adminHomePageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);


        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,125,width - 285,125);


        adminHomePageFrame.setLayout(null);
        adminHomePageFrame.setTitle("Questria : Admin HomePage");
        adminHomePageFrame.setResizable(true);



        adminHomePageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminHomePageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminHomePageFrame.add(postPanel.getPostPanel());
//            guestHomePageFrame.add(postPanel2.getPostPanel());
//            guestHomePageFrame.add(postPanel3.getPostPanel());
        adminHomePageFrame.setVisible(true);

        return adminHomePageFrame;
    }
}
