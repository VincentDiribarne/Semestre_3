package Arbre;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Tree<Character> treeA = new TreeImpl<Character>('a');
        Tree<Character> treeB = new TreeImpl<Character>('b');
        Tree<Character> treeC = new TreeImpl<Character>('c');
        Tree<Character> treeD = new TreeImpl<Character>('d');
        Tree<Character> treeE = new TreeImpl<Character>('e');
        Tree<Character> treeF = new TreeImpl<Character>('f');
        Tree<Character> treeG = new TreeImpl<Character>('g');

        treeA.addTree(treeB);
        treeA.addTree(treeC);
        treeC.addTree(treeD);
        treeC.addTree(treeE);
        treeC.addTree(treeF);
        treeD.addTree(treeG);

        treeA.dumpTree();

        System.out.println("");
        System.out.println("Parcours en Préfix");
        Iterator<Character> it = treeA.prefixPathIterator();
        while (it.hasNext()) {
            Character character = it.next();
            System.out.print(character);
        }
        System.out.println();

        System.out.println("Parcours en Suffix");
        it = treeA.suffixPathIterator();
        while (it.hasNext()) {
            Character character = (Character) it.next();
            System.out.print(character);
        }
        System.out.println();
        /*
        it = treeA.spanPathIterator();
        while (it.hasNext()) {
            Character character = (Character) it.next();
            System.out.print(character);
        }*/
    }
}
