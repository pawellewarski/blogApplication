package pl.akademiakodu.blogApplication.model.forms;


import lombok.*;

@Getter
@Setter
@ToString(exclude = "password")
public class LoginForm {

    private String userName;
    private String password;




}
