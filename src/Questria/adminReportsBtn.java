package Questria;

import javax.swing.*;
import java.awt.*;

public class adminReportsBtn {
    private JPanel adminReportsBtnPanel;
    private JButton postsBtn;
    private JButton commentsBtn;

    public JPanel getAdminReportsBtnPanel() {
        return adminReportsBtnPanel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        if(postsBtn == null) postsBtn = new JButton("Posts");
        postsBtn = new RoundedButton("Posts", 30, Color.WHITE, Color.WHITE);

        if(commentsBtn == null) commentsBtn = new JButton("Comments");
        commentsBtn = new RoundedButton("Comments", 30,Color.WHITE, Color.WHITE);

    }
}
