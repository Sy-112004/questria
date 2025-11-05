package Questria;

import Questria.PopUp.LogOutConfirmationDialog;
import Questria.GuestHomepage;

import javax.swing.*;
import java.awt.*;

public class adminSideBar {
    private JPanel adminSideBarPanel;
    private JLabel MenuLbl;
    private JButton homeBtn;
    private JButton popularBtn;
    private JLabel topicsLbl;
    private JButton educationBtn;
    private JButton travelBtn;
    private JButton moviesTVBtn;
    private JButton gamesBtn;
    private JButton foodsDrinksBtn;
    private JButton musicBtn;
    private JButton logOutBtn;
    private JButton reportsBtn;
    private JButton profileBtn;

    ImageIcon homeIcon    = new ImageIcon(new ImageIcon("assets/home.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
    ImageIcon popularIcon = new ImageIcon(new ImageIcon("assets/popular.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    ImageIcon logoutIcon  = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    ImageIcon reportsIcon = new ImageIcon(new ImageIcon("assets/reports.png").getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
    ImageIcon profileIcon = new ImageIcon(new ImageIcon("assets/profile.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));

    private boolean logoutWired = false;
    PageBuilder pageBuilder = new PageBuilder();

    public adminSideBar() {
        // Attach listener for logout only once
        if (!logoutWired && logOutBtn != null) {
            logoutWired = true;
            logOutBtn.addActionListener(e -> {
                LogOutConfirmationDialog.show(logOutBtn, () -> {
                    // ✅ Perform logout logic
                    // Close current Admin window
                    Window currentWindow = SwingUtilities.getWindowAncestor(adminSideBarPanel);
                    if (currentWindow != null) currentWindow.dispose();

                    // ✅ Open GuestHomePage after logout
                    pageBuilder.showGuestHomePage();
                });
            });
        }
    }

    public JPanel getAdminSideBarPanel() {
        homeBtn.setIcon(homeIcon);
        popularBtn.setIcon(popularIcon);
        logOutBtn.setIcon(logoutIcon);
        reportsBtn.setIcon(reportsIcon);
        profileBtn.setIcon(profileIcon);
        return adminSideBarPanel;
    }

    private void createUIComponents() {
        // for IntelliJ GUI Designer
    }
}
