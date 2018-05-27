package com.example.test.instagram.models;

public class UserAccountSettings {

    private String description;
    private String display_name;
    private long follwers;
    private long follwing;
    private long posts;
    private String profile_photo;
    private String username;
    private String website;

    public UserAccountSettings(String description, String display_name, long follwers, long follwing, long posts, String profile_photo, String username, String website) {
        this.description = description;
        this.display_name = display_name;
        this.follwers = follwers;
        this.follwing = follwing;
        this.posts = posts;
        this.profile_photo = profile_photo;
        this.username = username;
        this.website = website;
    }

    public UserAccountSettings(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public long getFollwers() {
        return follwers;
    }

    public void setFollwers(long follwers) {
        this.follwers = follwers;
    }

    public long getFollwing() {
        return follwing;
    }

    public void setFollwing(long follwing) {
        this.follwing = follwing;
    }

    public long getPosts() {
        return posts;
    }

    public void setPosts(long posts) {
        this.posts = posts;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "UserAccountSettings{" +
                "description='" + description + '\'' +
                ", display_name='" + display_name + '\'' +
                ", follwers=" + follwers +
                ", follwing=" + follwing +
                ", posts=" + posts +
                ", profile_photo='" + profile_photo + '\'' +
                ", username='" + username + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
