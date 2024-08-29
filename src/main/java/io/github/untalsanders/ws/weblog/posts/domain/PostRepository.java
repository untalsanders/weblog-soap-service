package io.github.untalsanders.ws.weblog.posts.domain;

import java.util.Optional;

/**
 * Repository class for <code>Post</code> domain objets. All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data see here: <a href="http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation">http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation</a>
 *
 * @author Sanders Gutiérrez
 */
public interface PostRepository {
    /**
     * Retrieve a <code>Post</code>s from the data store.
     *
     * @param id the id to search for
     * @return <code>Optional</code> of <code>Post</code>
     */
    Optional<Post> findById(String id);
}
