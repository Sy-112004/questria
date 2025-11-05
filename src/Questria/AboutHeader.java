package Questria;

import javax.swing.*;
import java.awt.*;

public class AboutHeader {
    private JPanel aboutHeaderPanel;
    private JLabel aboutQuestriaLbl;
    private JButton backBtn;

    ImageIcon backIcon = new ImageIcon(new ImageIcon("assets/exit.png").getImage().getScaledInstance(90,100, Image.SCALE_DEFAULT));

    public JPanel getAboutHeaderPanel() {
        backBtn.setIcon(backIcon);
        return aboutHeaderPanel;
    }
}
