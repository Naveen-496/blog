package dev.danvega.blog.repository;

import dev.danvega.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post , Integer>
{

}
