package Questria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPost {
    private JPanel viewPostPanel;
    private JLabel backLbl;
    private JLabel profileLbl;
    private JPanel pointsPanel;
    private JButton bookmarkBtn;
    private JButton moreBtn;
    private JLabel titleLbl;
    private JLabel topicLbl;
    private JPanel tagsPanel;
    private JLabel tagsLbl;
    private JTextPane bodyTextPane;
    private JPanel votePanel;
    private JLabel upvoteImageLbl;
    private JLabel downvoteLbl;
    private JButton commentBtn;
    private JLabel upvoteLbl;
    private JLabel timeLbl;
    private JLabel pointsLbl;

    ImageIcon backIcon = new ImageIcon(new ImageIcon("assets/previous.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT));
    ImageIcon upvoteIcon = new ImageIcon(new ImageIcon("assets/upvote.png").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
    ImageIcon downvoteIcon = new ImageIcon(new ImageIcon("assets/downvote.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
    ImageIcon commentIcon = new ImageIcon(new ImageIcon("assets/comment.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon moreIcon = new ImageIcon( new ImageIcon("assets/more.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon bookmarkIcon = new ImageIcon(new ImageIcon("assets/bookmark.png").getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));


    public ViewPost() {
        moreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popup = Questria.PopUp.UserPopupOnOwnPost.build(
                        // EDIT: open EditPostPage and close current window
                        () -> {
                            // close the window that contains this view
                            Window w = SwingUtilities.getWindowAncestor(viewPostPanel);
                            if (w != null) w.dispose();

                            // open EditPostPage
                            EditPostPage edit = new EditPostPage();
                            edit.getEditPostPageFrame(); // ensure this method shows the frame
                        },
                        // DELETE
                        () -> System.out.println("Delete clicked"),
                        // LOCK
                        () -> System.out.println("Lock clicked")
                );
                popup.show(moreBtn, 0, moreBtn.getHeight() + 6);
            }
        });
    }

    public JPanel getViewPostPanel() {
        profileLbl.setIcon(profileIcon);
        upvoteImageLbl.setIcon(upvoteIcon);
        downvoteLbl.setIcon(downvoteIcon);
        commentBtn.setIcon(commentIcon);
        moreBtn.setIcon(moreIcon);
        bookmarkBtn.setIcon(bookmarkIcon);
        backLbl.setIcon(backIcon);

//        if (backLbl == null) {
//            backLbl = new JLabel(backIcon);
//            backLbl.setBounds(10, 10, 45, 45); // adjust coordinates to match profileLbl
//            viewPostPanel.add(backLbl);
//        }

        return viewPostPanel;
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



        bodyTextPane = new JTextPane();
        bodyTextPane.setEditable(false);
//        bodyTextPane.setEnabled(false);
        bodyTextPane.setForeground(Color.BLACK);
//        bodyTextPane.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//        bodyTextPane.setPreferredSize(new Dimension(500, 100)); // starting size
//
//        // 🧩 Auto-fit height as user types
//        bodyTextPane.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
//            private void updateSize() {
//                SwingUtilities.invokeLater(() -> {
//                    Dimension preferred = bodyTextPane.getUI().getPreferredSize(bodyTextPane);
//                    int newHeight = preferred.height + 10;
//                    bodyTextPane.setPreferredSize(new Dimension(bodyTextPane.getWidth(), newHeight));
//                    bodyTextPane.revalidate();
//                    if (bodyTextPane.getParent() != null) {
//                        bodyTextPane.getParent().revalidate();
//                    }
//                });
//            }
//
//            @Override
//            public void insertUpdate(javax.swing.event.DocumentEvent e) {
//                updateSize();
//            }
//
//            @Override
//            public void removeUpdate(javax.swing.event.DocumentEvent e) {
//                updateSize();
//            }
//
//            @Override
//            public void changedUpdate(javax.swing.event.DocumentEvent e) {
//                updateSize();
//            }
//        });

    }
}
