package structure.composite;

import java.util.ArrayList;
import java.util.List;

public interface Graphic {
    //Imprime le graphique.
    public void print();
}
 
class CompositeGraphic implements Graphic{
    //Collection de graphiques enfants.
    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();
 
    //Imprime le graphique.
    public void print(){
        for (Graphic graphic : mChildGraphics){
            graphic.print();
        }
    }
     //Ajoute le graphique à la composition composition.
    public void add(Graphic graphic){
        mChildGraphics.add(graphic);
    }
     //Retire le graphique de la composition.
    public void remove(Graphic graphic){
        mChildGraphics.remove(graphic);
    }
}

class Ellipse implements Graphic{
    //Imprime le graphique.
    public void print()    {
        System.out.println("Ellipse");
    }
}
