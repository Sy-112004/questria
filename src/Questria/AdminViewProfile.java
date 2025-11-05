package Questria;

import javax.swing.*;
import java.awt.*;

public class AdminViewProfile {
    private JPanel adminViewProfilePanel;
    private JLabel profileLbl;
    private JLabel usernameLbl;

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT));
    ImageIcon editIcon = new ImageIcon(new ImageIcon("assets/edit.png").getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH));

    public JPanel getAdminViewProfilePanel() {
        profileLbl.setIcon(profileIcon);
        usernameLbl.setIcon(editIcon);

        usernameLbl.setIcon(editIcon);
        usernameLbl.setHorizontalTextPosition(SwingConstants.LEFT); // text is left of icon -> icon appears right
        usernameLbl.setIconTextGap(6);// spacing between text and icon

        return adminViewProfilePanel;
    }
}
