package Questria;

import javax.swing.*;
import java.awt.*;

public class LandingPageElement {
    private JPanel LandingPageElementPanel;
    private JLabel imageLbl;

    ImageIcon elementImage = new ImageIcon(new ImageIcon("assets/element.png").getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT));

    public JPanel getLandingPageElement() {
        imageLbl.setIcon(elementImage);
        return LandingPageElementPanel;
    }
}
