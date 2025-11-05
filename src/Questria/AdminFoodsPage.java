package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminFoodsPage {
    public static void main(String[] args) {
        AdminFoodsPage adminFoodsPage = new AdminFoodsPage();
        adminFoodsPage.getAdminFoodsPageFrame();

    }

    public JFrame getAdminFoodsPageFrame(){
        JFrame adminFoodsPageFrame = new JFrame();
        adminFoodsPageFrame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        adminFoodsPageFrame.pack();

        adminFoodsPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminFoodsPageFrame.getWidth();
        int height = adminFoodsPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        Foods foodsPanel = new Foods();
        foodsPanel.getFoodsPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        adminFoodsPageFrame.setLayout(null);
        adminFoodsPageFrame.setTitle("Questria: AdminFoodsTopicPageFrame");
        adminFoodsPageFrame.setResizable(true);

        adminFoodsPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminFoodsPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminFoodsPageFrame.add(foodsPanel.getFoodsPanel());
        adminFoodsPageFrame.add(postPanel.getPostPanel());

        adminFoodsPageFrame.setVisible(true);
        return adminFoodsPageFrame;

    }
}
