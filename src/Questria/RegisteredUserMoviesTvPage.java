package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserMoviesTvPage {
    public static void main(String[] args) {
        RegisteredUserMoviesTvPage registeredUserMoviesTvPage = new RegisteredUserMoviesTvPage();
        registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame();
    }
    public JFrame getRegisteredUserMoviesTvPageFrame(){
        JFrame registeredUserMoviesTvPageFrame = new JFrame();
        registeredUserMoviesTvPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserMoviesTvPageFrame.pack();

        registeredUserMoviesTvPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserMoviesTvPageFrame.getWidth();
        int height = registeredUserMoviesTvPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        moviesTv moviesTvPanel = new moviesTv();
        moviesTvPanel.getMoviesTvPanel().setBounds(300,130,width - 300, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,310,width -300,125);

        registeredUserMoviesTvPageFrame.setLayout(null);
        registeredUserMoviesTvPageFrame.setTitle("Questria: GuestTravelTopicPageFrame");
        registeredUserMoviesTvPageFrame.setResizable(true);

        registeredUserMoviesTvPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserMoviesTvPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserMoviesTvPageFrame.add(moviesTvPanel.getMoviesTvPanel());
        registeredUserMoviesTvPageFrame.add(postPanel.getPostPanel());

        registeredUserMoviesTvPageFrame.setVisible(true);
        return registeredUserMoviesTvPageFrame;
    }
}
