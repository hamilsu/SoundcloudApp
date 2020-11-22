package com.soundbubble.app.controllers;

import com.soundbubble.app.dto.LabelValueForSongs;
import com.soundbubble.app.dto.Song;
import com.soundbubble.app.dto.User;
import com.soundbubble.app.services.ISoundBubbleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SoundBubbleController {
    
    @Autowired
    ISoundBubbleService soundBubbleService;
    
    Logger log = LoggerFactory.getLogger(this.getClass());
    
    
    
    
    @RequestMapping("/")
    public String index(Model model){
        return "start";
    }
    
    @GetMapping("/user/{streamLink}")
    public ResponseEntity fetchUserByUsername(@PathVariable("streamLink") String streamLink){
        User foundUser = soundBubbleService.fetchUserByName(streamLink);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundUser, headers, HttpStatus.OK);

    }

    @GetMapping("/song/{permalink}")
    public ResponseEntity fetchSongByPermalink(@PathVariable("permalink") String permalink) {
        Song foundSong = soundBubbleService.fetchSongByStream(permalink);
        //I'm not entirely sure if this header is correct for the purposes of this method
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundSong, headers, HttpStatus.OK);
    }

    //TODO: Take a look at this after testing to see if we need to handle this exception with more elegance
    @GetMapping("/songs")
    public String searchSongsForm (@RequestParam(value="searchTerm",required=false,defaultValue = "None") String searchTerm, Model model) {
        try {
            List<Song> songs = soundBubbleService.fetchSongs(searchTerm);
            model.addAttribute("song", songs);
            return "songs";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

        @GetMapping("/song/{streamLink}/")
        public ResponseEntity fetchSongByStream(@PathVariable("streamLink") String streamLink){
        Song foundSong = soundBubbleService.fetchSongByStream(streamLink);
        //I'm not entirely sure if this header is correct for the purposes of this method
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundSong, headers, HttpStatus.OK);
        
            
        }
        //TODO: Professor's project has a sustainability endpoint. Figure out why and if we need to handle a similar one

        @GetMapping("/songAutoComplete")
        @ResponseBody
        public List<LabelValueForSongs> SongNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term) {
            List<LabelValueForSongs> allSongNames = new ArrayList<LabelValueForSongs>();
            try {
                List<Song> Songs = soundBubbleService.fetchSongs(term);
                for (Song Song: Songs) {
                    LabelValueForSongs LabelValueForSongs = new LabelValueForSongs();
                    LabelValueForSongs.setLabel(Song.toString());
                    LabelValueForSongs.setValue(Song.getStream_Url());
                    allSongNames.add(LabelValueForSongs);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<LabelValueForSongs>();
            }
            return allSongNames;
        }

        @GetMapping("/{username}/favorites/")
        public ModelAndView showFavoritesList(@PathVariable ("username") String username){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Favorites");
        User user = soundBubbleService.fetchUserByName(username);
        modelAndView.addObject("favorites",user.favoritesList);
        return modelAndView;
    }
}
