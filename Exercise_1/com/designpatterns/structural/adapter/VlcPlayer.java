package com.designpatterns.structural.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {
    
    @Override
    public void playMp4(String fileName) {
        // Not supported by this player
    }
    
    @Override
    public void playVlc(String fileName) {
        System.out.println("  📺 Playing VLC file: " + fileName);
    }
}