package io.github.untalsanders.ws.demo;

import io.github.untalsanders.ws.demo.soap.Post;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PostRepository {
    private static final Map<Long, Post> posts = new HashMap<>();

    @PostConstruct
    public void initData() {
        Post post1 = new Post();
        post1.setId(1L);
        post1.setTitle("Post 1");
        post1.setContent("This is a post 1");
        post1.setPublished(true);

        posts.put(post1.getId(), post1);

        Post post2 = new Post();
        post2.setId(2L);
        post2.setTitle("Post 2");
        post2.setContent("This is a post 2");
        post2.setPublished(true);

        posts.put(post2.getId(), post2);

        Post post3 = new Post();
        post3.setId(3L);
        post3.setTitle("Post 3");
        post3.setContent("This is a post 3");
        post3.setPublished(false);

        posts.put(post3.getId(), post3);
    }

    public Post findPostById(Long id) {
        return posts.get(id);
    }
}
