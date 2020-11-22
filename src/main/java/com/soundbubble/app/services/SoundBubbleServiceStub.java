package com.soundbubble.app.services;



import com.soundbubble.app.dto.Song;
import com.soundbubble.app.dto.User;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class SoundBubbleServiceStub implements ISoundBubbleService {

    List<User> userList = new LinkedList<User>();

    @Override
    public Song fetchSongByPermalink(String permalink) {

        return null;
    }

    @Override
    public Song fetchSongByStream(String stream_url) {

        return null;
    }

    @Override
    public void fetchSCUserByID(String id) {

    }

    @Override
    public void fetchSCUserByPermalink(String permalink) {

    }

    @Override
    public void saveNewUser(User newUser) {
        userList.add(newUser);
    }

//    @Override
//    public User fetchUserByID(int id) throws NoSuchElementException {
//        User foundUser = userList.stream().filter(x->x.id == id).findAny().orElseThrow();
//        return foundUser;
//    }

    @Override
    public User fetchUserByName(String name) throws NoSuchElementException {
        User foundUser = userList.stream().filter(x->x.username.equals(name)).findAny().orElseThrow();
        return foundUser;
    }

    //TODO: Implement search feature. Hopefully Matthew has some experience with this since we're essentially trying to search the SoundCloud database, not our own.
    @Override
    public List<Song> fetchSongs(String searchTerm) throws IOException {
        return null;
    }
}
