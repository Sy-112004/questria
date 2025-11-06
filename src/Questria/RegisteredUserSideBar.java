package Questria;

import Questria.PopUp.LogOutConfirmationDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisteredUserSideBar {
    private JPanel RegisteredUserSideBarPanel;
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
    private JButton bookmarkBtn;
    private JButton logOutBtn;

    ImageIcon homeIcon     = new ImageIcon(new ImageIcon("assets/home.png").getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
    ImageIcon popularIcon  = new ImageIcon(new ImageIcon("assets/popular.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    ImageIcon bookmarkIcon = new ImageIcon(new ImageIcon("assets/bookmark.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
    ImageIcon logoutIcon   = new ImageIcon(new ImageIcon("assets/arrow-left.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));

    private final PageBuilder pageBuilder = new PageBuilder();

    // prevents duplicate listener registration
    private boolean logoutWired = false;

//    public RegisteredUserSideBar() {
//        // Existing navigation wiring
//        if (homeBtn != null) {
//            homeBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showRegisteredUserHomePage();
//                }
//            });
//        }
//        if (popularBtn != null) {
//            popularBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showRegisteredUserPopularPage();
//                }
//            });
//        }
//        if (bookmarkBtn != null) {
//            bookmarkBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showBookmarksPage();
//                }
//            });
//        }
//        if (educationBtn != null) {
//            educationBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showGuestEducationTopicPage();
//                }
//            });
//        }
//        if (travelBtn != null) {
//            travelBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showGuestTravelPage();
//                }
//            });
//        }
//        if (moviesTVBtn != null) {
//            moviesTVBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showGuestMoviesTvPage();
//                }
//            });
//        }
//        if (gamesBtn != null) {
//            gamesBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showRegisteredUserGamesPage();
//                }
//            });
//        }
//        if (foodsDrinksBtn != null) {
//            foodsDrinksBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showRegisteredUserGamesPage();
//                }
//            });
//        }
//        if (musicBtn != null) {
//            musicBtn.addActionListener(new ActionListener() {
//                @Override public void actionPerformed(ActionEvent e) {
//                    pageBuilder.showRegisteredUserMusicPage();
//                }
//            });
//        }
//        // NOTE: We wire logOutBtn later in getRegisteredUserSideBarPanel() to ensure it's initialized.
//    }

    public JPanel getRegisteredUserSideBarPanel() {
        // Set icons
        if (homeBtn != null)     homeBtn.setIcon(homeIcon);
        if (popularBtn != null)  popularBtn.setIcon(popularIcon);
        if (bookmarkBtn != null) bookmarkBtn.setIcon(bookmarkIcon);
        if (logOutBtn != null)   logOutBtn.setIcon(logoutIcon);

        // Wire logout confirmation ONCE (safe here because GUI builder has created the components)
        if (!logoutWired && logOutBtn != null) {
            logoutWired = true;
            logOutBtn.addActionListener(e -> {
                LogOutConfirmationDialog.show(logOutBtn, () -> {
                    // Close the window that owns this sidebar
                    Window currentWindow = SwingUtilities.getWindowAncestor(RegisteredUserSideBarPanel);
                    if (currentWindow != null) currentWindow.dispose();

                    // Show Guest Home Page via PageBuilder
                    pageBuilder.showGuestHomePage();
                });
            });
        }

        return RegisteredUserSideBarPanel;
    }
}
