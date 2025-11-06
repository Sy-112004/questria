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


}
