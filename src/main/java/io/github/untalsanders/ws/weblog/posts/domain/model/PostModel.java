package io.github.untalsanders.ws.weblog.posts.domain.model;

/**
 * Simple POJO domain object representing a post.
 *
 * @author Sanders Gutiérrez
 */
public final class PostModel {
    private PostId id;
    private String title;
    private String content;
    private Boolean published;

    public PostModel() {
        super();
    }

    public PostModel(PostId id, String title, String content, Boolean published) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.published = published;
    }

    public PostId getId() {
        return id;
    }

    public void setId(PostId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", published=" + published +
            '}';
    }
}
