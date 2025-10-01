package com.designpatterns.structural.adapter;

/**
 * Target Interface - what the client expects
 * Defines the interface for media playback
 */
public interface MediaPlayer {
    void play(String audioType, String fileName);
}