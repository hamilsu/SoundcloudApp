package com.soundbubble.app.dto;

import lombok.Data;


public @Data
class LabelValueForSongs {
    private String label;
    private String name;
    private String permalink_url;
    private String stream_url;
    private String artist;

}
