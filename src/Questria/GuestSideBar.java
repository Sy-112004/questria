package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestSideBar {
    private JPanel GuestSideBarPanel;
    private JLabel MenuLbl;
    private JButton homeBtn;
    private JButton popularBtn;
    private JLabel topicsLbl;
    private JButton educationBtn;
    private JButton travelBtn;
    private JButton moviesTVBtn;
    private JButton gamesBtn;
    private JButton foodsDrinksBtn;
    private JButton musicBtn;

    ImageIcon homeIcon = new ImageIcon(new ImageIcon("assets/home.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
    ImageIcon popularIcon = new ImageIcon(new ImageIcon("assets/popular.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
//    ImageIcon educationIcon = new ImageIcon(new ImageIcon("assets/education.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
//    ImageIcon travelIcon = new ImageIcon(new ImageIcon("assets/travel.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
//    ImageIcon musicIcon = new ImageIcon(new ImageIcon("assets/music.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
//    ImageIcon moviesTVIcon = new ImageIcon(new ImageIcon("assets/movies.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
//    ImageIcon gamesIcon = new ImageIcon(new ImageIcon("assets/games.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
//    ImageIcon foodsDrinksIcon = new ImageIcon( new ImageIcon("assets/food.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));

    public JPanel getGuestSideBarPanel() {
        homeBtn.setIcon(homeIcon);
        popularBtn.setIcon(popularIcon);
//        educationBtn.setIcon(educationIcon);
//        travelBtn.setIcon(travelIcon);
//        musicBtn.setIcon(musicIcon);
//        moviesTVBtn.setIcon(moviesTVIcon);
//        gamesBtn.setIcon(gamesIcon);
//        foodsDrinksBtn.setIcon(foodsDrinksIcon);


        return GuestSideBarPanel;
    }
}
