package Questria;

import javax.swing.*;
import java.awt.*;

public class Education {
    private JPanel educationPanel;
    private JLabel eduLbl;
    private JButton followEduButton;

    ImageIcon eduIcon = new ImageIcon(new ImageIcon("assets/education.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

    public JPanel getEducationPanel() {
        eduLbl.setIcon(eduIcon);
        return educationPanel;

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        followEduButton = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);

    }
}
