package com.hl.attendance;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
public class GetXmlSetting {
    public static String getXml(String attrName)  {
        String resoult = null;
        SAXReader reader = new SAXReader();
        Document document;
        try {
            document = reader.read(GetXmlSetting.class.getClassLoader().getResourceAsStream("setting.xml"));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        Element root = document.getRootElement();
        //System.out.println(root.getName());  // class
        //System.out.println(root.attribute("name").getValue()); // name属性为uestc

        List<Element> elements = root.elements();
        for (Element element : elements) {
            List<Element> stuElement = element.elements();
            for (Element attr : stuElement) {
                if(attr.getName().equals(attrName)) {
                    resoult = String.valueOf(attr.getData());
                }
            }
        }
        return resoult;
    }

    public static String getProperties(String keyName) {
        Properties properties;
        String set="";
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("D:\\autoAttendance\\application.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Object key:properties.keySet()){
            if (keyName.equals(key)){
                return String.valueOf(properties.get(key));
            }
        }
        return set;
    }
    //读取TXT文件
    public static String getTxt(String fileName){
        List<String> checkins = new ArrayList(); // List初始化
        try{
            String pathname = fileName;
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                checkins.add(line);
                line = br.readLine();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return checkins.toString();
    }

    public static String getPropertiesAsList(String filename,String keyName){
        List<String> pros= Arrays.asList(getTxt(filename).split(","));
        for (String str:pros){
            if (str.contains(keyName)){
                return str;
            }
        }
        return null;
    }
}
