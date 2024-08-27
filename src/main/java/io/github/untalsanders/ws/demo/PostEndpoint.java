package io.github.untalsanders.ws.demo;

import io.github.untalsanders.ws.demo.soap.GetPostRequest;
import io.github.untalsanders.ws.demo.soap.GetPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PostEndpoint {
    private static final String NAMESPACE_URI = "https://io.github.untalsanders/ws/soap";

    private final PostRepository repository;

    @Autowired
    public PostEndpoint(PostRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPostRequest")
    @ResponsePayload
    public GetPostResponse getPost(@RequestPayload GetPostRequest request) {
        GetPostResponse response = new GetPostResponse();
        response.setPost(repository.findPostById(request.getId()));
        return response;
    }
}
