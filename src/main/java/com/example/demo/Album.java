package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String artist;
    private String title;
    private long year;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL,
   fetch = FetchType.EAGER)
    public Set<Song> songs;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
