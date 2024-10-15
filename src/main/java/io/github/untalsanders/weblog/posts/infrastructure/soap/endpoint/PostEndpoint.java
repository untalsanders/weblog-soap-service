package io.github.untalsanders.weblog.posts.infrastructure.soap.endpoint;

import io.github.untalsanders.weblog.posts.application.service.PostService;
import io.github.untalsanders.weblog.posts.domain.model.PostModel;
import io.github.untalsanders.weblog.soap.Post;
import io.github.untalsanders.weblog.soap.PostListResponse;
import io.github.untalsanders.weblog.soap.PostRequest;
import io.github.untalsanders.weblog.soap.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Endpoint
public class PostEndpoint {
    private static final String NAMESPACE_URI = "https://io.github.untalsanders/ws/soap";

    private final PostService postService;

    @Autowired
    public PostEndpoint(PostService postService) {
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postListResponse")
    @ResponsePayload
    public PostListResponse getPosts() {
        List<Post>  postList = new ArrayList<>();
        postService.getPosts().forEach(post -> {
            Post p = new Post();
            p.setId(post.getId().value());
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            p.setPublished(post.getPublished());
            postList.add(p);
        });
        PostListResponse response = new PostListResponse();
        response.getPosts().addAll(postList);
        return response;
    }
}
