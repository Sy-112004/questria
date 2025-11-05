package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminMoviesTvPage {
    public static void main(String[] args) {
        AdminMoviesTvPage adminMoviesTvPage = new AdminMoviesTvPage();
        adminMoviesTvPage.getAdminMoviesTvPageFrame();

    }

    public JFrame getAdminMoviesTvPageFrame(){
        JFrame adminMoviesTvPageFrame = new JFrame();
        adminMoviesTvPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        adminMoviesTvPageFrame.pack();

        adminMoviesTvPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = adminMoviesTvPageFrame.getWidth();
        int height = adminMoviesTvPageFrame.getHeight();

        adminHeader adminHeaderPanel = new adminHeader();
        adminHeaderPanel.getAdminHeaderPanel().setBounds(0,0,width,123);

        adminSideBar adminSideBarPanel = new adminSideBar();
        adminSideBarPanel.getAdminSideBarPanel().setBounds(0,123,280,height - 123);

        moviesTv moviesTvPanel = new moviesTv();
        moviesTvPanel.getMoviesTvPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        adminMoviesTvPageFrame.setLayout(null);
        adminMoviesTvPageFrame.setTitle("Questria: Admin Movies TV Page Frame");
        adminMoviesTvPageFrame.setResizable(true);

        adminMoviesTvPageFrame.add(adminHeaderPanel.getAdminHeaderPanel());
        adminMoviesTvPageFrame.add(adminSideBarPanel.getAdminSideBarPanel());
        adminMoviesTvPageFrame.add(moviesTvPanel.getMoviesTvPanel());
        adminMoviesTvPageFrame.add(postPanel.getPostPanel());

        adminMoviesTvPageFrame.setVisible(true);
        return adminMoviesTvPageFrame;



    }
}
