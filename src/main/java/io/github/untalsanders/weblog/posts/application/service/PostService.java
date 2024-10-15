package io.github.untalsanders.weblog.posts.application.service;

import io.github.untalsanders.weblog.posts.domain.exception.PostNotFoundException;
import io.github.untalsanders.weblog.posts.domain.model.PostModel;
import io.github.untalsanders.weblog.posts.domain.repository.PostRepository;
import io.github.untalsanders.weblog.posts.domain.usecase.RetrievePostUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements RetrievePostUseCase {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
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
