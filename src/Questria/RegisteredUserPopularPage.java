package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserPopularPage {
    public static void main(String[] args) {
        RegisteredUserPopularPage registeredUserPopularPage = new RegisteredUserPopularPage();
        registeredUserPopularPage.getRegisteredUserPopularPageFrame();
    }
    public JFrame getRegisteredUserPopularPageFrame(){
        JFrame registeredUserPopularPageFrame = new JFrame();
        registeredUserPopularPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserPopularPageFrame.pack();

        registeredUserPopularPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserPopularPageFrame.getWidth();
        int height = registeredUserPopularPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        PopularFilter popularFilterPanel = new PopularFilter();
        popularFilterPanel.getPopularFilterPanel().setBounds(305,130,width - 305, 50);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,175,width -300,125);

        registeredUserPopularPageFrame.setLayout(null);
        registeredUserPopularPageFrame.setTitle("Questria : Registered User Popular Page");
        registeredUserPopularPageFrame.setResizable(true);

        registeredUserPopularPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserPopularPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserPopularPageFrame.add(popularFilterPanel.getPopularFilterPanel());
        registeredUserPopularPageFrame.add(postPanel.getPostPanel());

        registeredUserPopularPageFrame.setVisible(true);

        return registeredUserPopularPageFrame;
    }
}
