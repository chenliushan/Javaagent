package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyMain {

    private static Logger logger = LogManager.getLogger();

    static {
        logger.info("MyMain static is running");
        MyJavaAgentLoader.loadAgent();//dynamic load a java agent;
    }

    public static void main(String[] args) {
        logger.info("MyMain is running");
        URL[] urls = new URL[]{getURL(args[0])};//args[0]="/Users/liushanchen/IdeaProjects/AfTest/build/classes/main"
        ClassLoader loader = new URLClassLoader(urls);
        Class thisClass = null;
        try {
            thisClass = loader.loadClass(args[1]);//args[1]="polyu_af.MyList1"
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
     private static URL getURL(String path) {
        File files = new File(path);
        try {
            return files.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}