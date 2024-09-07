package io.github.untalsanders.ws.weblog.posts.infrastructure.soap.endpoint;

import io.github.untalsanders.ws.weblog.posts.application.service.RetrievePostService;
import io.github.untalsanders.ws.weblog.posts.domain.model.PostModel;
import io.github.untalsanders.ws.weblog.soap.Post;
import io.github.untalsanders.ws.weblog.soap.PostRequest;
import io.github.untalsanders.ws.weblog.soap.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class PostEndpoint {
    private static final String NAMESPACE_URI = "https://io.github.untalsanders/ws/soap";

    private final RetrievePostService postService;

    @Autowired
    public PostEndpoint(RetrievePostService postService) {
        this.postService = postService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postRequest")
    @ResponsePayload
    public PostResponse getPost(@RequestPayload PostRequest request) {
        Optional<PostModel> postModel = postService.getPostById(request.getId());
        Post post = new Post();
        if (postModel.isPresent()) {
            post.setId(postModel.get().getId().value());
            post.setTitle(postModel.get().getTitle());
            post.setContent(postModel.get().getContent());
            post.setPublished(postModel.get().getPublished());
        }
        PostResponse response = new PostResponse();
        response.setPost(post);
        return response;
    }
}
