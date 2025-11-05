package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPageHeader {
    private JPanel LandingPageHeaderPanel;
    private JLabel questriaLbl;
    private JButton homeBtn;
    private JButton aboutButton;
    private JButton guestButton;
    private JTextField textField1;
    private JLabel searchLbl;

    PageBuilder pageBuilder = new PageBuilder();


//    ImageIcon searchIcon = new ImageIcon(new ImageIcon("assets/search.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT) );

    public LandingPageHeader() {
        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pageBuilder.showGuestHomePage();
            }
        });
    }

    public JPanel getLandingPageHeaderPanel() {
//        searchLbl.setIcon(searchIcon);
        return LandingPageHeaderPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
//        if (textField1 == null) textField1 = new RoundedTextField(40);
////        textField1.setBackground(Color.decode("#59A5D8"));
//        textField1.setBackground(Color.WHITE);
//        textField1.setForeground(Color.BLACK);
    }
}
