package io.github.untalsanders.ws.weblog.posts.infrastructure.persistence;

import io.github.untalsanders.ws.weblog.posts.domain.model.PostId;
import io.github.untalsanders.ws.weblog.posts.domain.model.PostModel;
import io.github.untalsanders.ws.weblog.posts.domain.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPostRepository implements PostRepository {
    private static final Map<String, PostModel> posts = new HashMap<>();

    @PostConstruct
    private void initData() {
        PostModel postModel1 = new PostModel();
        PostId postId1 = new PostId(String.valueOf(UUID.randomUUID()));
        postModel1.setId(postId1);
        postModel1.setTitle("Post 1");
        postModel1.setContent("This is a post 1");
        postModel1.setPublished(true);

        PostModel postModel2 = new PostModel();
        PostId postId2 = new PostId(String.valueOf(UUID.randomUUID()));
        postModel2.setId(postId2);
        postModel2.setTitle("Post 2");
        postModel2.setContent("This is a post 2");
        postModel2.setPublished(true);

        PostModel postModel3 = new PostModel();
        PostId postId3 = new PostId(String.valueOf(UUID.randomUUID()));
        postModel3.setId(postId3);
        postModel3.setTitle("Post 3");
        postModel3.setContent("This is a post 3");
        postModel3.setPublished(false);

        posts.put(postModel1.getId().value(), postModel1);
        posts.put(postModel2.getId().value(), postModel2);
        posts.put(postModel3.getId().value(), postModel3);
    }

    @Override
    public List<PostModel> findAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Optional<PostModel> findById(final String id) {
        Objects.requireNonNull(id, "id must not be null");
        return Optional.ofNullable(posts.get(id));
    }
}
