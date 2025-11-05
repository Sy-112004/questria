package Questria;

import javax.swing.*;
import java.awt.*;

public class LandingPageLogIn {
    private JPanel LandingPageLogInPanel;
    private JButton signUpButton;
    private JButton logInButton;
    private JLabel questriaLbl;

    public JPanel getLandingPageLogInPanel() {
        return LandingPageLogInPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        if (signUpButton == null) signUpButton = new JButton("Sign Up");

        signUpButton = new RoundedButton("Sign Up",70, Color.decode("#59A5D8"), Color.WHITE);

        if(logInButton == null) logInButton = new JButton("Log In");
        logInButton = new RoundedButton("Log In", 70,Color.decode("#E6E6E6"), Color.WHITE);
    }
}
