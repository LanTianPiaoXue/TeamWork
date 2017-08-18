package java8.character.lambda.dao;

import java8.character.lambda.entity.Album;
import java8.character.lambda.entity.Artist;
import java8.character.lambda.entity.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/7/9.
 */
public class DbData {
    public List<Album> getAlbums(int albumAmount,int musicianAmount,int trackAmount){
        List<Album> albums = new ArrayList<>();
        if(albumAmount < 2){
            albumAmount = 1;
        }
       for (int i = 0; i < albumAmount ; i++){
           Album album = new Album();
           album.setName("模特专辑");
           album.setTracks(this.getTracks(trackAmount));
           album.setMusicians(this.getArtists(musicianAmount));
           albums.add(album);
       }
        return albums;
    }

    private List<Track> getTracks(int trackAmount) {
        List<Track> tracks = new ArrayList<>();
        for (int i = 0;i < trackAmount; i++){
            Track track = new Track();
            track.setName("模特"+i);
            tracks.add(track);
        }
        return tracks;
    }


    public List<Artist> getArtists(int amount){
        if(amount < 2){
            amount = 1;
        }
        List<Artist> artists = new ArrayList<Artist>();
        for(int i = 0; i< amount; i++){
            Artist a = new Artist();
            a.setName("甲壳虫乐队"+i+",好妹妹乐队");
            a.setMembres(Arrays.asList(new String[]{"约翰"+i,"桥"+i,"列侬"+i,"卡尔"+i}));
            a.setOrigin("China"+i);
            artists.add(a);
        }
        return  artists;
    }
}
