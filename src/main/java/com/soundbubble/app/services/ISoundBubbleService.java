package com.soundbubble.app.services;


import com.soundbubble.app.dto.User;

import java.util.NoSuchElementException;

public interface ISoundBubbleService {
    public void fetchSongByPermalink(String permalink);

    public void fetchSongByStream(String steam_url);

    public void fetchSCUserByID(String id);

    public void fetchSCUserByPermalink(String permalink);

    public void saveNewUser(User newUser);

    public User fetchUserByID(int id) throws NoSuchElementException;

    User fetchUserByName(String name) throws NoSuchElementException;
}
