package com.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Media Library - demonstrates usage with Dependency Inversion
 * Manages a collection of media files
 */
public class MediaLibrary {
    private MediaPlayer player;
    private List<MediaFile> mediaFiles;
    
    public MediaLibrary(MediaPlayer player) {
        this.player = player;
        this.mediaFiles = new ArrayList<>();
    }
    
    public void addMediaFile(String fileName, String fileType) {
        mediaFiles.add(new MediaFile(fileName, fileType));
    }
    
    public void playMedia(String audioType, String fileName) {
        System.out.println("Requesting: " + audioType.toUpperCase() + " - " + fileName);
        player.play(audioType, fileName);
        System.out.println();
    }
    
    public void playAllMedia() {
        System.out.println("Playing all media in library:");
        for (MediaFile file : mediaFiles) {
            playMedia(file.getFileType(), file.getFileName());
        }
    }
    
    public List<MediaFile> getMediaFiles() {
        return new ArrayList<>(mediaFiles);
    }
    
    public int getMediaCount() {
        return mediaFiles.size();
    }
    
    // Inner class to represent a media file
    public static class MediaFile {
        private String fileName;
        private String fileType;
        
        public MediaFile(String fileName, String fileType) {
            this.fileName = fileName;
            this.fileType = fileType;
        }
        
        public String getFileName() {
            return fileName;
        }
        
        public String getFileType() {
            return fileType;
        }
    }
}