

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTree;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtTextareaUser;
	private JTextField txtTextareaGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					add(new DefaultMutableTreeNode("John"));
					add(new DefaultMutableTreeNode("Sarah"));
				}
			}
		));
		tree.setBounds(5, 5, 156, 251);
		contentPane.add(tree);
		
		JButton btnNewButton = addUser();
		btnNewButton.setBounds(299, 11, 125, 45);
		contentPane.add(btnNewButton);
		
		JButton button = addGroup();
		button.setBounds(299, 52, 125, 45);
		contentPane.add(button);
		
		JButton btnButtonShow_2 = new JButton("Button - Show Positive Percentage");
		btnButtonShow_2.setBounds(299, 211, 125, 45);
		contentPane.add(btnButtonShow_2);
		
		JButton btnButtonShow_1 = new JButton("Button - Show Messages Total");
		btnButtonShow_1.setBounds(176, 211, 125, 45);
		contentPane.add(btnButtonShow_1);
		
		JButton btnButtonShow = new JButton("Button - Show Group Total");
		btnButtonShow.setBounds(299, 167, 125, 45);
		contentPane.add(btnButtonShow);
		
		JButton btnButtonShowUser = new JButton("Button- Show User Total");
		btnButtonShowUser.setBounds(176, 167, 125, 45);
		contentPane.add(btnButtonShowUser);
		
		JButton btnButtonOpen = goToUI();
		btnButtonOpen.setBounds(176, 95, 248, 45);
		contentPane.add(btnButtonOpen);
		
		txtTextareaUser = new JTextField();
		txtTextareaUser.setText("TextArea - User Id");
		txtTextareaUser.setBounds(176, 11, 125, 44);
		contentPane.add(txtTextareaUser);
		txtTextareaUser.setColumns(10);
		
		txtTextareaGroup = new JTextField();
		txtTextareaGroup.setText("TextArea - Group Id");
		txtTextareaGroup.setColumns(10);
		txtTextareaGroup.setBounds(176, 52, 125, 44);
		contentPane.add(txtTextareaGroup);
	}

	private JButton addGroup() {
		JButton button = new JButton("Button - Add Group");
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					add(new DefaultMutableTreeNode("John"));
					add(new DefaultMutableTreeNode("Sarah"));
				}
			}
		));
		tree.setBounds(5, 5, 156, 251);
		contentPane.add(tree);
		return button;
	}

	private JButton goToUI() {
		JButton btnButtonOpen = new JButton("Button - Open User View");
		btnButtonOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UserView uv = new UserView();
							uv.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		return btnButtonOpen;
	}

	private JButton addUser() {
		JButton btnNewButton = new JButton("Button - Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				TreeComponent g1 = new TreeGroup("Root");
				TreeComponent g2 = new TreeGroup("CS356");
				TreeComponent g3 = new TreeGroup("CS356 - 1");
				TreeComponent tree = new TreeGroup("Everything");
				tree.add(g1);
				g1.add(new Tree("John"));
				g1.add(new Tree("Sarah"));
				g1.add(g2);
				g2.add(new Tree("Eddie"));
				TreeList tl = new TreeList(tree);
				tl.getTreeList();
			}
		});

		
		return btnNewButton;
	}
	

}
