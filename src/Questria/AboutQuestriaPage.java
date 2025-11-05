package Questria;

import javax.swing.*;
import java.awt.*;

public class AboutQuestriaPage {

    public static void main(String[] args) {
        // Run on EDT
        SwingUtilities.invokeLater(() -> {
            AboutQuestriaPage page = new AboutQuestriaPage();
            page.getAboutQuestriaPageFrame().setVisible(true);
        });
    }

    public JFrame getAboutQuestriaPageFrame() {
        // Create frame
        JFrame aboutQuestriaPageFrame = new JFrame("QUESTRIA : About Questria");
        aboutQuestriaPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Build header and rules panels (they are designer-backed classes you provided)
        AboutHeader aboutHeader = new AboutHeader();
        Rules rules = new Rules();

        JPanel headerPanel = aboutHeader.getAboutHeaderPanel();
        JPanel rulesPanel = rules.getRulesPanel();

        // Defensive fallbacks: if GUI Designer didn't wire fields, create simple placeholders
        if (headerPanel == null) {
            headerPanel = new JPanel();
            headerPanel.setBackground(Color.decode("#D6E4F5"));
            headerPanel.add(new JLabel("About Questria"));
        }

        if (rulesPanel == null) {
            rulesPanel = new JPanel();
            rulesPanel.setBackground(Color.WHITE);
            rulesPanel.add(new JLabel("Rules content missing"));
        }

        // Give header a preferred height (so it stays compact)
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        headerPanel.setPreferredSize(new Dimension(screen.width, 123));

        // Wrap rulesPanel into a vertically laid-out container so the scrollpane calculates
        // the preferred height correctly (helps ensure the scrollbars appear when content is tall)
        JPanel contentWrapper = new JPanel();
        contentWrapper.setLayout(new BoxLayout(contentWrapper, BoxLayout.Y_AXIS));
        contentWrapper.setBackground(Color.decode("#D6E4F5"));
        contentWrapper.add(rulesPanel);

        // If you want spacing between rules blocks, you can add rigid areas or empty borders
        // contentWrapper.add(Box.createRigidArea(new Dimension(0, 20)));

        // Create scroll pane for the content wrapper
        JScrollPane scrollPane = new JScrollPane(contentWrapper,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smoother scroll
        scrollPane.setBorder(null);
        // Make viewport background match wrapper for seamless look
        scrollPane.getViewport().setBackground(contentWrapper.getBackground());

        // Layout frame: header in NORTH, scroll pane in CENTER
        aboutQuestriaPageFrame.getContentPane().setLayout(new BorderLayout());
        aboutQuestriaPageFrame.getContentPane().add(headerPanel, BorderLayout.NORTH);
        aboutQuestriaPageFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Make the frame full-screen sized (or set to preferred size)
        aboutQuestriaPageFrame.setSize(screen);
        aboutQuestriaPageFrame.setLocationRelativeTo(null); // center on screen

        // Return the frame (visible flag set by caller / main)
        return aboutQuestriaPageFrame;
    }
}
