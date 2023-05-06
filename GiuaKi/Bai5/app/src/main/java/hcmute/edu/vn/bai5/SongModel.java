package hcmute.edu.vn.bai5;

import java.io.Serializable;

public class SongModel implements Serializable {
    private String mCode;
    private String mTitle;
    private String mLyric;
    private String mArtist;

    public SongModel(String code, String title, String lyric, String artist) {
        mCode = code;
        mTitle = title;
        mLyric = lyric;
        mArtist = artist;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLyric() {
        return mLyric;
    }

    public void setLyric(String lyric) {
        mLyric = lyric;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }
}