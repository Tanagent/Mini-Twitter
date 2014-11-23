import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JButton;
import javax.swing.JTree;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JScrollBar;

public class UserInterface extends JFrame implements TreeSelectionListener {

	private JPanel contentPane;
	private JTextField txtTextareaUser;
	private JTextField txtTextareaGroup;
	private JTree tree;
	private JScrollPane sp;
	private Users root, cs356,cs356s01;
	private Users stu1, stu2, stu3, stu4, stu8, stu9, stu10;
	private Users john, bob, steve, oostu, ppstu2;
	private JLabel cost;
	private String user;
	private static UserInterface instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = UserInterface.getInstance();
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
	private UserInterface() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		sp = new JScrollPane();
		makeUsers();
		setTree(root);

		JButton btnNewButton = addUser();
		btnNewButton.setBounds(366, 5, 160, 52);
		contentPane.add(btnNewButton);
		
		JButton button = addGroup();
		button.setBounds(366, 56, 160, 52);
		contentPane.add(button);
		
		JButton btnButtonShow_2 = new JButton("Button - Show Positive Percentage");
		btnButtonShow_2.setBounds(366, 259, 160, 58);
		contentPane.add(btnButtonShow_2);
		
		JButton btnButtonShow_1 = new JButton("Button - Show Messages Total");
		btnButtonShow_1.setBounds(205, 259, 160, 58);
		contentPane.add(btnButtonShow_1);
		
		JButton btnButtonShow = new JButton("Button - Show Group Total");
		btnButtonShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnButtonShow.setBounds(366, 210, 160, 46);
		contentPane.add(btnButtonShow);
		
		JButton btnButtonShowUser = totalUser();
		btnButtonShowUser.setBounds(205, 211, 160, 45);
		contentPane.add(btnButtonShowUser);
		
		JButton btnButtonOpen = goToUI();
		btnButtonOpen.setBounds(205, 108, 321, 52);
		contentPane.add(btnButtonOpen);
		
		txtTextareaUser = new JTextField();
		txtTextareaUser.setText("TextArea - User Id");
		txtTextareaUser.setBounds(205, 5, 160, 52);
		contentPane.add(txtTextareaUser);
		txtTextareaUser.setColumns(10);
		
		txtTextareaGroup = new JTextField();
		txtTextareaGroup.setText("TextArea - Group Id");
		txtTextareaGroup.setColumns(10);
		txtTextareaGroup.setBounds(205, 58, 160, 48);
		contentPane.add(txtTextareaGroup);
	}
	
	public static UserInterface getInstance() {
		if(instance == null)
			instance = new UserInterface();
		return instance;
	}
	
	private void setTree(Users topDog) {
		
//		leafCount = root.getLeafCount();
//		tree = new JTree(root);
		DefaultMutableTreeNode troot;
		troot = new DefaultMutableTreeNode(topDog.getName());
		tree = new JTree(troot);
		tree.addTreeSelectionListener((TreeSelectionListener) this);
		addNodes(troot, topDog);
		
		tree.setBounds(5, 5, 190, 312);
		contentPane.add(tree);

	}
	
	private void addNodes(DefaultMutableTreeNode pnode, Users user) {
		DefaultMutableTreeNode node;
		
		Enumeration e = user.elements();
		while (e.hasMoreElements()) {
			Users newUser = (Users) e.nextElement();
			node = new DefaultMutableTreeNode(newUser.getName());
			pnode.add(node);
			addNodes(node, newUser);
		}
	}
	
	private void makeUsers() {
	    root = new Users("Root");
	    root.add(john = new Users("John"));
	    root.add(bob = new Users("Bob"));
	    root.add(steve = new Users("Stever"));
	    root.add(cs356 = new Users("CS356"));

	    cs356.add(stu1 = new Users("stu1"));
	    cs356.add(stu2 = new Users("stu2"));
	    cs356.add(stu3 = new Users("stu3"));
	    cs356.add(cs356s01 = new Users("CS356Session01"));
	    
	    cs356s01.add(stu8 = new Users("stu8"));
	    cs356s01.add(stu9 = new Users("stu9"));
	    cs356s01.add(stu10 = new Users("stru10"));
	    
		cs356.add(stu4 = new Users("stu4"));
		
		root.add(oostu = new Users("oostu"));
		root.add(ppstu2 = new Users("ppstu2"));
	}
	
	private JButton totalUser() {
		JButton btnButtonShowUser = new JButton("Button- Show User Total");
		btnButtonShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				class Display extends JFrame {
					private JLabel item;
					public Display() {
						super("Total User");
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
		// iterates through the tree to find name
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent evt) {
				TreePath[] paths = evt.getPaths();
				for (int i = 0; i < paths.length; i++) {
					if(evt.isAddedPath(i)){
						user = paths[i].getLastPathComponent().toString();
						break;
					} else {
						break;
					}
				}
			}
		});
		btnButtonOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UserView uv = new UserView(user);
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

			}
		});
		return btnNewButton;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


