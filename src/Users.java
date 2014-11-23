import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 */

/**
 * @author Brian Tan
 *
 */
public class Users {
	private String name;
	private boolean isLeaf;
	Vector subordinates;
	Users parent = null;
	
	public Users(String name) {
		this.name = name;
		isLeaf = false;
		subordinates = new Vector();
	}
	
	public void setLeaf(boolean isLeaf){
		this.isLeaf = isLeaf;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getLeaf() {
		return isLeaf;
	}
	
	public String getName() {
		return name;
	}
	
	public Enumeration elements() {
		return subordinates.elements();
	}
	
	public Users getChild(String s) {
		Users users = null;
		if(getName().equals(s))
			return this;
		else {
			boolean found = false;
			Enumeration e = elements();
			while (e.hasMoreElements() && (!found)) {
				users = (Users) e.nextElement();
				found = users.getName().equals(s);
				if(!found) {
					users = users.getChild(s);
					found = (users != null);
				}
			}
			if (found)
				return users;
			else
				return null;
		}
	}
	
	public boolean add(Users u) {
		if(!isLeaf)
			subordinates.addElement(u);
		return isLeaf; // false if unsuccessful
	}
	
	public void remove(Users u) {
		if(!isLeaf)
			subordinates.removeElement(u);
	}
}
