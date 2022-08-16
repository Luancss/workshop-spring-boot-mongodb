package com.luancss.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luancss.workshopmongo.domain.Post;
import com.luancss.workshopmongo.repository.PostRepository;
import com.luancss.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if(post.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post.get();
	}
	
}