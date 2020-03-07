import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class GraphRepresentation {
	public static GUI gui = new GUI();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String v1 = "", v2 = "";
        System.out.println("Enter number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();
        Graph g = new Graph(v, e);
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
        ProcessBuilder builder = new ProcessBuilder("python main.py");
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        String in = "";
        in += g.edges.length + " ";
        for(int i = 0 ; i < g.edges.length ; i++) {
        	in += g.edges[i].src + " " + g.edges[i].dst + " ";
        }
        bw.write(in);
        gui.main(g);
    }
    


}

