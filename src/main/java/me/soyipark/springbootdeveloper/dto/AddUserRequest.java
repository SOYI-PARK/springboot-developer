package me.soyipark.springbootdeveloper.dto;

import lombok.Getter;
import lombok.Setter;
import me.soyipark.springbootdeveloper.domain.Article;
import me.soyipark.springbootdeveloper.domain.User;

@Getter
@Setter
public class AddUserRequest {
    private String email;
    private String password;
}
