package com.soundbubble.app.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public @Data
class User {
    public String username;
    public String password;
    public SCUser scAccount;
    public int id;
    public FavoritesList favoritesList;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.scAccount = null;
        this.id = (int)Math.random()*10001; //just generating a random ID until we get auto iteration from out DB.
        this.favoritesList = new FavoritesList();

    }

    //Note: This constructor should only be called for testing purposes.
    public User(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.scAccount = null;
        this.favoritesList = new FavoritesList();
    }
}
