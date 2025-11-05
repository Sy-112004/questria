package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminReportsCommentsPage {
    public static void main(String[] args) {
        AdminReportsCommentsPage adminReportsCommentsPage = new AdminReportsCommentsPage();
        adminReportsCommentsPage.getAdminReportsCommentsPageFrame();
    }

    public JFrame getAdminReportsCommentsPageFrame(){
        JFrame adminReportsCommentsPageFrame = new JFrame();
        adminReportsCommentsPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminReportsCommentsPageFrame.pack();

        adminReportsCommentsPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminReportsCommentsPageFrame.getWidth();
        int height = adminReportsCommentsPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        adminReportsBtn adminReportsBtnPanel = new adminReportsBtn();
        adminReportsBtnPanel.getAdminReportsBtnPanel().setBounds(285,130,1050,70);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,200,width - 260,140);

        adminReportsCommentsPageFrame.setLayout(null);
        adminReportsCommentsPageFrame.setTitle("Questria : Admin Reports Comments Page");
        adminReportsCommentsPageFrame.setResizable(false);

        adminReportsCommentsPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminReportsCommentsPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminReportsCommentsPageFrame.add(adminReportsBtnPanel.getAdminReportsBtnPanel());
        adminReportsCommentsPageFrame.add(commentPanel.getCommentPanel());

        adminReportsCommentsPageFrame.setVisible(true);

        return adminReportsCommentsPageFrame;

    }
}
