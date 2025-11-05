package Questria;

import javax.swing.*;
import java.awt.*;

public class GuestViewPostPage {
    public static void main(String[] args) {
        GuestViewPostPage guestViewPostPage = new GuestViewPostPage();
        guestViewPostPage.getGuestViewPostPageFrame();

    }
    public JFrame getGuestViewPostPageFrame(){
        JFrame guestViewPostPage = new JFrame();
        guestViewPostPage.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        guestViewPostPage.pack();

        guestViewPostPage.getContentPane().setBackground(Color.WHITE);

        int width = guestViewPostPage.getWidth();
        int height = guestViewPostPage.getHeight();

        GuestSideBar guestSideBarPanel = new GuestSideBar();
        guestSideBarPanel.getGuestSideBarPanel().setBounds(0, 123, 280, height - 123);

        GuestHeader guestHeaderPanel = new GuestHeader();
        guestHeaderPanel.getGuestHeaderPanel().setBounds(0, 0, width, 123);

        ViewPost viewPostPanel = new ViewPost();
        viewPostPanel.getViewPostPanel().setBounds(290,125,width - 260,300);

        comment commentPanel = new comment();
        commentPanel.getCommentPanel().setBounds(280,422,width - 260,150);

        reply replyPanel = new reply();
        replyPanel.getReplyPanel().setBounds(295,573, width - 270, 130);
//        view viewPanel = new view();
//        viewPanel.getViewPanel().setBounds(250,123 ,width - 260,350);



        guestViewPostPage.setLayout(null);
        guestViewPostPage.setTitle("Questria : Guest View Post Page");
        guestViewPostPage.setResizable(false);

        guestViewPostPage.add(viewPostPanel.getViewPostPanel());
//        guestViewPostPage.add(viewPostPanel.getViewPostPanel());
        guestViewPostPage.add(commentPanel.getCommentPanel());
        guestViewPostPage.add(guestHeaderPanel.getGuestHeaderPanel());
        guestViewPostPage.add(guestSideBarPanel.getGuestSideBarPanel());
        guestViewPostPage.add(replyPanel.getReplyPanel());
        guestViewPostPage.setVisible(true);

        return guestViewPostPage;



    }
}
