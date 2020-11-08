package com.soundbubble.app.dto;

import lombok.Data;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
Honestly not even sure if we need this class. At one point I imagined it having some additional functionality over a
regular list, which is why I created a new class for it. At the moment though nothing comes to mind that it really
needs extra, so if no one else thinks of anything worthwhile to add then let's just delete it and change
User.favoritesList to a LinkedList;
 */

public @Data
class FavoritesList extends LinkedList {
    public FavoritesList() {
        super();
    }

    public FavoritesList(Collection c) {
        super(c);
    }
}
