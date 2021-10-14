package lsp;

public class Square {

    private final Rectangle rect;

    public Square() {
        super();
        rect = new Rectangle();
    }

    public void setSize(int size) {
        rect.setHeight(size);
        rect.setWidth(size);
    }

    public int getSize() {
        return rect.getHeight();
    }

    public int getArea() {
        return rect.getArea();
    }
}
