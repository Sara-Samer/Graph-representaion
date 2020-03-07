import java.util.ArrayList;

public class Vertex {
    int ID;
    String name;
    ArrayList<Integer> adj = new ArrayList<Integer>();
    Vertex(){}
    Vertex(int x, String n) {
        ID = x;
        name = n;
    }
    public int getID(){return ID;} 
    public String getName(){return name;} 
}