package io.github.untalsanders.ws.demo.domain.model;

import lombok.*;

/**
 * Simple POJO domain object representing a post.
 *
 * @author Sanders Gutiérrez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
}
