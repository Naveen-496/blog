package dev.blog;

import dev.blog.model.Author;
import dev.blog.model.Comment;
import dev.blog.model.Post;
import dev.blog.repository.AuthorRepository;
import dev.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(PostRepository posts , AuthorRepository authors){
		return args -> {
			AggregateReference<Author , Integer> naveen = AggregateReference.to (authors.save( new Author(null , "Naveen" , "Reddy" ,"naveenreddy@gmail.com" , "Naveen@111")).id());
			Post post = new Post("Hello World!" , "Welcome to my Blog" , naveen );
			post.addComment( new Comment("Naveen", "This is my First Comment"));
			posts.save(post);
		};
	}

}
