package com.example.demo.factory;

import com.example.demo.dto.UserDTO;
import com.example.demo.request.BaseRequest;
import org.springframework.stereotype.Component;

@Component
public class UserFactory implements BaseFactory<UserDTO> {
    @Override
    public BaseRequest create(UserDTO input) {
        System.out.println("user factory ……");
        return null;
    }

    public <T> T test(T input){
        return input;
    }
}
