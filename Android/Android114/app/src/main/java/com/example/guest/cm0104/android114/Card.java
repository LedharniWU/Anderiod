package com.example.guest.cm0104.android114;

/**
 * Created by guest on 2019/01/08.
 */

public class Card {
    private String japanese;
    private String english;
    private int id;

    public Card(String japanese, String english, int id) {
        this.japanese = japanese;
        this.english = english;
        this.id = id;
    }

    public String getJapanese() {
        return japanese;
    }

    public String getEnglish() {
        return english;
    }

    public int getId() {
        return id;
    }
}

