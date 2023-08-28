package com.example.blogsystemapi.Controller;

import com.example.blogsystemapi.Api.ApiResponse;
import com.example.blogsystemapi.Model.Blog;
import com.example.blogsystemapi.Model.User;
import com.example.blogsystemapi.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAllBlog() {
        return ResponseEntity.status(200).body(blogService.getAll());
    }


    @GetMapping("/getMyBlog")
    public ResponseEntity getMyTodo(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(blogService.get(user.getId()));
    }


    @PostMapping("/add")
    public ResponseEntity addTodo(@AuthenticationPrincipal User user,@RequestBody Blog blog) {
        blogService.BlogAdd(user.getId(),blog);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@AuthenticationPrincipal User user,@PathVariable Integer id , @RequestBody Blog blog) {
        blogService.BlogUpdate(user.getId(),id,blog);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@AuthenticationPrincipal User user,@PathVariable Integer id) {
        blogService.BlogDelete(user.getId(),id);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }



    @GetMapping("/find/{name}")
    public ResponseEntity deleteTodo(@AuthenticationPrincipal User user,@PathVariable String name) {
        return ResponseEntity.status(200).body(blogService.find(user.getId(),name));
    }



}
