package com.soundbubble.app.services;

import com.soundbubble.app.dto.User;

public interface IUserService {
    User createNewUser(String username, String password);

    User createNewUserWithPredeterminedID(String username, String password, int id);
}
