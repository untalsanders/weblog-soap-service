package io.github.untalsanders.ws.weblog.posts.domain;

/**
 * Simple POJO domain object representing a post.
 *
 * @author Sanders Gutiérrez
 */
public final class Post {
    private final PostId id;
    private final String title;
    private final String content;
    private final Boolean published;

    public Post(PostId id, String title, String content, Boolean published) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.published = published;
    }

    public PostId id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String content() {
        return content;
    }

    public Boolean published() {
        return published;
    }
}
