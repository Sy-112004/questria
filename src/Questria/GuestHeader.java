package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestHeader {

    private JPanel GuestHeaderPanel;
    private JTextField searchTextField1;
    private JButton signupBtn;
    private JButton logInButton;
    private JLabel questriaLbl;
    private JLabel searchLbl;

    ImageIcon searchIcon = new ImageIcon(new ImageIcon("assets/search.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    PageBuilder pageBuilder = new PageBuilder();
    public GuestHeader() {
        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageBuilder.showSignUpPage();
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageBuilder.showLogInPage();
            }
        });
    }

    public JPanel getGuestHeaderPanel() {
        searchLbl.setIcon(searchIcon);
        return GuestHeaderPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (signupBtn == null) signupBtn = new JButton("Sign Up");

        signupBtn = new RoundedButton("Sign Up",50, Color.decode("#F5F5F5"), Color.WHITE);

        if(logInButton == null) logInButton = new JButton("Log In");
        logInButton = new RoundedButton("Log In", 50,Color.decode("#59A5D8"), Color.WHITE);

        if ( searchTextField1 == null) searchTextField1 = new RoundedTextField(50);
//        textField1.setBackground(Color.decode("#59A5D8"));
        searchTextField1.setBackground(Color.decode("#DEE8FE"));
//        searchTextField1.setBackground(Color.WHITE);
        searchTextField1.setForeground(Color.BLACK);
    }
}
