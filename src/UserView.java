

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton, btnNewButton_1;
	private JList list, list_1;
	private JLabel jl;
	private List followers = new ArrayList();
	private List tweets = new ArrayList();
	private String user;

	/**
	 * Create the frame.
	 */
	public UserView(String user) {
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
		
		btnNewButton = followUser();
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
		
		list_1 = new JList();
		list_1.setBounds(10, 191, 414, 59);
		contentPane.add(list_1);
		
		btnNewButton_1 = submitTweet();
		btnNewButton_1.setBounds(319, 145, 105, 35);
		contentPane.add(btnNewButton_1);
		

	}

	private JButton submitTweet() {
		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			DefaultListModel DLM = new DefaultListModel();
			public void actionPerformed(ActionEvent arg0) {
				String input = textField_1.getText();
				tweets.add(input);
				DLM.addElement(tweets.get(tweets.size() - 1));
				list_1.setModel(DLM);
			}
		});
		return btnNewButton_1;
	}

	private JButton followUser() {
		JButton btnNewButton = new JButton("Follow User");
		btnNewButton.addActionListener(new ActionListener() {
			DefaultListModel DLM = new DefaultListModel();
			public void actionPerformed(ActionEvent arg0) {
				String input = textField.getText();
				followers.add(input);
				DLM.addElement(followers.get(followers.size() - 1));
				list.setModel(DLM);
			}
		});
		return btnNewButton;
	}
}
