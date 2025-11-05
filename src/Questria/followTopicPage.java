package Questria;

import javax.swing.*;
import java.awt.*;

public class followTopicPage {
    public static void main(String[] args) {
        followTopicPage followTopicPage = new followTopicPage();
        followTopicPage.getFollowTopicPageFrame();
    }

    public JFrame getFollowTopicPageFrame(){
        JFrame followTopicPageFrame = new JFrame();
        followTopicPageFrame.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        followTopicPageFrame.pack();

        int width = followTopicPageFrame.getContentPane().getWidth();
        int height = followTopicPageFrame.getContentPane().getHeight();

        // Get the panel
        followTopics followTopicsPanel = new followTopics();
        JPanel panel = followTopicsPanel.getFollowTopicsPanel();

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new GridBagLayout());
        wrapperPanel.setBackground(Color.decode("#D6E4F5")); // Light blue background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 20, 0); // Top and bottom padding

        wrapperPanel.add(panel, gbc);

        // Add the PANEL to the JScrollPane, not the frame!
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, width, height);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling
        scrollPane.setBorder(null); // Remove border if desired

        int scrollPaneX = 0;
        int scrollPaneY = 0;
        scrollPane.setBounds(scrollPaneX, scrollPaneY, width , height );

        followTopicPageFrame.setLayout(null);
        followTopicPageFrame.setTitle("QUESTRIA : Follow Topics Page");
        followTopicPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        followTopicPageFrame.setResizable(false);

        // Add ONLY the scrollPane to the frame (not both panel and scrollPane)
        followTopicPageFrame.add(scrollPane);

        followTopicPageFrame.setVisible(true);

        return followTopicPageFrame;
    }
}