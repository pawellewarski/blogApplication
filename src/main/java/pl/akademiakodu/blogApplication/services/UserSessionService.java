package pl.akademiakodu.blogApplication.services;


import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.akademiakodu.blogApplication.model.dto.UserDto;
import pl.akademiakodu.blogApplication.model.entities.User;
import pl.akademiakodu.blogApplication.ropository.UserRepository;

import java.util.Optional;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {

    @Getter
    private boolean logged;

    @Getter
    private UserDto userDto;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public boolean loginUser(String userName, String password){
        Optional<User> optionalUser = userRepository.findByUserName(userName);

        if(!optionalUser.isPresent()){
            return false;
        }

        User user = optionalUser.get();

        userDto = modelMapper.map(user, UserDto.class);
        logged = true;
        return logged;

    }

    public boolean logout(){
        logged = false;
        userDto = null;
        return true;
    }

}
