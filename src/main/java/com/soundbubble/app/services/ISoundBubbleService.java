package com.soundbubble.app.services;

public interface ISoundBubbleService {
    public void fetchSongByPermalink(String permalink);

    public void fetchSongByStream(String steam_url);

    public void fetchSCUserByID(String id);

    public void fetchSCUserByPermalink(String permalink);
}
