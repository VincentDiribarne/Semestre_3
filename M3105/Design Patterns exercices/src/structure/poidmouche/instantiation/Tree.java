package structure.poidmouche.instantiation;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree representation.
 */
public class Tree {
	
	/** The x coordinate. */
	private int x = 0;
	
	/** The y coordinate. */
	private int y = 0;
	
	/** Branches on this tree. */
	private List<Branch> branches = new ArrayList<Branch>();

	/**
	 * Default constructor.
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param nbBranches The number of branches on this tree.
	 */
	public Tree(int x, int y, int nbBranches) {
		super();
		this.x = x;
		this.y = y;
		for (int i = 0; i < nbBranches; i++) {
			branches.add(new Branch());
		}
	}

	/**
	 * Display this tree.
	 */
	public void display() {
		System.out.println(String.valueOf(x) + " " +  String.valueOf(y) + " " + String.valueOf(branches.size()));
	}
}
