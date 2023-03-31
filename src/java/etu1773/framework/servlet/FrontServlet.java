package etu1773.framework.servlet;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etu1773.framework.Mapping;
import etu1773.framework.Utilitaire;
import etu1773_framework.*;
import model.Url;
/**
 *
 * @author itu
 */
public class FrontServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HashMap<String,Mapping> MappingUrls=new HashMap<String,Mapping>();

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) {
        MappingUrls = mappingUrls;
    }

    public void init(PrintWriter out) {
        Utilitaire ut=new Utilitaire();
        HashMap<String,Mapping> maps=new HashMap<>();
        try {
        ArrayList<Class> classes=ut.findClassesInPackage("C:/Users/LENOVO/FrameWork_MrNaina/src/java","model");
        HashMap<String,Mapping> meths=ut.findAllAnnotatedMethods(classes); 
        for (Entry<String, Mapping> entry : meths.entrySet()) {
            out.println("<p>Url : " + entry.getKey() + ", ClassName : " + entry.getValue().getClassName() +", MethodName :"+entry.getValue().getMethod() +"</p>");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Utilitaire ut=new Utilitaire();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FrontServlet at " + ut.getUrl(request) + "</h1>");
            init(out);
            // try {
            // ArrayList<Class> allc=ut.findClassesInPackage("C:/Users/LENOVO/FrameWork_MrNaina/src/java","model");
            // out.println("<h1>Servlet FrontServlet at " + ut.getUrl(request) + "</h1>");
            //     for (int i = 0; i < allc.size(); i++) {
            //         out.println("<p>"+allc.get(i).getName()+"</p>");
            // }
            // }catch(Exception e){}
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
