import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.*;
public class GraphRepresentation {
	public static GUI gui = new GUI();
    public static void main(int v , int e , String v1, String v2) throws IOException {
        Scanner sc = new Scanner(System.in);
        //v1 = "", v2 = "";
        //System.out.println("Enter number of vertices: ");
        //v = sc.nextInt();
        //System.out.println("Enter number of edges: ");
        //e = sc.nextInt();
        Graph g = new Graph(v, e);
        String[] v11 = new String[v];
        String[] eFrom = new String[e];
        String[] eTo = new String[e];
        boolean from = true;
        
        for(int i = 0, f = 0, t = 0 ; i < v2.length() ; i++) {
        	if(v2.charAt(i) != ' ' && from) {
        		eFrom[f] = "" + v2.charAt(i);
        		f++;
        		from = false;
        	}
        	else if(v2.charAt(i) != ' ') {
        		eTo[t] = "" + v2.charAt(i);
        		t++;
        		from = true;
        	}
        }
        
        for(int i = 0, j = 0 ; i < v1.length() ; i++) {
        	if(v1.charAt(i) != ' ') {
        		v11[j] = "" + v1.charAt(i);
        		j++;
        	}
        }
        for (int i = 0; i < g.vNum; i++) {
            //System.out.println("Enter vertex name: ");
            //v1 = sc.next();
            g.addVertex(i, v11[i]);
        }
        for (int i = 0; i < g.eNum; i++) {
            //System.out.println("Enter source node: ");            
            //v1 = sc.next();
            //System.out.println("Enter distination node: ");
            //v2 = sc.next();
            g.addEdge(eFrom[i], eTo[i], i);   
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

