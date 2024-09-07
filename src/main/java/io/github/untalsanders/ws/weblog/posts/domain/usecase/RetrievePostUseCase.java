package io.github.untalsanders.ws.weblog.posts.domain.usecase;

import io.github.untalsanders.ws.weblog.posts.domain.exception.PostNotFoundException;
import io.github.untalsanders.ws.weblog.posts.domain.model.PostModel;

import java.util.List;
import java.util.Optional;

public interface RetrievePostUseCase {
    /**
     * Retrieve all <code>Post</code>s.
     *
     * @return <code>Collection</code> of <code>Post</code>s
     */
    List<PostModel> getPosts();

    /**
     * Retrieve a <code>Post</code> by id.
     *
     * @param id the id to search for
     * @return the <code>Post</code> if found
     */
    Optional<PostModel> getPostById(String id) throws PostNotFoundException;
}
