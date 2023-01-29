package dev.danvega.blog.controller;

import dev.danvega.blog.model.Post;
import dev.danvega.blog.model.dto.PostDetails;
import dev.danvega.blog.repository.AuthorRepository;
import dev.danvega.blog.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping()
    public Iterable<Post> findAllPosts(){
        return postRepository.findAll();
    }
    @GetMapping("/{id}")
    public Post findPost(@PathVariable Integer id){
        return postRepository.findById(id).orElse(null);
    }
    @GetMapping("/{id}/details")
    public PostDetails getDetails(@PathVariable Integer id){
        Post post = postRepository.findById(id).orElse(null);
        return new PostDetails(post , authorRepository.findById(post.getAuthor().getId()).get());
    }

}
