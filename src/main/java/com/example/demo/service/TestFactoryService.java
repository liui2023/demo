package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.factory.BaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestFactoryService {

    @Autowired
    private BaseFactory<UserDTO> userDTOBaseFactory;

    public void test(){
        userDTOBaseFactory.create(new UserDTO());
    }
}
