

public class Tree extends TreeComponent {
	String name;
	
	public Tree(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void displayTreeInfo() {
		System.out.println(getName());
	}
}
