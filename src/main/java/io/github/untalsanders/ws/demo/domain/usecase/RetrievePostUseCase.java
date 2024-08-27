package io.github.untalsanders.ws.demo.domain.usecase;

import io.github.untalsanders.ws.demo.domain.exception.PostNotFoundException;
import io.github.untalsanders.ws.demo.domain.model.Post;

import java.util.Optional;

public interface RetrievePostUseCase {
    /**
     * Retrieve a <code>Post</code> by id.
     *
     * @param id the id to search for
     * @return the <code>Post</code> if found
     */
    Optional<Post> getPost(Long id) throws PostNotFoundException;
}
