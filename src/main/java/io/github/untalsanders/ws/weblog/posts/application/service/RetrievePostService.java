package io.github.untalsanders.ws.weblog.posts.application.service;

import io.github.untalsanders.ws.weblog.posts.domain.exception.PostNotFoundException;
import io.github.untalsanders.ws.weblog.posts.domain.model.PostModel;
import io.github.untalsanders.ws.weblog.posts.domain.repository.PostRepository;
import io.github.untalsanders.ws.weblog.posts.domain.usecase.RetrievePostUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetrievePostService implements RetrievePostUseCase {
    private final PostRepository postRepository;

    public RetrievePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostModel> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostModel> getPostById(final String id) throws PostNotFoundException {
        Optional<PostModel> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }
        return post;
    }
}
