package io.github.untalsanders.weblog;

import io.github.untalsanders.weblog.posts.infrastructure.soap.endpoint.PostEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WeblogApplicationTests {

    @Autowired
    private PostEndpoint postEndpoint;

    @Test
    void contextLoads() {
        WeblogApplication.main(new String[] {});
    }

    @Test
    @DisplayName("Should exist postEndpoint in actual context")
    void shouldExistPostEndpoint() {
        assertThat(postEndpoint).isNotNull();
    }

}
