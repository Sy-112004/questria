package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserHomePage {
    public static void main(String[] args) {
        RegisteredUserHomePage registeredUserHomePage = new RegisteredUserHomePage();
        registeredUserHomePage.getRegisteredUserHomePageFrame();

    }
     public JFrame getRegisteredUserHomePageFrame(){

        JFrame registeredUserHomePageFrame = new JFrame();
        registeredUserHomePageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserHomePageFrame.pack();

        registeredUserHomePageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserHomePageFrame.getWidth();
        int height = registeredUserHomePageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

         RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
         registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

         UserHomeBtns userHomeBtnsPanel = new UserHomeBtns();
         userHomeBtnsPanel.getUserHomeBtnsPanel().setBounds(300,130,width-300,70);

         post postPanel = new post();
         postPanel.getPostPanel().setBounds(300,190,width -300,125);


         registeredUserHomePageFrame.setLayout(null);
         registeredUserHomePageFrame.setTitle("Questria : RegisteredUserHomePage");
         registeredUserHomePageFrame.setResizable(true);

         registeredUserHomePageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
         registeredUserHomePageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
         registeredUserHomePageFrame.add(userHomeBtnsPanel.getUserHomeBtnsPanel());
         registeredUserHomePageFrame.add(postPanel.getPostPanel());

         registeredUserHomePageFrame.setVisible(true);

         return registeredUserHomePageFrame;


     }

}
