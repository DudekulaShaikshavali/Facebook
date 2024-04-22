//package util;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class ReadConfig {
//    Properties prop;
//    FileInputStream fis;
// public static String path=System.getProperty("user.dir");
//    public ReadConfig(){
//        try{
//        fis=new FileInputStream(path+"//src//test/resources//application.properties");
//        prop=new Properties();
//
//        if(fis !=null){
//            prop.load(fis);
//        }else {
//            System.out.println("sorry, unable to find application properties file");
//        }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public String getFacebook_Url(){
//String url=prop.getProperty("dev.url");
//        return url;
//    }
//
//    public String getMobile_Number(){
//      String mobile=prop.getProperty("dev.mobilenumbe");
//        return mobile;
//    }
//    public String getPassword(){
//      String  password= prop.getProperty("dev.pass");
//        return password;
//    }
//}
