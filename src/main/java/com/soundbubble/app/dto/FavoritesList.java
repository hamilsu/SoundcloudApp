package com.soundbubble.app.dto;

import lombok.Data;

import java.util.List;

public @Data
class FavoritesList {
    private List<Song> songList;
}
