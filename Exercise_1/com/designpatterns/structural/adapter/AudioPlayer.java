package com.designpatterns.structural.adapter;

/**
 * Concrete Target - Audio Player (can play MP3 natively)
 * Uses adapter for formats it doesn't support natively
 */
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;
    
    @Override
    public void play(String audioType, String fileName) {
        // Normalize input
        audioType = audioType.toLowerCase().trim();
        
        // Native support for MP3
        if (audioType.equals("mp3")) {
            System.out.println("  🎵 Playing MP3 file: " + fileName);
        }
        // Use adapter for other formats (MP4, VLC)
        else if (audioType.equals("mp4") || audioType.equals("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        // Unsupported format
        else {
            System.out.println("  ❌ Invalid media format: " + audioType + ". Format not supported.");
        }
    }
}