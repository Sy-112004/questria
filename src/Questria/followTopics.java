package Questria;

import javax.swing.*;
import java.awt.*;

public class followTopics {
    private JPanel followTopicsPanel;
    private JLabel chooseLbl;
    private JButton nextBtn;
    private JPanel eduTopicPanel;
    private JLabel eduLbl;
    private JButton followEduButton;
    private JPanel travelTopicPanel;
    private JLabel travelLbl;
    private JButton followTravelBtn;
    private JPanel moviesTVPanel;
    private JLabel moviesLbl;
    private JPanel gamesPanel;
    private JLabel gamesLbl;
    private JButton followGamesBtn;
    private JButton followMoviesBtn;
    private JLabel foodsLbl;
    private JButton followFoodBtn;
    private JPanel foodsPanel;
    private JLabel musicLbl;
    private JPanel musicPanel;
    private JButton followMusicBtn;

    ImageIcon nextIcon = new ImageIcon(new ImageIcon("assets/next.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
    ImageIcon eduIcon = new ImageIcon(new ImageIcon("assets/education.png").getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT));
    ImageIcon travelIcon = new ImageIcon(new ImageIcon("assets/travel.png").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
    ImageIcon gamesIcon = new ImageIcon(new ImageIcon("assets/games.png").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
    ImageIcon musicIcon = new ImageIcon(new ImageIcon("assets/music.png").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
    ImageIcon foodIcon = new ImageIcon(new ImageIcon("assets/food.png").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
    ImageIcon moviesIcon = new ImageIcon(new ImageIcon("assets/movies.png").getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));


    public JPanel getFollowTopicsPanel() {
        eduLbl.setIcon(eduIcon);
        travelLbl.setIcon(travelIcon);
        gamesLbl.setIcon(gamesIcon);
        musicLbl.setIcon(musicIcon);
        foodsLbl.setIcon(foodIcon);
        moviesLbl.setIcon(moviesIcon);
        nextBtn.setIcon(nextIcon);

        Dimension maxSize = new Dimension(800, Integer.MAX_VALUE);
        followTopicsPanel.setMaximumSize(maxSize);

        return followTopicsPanel;
    }

    public JPanel getEduTopicPanel() {
        eduLbl.setIcon(eduIcon);
        return eduTopicPanel;
    }

    public JPanel getTravelTopicPanel() {
        return travelTopicPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        eduTopicPanel = new RoundedPanel(30,Color.decode("#F5F5F5"), Color.gray, 0,false);
        eduTopicPanel.setLayout(new GridBagLayout());
        eduTopicPanel.setBorder(null);

        followEduButton = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);


        travelTopicPanel = new RoundedPanel(30,Color.decode("#F5F5F5"), Color.gray, 0,false);
        travelTopicPanel.setLayout(new GridBagLayout());
        travelTopicPanel.setBorder(null);

        followTravelBtn = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);


        moviesTVPanel = new RoundedPanel(30,Color.decode("#F5F5F5"), Color.gray, 0,false);
        moviesTVPanel.setLayout(new GridBagLayout());
        moviesTVPanel.setBorder(null);

        followMoviesBtn = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);


        foodsPanel = new RoundedPanel(30,Color.decode("#F5F5F5"), Color.gray, 0,false);
        foodsPanel.setLayout(new GridBagLayout());
        foodsPanel.setBorder(null);

        followFoodBtn = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);


        musicPanel = new RoundedPanel(30,Color.decode("#F5F5F5"), Color.gray, 0,false);
        musicPanel.setLayout(new GridBagLayout());
        musicPanel.setBorder(null);

        followMusicBtn = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);


        gamesPanel = new RoundedPanel(30,Color.decode("#F5F5F5"), Color.gray, 0,false);
        gamesPanel.setLayout(new GridBagLayout());
        gamesPanel.setBorder(null);

        followGamesBtn = new RoundedButton("",30,Color.decode("#59A5D8"),Color.WHITE);


    }
}
