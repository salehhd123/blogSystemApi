package com.example.blogsystemapi.service;


import com.example.blogsystemapi.Api.ApiExeption;
import com.example.blogsystemapi.Model.User;
import com.example.blogsystemapi.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetialsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=authRepository.findbyemailorusername(username);
        if (user==null){
            throw new ApiExeption("Wrong username or password");
        }
      return user;
    }




}
