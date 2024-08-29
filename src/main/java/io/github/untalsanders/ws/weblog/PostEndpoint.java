package io.github.untalsanders.ws.weblog;

import io.github.untalsanders.ws.weblog.soap.PostRequest;
import io.github.untalsanders.ws.weblog.soap.PostResponse;
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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postRequest")
    @ResponsePayload
    public PostResponse getPost(@RequestPayload PostRequest request) {
        PostResponse response = new PostResponse();
        response.setPost(repository.findPostById(request.getId()));
        return response;
    }
}
