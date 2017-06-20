package com.ldd.util;

import com.ldd.pojo.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import javax.sql.rowset.spi.XmlWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 读写xml工具类
 * time: 2017/6/20 author:ldd
 */
public class XmlUtil {

    /**
     * 获取xml数据集合
     * @return
     * @throws Exception
     */
    public List<User> readXml() throws Exception{
        List<User> users = new ArrayList<User>();
        Document document = getDocument();
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (int i = 0; i < elements.size(); i++) {
            User user = new User();
            user.setName(elements.get(i).elementText("name"));
            user.setAge(Integer.parseInt(elements.get(i).elementText("age")));
            users.add(user);
        }
        return users;
    }

    /**
     * 添加user对象到xml中
     * @param user 需要存入xml的数据
     * @throws Exception
     */
    public void addUserToXml(User user) throws Exception{
        FileOutputStream out = new FileOutputStream(new File("./src/main/resources/demo.xml"));
        XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
        Document document = getDocument();
        Element rootElement = document.getRootElement();
        Element element = rootElement.addElement("user");
//        element.addAttribute("id", UUID.randomUUID()+"");
        element.addElement("name").setText(user.getName());
        element.addElement("age").setText(user.getAge()+"");
        writer.write(document);
    }

    /**
     * 获取document对象
     * @return
     * @throws Exception
     */
    private Document getDocument() throws Exception {
        InputStream is = XmlUtil.class.getClassLoader().getResourceAsStream("demo.xml");

        SAXReader saxReader = new SAXReader();
        return saxReader.read(is);
    }
}
