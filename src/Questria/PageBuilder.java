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

    public void showLandingPage(){
        showPage(landingPage.getLandingPageFrame());
        hidePage(guestHomepage.getGuestHomePageFrame());
    }

    public void showGuestHomePage(){
        showPage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
    }

    public void showLogInPage(){
        showPage(logInPage.getLogInPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
    }

    public void showAboutQuestriaPage(){
        showPage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
    }

    public void showSignUpPage(){
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        showPage(signUpPage.getSignUpPage());
    }

    public void showFollowTopicPage(){
        showPage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());

    }

    public void showRegisteredUserHomePage(){
        showPage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());

    }

    public void showGuestEducationTopicPage(){
        showPage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());

    }

    public void showGuestTravelPage(){
        showPage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());

    }
    public void showGuestGamesPage(){
        showPage(guestGamesPage.getGuestGamesPageFrame());
        hidePage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());

    }

    public void showGuestMusicPage(){
        showPage(guestMusicPage.getGuestMusicPageFrame());
        hidePage(guestGamesPage.getGuestGamesPageFrame());
        hidePage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
    }

    public void showGuestFoodsPage(){
        showPage(guestFoodsPage.getGuestFoodsPageFrame());
        hidePage(guestMusicPage.getGuestMusicPageFrame());
        hidePage(guestGamesPage.getGuestGamesPageFrame());
        hidePage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
    }
    public void showGuestMoviesTvPage(){
        showPage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
        hidePage(guestMusicPage.getGuestMusicPageFrame());
        hidePage(guestGamesPage.getGuestGamesPageFrame());
        hidePage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
    }

    public void showGuestPopularPage(){
        showPage(guestPopularPage.getGuestPopularPageFrame());
        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
        hidePage(guestMusicPage.getGuestMusicPageFrame());
        hidePage(guestGamesPage.getGuestGamesPageFrame());
        hidePage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());
    }
    public void showGuestViewPostPage(){
        showPage(guestViewPostPage.getGuestViewPostPageFrame());
        hidePage(guestPopularPage.getGuestPopularPageFrame());
        hidePage(guestMoviesTvPage.getGuestMoviesTvPageFrame());
        hidePage(guestFoodsPage.getGuestFoodsPageFrame());
        hidePage(guestMusicPage.getGuestMusicPageFrame());
        hidePage(guestGamesPage.getGuestGamesPageFrame());
        hidePage(guestTravelPage.getGuestTravelPageFrame());
        hidePage(guestEducationTopicPage.getGuestEducationTopicPage());
        hidePage(registeredUserHomePage.getRegisteredUserHomePageFrame());
        hidePage(followTopicPage.getFollowTopicPageFrame());
        hidePage(aboutQuestriaPage.getAboutQuestriaPageFrame());
        hidePage(signUpPage.getSignUpPage());
        hidePage(guestHomepage.getGuestHomePageFrame());
        hidePage(landingPage.getLandingPageFrame());
        hidePage(logInPage.getLogInPageFrame());

    }


}
