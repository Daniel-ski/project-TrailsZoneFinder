package com.example.trailszonefinder.model.entity;

import com.example.trailszonefinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(optional = false)
    private User author;

    @Column(name = "video_url")
    private String videoUrl;
    @OneToMany(targetEntity = Comment.class,mappedBy = "route")
    private List<Comment> comments;

    @OneToMany(targetEntity = Picture.class,mappedBy = "route")
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    public Route() {
        this.comments = new ArrayList<>();
        this.pictures = new HashSet<>();
        this.categories = new HashSet<>();
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
