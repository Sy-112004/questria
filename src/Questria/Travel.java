package Questria;

import javax.swing.*;
import java.awt.*;

public class Travel {
    private JPanel travelPanel;
    private JLabel travelLbl;
    private JButton followTravelBtn;

    ImageIcon travelIcon = new ImageIcon(new ImageIcon("assets/travel.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

    public JPanel getTravelPanel(){
        travelLbl.setIcon(travelIcon);
        return travelPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        followTravelBtn = new RoundedButton("",30, Color.decode("#59A5D8"),Color.WHITE);

    }
}
