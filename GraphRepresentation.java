import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.*;
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
        gui.main(g);
        
        String prg = "import sys\r\n" + 
        		"import matplotlib.pyplot as plt\r\n" + 
        		"import networkx as nx\r\n" + 
        		"\r\n" + 
        		"G = None\r\n" + 
        		"G = nx.MultiDiGraph()\r\n" + 
        		"nEdges = int(input(\"Enter the number of edges: \"))\r\n" + 
        		"\r\n" + 
        		"for i in range(nEdges):\r\n" + 
        		"    a = input(\"Enter edge \" + str(i + 1) + \" src: \")\r\n" + 
        		"    b = input(\"Enter edge \" + str(i + 1) + \" dst: \")\r\n" + 
        		"    G.add_edge(a, b)\r\n" + 
        		"\r\n" + 
        		"nx.draw(G, with_labels=True)\r\n" + 
        		"plt.show()\r\n" + 
        		""; 
        BufferedWriter out = new BufferedWriter(new FileWriter("main.py"));
        out.write(prg);
        out.close();
        /*String prg = "import sys";
       
        
        //BufferedWriter out2 = new BufferedWriter(new FileWriter(".py"));
        //out.write(prg);
        //out.close();
        Process p = Runtime.getRuntime().exec("python D:\\FCI\\Codes\\algo_Graph/test.py");

        /*int number1 = 10;
        int number2 = 32;
        //ProcessBuilder pb = new ProcessBuilder("python","test.py",""+1,""+1+""+1);
        //Process p = pb.start();
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
        */
        //Process p = Runtime.getRuntime().exec("python test.py "+ 1 +" "+1 + " " + 1);
        //BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        //int ret = new Integer(in.readLine()).intValue();
        //System.out.println("value is : "+ret);
        
        ProcessBuilder builder = new ProcessBuilder("python","main.py");
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        String in = "";
        in += g.edges.length + " ";
        for(int i = 0 ; i < g.edges.length ; i++) {
        	in += g.edges[i].src + " " + g.edges[i].dst + " ";
        }
        bw.write(in);
        
        
    }
    


}

