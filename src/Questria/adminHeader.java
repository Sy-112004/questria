package Questria;

import javax.swing.*;
import java.awt.*;

public class adminHeader {
    private JPanel adminHeaderPanel;
    private JLabel questriaLbl;
    private JTextField searchTextField;
    private JLabel searchLbl;

    ImageIcon searchIcon = new ImageIcon(new ImageIcon("assets/search.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));

    public JPanel getAdminHeaderPanel() {
        searchLbl.setIcon(searchIcon);
        return adminHeaderPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if ( searchTextField == null) searchTextField = new RoundedTextField(50);
//        textField1.setBackground(Color.decode("#59A5D8"));
        searchTextField.setBackground(Color.decode("#DEE8FE"));
//        searchTextField1.setBackground(Color.WHITE);
        searchTextField.setForeground(Color.BLACK);
    }
}
