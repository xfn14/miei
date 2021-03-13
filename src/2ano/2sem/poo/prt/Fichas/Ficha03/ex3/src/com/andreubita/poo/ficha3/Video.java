package com.andreubita.poo.ficha3;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Video {
    private String name;
    private byte[] video;
    private LocalDate postedOn;
    private int resolution;
    private Tuple<Integer,Integer> duration; // <Minutes,Seconds>
    private String[] comments;
    private int likes;
    private int dislikes;

    public Video(){
        this.name = "Me at the zoo";
        this.video = new byte[32];
        this.postedOn = LocalDate.of(2005, 4, 23);
        this.resolution = 240;
        this.duration = new Tuple<>(0,19);
        setComments(new String[0]);
        this.comments = new String[0];
        this.likes = 7200000;
        this.dislikes = 178000;
    }

    public Video(String name, byte[] video, int resolution,
                 Tuple<Integer, Integer> duration, int likes,
                 int dislikes) {
        this.name = name;
        this.video = video;
        this.postedOn = LocalDate.now();
        this.resolution = resolution;
        this.duration = duration;
        setComments(new String[0]);
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Video(Video video1){
        this.name = video1.getName();
        this.video = video1.getVideo();
        this.postedOn = video1.getPostedOn();
        this.resolution = video1.getResolution();
        this.duration = video1.getDuration();
        setComments(video1.getComments());
        this.likes = video1.getLikes();
        this.dislikes = video1.getDislikes();
    }

    public void insertComment(String comment){
        this.comments = Arrays.copyOf(this.comments, this.comments.length+1);
        this.comments[this.comments.length-1] = comment;
    }

    public long daysAfter(){
        return Duration.between(this.postedOn, LocalDate.now()).toDays();
    }

    public void thumbsUp(){
        this.likes++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getVideo() {
        return Arrays.copyOf(this.video, this.video.length);
    }

    public void setVideo(byte[] video) {
        this.video = Arrays.copyOf(this.video, this.video.length);
    }

    public LocalDate getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(LocalDate postedOn) {
        this.postedOn = postedOn;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public Tuple<Integer, Integer> getDuration() {
        return duration;
    }

    public void setDuration(Tuple<Integer, Integer> duration) {
        this.duration = duration;
    }

    public String[] getComments() {
        return Arrays.copyOf(this.comments, this.comments.length);
    }

    public void setComments(String[] comments) {
        this.comments = Arrays.copyOf(this.comments, this.comments.length);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        ArrayList<Integer> test = new ArrayList<>(40);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video1 = (Video) o;
        return resolution == video1.resolution &&
                likes == video1.likes &&
                dislikes == video1.dislikes &&
                this.name.equals(video1.getName()) &&
                Arrays.equals(video, video1.video) &&
                Objects.equals(postedOn, video1.postedOn) &&
                Objects.equals(duration, video1.duration) &&
                Arrays.equals(comments, video1.comments);
    }

    // Funçao processa?
    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", video=" + Arrays.toString(video) +
                ", postedOn=" + postedOn +
                ", resolution=" + resolution +
                ", duration=" + duration +
                ", comments=" + Arrays.toString(comments) +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}
