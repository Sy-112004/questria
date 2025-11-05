package Questria;

import javax.swing.*;
import java.awt.*;

public class EditPostPage {
    public static void main(String[] args) {
        EditPostPage editPostPage = new EditPostPage();
        editPostPage.getEditPostPageFrame();

    }

    public JFrame getEditPostPageFrame(){
        JFrame editPostPageFrame = new JFrame();
        editPostPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        editPostPageFrame.pack();

        editPostPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = editPostPageFrame.getWidth();
        int height = editPostPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 300, height - 123);

        EditPost editPostPanel = new EditPost();
        editPostPanel.getEditPostPanel().setBounds(300,123,width -300,height -123);

        editPostPageFrame.setLayout(null);
        editPostPageFrame.setTitle("Questria: editPostPageFrame");
        editPostPageFrame.setResizable(true);

        editPostPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        editPostPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        editPostPageFrame.add(editPostPanel.getEditPostPanel());

        editPostPageFrame.setVisible(true);
        return editPostPageFrame;
    }
}
