package dev.blog.repository;

import dev.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post , Integer>
{

}
