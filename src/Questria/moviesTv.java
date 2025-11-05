package Questria;

import javax.swing.*;
import java.awt.*;

public class moviesTv {
    private JPanel moviesTvPanel;
    private JLabel moviesTvLbl;
    private JButton followMoviesTvButton;

    ImageIcon moviesTvIcon = new ImageIcon(new ImageIcon("assets/movies.png").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));

    public JPanel getMoviesTvPanel() {
        moviesTvLbl.setIcon(moviesTvIcon);
        return moviesTvPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        followMoviesTvButton = new RoundedButton("",30, Color.decode("#59A5D8"),Color.WHITE);

    }
}
