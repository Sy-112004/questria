package Questria;

import javax.swing.*;
import java.awt.*;

public class LogInPage {
    public static void main(String[] args) {
        LogInPage logInPage = new LogInPage();
        logInPage.getLogInPageFrame();
    }

    public JFrame getLogInPageFrame(){

        JFrame logInPageFrame = new JFrame();
        logInPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        logInPageFrame.pack();

        int width = logInPageFrame.getContentPane().getWidth();
        int height = logInPageFrame.getContentPane().getHeight();

        LandingPageHeader landingPageHeaderPanel = new LandingPageHeader();
        landingPageHeaderPanel.getLandingPageHeaderPanel().setBounds(0,0,width,123);

        LogIn logInPanel = new LogIn();
        logInPanel.getLogInPanel().setBounds(0,123,width,height -123);

        logInPageFrame.setLayout(null);
        logInPageFrame.setTitle("QUESTRIA : Log In");
        logInPageFrame.setResizable(false);
        logInPageFrame.setVisible(true);

        logInPageFrame.add(landingPageHeaderPanel.getLandingPageHeaderPanel());
        logInPageFrame.add(logInPanel.getLogInPanel());
        return logInPageFrame;
    }
}
