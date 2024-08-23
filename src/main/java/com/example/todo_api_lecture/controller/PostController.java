package com.example.todo_api_lecture.controller;

import com.example.todo_api_lecture.entity.Post;
import com.example.todo_api_lecture.service.PostService;
import com.example.todo_api_lecture.service.TodoService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/posts")
public class PostController {


    private final PostService postService;
    private final TodoService todoService;


    // GET /api/posts - Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // GET /api/posts/{id} - Get a post by id
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return ResponseEntity.ok(post);
    }

    // POST /api/posts - Create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // PUT /api/posts/{id} - Update a post
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Post updatedPost = postService.updatePost(id, postDetails);
        return ResponseEntity.ok(updatedPost);
    }

    // DELETE /api/posts/{id} - Delete a post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
