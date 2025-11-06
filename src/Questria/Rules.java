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

    ImageIcon rule1Icon = new ImageIcon(new ImageIcon("assets/rule1.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule2Icon = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule3Icon = new ImageIcon(new ImageIcon("assets/lock.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule4Icon = new ImageIcon(new ImageIcon("assets/4.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule5Icon = new ImageIcon(new ImageIcon("assets/5.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule6Icon = new ImageIcon(new ImageIcon("assets/6.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule7Icon = new ImageIcon(new ImageIcon("assets/7.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    ImageIcon rule8Icon = new ImageIcon(new ImageIcon("assets/8.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));


    public JPanel getRulesPanel() {
        rule1ImageLbl.setIcon(rule1Icon);
        rule2ImageLbl.setIcon(rule2Icon);
        rule3ImageLbl.setIcon(rule3Icon);
        rule4ImageLbl.setIcon(rule4Icon);
        rule5ImageLbl.setIcon(rule5Icon);
        rule6ImageLbl.setIcon(rule6Icon);
        rule7iamgeLbl.setIcon(rule7Icon);
        rule8ImageLbl.setIcon(rule8Icon);

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

        Dimension ruleSize = new Dimension(320, 300);

        JPanel[] panels = {
                rule1Panel, rule2Panel, rule3Panel, rule4Panel,
                rule5Panel, rule6Panel, rule7Panel, rule8Panel
        };

        for (JPanel p : panels) {
            p.setPreferredSize(ruleSize);
            p.setMinimumSize(ruleSize);
            p.setMaximumSize(ruleSize);
        }

//        // if using a layout that respects preferred sizes (like FlowLayout/BoxLayout),
//        // call:
//        rulesPanel.revalidate();
//        rulesPanel.repaint();


    }
}
