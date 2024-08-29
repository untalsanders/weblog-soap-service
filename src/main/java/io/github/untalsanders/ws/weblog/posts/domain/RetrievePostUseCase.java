package io.github.untalsanders.ws.weblog.posts.domain;

import java.util.Optional;

public interface RetrievePostUseCase {
    /**
     * Retrieve a <code>Post</code> by id.
     *
     * @param id the id to search for
     * @return the <code>Post</code> if found
     */
    Optional<Post> getPost(String id) throws PostNotFoundException;
}
