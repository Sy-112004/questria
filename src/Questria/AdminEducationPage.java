package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminEducationPage {
    public static void main(String[] args) {
        AdminEducationPage adminEducationPage = new AdminEducationPage();
        adminEducationPage.getAdminEducationPageFrame();
    }

    public JFrame getAdminEducationPageFrame(){
        JFrame adminEducationPageFrame = new JFrame();
        adminEducationPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminEducationPageFrame.pack();

        adminEducationPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminEducationPageFrame.getWidth();
        int height = adminEducationPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        Education educationPanel = new Education();
        educationPanel.getEducationPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        adminEducationPageFrame.setLayout(null);
        adminEducationPageFrame.setTitle("Questria : admin education Page");
        adminEducationPageFrame.setResizable(true);

        adminEducationPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminEducationPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminEducationPageFrame.add(educationPanel.getEducationPanel());
        adminEducationPageFrame.add(postPanel.getPostPanel());

        adminEducationPageFrame.setVisible(true);

        return adminEducationPageFrame;

    }
}
