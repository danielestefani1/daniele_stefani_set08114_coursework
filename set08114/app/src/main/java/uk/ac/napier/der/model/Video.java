package uk.ac.napier.der.model;

/**
 * Created by Dan on 01/03/2018.
 * The code use is a get,set to be able to retrieve the video url
 * of the videos stored in my personal dropbox.
 * properly downscaled from 4k quality to add compatibility
 * to older devices
 */

public class Video {

    private String videoUrl;

    public Video(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
