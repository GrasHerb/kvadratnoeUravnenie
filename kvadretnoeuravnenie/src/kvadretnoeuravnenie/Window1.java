package kvadretnoeuravnenie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Window1 extends JFrame {

	private JPanel contentPane;
	private JTextField txt_b;
	private JTextField txt_a;
	private JTextField txt_c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 frame = new Window1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_a = new JTextField();
		
		
		txt_a.setText("0");
		txt_a.setBounds(23, 82, 46, 20);
		contentPane.add(txt_a);
		txt_a.setColumns(10);
		
		txt_b = new JTextField();
		txt_b.setText("0");
		txt_b.setBounds(111, 82, 46, 20);
		contentPane.add(txt_b);
		txt_b.setColumns(10);
		
		txt_c = new JTextField();
		txt_c.setText("0");
		txt_c.setBounds(189, 82, 46, 20);
		contentPane.add(txt_c);
		txt_c.setColumns(10);
		
		JLabel lbl_a = new JLabel("x2 + ");
		lbl_a.setBounds(79, 85, 46, 14);
		contentPane.add(lbl_a);
		
		JLabel lbl_b = new JLabel("x +");
		lbl_b.setBounds(164, 85, 46, 14);
		contentPane.add(lbl_b);
		
		JLabel lbl_c = new JLabel("= 0");
		lbl_c.setBounds(242, 85, 46, 14);
		contentPane.add(lbl_c);
		
		JButton btnSolve = new JButton("Решить уравнение");
		
		btnSolve.setBounds(60, 120, 150, 25);
		contentPane.add(btnSolve);
		
		JLabel labelbl = new JLabel("Решение");
		labelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelbl.setHorizontalAlignment(SwingConstants.CENTER);
		labelbl.setBounds(85, 155, 100, 14);
		contentPane.add(labelbl);
		
		JLabel labelbl_1 = new JLabel("Квадратное уравнение");
		labelbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelbl_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelbl_1.setBounds(40, 25, 200, 14);
		contentPane.add(labelbl_1);
		
		JLabel lblSolution = new JLabel("");
		lblSolution.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolution.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSolution.setBounds(23, 180, 251, 52);
		contentPane.add(lblSolution);
		
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a,b,c;
				try {
					a=Double.parseDouble(txt_a.getText());
				}
				catch (NumberFormatException nfe){
					a=0.0;
					txt_a.setText("0.0");
				}try {
					b=Double.parseDouble(txt_b.getText());
				}
				catch (NumberFormatException nfe){
					b=0.0;
					txt_b.setText("0.0");
				}try {
					c=Double.parseDouble(txt_c.getText());
				}
				catch (NumberFormatException nfe){
					c=0.0;
					txt_c.setText("0.0");
				}
				double D=b*b-a*c*4;
				double x1, x2;
				String Sol = "";
				if (D<0) Sol="Натуральных корней нет.";
				else if(D > 0. && a != 0.){ 
					x1 = (-b + Math.sqrt(D)) / (2. * a); 
					x2 = (-b - Math.sqrt(D)) / (2. * a); 
					Sol = "Корни: x1 = " + x1 + ", x2 = " + x2; 
				}
				else if(D == 0.0 && a != 0.0){ 
					x1 = -b / (2. * a); 
					Sol = "Корень x = " + x1; 
				}
				else if(a == 0 && b != 0.){ 
					x1 = -c / b; 
					Sol = "Корень x = " + x1; 
				}
				lblSolution.setText(Sol); 
			}
		});
	}

}
