package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogIn {
    private JPanel logInPanel;
    private JButton logInButton;
    private JPanel logInDetailsPanel;
    private JLabel emailLbl;
    private JTextField emailTextField;
    private JTextField usernameTextField;
    private JLabel passLbl;
    private JPasswordField passwordField;
    private JLabel signupLbl;

    PageBuilder pageBuilder = new PageBuilder();

    public LogIn() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageBuilder.showFollowTopicPage();
            }
        });
        signupLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pageBuilder.showSignUpPage();
            }
        });
    }

    public JPanel getLogInPanel() {
        return logInPanel;
    }

    public JPanel getLogInDetailsPanel() {
        return logInDetailsPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


        if (logInDetailsPanel == null) {
            logInDetailsPanel = new RoundedPanel(30, Color.WHITE, Color.BLACK, 2, true);
            logInDetailsPanel.setLayout(new GridBagLayout());
            logInDetailsPanel.setBorder(null);

            Dimension detailsSize = new Dimension(900, 240);
            logInDetailsPanel.setPreferredSize(detailsSize);
            logInDetailsPanel.setMaximumSize(detailsSize);
        }

        // Button
        if (logInButton == null) {
            logInButton = new RoundedButton("Log In", 60, Color.decode("#59A5D8"), Color.WHITE);
            logInButton.setPreferredSize(new Dimension(300, 50));
        }

        // Email text field
        if (emailTextField == null) {
            emailTextField = new RoundedTextField(40);
            emailTextField.setBackground(Color.decode("#59A5D8"));
            emailTextField.setForeground(Color.WHITE);
            emailTextField.setCaretColor(Color.WHITE);
        }

        // Username text field (if present in form)
        if (usernameTextField == null) {
            // if the form has a usernameTextField placeholder, keep it null so Designer creates it;
            // otherwise create a custom one:
            usernameTextField = new RoundedTextField(40);
            usernameTextField.setBackground(Color.decode("#59A5D8"));
            usernameTextField.setForeground(Color.WHITE);
            usernameTextField.setCaretColor(Color.WHITE);
        }

        // Password field - create it only if not already created by the Designer
        if (passwordField == null) {
            // choose whichever look you want; here we use the light gray background + medium border
            passwordField = new RoundedPasswordField(40, new Color(0xE6E6E6), new Color(0xB4B4B4));
            passwordField.setForeground(Color.BLACK);
            passwordField.setCaretColor(Color.BLACK);
        }



//        logInDetailsPanel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
//        logInDetailsPanel.setLayout(new java.awt.GridBagLayout());
//
//        // increase border thickness to 8
//        ((RoundedPanel) logInDetailsPanel).setBorderThickness(5);
//
//        // optional refresh
//        logInDetailsPanel.revalidate();
//        logInDetailsPanel.repaint();
//
//        if (logInButton == null) logInButton = new JButton("Log In");
//        logInButton = new RoundedButton("Sign Up", 28, Color.decode("#59A5D8"), Color.WHITE);
//        logInButton.setPreferredSize(new Dimension(200, 50));
//
//        if (emailTextField == null) emailTextField = new RoundedTextField(45);
//        emailTextField.setBackground(Color.decode("#59A5D8"));
//        emailTextField.setForeground(Color.BLACK);
//
//        if (passwordField == null) {
//            passwordField = new RoundedPasswordField(45); // radius 20
//            passwordField.setPreferredSize(new Dimension(600, 28)); // adjust as needed
//            passwordField.setBackground(Color.WHITE); // fill color
//            passwordField.setForeground(Color.BLACK);
        }



    }

