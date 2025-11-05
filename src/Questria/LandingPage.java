package Questria;

import javax.swing.*;
import java.awt.*;

public class LandingPage {
    public static void main(String[]args) {
        LandingPage landingPage = new LandingPage();
        landingPage.getLandingPageFrame();
    }

        public JFrame getLandingPageFrame(){
            JFrame landingPageFrame = new JFrame();
            landingPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
            landingPageFrame.pack();

            int width = landingPageFrame.getContentPane().getWidth();
            int height = landingPageFrame.getContentPane().getHeight();

            LandingPageHeader landingPageHeaderPanel = new LandingPageHeader();
            landingPageHeaderPanel.getLandingPageHeaderPanel().setBounds(0,0,width, 123);

            LandingPageLogIn landingPageLogInPanel = new LandingPageLogIn();
            landingPageLogInPanel.getLandingPageLogInPanel().setBounds(0,123, width/2,height-123);

            LandingPageElement landingPageElementPanel = new LandingPageElement();
            landingPageElementPanel.getLandingPageElement().setBounds((width/2-1),123,width/2, height -123);


            landingPageFrame.setLayout(null);
            landingPageFrame.setTitle("QUESTRIA : LandingPage");
            landingPageFrame.setResizable(false);
            landingPageFrame.setVisible(true);

            landingPageFrame.add(landingPageHeaderPanel.getLandingPageHeaderPanel());
            landingPageFrame.add(landingPageLogInPanel.getLandingPageLogInPanel());
            landingPageFrame.add(landingPageElementPanel.getLandingPageElement());
            return landingPageFrame;
        }
    }

