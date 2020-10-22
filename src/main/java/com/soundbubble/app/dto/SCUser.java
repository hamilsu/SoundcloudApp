package com.soundbubble.app.dto;

import lombok.Data;

public @Data
class SCUser {
    private String id;
    private String permalink;
    private String username;
    private String avatar_url;


    public String permalinkURL(){
        String placeholder = "";

        return placeholder;
    }
}
