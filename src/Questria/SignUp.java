package Questria;

import javax.swing.*;
import java.awt.*;

public class SignUp {
    private JButton signUpButton;
    private JTextField emailTextField1;
    private JLabel emailLbl;
    private JLabel usernameLbl;
    private JTextField usernameTextField1;
    private JPasswordField confirmPasswordField;
    private JLabel passwordLbl;
    private JLabel confirmPassLbl;
    private JPanel signUpPanel;
    private JPanel signUpDetailsPanel;
    private JPasswordField passwordField;

    public JPanel getSignUpPagePanel() {
        return signUpPanel;
    }

    public JPanel getSignUpDetailsPanel() {
        return signUpDetailsPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        signUpDetailsPanel = new RoundedPanel(50, Color.WHITE);
        signUpDetailsPanel.setLayout(new java.awt.GridBagLayout());
//
//        // remove any rectangular border that the GUI designer might have set:
        signUpDetailsPanel.setBorder(null);
        signUpDetailsPanel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        signUpDetailsPanel.setLayout(new java.awt.GridBagLayout());
//
//        // increase border thickness to 8
        ((RoundedPanel) signUpDetailsPanel).setBorderThickness(5);
//
//        // optional refresh
        signUpDetailsPanel.revalidate();
        signUpDetailsPanel.repaint();


        if (emailTextField1 == null) emailTextField1 = new RoundedTextField(45);
        emailTextField1.setBackground(Color.decode("#59A5D8"));
        emailTextField1.setForeground(Color.BLACK);


        if (usernameTextField1 == null) usernameTextField1 = new RoundedTextField(45); // username field
        usernameTextField1.setBackground(Color.decode("#59A5D8"));
        usernameTextField1.setForeground(Color.BLACK);

        if (passwordField == null) {
            passwordField = new RoundedPasswordField(45); // radius 20
            passwordField.setPreferredSize(new Dimension(600, 28)); // adjust as needed
            passwordField.setBackground(Color.WHITE); // fill color
            passwordField.setForeground(Color.BLACK);
        }
        if (confirmPasswordField == null) {
            confirmPasswordField = new RoundedPasswordField(45);
            confirmPasswordField.setPreferredSize(new Dimension(600, 28));
            confirmPasswordField.setBackground(Color.WHITE);
            confirmPasswordField.setForeground(Color.BLACK);
        }
//        emailTextField1 = new RoundedTextField(40, new Color(230, 230, 230), new Color(180, 180, 180));
//        usernameTextField1 = new RoundedTextField(40, new Color(230, 230, 230), new Color(180, 180, 180));
        passwordField = new RoundedPasswordField(40, new Color(230, 230, 230), new Color(180, 180, 180));
        confirmPasswordField = new RoundedPasswordField(40, new Color(230, 230, 230), new Color(180, 180, 180));

        // Ensure button exists if it was custom-created
        if (signUpButton == null) signUpButton = new JButton("Sign Up");
        // Replace the Designer button with our custom rounded one:
        signUpButton = new RoundedButton("Sign Up", 60, Color.decode("#59A5D8"), Color.WHITE);

        // optional: change size if you want a wider pill
        signUpButton.setPreferredSize(new Dimension(300, 50));
    }
}
