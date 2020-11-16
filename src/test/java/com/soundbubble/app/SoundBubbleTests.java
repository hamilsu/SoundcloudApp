package com.soundbubble.app;

import com.soundbubble.app.dao.ISongDAO;
import com.soundbubble.app.dao.IUserDAO;
import com.soundbubble.app.dto.Song;
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
    private IUserDAO userDAO;
    private ISongDAO songDAO;
    private User user;
    private Song song;

    private boolean isLoggedIn;

    @Test
    void GivenUserSavesNewSongToFavorites(){
        user = new User ("Billy","Bob");
        song = WhenUserClicksSaveSong();
        Song copySong = new Song(song);
        ThenSaveSongToUser(user,song);

        Assert.assertEquals(user.favoritesList.remove(0),copySong);
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
        String username = userDAO.fetchUsername();
        String password = userDAO.fetchPassword();
        String nameAndPass[] = {username,password};
        return nameAndPass;
    }


    private void ThenSaveNewUser() {
        soundBubbleServiceStub.saveNewUser(user);
    }

    private void WhenUserEntersNewNameAndPassword(String username, String password, int id) {
    user = userServiceStub.createNewUserWithPredeterminedID(username, password,id);
    }
    private Song WhenUserClicksSaveSong() {
        //Honestly I'm not sure how we'll end up fetching the song at the moment. I'd assume when they click the button they'd already be at the song so we'd just fetch the URL they're at?
        return soundBubbleServiceStub.fetchSongByStream("streamURL");
    }

    private void ThenSaveSongToUser(User user, Song song) {
        user.favoritesList.add(song);
    }

}
