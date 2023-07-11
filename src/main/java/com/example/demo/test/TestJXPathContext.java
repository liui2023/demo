package com.example.demo.test;

import com.example.demo.dto.UserDTO;
import org.apache.commons.jxpath.JXPathContext;

public class TestJXPathContext {

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setVersions(1L);
        JXPathContext ctx = JXPathContext.newContext(userDTO);
        System.out.println(ctx.getValue("versions"));
    }
}
