package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestEducationTopicPage {
    public static void main(String[] args) {
        GuestEducationTopicPage guestEducationTopicPageFrame = new GuestEducationTopicPage();
        guestEducationTopicPageFrame.getGuestEducationTopicPage();

    }
    public JFrame getGuestEducationTopicPage(){
        JFrame guestEducationTopicPageFrame = new JFrame();
        guestEducationTopicPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestEducationTopicPageFrame.pack();

        guestEducationTopicPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = guestEducationTopicPageFrame.getWidth();
        int height = guestEducationTopicPageFrame.getHeight();

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0,0,width,123);

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0,123,280,height - 123);

        Education educationPanel = new Education();
        educationPanel.getEducationPanel().setBounds(280,130, width - 280, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(280,310,width -280,125);

        guestEducationTopicPageFrame.setLayout(null);
        guestEducationTopicPageFrame.setTitle("Questria : Guest Popular Page");
        guestEducationTopicPageFrame.setResizable(true);

        guestEducationTopicPageFrame.add(guestHeaderPanel.getGuestHeaderPanel());
        guestEducationTopicPageFrame.add(guestSideBarPanel.getGuestSideBarPanel());
        guestEducationTopicPageFrame.add(educationPanel.getEducationPanel());
        guestEducationTopicPageFrame.add(postPanel.getPostPanel());

        guestEducationTopicPageFrame.setVisible(true);

        return guestEducationTopicPageFrame;
    }
}
