package Questria;

import javax.swing.*;
import java.awt.*;

public class following {
    private JPanel followingPanel;
    private JComboBox comboBox1;

    public JPanel getFollowingPanel() {
        return followingPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        comboBox1 = new RoundedComboBox<>(20); // 20px corner radius

        // add items
        comboBox1.addItem("Sort");
        comboBox1.addItem("Most recent");
        comboBox1.addItem("Top");
        comboBox1.addItem("By topic");

        // styling
        comboBox1.setBackground(Color.decode("#59A5D8"));      // your requested searchbar color
//        comboBox1.setForeground(Color.decode("#333333"));      // text color
        // set the rounded combo border color (method exists on RoundedComboBox)
        if (comboBox1 instanceof RoundedComboBox) {
            ((RoundedComboBox<?>) comboBox1).setBorderColor(Color.decode("#C1C1C1"));
            ((RoundedComboBox<?>) comboBox1).setBorderWidth(1);
        }

        // sizing (important when using BoxLayout or designer layouts that stretch components)
        comboBox1.setPreferredSize(new Dimension(140, 36));
        comboBox1.setMaximumSize(comboBox1.getPreferredSize());


    }
}

