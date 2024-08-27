package io.github.untalsanders.ws.demo.application.service;

import io.github.untalsanders.ws.demo.domain.exception.PostNotFoundException;
import io.github.untalsanders.ws.demo.domain.model.Post;
import io.github.untalsanders.ws.demo.domain.repository.PostRepository;
import io.github.untalsanders.ws.demo.domain.usecase.RetrievePostUseCase;

import java.util.Optional;

public class RetrievePostService implements RetrievePostUseCase {
    private final PostRepository postRepository;

    public RetrievePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> getPost(Long id) throws PostNotFoundException {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }
        return post;
    }
}
