package com.example.demo.dto;

import lombok.Data;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * @Author mac777
 * @Date 2023/7/13 15:28
 * @Desc 又是充满希望的一天
 */
@Root(name = "test", strict = false)
@Data
public class TestXmlDTO {

    @Attribute(name = "value", required = true)
    private String value;
}
