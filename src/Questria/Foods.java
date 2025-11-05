package Questria;

import javax.swing.*;
import java.awt.*;

public class Foods {
    private JPanel foodsPanel;
    private JLabel foodsLbl;
    private JButton followFoodsButton;

    ImageIcon foodsIcon = new ImageIcon(new ImageIcon ("assets/food.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

    public JPanel getFoodsPanel() {
        foodsLbl.setIcon(foodsIcon);
        return foodsPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        followFoodsButton = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);

    }
}
