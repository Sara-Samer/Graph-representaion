import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends  JPanel {
	//public static GraphRepresentation gr = new GraphRepresentation();
	private JPanel contentPane;
	public static Graph g;
	public void paintComponent(Graphics gr) {
		/*JFrame jFrame = new JFrame();
        jFrame.add(new GUI());
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
		*/// Draw Tree Here
        super.paintComponent(gr);
        System.out.println(g.vertices.length);
        int counter = 2;
        int k = 10;
        Vector<Integer> x = new Vector<>();
        Vector<Integer> y = new Vector<>();
        
        Vector<Integer> x2 = new Vector<>();
        Vector<Integer> y2 = new Vector<>();
        
        for(int i = 0, j = 0 ; i < g.vertices.length; i++, j++) {
        	if(i == counter) {
        		j = 0;
        		counter *= 2;
        		k += 100;
        	}
        	gr.drawOval(k, (j+1)*80 , 40, 40);
        	gr.drawString(g.vertices[i].name,  k + 20, (j+1)*80 + 20);
        	x.add(k + 20);
        	y.add((j+1)*80 + 20);
        }
        for(int i = 0; i < g.edges.length ; i++) {
        	//gr.drawLine(70, 70, 180, 180);
        	if((g.edges[i].src) == (g.edges[i].dst)) {
        		gr.drawArc(x.elementAt((g.edges[i].src)), y.elementAt((g.edges[i].dst)) - 20, 30, 30, 90, -180);
        	}else
        		gr.drawLine(x.elementAt(g.edges[i].src),y.elementAt(g.edges[i].src) ,x.elementAt(g.edges[i].dst), y.elementAt(g.edges[i].dst));
        }
        
        //gr.drawOval(40, 40, 70, 70);
        //gr.drawString("A" , 70, 70);
        //gr.drawOval(180, 180, 70, 70);
        //g.drawArc(70, 70, 200, 200, 200, 200);
        //
        
        GUI panel = new GUI();
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints cl;
        cl = new GridBagConstraints();
        cl.gridy = 0;
        panel.add(new JLabel("Hello"), cl);
        panel.setVisible(true);
  }
	public static void main(Graph gr) {
		g = gr;
        JFrame jFrame = new JFrame();
        jFrame.add(new GUI());
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
 * Create the frame.
	 */
	public GUI() {
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
	}

}
