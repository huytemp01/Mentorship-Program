package mentorship.dailydev.dailydev.domain;

import java.time.LocalDateTime;

public class Process {
    private int id;
    private int rssId;
    private Status status;
    private LocalDateTime updateAt;
    private int numberOfNewPosts;

    public Process(int id, int rssId, Status status, LocalDateTime updateAt, int numberOfNewPosts) {
        this.id = id;
        this.rssId = rssId;
        this.status = status;
        this.updateAt = updateAt;
        this.numberOfNewPosts = numberOfNewPosts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRssId() {
        return rssId;
    }

    public void setRssId(int rssId) {
        this.rssId = rssId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int getNumberOfNewPosts() {
        return numberOfNewPosts;
    }

    public void setNumberOfNewPosts(int numberOfNewPosts) {
        this.numberOfNewPosts = numberOfNewPosts;
    }
}
