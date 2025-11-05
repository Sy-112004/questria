package Questria;

import Questria.PopUp.AdminPopupOnPost;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class PageBuilder {

    LandingPage landingPage = new LandingPage();
    GuestHomepage guestHomepage = new GuestHomepage();

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


}
