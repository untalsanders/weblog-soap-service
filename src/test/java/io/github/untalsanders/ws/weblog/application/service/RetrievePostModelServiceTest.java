package io.github.untalsanders.ws.weblog.application.service;

import io.github.untalsanders.ws.weblog.posts.application.service.RetrievePostService;
import io.github.untalsanders.ws.weblog.posts.domain.model.PostModel;
import io.github.untalsanders.ws.weblog.posts.domain.model.PostId;
import io.github.untalsanders.ws.weblog.posts.domain.exception.PostNotFoundException;
import io.github.untalsanders.ws.weblog.posts.domain.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrievePostModelServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private RetrievePostService service;

    @Test
    @DisplayName("Should retrieve a post")
    public void shouldRetrievePost() {
        final PostId postId = new PostId(UUID.randomUUID().toString());
        final PostModel postModelToRetrieve = new PostModel(postId, "Post #1", "Post number one", true);

        when(postRepository.findById(postId.value())).thenReturn(Optional.of(postModelToRetrieve));
        final Optional<PostModel> postRetrieved = service.getPostById(postId.value());
        assertThat(postRetrieved.isPresent()).isTrue();
        assertEquals(postRetrieved.get().getId().value(), postId.value());
        assertThat(postRetrieved.get().getTitle()).contains("Post #1");
        assertThat(postRetrieved.get().getContent()).contains("Post number one");
        assertTrue(postRetrieved.get().getPublished());
    }

    @Test
    @DisplayName("Should throw exception because the post was not found")
    public void shouldNotRetrievePostIfPostNotFound() {
        final PostId postId = new PostId(UUID.randomUUID().toString());
        when(postRepository.findById(postId.value())).thenReturn(Optional.empty());
        RuntimeException runtimeException = assertThrows(PostNotFoundException.class, () -> service.getPostById(postId.value()));
        String expectedMessage = "Post not found";
        assertThat(runtimeException.getMessage()).isEqualTo(expectedMessage);
    }
}