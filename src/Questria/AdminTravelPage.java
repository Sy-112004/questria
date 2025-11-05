package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminTravelPage {
    public static void main(String[] args) {
        AdminTravelPage adminTravelPage = new AdminTravelPage();
        adminTravelPage.getAdminTravelPageFrame();

    }

    public JFrame getAdminTravelPageFrame(){
        JFrame adminTravelPageFrame = new JFrame();
        adminTravelPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminTravelPageFrame.pack();

        adminTravelPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminTravelPageFrame.getWidth();
        int height = adminTravelPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        Travel travelPanel = new Travel();
        travelPanel.getTravelPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        adminTravelPageFrame.setLayout(null);
        adminTravelPageFrame.setTitle("Questria: AdminTravelTopicPageFrame");
        adminTravelPageFrame.setResizable(true);

        adminTravelPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminTravelPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminTravelPageFrame.add(travelPanel.getTravelPanel());
        adminTravelPageFrame.add(postPanel.getPostPanel());

        adminTravelPageFrame.setVisible(true);
        return adminTravelPageFrame;
    }
}
