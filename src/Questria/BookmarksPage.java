package Questria;

import javax.swing.*;
import java.awt.*;

public class BookmarksPage {
    public static void main(String[] args) {
        BookmarksPage bookmarksPage = new BookmarksPage();
        bookmarksPage.getBookmarksPageFrame();
    }

    public JFrame getBookmarksPageFrame(){
        JFrame bookmarksPageFrame = new JFrame();
        bookmarksPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        bookmarksPageFrame.pack();

        bookmarksPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = bookmarksPageFrame.getWidth();
        int height = bookmarksPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        post postPanel = new post();
        postPanel.getPostPanel().setBounds(300,125,width -300,125);

        bookmarksPageFrame.setLayout(null);
        bookmarksPageFrame.setTitle("Questria: registeredEducationTopicPageFrame");
        bookmarksPageFrame.setResizable(true);

        bookmarksPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        bookmarksPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        bookmarksPageFrame.add(postPanel.getPostPanel());

        bookmarksPageFrame.setVisible(true);
        return bookmarksPageFrame;

    }

}
