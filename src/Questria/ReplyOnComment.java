package Questria;

import javax.swing.*;
import java.awt.*;

public class ReplyOnComment {
    private JPanel replyOnCommentPanel;
    private JTextPane replyTextPane;
    private JButton commentBtn;
    private JButton cancelBtn;
    private JLabel mediaUploadLbl;
    private JLabel fileUploadLbl;
    private JLabel imageUploadLbl;

    ImageIcon imageUploadIcon = new ImageIcon(new ImageIcon("assets/picture.png").getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
    ImageIcon fileUploadIcon = new ImageIcon(new ImageIcon("assets/file.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon mediaUploadIcon = new ImageIcon(new ImageIcon("assets/video.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public JPanel getReplyOnCommentPanel() {
        imageUploadLbl.setIcon(imageUploadIcon);
        fileUploadLbl.setIcon(fileUploadIcon);
        mediaUploadLbl.setIcon(mediaUploadIcon);
        return replyOnCommentPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (commentBtn == null) commentBtn = new RoundedButton("Post", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (cancelBtn == null) cancelBtn = new RoundedButton("Cancel", 30, Color.decode("#59A5D8"), Color.WHITE);

        replyOnCommentPanel = new RoundedPanel(16, Color.decode("#FFFFFF"), Color.decode("#C1C1C1"), 1, true);
        replyOnCommentPanel.setLayout(new GridBagLayout());
        replyOnCommentPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
    }
}
