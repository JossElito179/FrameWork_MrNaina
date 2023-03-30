package model;
import java.util.ArrayList;

public class Emp {
    
    private String namee;
    private int id;

    @Url(value="emp-all")
    public ArrayList<Emp> findAll(){
        return null;
    }

    @Url(value="delete")
    public void suprimmer() {
        System.out.println("");
    }

    public void MethodBidon() {
        
    }
}
