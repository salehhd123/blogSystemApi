package com.example.blogsystemapi.Repository;


import com.example.blogsystemapi.Model.Blog;
import com.example.blogsystemapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Blog findBlogById(Integer id);
    List<Blog> findAllByUser(User user);


    @Query("select c from Blog c where c.user=?1 and c.title=?2")
    List<Blog> findAllBytitle(User user,String title);


}
