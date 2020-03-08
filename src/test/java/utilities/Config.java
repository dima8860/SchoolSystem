package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties = new Properties();

    static {
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
