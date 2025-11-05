package Questria;

import javax.swing.*;
import java.awt.*;

public class Games {
    private JPanel gamesPanel;
    private JLabel gamesLbl;
    private JButton followGamesButton;

    ImageIcon gamesIcon = new ImageIcon(new ImageIcon("assets/games.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

    public JPanel getGamesPanel() {
        gamesLbl.setIcon(gamesIcon);
        return gamesPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        followGamesButton = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);

    }
}
