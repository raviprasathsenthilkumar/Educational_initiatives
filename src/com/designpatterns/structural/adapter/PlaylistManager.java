package com.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Playlist Manager - manages playlists of media files
 */
public class PlaylistManager {
    private String playlistName;
    private List<MediaLibrary.MediaFile> playlist;
    private MediaPlayer player;
    
    public PlaylistManager(String playlistName, MediaPlayer player) {
        this.playlistName = playlistName;
        this.player = player;
        this.playlist = new ArrayList<>();
    }
    
    public void addToPlaylist(String fileName, String fileType) {
        playlist.add(new MediaLibrary.MediaFile(fileName, fileType));
        System.out.println("Added to playlist '" + playlistName + "': " + fileName);
    }
    
    public void playPlaylist() {
        System.out.println("\nPlaying playlist: " + playlistName);
        System.out.println("=".repeat(40));
        for (int i = 0; i < playlist.size(); i++) {
            MediaLibrary.MediaFile file = playlist.get(i);
            System.out.println("Track " + (i + 1) + ":");
            player.play(file.getFileType(), file.getFileName());
        }
        System.out.println("=".repeat(40));
    }
    
    public void removeFromPlaylist(int index) {
        if (index >= 0 && index < playlist.size()) {
            MediaLibrary.MediaFile removed = playlist.remove(index);
            System.out.println("Removed from playlist: " + removed.getFileName());
        }
    }
    
    public int getPlaylistSize() {
        return playlist.size();
    }
    
    public String getPlaylistName() {
        return playlistName;
    }
}