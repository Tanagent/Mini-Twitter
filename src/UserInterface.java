import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JTree tree;

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
		
//		tree = new JTree();
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("Root") {
//				{
//					DefaultMutableTreeNode node_1;
//					DefaultMutableTreeNode node_2;
//					add(new DefaultMutableTreeNode("john"));
//					add(new DefaultMutableTreeNode("bob"));
//					add(new DefaultMutableTreeNode("steve"));
//					node_1 = new DefaultMutableTreeNode("CS356");
//						node_1.add(new DefaultMutableTreeNode("stu1"));
//						node_1.add(new DefaultMutableTreeNode("stu2"));
//						node_1.add(new DefaultMutableTreeNode("stu3"));
//						node_2 = new DefaultMutableTreeNode("CS356Session01");
//							node_2.add(new DefaultMutableTreeNode("stu8"));
//							node_2.add(new DefaultMutableTreeNode("stu9"));
//							node_2.add(new DefaultMutableTreeNode("stu10"));
//						node_1.add(node_2);
//					add(node_1);
//					add(new DefaultMutableTreeNode("stu4"));
//					int leaf = node_1.getChildCount() + node_2.getChildCount() + 1;
//				}
//			}
//		));
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode john = new DefaultMutableTreeNode("John");
		root.add(john);
		DefaultMutableTreeNode bob = new DefaultMutableTreeNode("Bob");
		root.add(bob);
		DefaultMutableTreeNode steve = new DefaultMutableTreeNode("Steve");
		root.add(steve);
		DefaultMutableTreeNode cs356 = new DefaultMutableTreeNode("CS356");
		root.add(cs356);
		DefaultMutableTreeNode stu1 = new DefaultMutableTreeNode("stu1");
		cs356.add(stu1);
		DefaultMutableTreeNode stu2 = new DefaultMutableTreeNode("stu2");
		cs356.add(stu2);
		DefaultMutableTreeNode stu3 = new DefaultMutableTreeNode("stu3");
		cs356.add(stu3);
		DefaultMutableTreeNode CS356_1 = new DefaultMutableTreeNode("CS356Session01");
		cs356.add(CS356_1);
		DefaultMutableTreeNode stu8 = new DefaultMutableTreeNode("stu8");
		CS356_1.add(stu8);
		DefaultMutableTreeNode stu9 = new DefaultMutableTreeNode("stu9");
		CS356_1.add(stu9);
		DefaultMutableTreeNode stu10 = new DefaultMutableTreeNode("stu10");
		CS356_1.add(stu10);
		DefaultMutableTreeNode stu4 = new DefaultMutableTreeNode("stu4");
		cs356.add(stu4);
		DefaultMutableTreeNode oostu = new DefaultMutableTreeNode("oostu");
		root.add(oostu);
		DefaultMutableTreeNode ppstu2 = new DefaultMutableTreeNode("ppstu2");
		root.add(ppstu2);
		System.out.println(root.getLeafCount());
		tree = new JTree(root);
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
		
		JButton btnButtonShowUser = totalUser();
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

	private JButton totalUser() {
		JButton btnButtonShowUser = new JButton("Button- Show User Total");
		btnButtonShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				class Display extends JFrame {
					private JLabel item;
					
					public Display() {
						super("The title bar");
						setLayout(new FlowLayout());
						item = new JLabel("this is a sentence");
						add(item);
					}
				}
				Display display = new Display();
				display.setSize(275, 180);
				display.setVisible(true);
			}
		});
		return btnButtonShowUser;
	}

	private JButton addGroup() {
		JButton button = new JButton("Button - Add Group");
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


