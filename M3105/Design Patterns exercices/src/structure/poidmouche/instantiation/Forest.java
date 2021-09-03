package structure.poidmouche.instantiation;

import java.util.ArrayList;
import java.util.List;

/**
 * A forest.
 */
public class Forest {
	
	/** Keep track of the trees in the forest. */
	private List<Tree> trees = new ArrayList<Tree>();
	
	/**
	 * Default constructor.
	 * 
	 * @param nbTrees The number of trees to instantiate in this forest.
	 * @param nbBranchesByTree The number of branchees by tree
	 */
	public Forest(int nbTrees, int nbBranchesByTree) {
		super();
		for (int x = 0;x < nbTrees; x++) {
			// The real coordinates does not matter here
			trees.add(new Tree(x,x,nbBranchesByTree));
		}
	}

}
