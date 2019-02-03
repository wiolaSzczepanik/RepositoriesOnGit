package com.gitrepositories.gitrepositories;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubRepoDetailsDTO {

    @JsonProperty("full_name") private String fullName;
    private String description;
    private String url;
    @JsonProperty("stargazers_count") private String stargazersCount;
    @JsonProperty("created_at") private String createdAt;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(String stargazers_count) {
        this.stargazersCount = stargazers_count;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String created_at) {
        this.createdAt = created_at;
    }
}
