package Questria;

import Questria.PopUp.UserPopupOwnComment;
import Questria.PopUp.DeleteConfirmationDialog;   // ⬅ import the delete dialog

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

    private boolean popupWired = false; // guard to avoid double listeners

    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT));
    ImageIcon upvoteIcon  = new ImageIcon(new ImageIcon("assets/upvote.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
    ImageIcon downvoteIcon= new ImageIcon(new ImageIcon("assets/downvote.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
    ImageIcon replyIcon   = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon moreIcon    = new ImageIcon(new ImageIcon("assets/more.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon starIcon    = new ImageIcon(new ImageIcon("assets/star.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public comment() {
        // wiring happens after UI is constructed
    }

    public JPanel getCommentPanel() {
        if (profileLbl != null)      profileLbl.setIcon(profileIcon);
        if (upvoteImageLbl != null)  upvoteImageLbl.setIcon(upvoteIcon);
        if (downvoteLbl != null)     downvoteLbl.setIcon(downvoteIcon);
        if (replyBtn != null)        replyBtn.setIcon(replyIcon);
        if (moreBtn != null)         moreBtn.setIcon(moreIcon);
        if (pickedCommentBtn != null)pickedCommentBtn.setIcon(starIcon);

        wireMorePopup(); // attach popup once
        return commentPanel;
    }

    /** Attach popup to moreBtn exactly once. */
    private void wireMorePopup() {
        if (popupWired || moreBtn == null) return;
        popupWired = true;

        moreBtn.addActionListener(e -> {
            // Build the popup with connected actions
            JPopupMenu pm = UserPopupOwnComment.build(
                    // onEdit:
                    this::openEditPostPage,
                    // onDelete:
                    () -> DeleteConfirmationDialog.show(moreBtn, this::deleteThisComment)
            );
            pm.show(moreBtn, 0, moreBtn.getHeight() + 6);
        });
    }

    /** Open the Edit page (adjust class/method names if your edit page differs). */
    private void openEditPostPage() {
        SwingUtilities.invokeLater(() -> {
            try {
                // If your edit page class/method names differ, update here:
                Questria.EditPostPage page = new Questria.EditPostPage();
                JFrame f = page.getEditPostPageFrame();
                f.setVisible(true);
            } catch (Throwable t) {
                t.printStackTrace();
                JOptionPane.showMessageDialog(
                        commentPanel,
                        "Unable to open Edit page.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    /** What happens after confirming delete. Replace with your actual delete logic if needed. */
    private void deleteThisComment() {
        // Example: remove this comment panel from UI
        Container parent = (commentPanel != null) ? commentPanel.getParent() : null;
        if (parent != null) {
            parent.remove(commentPanel);
            parent.revalidate();
            parent.repaint();
        }
        System.out.println("Comment deleted!");
        // TODO: also call your backend/DB delete here if applicable.
    }

    /** Called by GUI designer for custom-created components. */
    private void createUIComponents() {
        if (pickedCommentBtn == null) pickedCommentBtn = new JButton();
        pickedCommentBtn = new RoundedButton("you have picked this comment",37, Color.decode("#F5F5F5"), Color.WHITE);
        pickedCommentBtn.setBorderPainted(false);

        if (moreBtn == null) moreBtn = new JButton();
        moreBtn = new RoundedButton("",37, Color.decode("#F5F5F5"), Color.WHITE);

        Color controlBorder1 = Color.decode("#C1C1C1");
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
