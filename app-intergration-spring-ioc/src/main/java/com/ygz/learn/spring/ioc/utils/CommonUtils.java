package com.ygz.learn.spring.ioc.utils;

import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by admin on 2017/8/16.
 */
public class CommonUtils {
    public  static  InputStream getInputStream(String resourceName) throws IOException {
        InputStream is = null;
        Enumeration urls = ClassLoader.getSystemResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = (URL) urls.nextElement();
            URLConnection con = url.openConnection();
            ResourceUtils.useCachesIfNecessary(con);
            is = con.getInputStream();
        }
        return is;
    }
     public  static  String getString(String resourceName,String key) throws IOException {
         ResourceBundle bundle = ResourceBundle.getBundle(resourceName, Locale.CHINA);
         return bundle.getString(key);

     }

}
