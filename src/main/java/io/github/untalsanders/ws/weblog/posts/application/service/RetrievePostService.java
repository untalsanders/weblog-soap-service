package io.github.untalsanders.ws.weblog.posts.application.service;

import io.github.untalsanders.ws.weblog.posts.domain.PostNotFoundException;
import io.github.untalsanders.ws.weblog.posts.domain.Post;
import io.github.untalsanders.ws.weblog.posts.domain.PostRepository;
import io.github.untalsanders.ws.weblog.posts.domain.RetrievePostUseCase;

import java.util.Optional;

public class RetrievePostService implements RetrievePostUseCase {
    private final PostRepository postRepository;

    public RetrievePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> getPost(String id) throws PostNotFoundException {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }
        return post;
    }
}
