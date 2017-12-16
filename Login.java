import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	Statement stm = null;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		cn = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 304, 267);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 49, 124, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 101, 124, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(144, 68, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					JOptionPane.showMessageDialog(null,"reachable1");
					String query = "select * from EmployeeInfo where username=? and password=?";
					JOptionPane.showMessageDialog(null,"reachable2");
					//stm = cn.createStatement();
					JOptionPane.showMessageDialog(null,"reachable3");
						pst = cn.prepareStatement(query);
			//		JOptionPane.showMessageDialog(null,"reachable3");
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					rs = stm.executeQuery(query);
					int count = 0;
					while(rs.next()){
						count = count + 1;					
						
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null,"User name and password is correct");
					}
					else if(count > 1)
					{
						JOptionPane.showMessageDialog(null,"Duplicate User name and password");
					}
					else{
						JOptionPane.showMessageDialog(null,"User name and password is not correct, Please Try again");
					}
					//JOptionPane.showMessageDialog(null,"reachable");
//					rs.close();
//					pst.close();
				}catch(Exception e){
					//JOptionPane.showMessageDialog(null,e);
					e.printStackTrace();
					System.out.println(e);
				}
			}			
		});
		btnNewButton.setBounds(44, 153, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 109, 86, 20);
		frame.getContentPane().add(passwordField);
	}
}
