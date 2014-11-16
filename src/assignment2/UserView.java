

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JList list, list_1;
	private JLabel jl;
	private ArrayList al;

	/**
	 * Create the frame.
	 */
	public UserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 200, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				jl.setText(input);
			}
		});
		
		JButton btnNewButton = followUser();
		btnNewButton.setBounds(220, 11, 204, 35);
		contentPane.add(btnNewButton);
		
		list = new JList();
		list.setToolTipText("");
		list.setBounds(10, 54, 414, 80);
		contentPane.add(list);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 145, 299, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		submitTweet();
		btnNewButton_1.setBounds(319, 145, 105, 35);
		contentPane.add(btnNewButton_1);
		
		list_1 = new JList();
		list_1.setBounds(20, 251, 404, -59);
		contentPane.add(list_1);
	}

	private void submitTweet() {
		btnNewButton_1 = new JButton("Submit");
	}

	private JButton followUser() {
		JButton btnNewButton = new JButton("Follow User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel DLM = new DefaultListModel();
				String input = textField.getText();
				DLM.addElement(input);
				list.setModel(DLM);
			}
		});
		return btnNewButton;
	}
}
