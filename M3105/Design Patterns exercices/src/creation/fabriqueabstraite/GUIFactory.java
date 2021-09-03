package creation.fabriqueabstraite;

public abstract class GUIFactory{
	
   public static GUIFactory getFactory(){
        int sys = 1; //readFromConfigFile("OS_TYPE");

        if (sys == 0)
            return(new WinFactory());

        return(new OSXFactory());
   }
   
   public abstract Button createButton();

}

class WinFactory extends GUIFactory{
    public Button createButton(){
        return(new WinButton());
    }
}

class OSXFactory extends GUIFactory{
    public Button createButton(){
        return(new OSXButton());
    }
}



