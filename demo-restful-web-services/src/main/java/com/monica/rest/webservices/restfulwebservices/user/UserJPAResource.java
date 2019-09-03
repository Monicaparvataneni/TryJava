package com.monica.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	@Autowired
	private UserRepository userRepository;
	private PostRepository postRepository;

	// retrieve all users //Get /users
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	// retrieve one user //get /users{id} Later HATEOAS
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id=" + id);
		// all-users - Hateoas - link to method
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	// add one user
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User newUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	// delete user
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);

	}
	// retrieve one user //get /users{id} Later HATEOAS
		@GetMapping("/jpa/users/{id}/posts")
		public List<Post> retrieveAllPosts(@PathVariable int id) {
			Optional<User> user = userRepository.findById(id);
			if (!user.isPresent())
				throw new UserNotFoundException("id=" + id);
			return user.get().getPosts();
			// all-users - Hateoas - link to method
			/*Resource<User> resource = new Resource<User>(user.get());
			ControllerLinkBuilder linkTo = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
			resource.add(linkTo.withRel("all-users"));
			return resource;*/
		}
		@GetMapping("/jpa/users/{userId}/posts/{id}")
		public Post retrievePostById(@PathVariable int id,@PathVariable int userId) throws Exception {
			Optional<User> user = userRepository.findById(userId);
			if (!user.isPresent())
				throw new UserNotFoundException("id=" + id);
			List<Post> posts= user.get().getPosts();
			Post post = posts.get(id);
			if(post ==null)
				throw new Exception();
			else
			return post;
		}
		// add one user
		@PostMapping("/jpa/users/{id}/posts")
		public ResponseEntity<Object> addPost(@PathVariable int id,Post post) {
			Optional<User> userOptional = userRepository.findById(id);
			if(!userOptional.isPresent()){
				throw new UserNotFoundException("id - "+id);
			}
			User user = userOptional.get();
			post.setUser(user);
			postRepository.save(post);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
}
