package Questria;

import javax.swing.*;
import java.awt.*;

public class Music {
    private JPanel musicPanel;
    private JLabel musicLbl;
    private JButton followMusicButton;

    ImageIcon musicIcon = new ImageIcon(new ImageIcon("assets/music.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));

    public JPanel getMusicPanel() {
        musicLbl.setIcon(musicIcon);
        return musicPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        followMusicButton = new RoundedButton("",30, Color.decode("#59A5D8"),Color.WHITE);

    }
}
