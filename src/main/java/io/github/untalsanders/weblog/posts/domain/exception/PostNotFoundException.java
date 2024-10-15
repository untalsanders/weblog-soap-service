package io.github.untalsanders.weblog.posts.domain.exception;

/**
 * A class that extends <code>RuntimeException</code> to customize the error
 * message when a <code>Post</code> not is found.
 *
 * @author Sanders Gutiérrez
 */
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
