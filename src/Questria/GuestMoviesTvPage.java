package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestMoviesTvPage {
    public static void main(String[] args) {
        GuestMoviesTvPage guestMoviesTvPage = new GuestMoviesTvPage();
        guestMoviesTvPage.getGuestMoviesTvPageFrame();
    }
    public JFrame getGuestMoviesTvPageFrame(){
        JFrame guestMoviesTvPageFrame = new JFrame();
        guestMoviesTvPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestMoviesTvPageFrame.pack();

        guestMoviesTvPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestMoviesTvPageFrame.getWidth();
        int height = guestMoviesTvPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,280,height - 123);

        moviesTv moviesTvPanel = new moviesTv();
        moviesTvPanel.getMoviesTvPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        guestMoviesTvPageFrame.setLayout(null);
        guestMoviesTvPageFrame.setTitle("Questria: GuestTravelTopicPageFrame");
        guestMoviesTvPageFrame.setResizable(true);

        guestMoviesTvPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestMoviesTvPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestMoviesTvPageFrame.add(moviesTvPanel.getMoviesTvPanel());
        guestMoviesTvPageFrame.add(postPanel.getPostPanel());

        guestMoviesTvPageFrame.setVisible(true);
        return guestMoviesTvPageFrame;
    }
}
