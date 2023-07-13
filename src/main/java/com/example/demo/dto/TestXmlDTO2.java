package com.example.demo.dto;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @Author mac777
 * @Date 2023/7/13 15:45
 * @Desc 又是充满希望的一天
 */
@Root
@Data
public class TestXmlDTO2 {

    @Element(name = "test")
    private TestXmlDTO test;
}
