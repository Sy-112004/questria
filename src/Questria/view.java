package Questria;

import javax.swing.*;
import java.awt.*;

public class view {
    private JPanel viewPanel;
    private JLabel profileLbl;
    private JPanel pointsPanel;
    private JLabel pointsLbl;
    private JButton bookmarkBtn;
    private JLabel titleLbl;
    private JPanel tagsPanel;
    private JLabel tagsLbl;
    private JTextPane bodyTextPane;
    private JPanel votePanel;
    private JLabel upvoteImageLbl;
    private JLabel downvoteLbl;
    private JButton commentBtn;
//    private JLabel backLbl;
    private JButton moreBtn;
    private JLabel backLbl;
    private JLabel upvoteLbl;
    private JLabel timeLbl;
    private JLabel topicsLbl;

    ImageIcon backIcon = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon upvoteIcon = new ImageIcon(new ImageIcon("assets/upvote.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
    ImageIcon downvoteIcon = new ImageIcon(new ImageIcon("assets/downvote.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
    ImageIcon commentIcon = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon moreIcon = new ImageIcon( new ImageIcon("assets/more.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon bookmarkIcon = new ImageIcon(new ImageIcon("assets/bookmark.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));


    public JPanel getViewPanel() {
        profileLbl.setIcon(profileIcon);
        upvoteImageLbl.setIcon(upvoteIcon);
        downvoteLbl.setIcon(downvoteIcon);
        commentBtn.setIcon(commentIcon);
        moreBtn.setIcon(moreIcon);
        bookmarkBtn.setIcon(bookmarkIcon);
        backLbl.setIcon(backIcon);

        return viewPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        Color controlBorder = Color.decode("#59A5D8");
        tagsPanel = new RoundedPanel(30, Color.decode("#59A5D8"), controlBorder, 0, false);
        tagsPanel.setLayout(new GridBagLayout());
        tagsPanel.setBorder(null);
        tagsPanel.revalidate();
        tagsPanel.repaint();

        Color controlBorder1 = Color.decode("#C1C1C1");        // light gray border
        votePanel = new RoundedPanel(37, Color.decode("#F5F5F5"), controlBorder1, 2, false);
        votePanel.setLayout(new GridBagLayout());
        votePanel.setBorder(null);
        votePanel.revalidate();
        votePanel.repaint();

        if (commentBtn == null) commentBtn = new JButton();

        commentBtn = new RoundedButton("",37, Color.decode("#F5F5F5"), Color.WHITE);
        commentBtn.setBorderPainted(false);
//        commentBtn.setPreferredSize(new Dimension(25, 25));

        if (moreBtn == null) moreBtn = new JButton();

        moreBtn = new RoundedButton("",37, Color.decode("#F5F5F5"), Color.WHITE);

//        pointsPanel = new JPanel();
//        postPanel.setBorder(null);
//
        Color controlBorder2 = Color.decode("#59A5D8");
        pointsPanel = new RoundedPanel(15,Color.decode("#59A5D8"), controlBorder2,0, false);
        pointsPanel.setLayout(new GridBagLayout());
        pointsPanel.revalidate();
        pointsPanel.repaint();

        if (bookmarkBtn == null) bookmarkBtn = new JButton();

        bookmarkBtn = new RoundedButton("",37, Color.decode("#F5F5F5"), Color.WHITE);

    }

}
