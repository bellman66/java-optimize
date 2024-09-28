package keyword;

/**
 *  sealed keyword test
 **/
public class Sealed {

    // target extend class
    static sealed class Shape permits Circle, Rectangle {

    }

    static final class Circle extends Shape {

    }

    static non-sealed class Rectangle extends Shape {

    }

    // error because SecondCircle is not permitted
    // static final class SecondCircle extends Circle { }

    // not error because Rectangle is non-sealed
    static class SecondRectangle extends Rectangle {

    }

}
