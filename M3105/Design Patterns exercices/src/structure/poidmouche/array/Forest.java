package structure.poidmouche.array;

/**
 * A lightweight forest representation.
 */
public class Forest {

	/** The data of all the trees of the forest. */
	private int[][] trees = null;

	/**
	 *  Default constructor.
	 */
	public Forest(int nbTrees, int nbBranchesByTree) {
		super();
		// One column for the x, one for the y, one for the number of branches
		// The real values does not matter here
		trees = new int[nbTrees][3];
		for (int x = 0; x < nbTrees; x++) {
			trees[x][0] = 0;
			trees[x][1] = 1;
			trees[x][2] = nbBranchesByTree;
		}
	}
}
