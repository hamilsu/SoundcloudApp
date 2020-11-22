package com.soundbubble.app.dto;

import lombok.Data;

import java.util.Date;

public @Data
class LabelValueForSongs {
    private String name;
    private String permalink_url;
    private String stream_url;
    private String artist;

}
