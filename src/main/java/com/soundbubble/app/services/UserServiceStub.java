package com.soundbubble.app.services;


import com.soundbubble.app.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceStub implements IUserService{

    public User createNewUser(String userName, String password){
        return new User(userName, password);

    }

    @Override
    public User createNewUserWithPredeterminedID(String username, String password, int id) {
        return new User(username,password,id);
    }


}
