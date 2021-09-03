package structure.poidmouche;

import net.sourceforge.sizeof.SizeOf;
import structure.poidmouche.instantiation.Forest;

/**
 * Launch the lightweight forest example.
 * 
 * To work, the SizeOf library should be available in the build path. it can be
 * found here: http://sizeof.sourceforge.net/
 * 
 * The application must be launched with the "-javaagent:/path_to/sizeOf.jar" arguments
 * 
 * example: -javaagent:"C:\_REPO\IUT\M3105\Design Patterns exercices\SizeOf.jar"
 */
public class Launch {

	/** The number of trees in the forest. */
	private final static int NB_TREES = 100000;

	/** The number of branches on each tree. */
	private  final static int NB_BRANCHES = 100;
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		// First launch classic object instantiation
		Forest vForestClassic = new Forest(NB_TREES, NB_BRANCHES);
		// Display the memory used by this forest, and the time needed to instantiate it
		System.out.println(SizeOf.humanReadable(SizeOf.deepSizeOf(vForestClassic)));
		System.out.println(System.currentTimeMillis() - startTime);
		
		
		// Second launch lightweight instanciation
		startTime = System.currentTimeMillis();
		structure.poidmouche.array.Forest vForestArray = new structure.poidmouche.array.Forest(NB_TREES, NB_BRANCHES);
		// Display the memory used by this forest, and the time needed to instantiate it
		System.out.println(SizeOf.humanReadable(SizeOf.deepSizeOf(vForestArray)));
		System.out.println(System.currentTimeMillis() - startTime);

	}
}
