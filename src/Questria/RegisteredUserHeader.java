package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserHeader {
    private JPanel RegisteredUserHeaderPanel;
    private JLabel questriaLbl;
    private JTextField searchTextField;
    private JLabel searchLbl;
    private JButton postBtn;
    private JLabel profileLbl;

    ImageIcon searchIcon = new ImageIcon(new ImageIcon("assets/search.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));
    public JPanel getRegisteredUserHeaderPanel() {
        searchLbl.setIcon(searchIcon);
        profileLbl.setIcon(profileIcon);
        return RegisteredUserHeaderPanel;
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here


        if(postBtn == null) postBtn = new JButton("Log In");
        postBtn = new RoundedButton("Log In", 50,Color.decode("#59A5D8"), Color.WHITE);

        if ( searchTextField == null) searchTextField = new RoundedTextField(50);
//        textField1.setBackground(Color.decode("#59A5D8"));
        searchTextField.setBackground(Color.decode("#DEE8FE"));
//        searchTextField1.setBackground(Color.WHITE);
        searchTextField.setForeground(Color.BLACK);
    }
}
