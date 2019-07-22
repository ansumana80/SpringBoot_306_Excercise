package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController
{
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/")
    public String index(Model model) {
        //First let's create an album
        Album album = new Album();
        album.setTitle("The Java Man");
        album.setArtist("Jimah Rogers");
        album.setYear(2020);

        Album album1 = new Album();
        album1.setTitle("The Python Man");
        album1.setArtist("Ansu Rogers");
        album1.setYear(2019);
        // let's create a song
        Song song = new Song();
        song.setTitle("Anyone can learn Java");
        song.setDescription("Non Computer Science guide to get started in Java");
        song.setYear(2020);

        Song song1 = new Song();
        song1.setTitle("Bad, Bad, Java Bad");
        song1.setDescription("Java can be tough!");
        song1.setYear(2019);

        // add the song to an empty list
        Set<Song> songs = new HashSet<Song>();
        songs.add(song);
        songs.add(song1);


        // add the list of songs to the album's song list
        album.setSongs(songs);
        album1.setSongs(songs);

        //save the album to the database
        albumRepository.save(album);
        albumRepository.save(album1);

        //Grad all the directors from the database and send them to
        //the template

        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }






}
