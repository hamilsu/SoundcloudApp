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

    //This is mainly for testing purposes to ensure there's no weird aliasing problems when trying to copy a song
    public Song(Song song) {
        this.name = song.name;
        this.genre = song.genre;
        this.releaseDate = song.releaseDate;
        this.description = song.description;
        this.permalink_url = song.permalink_url;
        this.artwork_url = song.artwork_url;
        this.artist = song.artist;
        this.stream_url = song.stream_url;
    }
}
