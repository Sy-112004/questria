package Questria;

import javax.swing.*;
import java.awt.*;

public class CommentOnPost {
    private JPanel commentOnPostPanel;
    private JLabel mediaUploadLbl;
    private JLabel fileUploadLbl;
    private JLabel imageUploadLbl;
    private JTextPane commentTextPane;
    private JButton commentBtn;
    private JButton cancelBtn;

    ImageIcon imageUploadIcon = new ImageIcon(new ImageIcon("assets/picture.png").getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
    ImageIcon fileUploadIcon = new ImageIcon(new ImageIcon("assets/file.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon mediaUploadIcon = new ImageIcon(new ImageIcon("assets/video.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public JPanel getCommentOnPostPanel() {
        imageUploadLbl.setIcon(imageUploadIcon);
        fileUploadLbl.setIcon(fileUploadIcon);
        mediaUploadLbl.setIcon(mediaUploadIcon);
        return commentOnPostPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (commentBtn == null) commentBtn = new RoundedButton("Post", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (cancelBtn == null) cancelBtn = new RoundedButton("Cancel", 30, Color.decode("#59A5D8"), Color.WHITE);

        commentOnPostPanel = new RoundedPanel(16, Color.decode("#FFFFFF"), Color.decode("#C1C1C1"), 1, true);
        commentOnPostPanel.setLayout(new GridBagLayout());
        commentOnPostPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

//        JScrollPane scroll = new JScrollPane(commentTextPane,
//                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scroll.setOpaque(false);
//        scroll.getViewport().setOpaque(false);
//        scroll.setBorder(BorderFactory.createEmptyBorder()); // remove default rectangle border
//
//        // small icon labels (optional) — keep them non-opaque or same background
//
//        // Layout constraints: put scroll in row 0 spanning many columns, then icons left and buttons right in row 1
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 3;
//        gbc.weightx = 1.0;
//        gbc.weighty = 1.0;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.insets = new Insets(4, 4, 8, 4);
//        commentOnPostPanel.add(scroll, gbc);
//
//        // icons row (left)
//        gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.weightx = 0.0;
//        gbc.weighty = 0.0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.fill = GridBagConstraints.NONE;
//        gbc.insets = new Insets(0, 4, 0, 4);
//
//        JPanel iconRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
//        iconRow.setOpaque(false);
//        iconRow.add(imageUploadLbl);
//        iconRow.add(fileUploadLbl);
//        iconRow.add(mediaUploadLbl);
//        commentOnPostPanel.add(iconRow, gbc);
//
//        // buttons row (right)
//        gbc = new GridBagConstraints();
//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        gbc.anchor = GridBagConstraints.EAST;
//        gbc.insets = new Insets(0, 4, 0, 4);
//        JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
//        btnRow.setOpaque(false);
//        btnRow.add(cancelBtn);
//        btnRow.add(commentBtn);
//        commentOnPostPanel.add(btnRow, gbc);
    }
}
