
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GraphRepresentation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v1 = "", v2 = "";
        System.out.println("Enter number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();
        graph g = new graph(v, e);
        for (int i = 0; i < g.vNum; i++) {
            System.out.println("Enter vertex name: ");
            v1 = sc.next();
            g.addVertex(i, v1);
        }
        for (int i = 0; i < g.eNum; i++) {
            System.out.println("Enter source node: ");            
            v1 = sc.next();
            System.out.println("Enter distination node: ");
            v2 = sc.next();
            g.addEdge(v1, v2, i);   
        }
        sc.close();
        String s = g.getAdjMatrix();
        System.out.println("AdjMatrix: \n" + s);
        s = g.getIncMat();
        System.out.println("IncMatrix: \n" + s);
        s = g.adjList();
        System.out.println("AdjList: \n" + s);
        System.out.println("Representation Matrix: \n" );
        g.printRepresentationMatrix();
    }
    


}

class vertex{
    int ID;
    String name;
    ArrayList<Integer> adj = new ArrayList<Integer>();
    vertex(){}
    vertex(int x, String n) {
        ID = x;
        name = n;
    }
    public int getID(){return ID;} 
    public String getName(){return name;} 
}
class edge{
    int src;
    int dst;
    edge(int s, int d){
        src = s;
        dst = d;
    }
}
class graph{
    public vertex[] vertices;
    public edge[] edges;
    public int vNum = 0, eNum = 0;
    graph(int v, int e){
        vertices = new vertex[v];
        edges = new edge[e];
        this.eNum = e;
        this.vNum = v;
    }
    public int [][] buildRepresentationMatrix()
    {
       int representionMatrix [][] = new int [vertices.length][vertices.length];
       for (int i=0 ; i<edges.length ; i++)
        {
            representionMatrix[edges[i].src][edges[i].dst]++;
        }
       return representionMatrix;
    }
    public void printRepresentationMatrix( )
    {
        int [][] representionMatrix = buildRepresentationMatrix();
        System.out.println("The Representation Matrix");
        
        for(int i=0 ;i<vertices.length ; i++)
              System.out.print("    "+vertices[i].name);
        
        System.out.println();
        for(int i=0 ;i<vertices.length ; i++)
        {
            System.out.print(vertices[i].name+ "  ");
            for(int j=0 ;j<vertices.length ; j++)
            {
                System.out.print(representionMatrix[i][j]+ "     ");
            }
            System.out.println();
        }
    }
    
    public int getVertexIndex(String name){
        for(int i = 0; i < vNum; ++i){
            String n = vertices[i].getName();
            if(n.equals(name))
                return vertices[i].ID;
        }
        return -1;
    }
    public void addEdge(String v1, String v2, int i){
        int index1 = getVertexIndex(v1);
        int index2 = getVertexIndex(v2); 
        if(index1 == -1 || index2 == -1)
            return;
        vertex v = vertices[index1];
        v.adj.add(index2); 
        edges[i] = new edge(index1, index2);

    }
    public void addVertex(int ID, String name){
        vertices[ID] = new vertex(ID, name);
    }
    private String adjList(int ID){
        ArrayList<Integer> adj = vertices[ID].adj;
        String s = "";
        for(int index: adj){
            s = s + vertices[index].getName() + "| ";
        }
        return s;
    }
    public String adjList(){
        String s = "";
        for(vertex v: vertices){
            s = s + v.getName() + ": " + this.adjList(v.getID()) + '\n';
        }
        return s;
    }
    private int[][] adjMatrix(){
        int[][] mat = new int[this.vNum][this.vNum];
        for(edge e: edges){
            int src = e.src;
            int dst = e.dst;
            mat[src][dst] = 1;
        }
        return mat;
    }
    public String getAdjMatrix(){
        int[][] mat = this.adjMatrix();
        String s = "  ";
        // for (int j = 0; j < this.vNum; j++)
        //     s = s + vertices[j].getName() + " ";
        // s += '\n';
        // for (int i = 0; i < this.vNum; i++) {
        //     s = s + vertices[i].getName() + " ";
        //         for (int j = 0; j < this.vNum; j++)
        //         if(mat[i][j])
        //             s = s + "1 ";
        //         else
        //             s = s + "0 ";
        //     s = s + '\n';
        // }
        //System.out.println(Arrays.deepToString(mat));
        //s = Arrays.deepToString(mat).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
        //System.out.println(Arrays.deepToString(mat));
        s = "  " + Arrays.deepToString(mat)
        .replace("],","\n")
        .replace(",","\t|")
        .replaceAll("[\\[\\]]", "");
        return s;
    }
    private int[][] incMat(){
        int[][] mat = new int[this.vNum][this.eNum];
        for (int i = 0; i < this.vNum; i++) {
            for(int j = 0; j < this.eNum; j++){
                edge e = edges[j];
                int src = e.src;
                int dst = e.dst;
                mat[src][dst] = -1;
                mat[dst][dst] = 1;
            }
            
        }
        return mat;
    }
    public String getIncMat(){
        int[][] mat = this.incMat();
        String s = "  ";
        // for (int j = 0; j < this.eNum; j++)
        //     s = s + "E" + j + " ";
        // s += '\n';
        // for (int i = 0; i < this.vNum; i++) {
        //     s = s + vertices[i].getName() + " ";
        //     for (int j = 0; j < this.eNum; j++)
        //         s = s + mat[i][j] + " ";
        //     s = s + '\n';
        // }
        //s = Arrays.deepToString(mat).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
        //System.out.println(Arrays.deepToString(mat));
        s = "  " + Arrays.deepToString(mat)
        .replace("],","\n")
        .replace(",","\t|")
        .replaceAll("[\\[\\]]", "");
        return s;
    }

}
