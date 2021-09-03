package creation.fabriqueabstraite;

public abstract class Button{
    private String caption;

    public String getCaption(){
        return caption;
    }

    public void setCaption(String caption){
        this.caption = caption;
    }

    public abstract void paint();
}

class WinButton extends Button{
    public void paint(){
        System.out.println("I'm a WinButton: "+ getCaption());
    }
}

class OSXButton extends Button{
    public void paint(){
        System.out.println("I'm an OSXButton: "+ getCaption());
    }
}
