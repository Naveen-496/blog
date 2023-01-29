package dev.blog.controller;

import dev.blog.repository.AuthorRepository;
import dev.blog.repository.PostRepository;
import dev.blog.model.Post;
import dev.blog.model.dto.PostDetails;
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
