package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminReportsPage {
    public static void main(String[] args) {
        AdminReportsPage adminReportsPage = new AdminReportsPage();
        adminReportsPage.getAdminReportsPageFrame();

    }

    public JFrame getAdminReportsPageFrame(){
        JFrame adminReportsPageFrame = new JFrame();
        adminReportsPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminReportsPageFrame.pack();

        adminReportsPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminReportsPageFrame.getWidth();
        int height = adminReportsPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        adminReportsBtn adminReportsBtnPanel = new adminReportsBtn();
        adminReportsBtnPanel.getAdminReportsBtnPanel().setBounds(285,130,1050,70);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,190,width -300,125);

        adminReportsPageFrame.setLayout(null);
        adminReportsPageFrame.setTitle("Questria : Admin Reports Page");
        adminReportsPageFrame.setResizable(true);

        adminReportsPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminReportsPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminReportsPageFrame.add(adminReportsBtnPanel.getAdminReportsBtnPanel());
        adminReportsPageFrame.add(postPanel.getPostPanel());

        adminReportsPageFrame.setVisible(true);

        return adminReportsPageFrame;


    }
}
