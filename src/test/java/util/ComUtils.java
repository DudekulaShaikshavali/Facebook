package util;

import java.io.File;

public class ComUtils {
    public static String getProjectDirectory(){
        return System.getProperty("user.dir");
    }

    public static String getFileSeperator(){
        return File.separator;
    }
}
