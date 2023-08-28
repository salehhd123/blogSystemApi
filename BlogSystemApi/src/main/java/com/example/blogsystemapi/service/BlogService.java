package com.example.blogsystemapi.service;


import com.example.blogsystemapi.Api.ApiExeption;
import com.example.blogsystemapi.Model.Blog;
import com.example.blogsystemapi.Model.User;
import com.example.blogsystemapi.Repository.AuthRepository;
import com.example.blogsystemapi.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final AuthRepository authRepository;
    private final BlogRepository blogRepository;


    public List<Blog> getAll(){
        return blogRepository.findAll();
    }
   public List<Blog> get(Integer id){
       User user = authRepository.findUserById(id);
       return blogRepository.findAllByUser(user);
   }


    public void BlogAdd(Integer id,Blog blog)
    {
        User user = authRepository.findUserById(id);
        //one to many
        blog.setUser(user);
        blogRepository.save(blog);
    }

    public void BlogUpdate(Integer id,Integer blogID,Blog blog){
        User user = authRepository.findUserById(id);
        Blog blog1 = blogRepository.findBlogById(blogID);
        if (blog1==null){
            throw new ApiExeption("Id not Found");
        }
        if (blog1.getUser()!=user){
            throw new ApiExeption("Id not Found");
        }
        blog1.setTitle(blog.getTitle());
        blog1.setBody(blog.getBody());
        blogRepository.save(blog1);
    }


    public void BlogDelete(Integer id,Integer blogID){
        User user = authRepository.findUserById(id);
        Blog blog1 = blogRepository.findBlogById(blogID);
        if (blog1==null){
            throw new ApiExeption("Id not Found");
        }
        if (blog1.getUser()!=user){
            throw new ApiExeption("Id not Found");
        }
        blogRepository.delete(blog1);
    }


    public List<Blog> find(Integer id, String title){
        User user = authRepository.findUserById(id);
        List<Blog> g = blogRepository.findAllBytitle(user,title);
        if (g.isEmpty()){
            throw new ApiExeption("wrong title");
        }
        return g;
    }





}
