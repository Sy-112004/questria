package Questria;

import javax.swing.*;
import java.awt.*;

public class PopularFilter {
    private JPanel popularFilterPanel;
    private JComboBox popularFilterComboBox;

    public JPanel getPopularFilterPanel() {
        return popularFilterPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        popularFilterComboBox = new RoundedComboBox<>(20); // 20px corner radius

        // add items
//        comboBox1.addItem("Sort");
//        comboBox1.addItem("Most recent");
//        comboBox1.addItem("Top");
//        comboBox1.addItem("By topic");

        // styling
        popularFilterComboBox.setBackground(Color.decode("#59A5D8"));      // your requested searchbar color
//        comboBox1.setForeground(Color.decode("#333333"));      // text color
        // set the rounded combo border color (method exists on RoundedComboBox)
//        if (popularFilterComboBox instanceof RoundedComboBox) {
//            ((RoundedComboBox<?>) popularFilterComboBox).setBorderColor(Color.decode("#C1C1C1"));
//            ((RoundedComboBox<?>) popularFilterComboBox).setBorderWidth(1);
//        }

        // sizing (important when using BoxLayout or designer layouts that stretch components)
        popularFilterComboBox.setPreferredSize(new Dimension(140, 36));
        popularFilterComboBox.setMaximumSize(popularFilterComboBox.getPreferredSize());
    }
}
