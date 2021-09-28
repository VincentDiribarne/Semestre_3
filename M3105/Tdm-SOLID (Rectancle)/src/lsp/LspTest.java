package lsp;

public class LspTest {

    private static Rectangle getNewRectangle() {
        return new Rectangle();
    }

    private static Square getNewSquare() {
        return new Square();
    }

    public static void main(String[] args) {
        Rectangle aRectangle = getNewRectangle();
        Square square = getNewSquare();

        aRectangle.setWidth(50);
        aRectangle.setHeight(5);
        square.setSize(5);

        System.out.println("Rectancle : " + aRectangle.getArea());
        System.out.println("Carré : " + square.getArea());
    }
}
