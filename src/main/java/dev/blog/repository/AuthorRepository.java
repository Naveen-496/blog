package dev.blog.repository;

import dev.blog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author , Integer> {
}
