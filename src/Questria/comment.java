package Questria;

import javax.swing.*;
import java.awt.*;

public class comment {
    private JPanel commentPanel;
    private JLabel profileLbl;
    private JTextPane commentTextPane;
    private JButton pickedCommentBtn;
    private JPanel votePanel;
    private JLabel upvoteImageLbl;
    private JLabel downvoteLbl;
    private JButton replyBtn;
    private JButton moreBtn;
    private JLabel upvoteLbl;

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
    ImageIcon upvoteIcon = new ImageIcon(new ImageIcon("assets/upvote.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
    ImageIcon downvoteIcon = new ImageIcon(new ImageIcon("assets/downvote.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
    ImageIcon replyIcon = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon moreIcon = new ImageIcon( new ImageIcon("assets/more.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon starIcon = new ImageIcon(new ImageIcon("assets/star.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public JPanel getCommentPanel() {
        profileLbl.setIcon(profileIcon);
        upvoteImageLbl.setIcon(upvoteIcon);
        downvoteLbl.setIcon(downvoteIcon);
        replyBtn.setIcon(replyIcon);
        moreBtn.setIcon(moreIcon);
        pickedCommentBtn.setIcon(starIcon);
        return commentPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (pickedCommentBtn == null) pickedCommentBtn = new JButton();

        pickedCommentBtn = new RoundedButton("you have picked this comment",37, Color.decode("#F5F5F5"), Color.WHITE);
        pickedCommentBtn.setBorderPainted(false);

        if (moreBtn == null) moreBtn = new JButton();

        moreBtn = new RoundedButton("",37, Color.decode("#F5F5F5"), Color.WHITE);

        Color controlBorder1 = Color.decode("#C1C1C1");        // light gray border
        votePanel = new RoundedPanel(37, Color.decode("#F5F5F5"), controlBorder1, 2, false);
        votePanel.setLayout(new GridBagLayout());
        votePanel.setBorder(null);
        votePanel.revalidate();
        votePanel.repaint();

        if (replyBtn == null) replyBtn = new JButton();

        replyBtn = new RoundedButton("",37, Color.decode("#F5F5F5"), Color.WHITE);
        replyBtn.setBorderPainted(false);

        commentTextPane = new JTextPane();
        commentTextPane.setEditable(false);
        commentTextPane.setForeground(Color.BLACK);

    }
}
