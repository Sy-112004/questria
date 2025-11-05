package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserSideBar {
    private JPanel RegisteredUserSideBarPanel;
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
    private JButton bookmarkBtn;
    private JButton logOutBtn;

    ImageIcon homeIcon = new ImageIcon(new ImageIcon("assets/home.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
    ImageIcon popularIcon = new ImageIcon(new ImageIcon("assets/popular.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    ImageIcon bookmarkIcon = new ImageIcon(new ImageIcon ("assets/bookmark.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    ImageIcon logoutIcon = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));

    public JPanel getRegisteredUserSideBarPanel() {
        homeBtn.setIcon(homeIcon);
        popularBtn.setIcon(popularIcon);
        bookmarkBtn.setIcon(bookmarkIcon);
        logOutBtn.setIcon(logoutIcon);
        return RegisteredUserSideBarPanel;
    }
}
