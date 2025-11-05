package Questria;

import javax.swing.*;
import java.awt.*;

public class SignUpPage {
    public static void main(String[] args){

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getSignUpPage();

    }

    public JFrame getSignUpPage(){
        JFrame signUpPageFrame = new JFrame();
        signUpPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        signUpPageFrame.pack();

        int width = signUpPageFrame.getContentPane().getWidth();
        int height = signUpPageFrame.getContentPane().getHeight();

        LandingPageHeader landingPageHeaderPanel = new LandingPageHeader();
        landingPageHeaderPanel.getLandingPageHeaderPanel().setBounds(0,0,width,123);

        SignUp signUpPanel = new SignUp();
        signUpPanel.getSignUpPagePanel().setBounds(0,123,width,height-123);



        signUpPageFrame.setLayout(null);
        signUpPageFrame.setTitle("QUESTRIA : Sign Up");
        signUpPageFrame.setResizable(false);
        signUpPageFrame.setVisible(true);

        signUpPageFrame.add(landingPageHeaderPanel.getLandingPageHeaderPanel());
        signUpPageFrame.add(signUpPanel.getSignUpPagePanel());
        return signUpPageFrame;
    }

}
