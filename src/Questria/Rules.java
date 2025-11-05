package Questria;

import javax.swing.*;
import java.awt.*;

public class Rules {
    private JPanel rulesPanel;
    private JPanel rule1Panel;
    private JPanel rule2Panel;
    private JLabel rule2ImageLbl;
    private JPanel rule3Panel;
    private JLabel rule3ImageLbl;
    private JLabel rule1ImageLbl;
    private JPanel rule4Panel;
    private JTextPane rememberTheHumanBehindTextPane;
    private JLabel rule4ImageLbl;
    private JLabel rule5ImageLbl;
    private JLabel rule6ImageLbl;
    private JLabel rule7iamgeLbl;
    private JLabel rule8ImageLbl;
    private JPanel rule5Panel;
    private JPanel rule6Panel;
    private JPanel rule7Panel;
    private JPanel rule8Panel;

//    ImageIcon

    public JPanel getRulesPanel() {
        return rulesPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        rule1Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule1Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule1Panel).setBorderThickness(0);

        rule1Panel.revalidate();
        rule1Panel.repaint();

        rule2Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule2Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule2Panel).setBorderThickness(0);

        rule2Panel.revalidate();
        rule2Panel.repaint();

        rule3Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule3Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule3Panel).setBorderThickness(0);

        rule3Panel.revalidate();
        rule3Panel.repaint();

        rule4Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule4Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule4Panel).setBorderThickness(0);

        rule4Panel.revalidate();
        rule4Panel.repaint();

        rule5Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule5Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule5Panel).setBorderThickness(0);

        rule5Panel.revalidate();
        rule5Panel.repaint();

        rule6Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule6Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule6Panel).setBorderThickness(0);

        rule6Panel.revalidate();
        rule6Panel.repaint();

        rule7Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule7Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule7Panel).setBorderThickness(0);

        rule7Panel.revalidate();
        rule7Panel.repaint();

        rule8Panel = new RoundedPanel(45, Color.WHITE, Color.BLACK, 3, true);
        rule8Panel.setLayout(new java.awt.GridBagLayout());

        ((RoundedPanel) rule8Panel).setBorderThickness(0);

        rule8Panel.revalidate();
        rule8Panel.repaint();



    }
}
