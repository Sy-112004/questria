package Questria;

import javax.swing.*;
import java.awt.*;

public class editProfile {
    private JPanel editProfilePanel;
    private JLabel backLbl;
    private JLabel editProfileLbl;
    private JLabel profileLbl;
    private JLabel addPictureLbl;
    private JLabel usernameLbl;
    private JTextField usernameTextField;
    private JLabel passwordLbl;
    private JButton changePassBtn;
    private JPasswordField passTextField;

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT));
    ImageIcon backIcon = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));

    public JPanel getEditProfilePanel() {
        profileLbl.setIcon(profileIcon);
        backLbl.setIcon(backIcon);
        return editProfilePanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (changePassBtn == null) changePassBtn = new RoundedButton("Change Password", 30, Color.decode("#59A5D8"), Color.WHITE);

        if (usernameTextField == null) {
            usernameTextField = new RoundedTextField(35);
            usernameTextField.setEditable(false);
//            titleTextField.setBorder(new LineBorder(new Color(0xCCCCCC), 1, true)); // gray, 1px, rounded
        }

        if (passTextField == null) {
            passTextField = new RoundedPasswordField(35);
            passTextField.setEditable(false);
            passTextField.setBackground(Color.GRAY);
//            titleTextField.setBorder(new LineBorder(new Color(0xCCCCCC), 1, true)); // gray, 1px, rounded
        }

    }
}
