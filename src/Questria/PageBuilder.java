package Questria;

import Questria.PopUp.AdminPopupOnPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class PageBuilder {

    LandingPage landingPage = new LandingPage();
    GuestHomepage guestHomepage = new GuestHomepage();
    SignUpPage signUpPage = new SignUpPage();
    LogInPage logInPage = new LogInPage();
    AboutQuestriaPage aboutQuestriaPage = new AboutQuestriaPage();
    followTopicPage followTopicPage = new followTopicPage();
    RegisteredUserHomePage registeredUserHomePage = new RegisteredUserHomePage();
    GuestEducationTopicPage guestEducationTopicPage = new GuestEducationTopicPage();
    GuestTravelPage guestTravelPage = new GuestTravelPage();
    GuestMoviesTvPage guestMoviesTvPage = new GuestMoviesTvPage();
    GuestGamesPage guestGamesPage = new GuestGamesPage();
    GuestMusicPage guestMusicPage = new GuestMusicPage();
    GuestFoodsPage guestFoodsPage = new GuestFoodsPage();
    GuestPopularPage guestPopularPage = new GuestPopularPage();
    GuestViewPostPage guestViewPostPage = new GuestViewPostPage();
    RegisteredUserEducationTopicPage registeredUserEducationTopicPage = new RegisteredUserEducationTopicPage();
    RegisteredUserTravelPage registeredUserTravelPage = new RegisteredUserTravelPage();
    RegisteredUserMoviesTvPage registeredUserMoviesTvPage = new RegisteredUserMoviesTvPage();
    RegisteredUserMusicPage registeredUserMusicPage = new RegisteredUserMusicPage();
    RegisteredUserFoodsPage registeredUserFoodsPage = new RegisteredUserFoodsPage();
    RegisteredUserPopularPage registeredUserPopularPage = new RegisteredUserPopularPage();
    BookmarksPage bookmarksPage = new BookmarksPage();
    RegisteredUserCreatePostPage registeredUserCreatePostPage = new RegisteredUserCreatePostPage();
    RegisteredUserViewProfilePage registeredUserViewProfilePage = new RegisteredUserViewProfilePage();
    RegisteredUserGamesPage registeredUserGamesPage = new RegisteredUserGamesPage();
    RegisteredUserCommentOnPostPage registeredUserCommentOnPostPage = new RegisteredUserCommentOnPostPage();
    RegisteredUserViewProfileCommentsPage registeredUserViewProfileCommentsPage = new RegisteredUserViewProfileCommentsPage();
    RegisteredUserViewProfileUpvotedPage registeredUserViewProfileUpvotedPage = new RegisteredUserViewProfileUpvotedPage();
    RegisteredUserViewProfileDownvotedPage registeredUserViewProfileDownvotedPage = new RegisteredUserViewProfileDownvotedPage();


    public void showPage (JFrame currentFrame){
        currentFrame.setVisible(true);
    }

    public void hidePage (JFrame previousFrame){
        previousFrame.dispatchEvent(new WindowEvent(previousFrame, WindowEvent.WINDOW_CLOSING));
        previousFrame.pack();
        previousFrame.setVisible(false);

        previousFrame.dispose();

        Frame[] allFrames = Frame.getFrames();


        for(Frame fr : allFrames){

            String specificFrameName = fr.getTitle();


            if(specificFrameName.equals(previousFrame.getTitle())){

                fr.dispose();
            }
        }


    }

    public void showLandingPage() {
        hidePage(guestHomepage.getGuestHomePageFrame());
        showPage(landingPage.getLandingPageFrame());

    }

    public void showGuestHomePage() {
        hidePage(landingPage.getLandingPageFrame());
        showPage(guestHomepage.getGuestHomePageFrame());

    }

    public void showLogInPage() {
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        showPage(logInPage.getLogInPageFrame());

    }

    public void showSignUpPage() {
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        showPage(signUpPage.getSignUpPage());

    }

    public void showAboutQuestriaPage() {
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
        showPage(aboutQuestriaPage.getAboutQuestriaPageFrame());

    }


    public void showFollowTopicPage() {
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
        showPage(followTopicPage.getFollowTopicPageFrame());

    }



//    public void showGuestEducationTopicPage() {
//        showPage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showGuestTravelPage() {
//        showPage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showGuestGamesPage() {
//        showPage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showGuestMusicPage() {
//        showPage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//
//    public void showGuestFoodsPage() {
//        showPage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//
//    public void showGuestMoviesTvPage() {
//        showPage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//
//    public void showGuestPopularPage() {
//        showPage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//
//    public void showGuestViewPostPage() {
//        showPage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserEducationTopicPage() {
//        showPage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserTravelPage() {
//        showPage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserMusicPage() {
//        showPage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserMoviesTvPage() {
//        showPage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserFoodsPage() {
//        showPage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserPopularPage() {
//        showPage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserCreatePostPage() {
//        showPage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserViewProfile() {
//        showPage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }

//    public void showBookmarksPage() {
//        showPage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//    public void showRegisteredUserGamesPage() {
//        showPage(registeredUserGamesPage.getRegisteredUserGamesPageFrame());
//        hidePage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//
//    }
//
//
//    public void showRegisteredUserHomePage() {
//        // Show the user home first
//        showPage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//
//        // Then hide the Follow Topics page (the source page)
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//
//        // Optional: hide others if they might still be visible
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//        hidePage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
////        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
////        hidePage(guestPopularPage.getGuestPopularPageFrame());
////        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
////        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
////        hidePage(guestMusicPage.getGuestMusicPageFrame());
////        hidePage(guestGamesPage.getGuestGamesPageFrame());
////        hidePage(guestTravelPage.getGuestTravelPageFrame());
////        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
////        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//
//    }
//
////    public void showRegisteredUserHomePage() {
////        // close the Follow Topics page first (the one you're coming from)
////        // now show the Registered User Home
////        showPage(registeredUserHomePage.getRegisteredUserHomePageFrame());
////        hidePage(followTopicPage.getFollowTopicPageFrame());
////        // ✅ REMOVE this accidental line (it re-opens Movies/TV and hides your home page)
////        // showPage(registeredUserMoviesTvPage.getRegisteredUserMoviesTvPageFrame());
////        // optional: hide other pages if they might still be open
////        hidePage(bookmarksPage.getBookmarksPageFrame());
////        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
////        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
////        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
////        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
////        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
////        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
////        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
////        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
////        hidePage(guestPopularPage.getGuestPopularPageFrame());
////        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
////        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
////        hidePage(guestMusicPage.getGuestMusicPageFrame());
////        hidePage(guestGamesPage.getGuestGamesPageFrame());
////        hidePage(guestTravelPage.getGuestTravelPageFrame());
////        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
////        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
////        hidePage(signUpPage.getSignUpPage());
////        hidePage(guestHomepage.getGuestHomePageFrame());
////        hidePage(landingPage.getLandingPageFrame());
////        hidePage(logInPage.getLogInPageFrame());
////    }
//
//    public void showRegisteredUserCommentOnPostPage() {
//        showPage(registeredUserCommentOnPostPage.getRegisteredUserCommentOnPostPageFrame());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(registeredUserGamesPage.getRegisteredUserGamesPageFrame());
//        hidePage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//    public void showRegisteredUserViewProfileCommentsPage() {
//        showPage(registeredUserViewProfileCommentsPage.getRegisteredUserViewProfileCommentsPageFrame());
//        hidePage(registeredUserCommentOnPostPage.getRegisteredUserCommentOnPostPageFrame());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(registeredUserGamesPage.getRegisteredUserGamesPageFrame());
//        hidePage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//
//    public void showRegisteredUserViewProfileUpvotedPage() {
//        showPage(registeredUserViewProfileUpvotedPage.getRegisteredUserViewProfileUpvotedPageFrame());
//        hidePage(registeredUserViewProfileCommentsPage.getRegisteredUserViewProfileCommentsPageFrame());
//        hidePage(registeredUserCommentOnPostPage.getRegisteredUserCommentOnPostPageFrame());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(registeredUserGamesPage.getRegisteredUserGamesPageFrame());
//        hidePage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }
//
//    public void showRegisteredUserViewProfileDownvotedPage() {
//        showPage(registeredUserViewProfileDownvotedPage.getRegisteredUserViewProfileDownvotedPageFrame());
//        hidePage(registeredUserViewProfileUpvotedPage.getRegisteredUserViewProfileUpvotedPageFrame());
//        hidePage(registeredUserViewProfileCommentsPage.getRegisteredUserViewProfileCommentsPageFrame());
//        hidePage(registeredUserCommentOnPostPage.getRegisteredUserCommentOnPostPageFrame());
//        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
//        hidePage(followTopicPage.getFollowTopicPageFrame());
//        hidePage(registeredUserGamesPage.getRegisteredUserGamesPageFrame());
//        hidePage(bookmarksPage.getBookmarksPageFrame());
//        hidePage(registeredUserViewProfilePage.getRegisteredUserViewProfilePageFrame());
//        hidePage(registeredUserCreatePostPage.getRegisteredUserCreatePostPageFrame());
//        hidePage(registeredUserPopularPage.getRegisteredUserPopularPageFrame());
//        hidePage(registeredUserFoodsPage.getRegisteredUserFoodsPageFrame());
//        hidePage(registeredUserMusicPage.getRegisteredUserMusicPageFrame());
//        hidePage(registeredUserTravelPage.getRegisteredUserTravelPageFrame());
//        hidePage(registeredUserEducationTopicPage.getRegisteredUserEducationTopicPageFrame());
//        hidePage(guestViewPostPage.getGuestViewPostPageFrame());
//        hidePage(guestPopularPage.getGuestPopularPageFrame());
//        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
//        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
//        hidePage(guestMusicPage.getGuestMusicPageFrame());
//        hidePage(guestGamesPage.getGuestGamesPageFrame());
//        hidePage(guestTravelPage.getGuestTravelPageFrame());
//        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
//        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
//        hidePage(signUpPage.getSignUpPage());
//        hidePage(guestHomepage.getGuestHomePageFrame());
//        hidePage(landingPage.getLandingPageFrame());
//        hidePage(logInPage.getLogInPageFrame());
//    }


}




