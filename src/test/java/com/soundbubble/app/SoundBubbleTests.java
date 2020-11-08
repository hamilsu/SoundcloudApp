package com.soundbubble.app;

import com.soundbubble.app.dao.IUserDAO;
import com.soundbubble.app.dto.User;
import com.soundbubble.app.services.ISoundBubbleService;
import com.soundbubble.app.services.IUserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;


@SpringBootTest
public class SoundBubbleTests {

    @Autowired
    private IUserService userServiceStub;
    private ISoundBubbleService soundBubbleServiceStub;
    private IUserDAO UserDAO;
    private User newUser;


    @Test
    void WhenUserSavesNewSongToFavorites(){

    }

    @Test
    void GivenUserSignsUp(){
        User testerUser = new User("PLACEHOLDER","PLACEHOLDER");
        String username = "PLACEHOLDER";
        String password = "PLACEHOLDER";
        WhenUserEntersNewNameAndPassword(username, password,22);
        ThenSaveNewUser();


        try {
            Assert.assertEquals(testerUser, soundBubbleServiceStub.fetchUserByID(22));
        }
        catch (NoSuchElementException e){
            Assert.fail("Error: User not found with that id");
        }

    }

    @Test
    void GivenUserSubmitsLogin(){
        String credentials[] = WhenThereIsSubmittedCredentials();
        try {
            Assert.assertTrue(ThenCheckCredentialsAreCorrect(credentials));
        }
        catch(NoSuchElementException e){
            Assert.fail("Error: User not found with that username");
        }

    }

    private boolean ThenCheckCredentialsAreCorrect(String[] credentials) throws NoSuchElementException {
        boolean passwordCorrect = false;
        try {
            User foundUser = soundBubbleServiceStub.fetchUserByName(credentials[0]);
            if (foundUser.password.equals(credentials[1])){
                passwordCorrect = true;
            }
            return passwordCorrect;
        }
        catch(NoSuchElementException e){
            throw e;
        }
    }

    private String[] WhenThereIsSubmittedCredentials() {
        String username = UserDAO.fetchUsername();
        String password = UserDAO.fetchPassword();
        String nameAndPass[] = {username,password};
        return nameAndPass;
    }


    private void ThenSaveNewUser() {
        soundBubbleServiceStub.saveNewUser(newUser);

    }

    private void WhenUserEntersNewNameAndPassword(String username, String password, int id) {
    newUser = userServiceStub.createNewUserWithPredeterminedID(username, password,id);
    }



}
