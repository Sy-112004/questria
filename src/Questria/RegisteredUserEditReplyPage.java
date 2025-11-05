package Questria;

import javax.swing.*;
import java.awt.*;

public class RegisteredUserEditReplyPage {
    public static void main(String[] args) {
        RegisteredUserEditReplyPage registeredUserEditReplyPage = new RegisteredUserEditReplyPage();
        registeredUserEditReplyPage.getRegisteredUserEditReplyPageFrame();
    }

    public JFrame getRegisteredUserEditReplyPageFrame(){
        JFrame registeredUserEditReplyPageFrame = new JFrame();
        registeredUserEditReplyPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        registeredUserEditReplyPageFrame.pack();

        registeredUserEditReplyPageFrame.getContentPane().setBackground(Color.WHITE);

        int width = registeredUserEditReplyPageFrame.getWidth();
        int height = registeredUserEditReplyPageFrame.getHeight();

        RegisteredUserHeader registeredUserHeaderPanel = new RegisteredUserHeader();
        registeredUserHeaderPanel.getRegisteredUserHeaderPanel().setBounds(0,0,width,123);

        RegisteredUserSideBar registeredUserSideBarPanel = new RegisteredUserSideBar();
        registeredUserSideBarPanel.getRegisteredUserSideBarPanel().setBounds(0, 123, 280, height - 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,422,width - 260,150);

        editReply editReplyPanel = new editReply();
        editReplyPanel.getEditReplyPanel().setBounds(350,573,900,200);

        registeredUserEditReplyPageFrame.setLayout(null);
        registeredUserEditReplyPageFrame.setTitle("Questria : Registered User Edit Reply Page");
        registeredUserEditReplyPageFrame.setResizable(true);

        registeredUserEditReplyPageFrame.add(viewPostPanel.getViewPostPanel());
        registeredUserEditReplyPageFrame.add(editReplyPanel.getEditReplyPanel());
        registeredUserEditReplyPageFrame.add(registeredUserHeaderPanel.getRegisteredUserHeaderPanel());
        registeredUserEditReplyPageFrame.add(registeredUserSideBarPanel.getRegisteredUserSideBarPanel());
        registeredUserEditReplyPageFrame.add(commentPanel.getCommentPanel());
//        registeredUserEditReplyPageFrame.add(replyPanel.getReplyPanel());
        registeredUserEditReplyPageFrame.setVisible(true);

        return registeredUserEditReplyPageFrame;

    }
}
