package io.github.untalsanders.ws.demo.application.service;

import io.github.untalsanders.ws.demo.domain.exception.PostNotFoundException;
import io.github.untalsanders.ws.demo.domain.model.Post;
import io.github.untalsanders.ws.demo.domain.repository.PostRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrievePostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private RetrievePostService service;

    @Test
    public void shouldRetrievePost() {
        Post postToRetrieve = new Post(1L, "Post #1", "Post number one");
        final Long postId = 1L;
        when(postRepository.findById(postId)).thenReturn(Optional.of(postToRetrieve));
        final Optional<Post> postRetrieved = service.getPost(postId);
        assertThat(postRetrieved.isPresent()).isTrue();
        assertEquals(postRetrieved.get().getId(), postId);
        assertEquals(postRetrieved.get().getTitle(), "Post #1");
    }

    @Test
    @Disabled
    public void shouldNotRetrievePostIfPostNotFound() {
        final Long postId = 2L;
        when(postRepository.findById(postId)).thenReturn(Optional.empty());
        final Optional<Post> postRetrieved = service.getPost(postId);
        assertThat(postRetrieved.isPresent()).isFalse();
        RuntimeException exception = assertThrows(PostNotFoundException.class, () -> service.getPost(postId));
        assertThat(exception.getMessage()).isEqualTo("Post not found");
    }
}