package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserFoodsPage {
    public static void main(String[] args) {
        RegisteredUserGamesPage registeredUserGamesPage = new RegisteredUserGamesPage();
        registeredUserGamesPage.getRegisteredUserGamesPageFrame();
    }

    public JFrame getRegisteredUserFoodsPageFrame(){
        JFrame registeredUserFoodsPageFrame = new JFrame();
        registeredUserFoodsPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserFoodsPageFrame.pack();

        registeredUserFoodsPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserFoodsPageFrame.getWidth();
        int height = registeredUserFoodsPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        Foods foodsPanel = new Foods();
        foodsPanel.getFoodsPanel().setBounds(300,130,width - 300, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,310,width -300,125);

        registeredUserFoodsPageFrame.setLayout(null);
        registeredUserFoodsPageFrame.setTitle("Questria: registeredUserFoodsPageFrame");
        registeredUserFoodsPageFrame.setResizable(true);

        registeredUserFoodsPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserFoodsPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserFoodsPageFrame.add(foodsPanel.getFoodsPanel());
        registeredUserFoodsPageFrame.add(postPanel.getPostPanel());

        registeredUserFoodsPageFrame.setVisible(true);
        return registeredUserFoodsPageFrame;


    }
}
