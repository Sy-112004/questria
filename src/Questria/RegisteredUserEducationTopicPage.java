package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserEducationTopicPage {
    public static void main(String[] args) {
        RegisteredUserEducationTopicPage registeredUserEducationTopicPage = new RegisteredUserEducationTopicPage();
        registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame();
    }

    public JFrame getRegisteredUserEducationTopicPageFrame(){
        JFrame registeredEducationTopicPageFrame = new JFrame();
        registeredEducationTopicPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredEducationTopicPageFrame.pack();

        registeredEducationTopicPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredEducationTopicPageFrame.getWidth();
        int height = registeredEducationTopicPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        Education educationPanel = new Education();
        educationPanel.getEducationPanel().setBounds(300,130, width - 300, 190);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,310,width -300,125);

        registeredEducationTopicPageFrame.setLayout(null);
        registeredEducationTopicPageFrame.setTitle("Questria: registeredEducationTopicPageFrame");
        registeredEducationTopicPageFrame.setResizable(true);

        registeredEducationTopicPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredEducationTopicPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredEducationTopicPageFrame.add(educationPanel.getEducationPanel());
        registeredEducationTopicPageFrame.add(postPanel.getPostPanel());

        registeredEducationTopicPageFrame.setVisible(true);
        return registeredEducationTopicPageFrame;

    }
}
