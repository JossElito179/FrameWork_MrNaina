package etu1773.framework;
import java.util.HashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Utilitaire sc=new Utilitaire();
        try {
            ArrayList<Class> list= sc.findClassesInPackage("C:/Users/LENOVO/FrameWork_MrNaina/src/java", "model");
            // for (Method method : sc.findAllAnnotatedMethods(list.get(1))) {
            //     System.out.println(method.getDeclaredAnnotation(Url.class).value() +" , "+ method);
            // }
            ArrayList<Class> classes=sc.findClassesInPackage("C:/Users/LENOVO/FrameWork_MrNaina/src/java","model");
            HashMap<String,Mapping> meths=sc.findAllAnnotatedMethods(classes); 
            //meths.forEach((s,m)->System.out.println(s+ " , "+ m.getClassName() +" , "+ m.getMethod()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
