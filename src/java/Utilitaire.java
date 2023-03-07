
import javax.servlet.http.HttpServletRequest;

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
}
