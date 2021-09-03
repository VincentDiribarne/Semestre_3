package structure.poidmouche.array;

/**
 * A lightweight tree, state less.
 */
public class Tree{
	
	/**
	 * The default constructor.
	 */
	public Tree() {
		super();
	}
	
	/**
	 * Display data of a tree.
	 */
	public void display(int x, int y, int nbBranches) {
		System.out.println(String.valueOf(x) + " " +  String.valueOf(y) + " " + String.valueOf(nbBranches));
	}
}
