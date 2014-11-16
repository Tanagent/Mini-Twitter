

import java.util.ArrayList;
import java.util.Iterator;

public class TreeGroup extends TreeComponent {
	ArrayList treeComponents = new ArrayList();
	
	String groupName;
	
	public TreeGroup(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void add(TreeComponent newTreeComponent) {
		treeComponents.add(newTreeComponent);
	}
	
	public void remove(TreeComponent newTreeComponent) {
		treeComponents.remove(newTreeComponent);
	}
	
	public TreeComponent getComponent(int componentIndex) {
		return (TreeComponent) treeComponents.get(componentIndex);
	}
	
	public void displayTreeInfo() {
		System.out.println(getGroupName() + "\n");
		Iterator treeIterator = treeComponents.iterator();
		while(treeIterator.hasNext()) {
			TreeComponent treeInfo = (TreeComponent) treeIterator.next();
			treeInfo.displayTreeInfo();
		}
	}
}
