package etu1773.framework;

import javax.servlet.http.HttpServletRequest;

import java.util.*;
import java.io.*;
import java.lang.reflect.Method;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author itu
 */
public class Utilitaire {
    
    public String getUrl(HttpServletRequest request){
        String a=request.getServletPath();
    return a;
    }

    public ArrayList<Class> findClassesInPackage(String path, String packageName) throws Exception {
        System.out.println(path + "/" +packageName );
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File directory=new File(path + "/" +packageName );
        System.out.println(directory);
        ArrayList<String> classNames = new ArrayList<>();
        ArrayList<Class> allClasses=new ArrayList<>();
        if (directory.exists()) {
            System.out.println("It exist");
            File[] files = directory.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                //System.out.println(fileName);
                if (fileName.endsWith(".java")) {
                    String className =packageName+"."+fileName.substring(0, fileName.length() -5);
                    // System.out.println(className);
                    Class clazz = classLoader.loadClass(className);
                    allClasses.add(clazz);
                    classNames.add(clazz.getSimpleName());
                }
            }
        }else{
            System.out.println("file does not exist yet");
        }
       return allClasses;
    }

    public HashMap<String,Mapping> findAllAnnotatedMethods(ArrayList<Class> params){
        HashMap<String,Mapping> allMeth=new HashMap<String,Mapping>();
        for (Class para : params) {
            for (Method method : para.getDeclaredMethods()) {
                if (method.getAnnotations().length>0) {
                    allMeth.put(method.getAnnotation(Url.class).value(), new Mapping(para.getName(),method.getName()));
                }
            }   
        }
        return allMeth;
    }

}
