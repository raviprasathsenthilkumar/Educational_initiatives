package com.designpatterns.structural.adapter;

public class Mp4Player implements AdvancedMediaPlayer {
    
    @Override
    public void playMp4(String fileName) {
        System.out.println("  🎬 Playing MP4 file: " + fileName);
    }
    
    @Override
    public void playVlc(String fileName) {
        // Not supported by this player
    }
}