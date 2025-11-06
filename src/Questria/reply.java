package Questria;

import Questria.PopUp.UserPopupCommentsOnOwnPost;

import javax.swing.*;
import java.awt.*;

public class reply {
    private JPanel replyPanel;
    private JLabel profileLbl;
    private JTextPane replyTextPane;
    private JPanel votePanel;
    private JLabel upvoteImageLbl;
    private JLabel downvoteLbl;
    private JLabel upvoteLbl;
    private JButton replyBtn;
    private JButton pickedCommentBtn;
    private JButton moreBtn;

    private boolean moreWired = false;

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
    ImageIcon upvoteIcon  = new ImageIcon(new ImageIcon("assets/upvote.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
    ImageIcon downvoteIcon= new ImageIcon(new ImageIcon("assets/downvote.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
    ImageIcon replyIcon   = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon moreIcon    = new ImageIcon(new ImageIcon("assets/more.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon starIcon    = new ImageIcon(new ImageIcon("assets/star.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public reply() {
        // constructor intentionally empty — listener is wired in getReplyPanel()
    }

    public JPanel getReplyPanel() {
        if (profileLbl != null)       profileLbl.setIcon(profileIcon);
        if (upvoteImageLbl != null)   upvoteImageLbl.setIcon(upvoteIcon);
        if (downvoteLbl != null)      downvoteLbl.setIcon(downvoteIcon);
        if (replyBtn != null)         replyBtn.setIcon(replyIcon);
        if (moreBtn != null)          moreBtn.setIcon(moreIcon);
        if (pickedCommentBtn != null) pickedCommentBtn.setIcon(starIcon);

        wireMoreBtnOnce(); // make sure the listener is attached to the actual button instance
        return replyPanel;
    }

    private void wireMoreBtnOnce() {
        if (moreWired || moreBtn == null) return;
        moreWired = true;

        moreBtn.addActionListener(evt -> {
            JPopupMenu pm = UserPopupCommentsOnOwnPost.build(
                    () -> System.out.println("Report this comment"),
                    () -> System.out.println("Delete this comment")
            );
            pm.show(moreBtn, 0, moreBtn.getHeight() + 6);
        });
    }

    /** Called by IntelliJ GUI Designer for custom-created components. */
    private void createUIComponents() {
        // Rounded containers/buttons you already use
        if (pickedCommentBtn == null) pickedCommentBtn = new JButton();
        pickedCommentBtn = new RoundedButton("you have picked this comment", 37, Color.decode("#F5F5F5"), Color.WHITE);
        pickedCommentBtn.setBorderPainted(false);

        if (moreBtn == null) moreBtn = new JButton();
        moreBtn = new RoundedButton("", 37, Color.decode("#F5F5F5"), Color.WHITE);

        Color controlBorder1 = Color.decode("#C1C1C1"); // light gray border
        votePanel = new RoundedPanel(37, Color.decode("#F5F5F5"), controlBorder1, 2, false);
        votePanel.setLayout(new GridBagLayout());
        votePanel.setBorder(null);

        if (replyBtn == null) replyBtn = new JButton();
        replyBtn = new RoundedButton("", 37, Color.decode("#F5F5F5"), Color.WHITE);
        replyBtn.setBorderPainted(false);

        replyTextPane = new JTextPane();
        replyTextPane.setEditable(false);
        replyTextPane.setForeground(Color.BLACK);
    }
}
