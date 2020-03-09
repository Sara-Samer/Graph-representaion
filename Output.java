import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Output {

	private JFrame frame;
	private JTextField textField_1;
	public String out = "";

	/**
	 * Launch the application.
	 */
	public  void main(Output o) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Output window = o;
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Output(String outt) {
		
		initialize(outt);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String outt) {
		out = outt;
		frame = new JFrame();
		frame.setEnabled(false);
		frame.setResizable(false);
		frame.setBounds(100, 100, 969, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel_1 = new JLabel("output : ");
		textField_1 = new JTextField(out);
		textField_1.setColumns(10);
		this.textField_1.setText(out);
		GraphRepresentation g = new GraphRepresentation();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(441)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 887, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
					.addGap(67))
		);
		frame.getContentPane().setLayout(groupLayout);
		this.textField_1.setText(out);
	}
}
