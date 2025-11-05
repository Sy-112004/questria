package Questria;

import javax.swing.*;
import java.awt.*;

public class editReply {
    private JPanel editReplyPanel;
    private JTextPane editReplyTextPane;
    private JLabel mediaUploadLbl;
    private JLabel fileUploadLbl;
    private JLabel imageUploadLbl;
    private JButton saveChangesBtn;
    private JButton cancelBtn;

    ImageIcon imageUploadIcon = new ImageIcon(new ImageIcon("assets/picture.png").getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT));
    ImageIcon fileUploadIcon = new ImageIcon(new ImageIcon("assets/file.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
    ImageIcon mediaUploadIcon = new ImageIcon(new ImageIcon("assets/video.png").getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));

    public JPanel getEditReplyPanel() {
        imageUploadLbl.setIcon(imageUploadIcon);
        fileUploadLbl.setIcon(fileUploadIcon);
        mediaUploadLbl.setIcon(mediaUploadIcon);
        return editReplyPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        if (saveChangesBtn == null) saveChangesBtn = new RoundedButton("Post", 30, Color.decode("#59A5D8"), Color.WHITE);
        if (cancelBtn == null) cancelBtn = new RoundedButton("Cancel", 30, Color.decode("#59A5D8"), Color.WHITE);

        editReplyPanel = new RoundedPanel(16, Color.decode("#FFFFFF"), Color.decode("#C1C1C1"), 1, true);
        editReplyPanel.setLayout(new GridBagLayout());
        editReplyPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

    }
}
