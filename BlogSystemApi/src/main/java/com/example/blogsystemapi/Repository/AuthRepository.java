package com.example.blogsystemapi.Repository;

import com.example.blogsystemapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> {

   User findUserByUsername(String username);

   @Query("select c from User c where c.username=?1 or c.email=?1")
   User findbyemailorusername(String info);

    User findUserById(Integer id);


}
