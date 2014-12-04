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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

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
	private DefaultMutableTreeNode troot;
	private int totalUser;
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
	 * Create the frame for UserInterface.
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
		
		JButton btnButtonShow_2 = new JButton("Show Positive Percentage");
		btnButtonShow_2.setBounds(366, 259, 160, 58);
		contentPane.add(btnButtonShow_2);
		
		JButton btnButtonShow_1 = new JButton("Show Messages Total");
		btnButtonShow_1.setBounds(205, 259, 160, 58);
		contentPane.add(btnButtonShow_1);
		
		JButton btnButtonShow = groupTotal();
		btnButtonShow.setBounds(366, 210, 160, 46);
		contentPane.add(btnButtonShow);
		
		JButton btnButtonShowUser = totalUser();
		btnButtonShowUser.setBounds(205, 211, 160, 45);
		contentPane.add(btnButtonShowUser);
		
		JButton btnButtonOpen = goToUI();
		btnButtonOpen.setBounds(205, 108, 321, 52);
		contentPane.add(btnButtonOpen);
		
		txtTextareaUser = new JTextField();
		txtTextareaUser.setText("User Id");
		txtTextareaUser.setBounds(205, 5, 160, 52);
		contentPane.add(txtTextareaUser);
		txtTextareaUser.setColumns(10);
		
		txtTextareaGroup = new JTextField();
		txtTextareaGroup.setText("Group Id");
		txtTextareaGroup.setColumns(10);
		txtTextareaGroup.setBounds(205, 58, 160, 48);
		contentPane.add(txtTextareaGroup);
		
		JButton btnNewButton_1 = verification();
		btnNewButton_1.setBounds(205, 184, 321, 28);
		contentPane.add(btnNewButton_1);
		
		lastUpdatedUser();
	}

	/**
	 * This button makes another window that ouputs the ID of
	 * the user who made the last update. 
	 */
	private void lastUpdatedUser() {
		JButton btnNewButton_2 = new JButton("Last Updated User");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				class Display extends JFrame {
					private JLabel item;
					public Display() {
						super("Last Updated User");
						UserView uv = new UserView(user);
						setLayout(new FlowLayout());
						item = new JLabel(uv.getLastUpdated());
						add(item);
					}
				}
				Display display = new Display();
				display.setSize(100, 100);
				display.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(205, 160, 321, 23);
		contentPane.add(btnNewButton_2);
	}

	private JButton verification() {
		JButton btnNewButton_1 = new JButton("User/Group ID verification");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				class Display extends JFrame {
					private JLabel item;
					public Display() {
						super("User/Group ID verification");
						setLayout(new FlowLayout());
						Enumeration e = troot.preorderEnumeration();
						if(checkDuplicate(e) && checkSpace())
							item = new JLabel("All the IDs have been validated");
						else if(checkDuplicate(e) && !checkSpace())
							item = new JLabel("IDs cannot contain spaces.");
						else if(!checkDuplicate(e) && checkSpace())
							item = new JLabel("IDs have to be unique");
						else
							item = new JLabel("IDs cannot contain spaces and has to be unique");
						add(item);
					}
				}
				Display display = new Display();
				display.setSize(300, 200);
				display.setVisible(true);
				
			}
		});
		return btnNewButton_1;
	}
	
	/**
	 * detects duplicates using sets.
	 * since set doesn't contain duplicates, size must be less
	 * for a list which contains duplicates.
	 * @return true if the set is the same as the list, false otherwise.
	 */
	private boolean checkDuplicate(Enumeration e) {
		//Enumeration e = troot.preorderEnumeration();
		ArrayList list = new ArrayList();
		Set set = new HashSet(list);
		while(e.hasMoreElements())
			list.add(e.nextElement());
		set.addAll(list);
		return (set.size() == list.size());
	}
	
	/**
	 * goes through the list and checks if any word contains a space
	 * @return true if there aren't any spaces, false otherwise.
	 */
	private boolean checkSpace() {
		Enumeration e = troot.preorderEnumeration();
		e.nextElement();
		while(e.hasMoreElements()) {
			if(e.nextElement().toString().contains(" "))
				return false;
		}
		return true;
	}
	
	/**
	 * The implementation of the lazy instantiation.
	 * @return the instance of UserInterface.
	 */
	public static UserInterface getInstance() {
		if(instance == null)
			instance = new UserInterface();
		return instance;
	}
	
	/**
	 * @return another window displaying the total number of groups in JTree when pressed.
	 */
	private JButton groupTotal() {
		JButton btnButtonShow = new JButton("Show Group Total");
		btnButtonShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				class Display extends JFrame {
					private JLabel item;
					public Display() {
						super("Total Group");
						setLayout(new FlowLayout());
						item = new JLabel(Integer.toString(3));
						add(item);
					}
				}
				Display display = new Display();
				display.setSize(100, 100);
				display.setVisible(true);
			}
		});
		return btnButtonShow;
	}
	
	/**
	 * builds JTree.
	 * @param topDog - the root of Jtree. 
	 */
	private void setTree(Users topDog) {
		troot = new DefaultMutableTreeNode(topDog.getName());
		tree = new JTree(troot);
		tree.addTreeSelectionListener((TreeSelectionListener) this);
		addNodes(troot, topDog);
		totalUser = troot.getLeafCount();
		
		tree.setBounds(5, 5, 190, 312);
		contentPane.add(tree);

	}
	
	/**
	 * adds nodes to the JTree if needed.
	 * @param pnode - the root node of JTree
	 * @param user - the root of JTree
	 */
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
	
	/**
	 * loads the users into the tree.
	 */
	private void makeUsers() {
	    root = new Users("Root");
	    root.add(john = new Users("John"));
	    root.add(bob = new Users("Bob"));
	    root.add(steve = new Users("Steven"));
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
	
	/**
	 * @return another window that outputs the total number of user
	 */
	private JButton totalUser() {
		JButton btnButtonShowUser = new JButton("Show User Total");
		btnButtonShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				class Display extends JFrame {
					private JLabel item;
					public Display() {
						super("Total User");
						setLayout(new FlowLayout());
						item = new JLabel(Integer.toString(totalUser));
						add(item);
					}
				}
				Display display = new Display();
				display.setSize(100, 100);
				display.setVisible(true);
			}
		});
		return btnButtonShowUser;
	}

	/**
	 * @return allows input another group to be added to the tree.
	 */
	private JButton addGroup() {
		JButton button = new JButton("Add Group");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserView asdf = new UserView("Bob");
				System.out.println(asdf.getFollowers());
			}
		});

		return button;
	}
	
	/**
	 * @return a button that opens up a view for the selected User.
	 */
	private JButton goToUI() {
		JButton btnButtonOpen = new JButton("Open User View");
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
		
		//opens up the window to the selected user.
		btnButtonOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UserView uv = new UserView(user);
							System.out.println(user + " - " + System.currentTimeMillis());
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

	/**
	 * @return adds user to JTree.
	 */
	private JButton addUser() {
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				// gets info from the text field and adds it onto the list.
			}
		});
		return btnNewButton;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * uses the observer pattern to it's followers.
	 */
	public void observer() {
		final EventSource eventSource = new EventSource();
		final ResponseHandler responseHandler = new ResponseHandler();
		eventSource.addObserver(responseHandler);
		Thread thread = new Thread(eventSource);
		thread.start();
	}
}


