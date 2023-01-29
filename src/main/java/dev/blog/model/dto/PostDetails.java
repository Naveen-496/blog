package dev.blog.model.dto;

import dev.blog.model.Author;
import dev.blog.model.Post;

public record PostDetails(Post post , Author author) {
}
