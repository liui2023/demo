package com.example.demo.utils;

import com.example.demo.dto.TestXmlDTO;
import com.example.demo.dto.TestXmlDTO2;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

/**
 * @Author mac777
 * @Date 2023/7/13 15:28
 * @Desc 又是充满希望的一天
 */
public class XmlToObjectUtil {

    public static Serializer serializer = new Persister(new Format("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));

    public static <T> T parse(String xmlStr, Class<T> clazz) throws Exception {
        return serializer.read(clazz, xmlStr, false);
    }

    public static void main(String[] args) throws Exception {
        String xml = "<xml>\n" +
                "    <test value = \"11111\" />\n" +
                "</xml>";
        System.out.println(XmlToObjectUtil.parse(xml, TestXmlDTO2.class).toString());
    }

}
