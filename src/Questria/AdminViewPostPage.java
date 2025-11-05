package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminViewPostPage {
    public static void main(String[] args) {
        AdminViewPostPage adminViewPostPage = new AdminViewPostPage();
        adminViewPostPage.getAdminViewPostPageFrame();
    }

    public JFrame getAdminViewPostPageFrame(){
        JFrame adminViewPostPageFrame = new JFrame();
        adminViewPostPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminViewPostPageFrame.pack();

        adminViewPostPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminViewPostPageFrame.getWidth();
        int height = adminViewPostPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,422,width - 260,150);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(295,573, width - 270, 130);

        adminViewPostPageFrame.setLayout(null);
        adminViewPostPageFrame.setTitle("Questria : Admin View Post Page");
        adminViewPostPageFrame.setResizable(false);

        adminViewPostPageFrame.add(viewPostPanel.getViewPostPanel());
        adminViewPostPageFrame.add(commentPanel.getCommentPanel());
        adminViewPostPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminViewPostPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminViewPostPageFrame.add(replyPanel.getReplyPanel());
        adminViewPostPageFrame.setVisible(true);

        return adminViewPostPageFrame;

    }
}
