package Questria;

import Questria.PopUp.AdminPopupOnPost;

import javax.swing.*;
import java.awt.*;

public class post { // consider renaming to Post
    private JPanel postPanel;
    private JLabel profileLbl;
    private JLabel topicLbl;
    private JLabel titleLbl;
    private JPanel votePanel;
    private JButton upvoteBtn;
    private JLabel upvoteLbl;
    private JLabel timeLbl;
    private JLabel upvoteImageLbl;
    private JLabel downvoteLbl;
    private JButton commentBtn;
    private JButton moreBtn;
    private JPanel pointsPanel;
    private JLabel pointsLbl;

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon upvoteIcon = new ImageIcon(new ImageIcon("assets/upvote.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
    ImageIcon downvoteIcon = new ImageIcon(new ImageIcon("assets/downvote.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
    ImageIcon commentIcon = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon moreIcon = new ImageIcon( new ImageIcon("assets/more.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public post() {
        // SINGLE listener only:
        if (moreBtn == null) moreBtn = new JButton(); // GUI designer may overwrite; this is safe
        moreBtn.addActionListener(e -> {
            JPopupMenu popup = AdminPopupOnPost.build(
                    () -> System.out.println("Delete action"),
                    () -> System.out.println("Lock action"),
                    () -> System.out.println("Mark as Safe action")
            );
            popup.show(moreBtn, 0, moreBtn.getHeight() + 6);
        });
    }

    public JPanel getPostPanel() {
        if (profileLbl != null) profileLbl.setIcon(profileIcon);
        if (upvoteImageLbl != null) upvoteImageLbl.setIcon(upvoteIcon);
        if (downvoteLbl != null) downvoteLbl.setIcon(downvoteIcon);
        if (commentBtn != null) commentBtn.setIcon(commentIcon);
        if (moreBtn != null) moreBtn.setIcon(moreIcon);
        return postPanel;
    }

    /** Called by IntelliJ GUI Designer for custom-created components. */
    private void createUIComponents() {
        postPanel = new JPanel(new BorderLayout());
        postPanel.setBackground(Color.WHITE);

        Color controlBorder = Color.decode("#C1C1C1");
        votePanel = new RoundedPanel(37, Color.decode("#F5F5F5"), controlBorder, 2, false);
        votePanel.setLayout(new GridBagLayout());
        votePanel.setBorder(null);

        if (commentBtn == null) commentBtn = new JButton();
        commentBtn = new RoundedButton("", 37, Color.decode("#F5F5F5"), Color.WHITE);
        commentBtn.setBorderPainted(false);

        if (moreBtn == null) moreBtn = new JButton();
        moreBtn = new RoundedButton("", 37, Color.decode("#F5F5F5"), Color.WHITE);

        pointsPanel = new RoundedPanel(15, Color.decode("#59A5D8"), controlBorder, 0, false);
        pointsPanel.setLayout(new GridBagLayout());
    }
}
