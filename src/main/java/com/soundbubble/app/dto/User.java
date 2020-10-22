package com.soundbubble.app.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

public @Data
class User {
    private String username;
    private String password;
    private SCUser scAccount;
    private int id;
    private FavoritesList favoritesList;
}
