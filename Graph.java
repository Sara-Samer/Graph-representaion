import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    public Vertex[] vertices;
    public Edge[] edges;
    public int vNum = 0, eNum = 0;
    Graph(int v, int e){
        vertices = new Vertex[v];
        edges = new Edge[e];
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
        Vertex v = vertices[index1];
        v.adj.add(index2); 
        edges[i] = new Edge(index1, index2);

    }
    public void addVertex(int ID, String name){
        vertices[ID] = new Vertex(ID, name);
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
        for(Vertex v: vertices){
            s = s + v.getName() + ": " + this.adjList(v.getID()) + '\n';
        }
        return s;
    }
    private int[][] adjMatrix(){
        int[][] mat = new int[this.vNum][this.vNum];
        for(Edge e: edges){
            int src = e.src;
            int dst = e.dst;
            mat[src][dst] = 1;
        }
        return mat;
    }
    public String getAdjMatrix(){
        int[][] mat = this.adjMatrix();
        String s = "  ";
        for (int j = 0; j < this.vNum; j++)
            s = s + " " + vertices[j].getName() + " ";
        s += '\n';
        for (int i = 0; i < this.vNum; i++) {
            s = s + vertices[i].getName() + " ";
            int[] row = mat[i];
            s += Arrays.toString(row) + '\n'; 
        }
        return s;
    }
    private int[][] incMat(){
        int[][] mat = new int[this.vNum][this.eNum];
        for (int i = 0; i < this.vNum; i++) {
            for(int j = 0; j < this.eNum; j++){
                Edge e = edges[j];
                int src = e.src;
                int dst = e.dst;
                if(src == dst){
                    mat[src][j] = 1;
                }else{
                    mat[src][j] = 1;
                    mat[dst][j] = -1;
                }
            }
            
        }
        return mat;
    }
    public String getIncMat(){
        int[][] mat = this.incMat();
        String s = "  ";
        for (int j = 0; j < this.eNum; j++)
            s = s + "E" + (j+1) + " ";
        s += '\n';
        for (int i = 0; i < this.vNum; i++) {
            s = s + vertices[i].getName() + " ";
            int[] row = mat[i];
            s += Arrays.toString(row) + '\n'; 
        }
        return s;
    }

}