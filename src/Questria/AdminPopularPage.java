package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminPopularPage {
    public static void main(String[] args) {
        AdminPopularPage adminPopularPage = new AdminPopularPage();
        adminPopularPage.getAdminPopularPageFrame();

    }

    public JFrame getAdminPopularPageFrame(){
        JFrame adminPopularPageFrame = new JFrame();
        adminPopularPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminPopularPageFrame.pack();

        adminPopularPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminPopularPageFrame.getWidth();
        int height = adminPopularPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        PopularFilter popularFilterPanel = new PopularFilter();
        popularFilterPanel.getPopularFilterPanel().setBounds(285,130,width - 305, 50);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,175,width - 280,125);

        adminPopularPageFrame.setLayout(null);
        adminPopularPageFrame.setTitle("Questria : Admin Popular Page");
        adminPopularPageFrame.setResizable(false);

        adminPopularPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminPopularPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminPopularPageFrame.add(popularFilterPanel.getPopularFilterPanel());
        adminPopularPageFrame.add(postPanel.getPostPanel());

        adminPopularPageFrame.setVisible(true);
        return adminPopularPageFrame;

    }
}
