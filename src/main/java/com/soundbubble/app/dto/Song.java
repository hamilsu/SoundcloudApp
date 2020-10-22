package com.soundbubble.app.dto;

import lombok.Data;

import java.util.Date;

public @Data class Song {
    private String name;
    private String genre;
    private Date releaseDate;
    private String description;
    private String permalink_url;
    private String artwork_url;
    private SCUser artist;
    private String stream_url;

}
