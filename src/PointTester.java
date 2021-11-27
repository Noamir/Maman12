import java.util.Objects;


public class PointTester {

    // Don't touch these, it's for colour purposes
    public static final String ANSI_RESET = "";
    public static final String ANSI_RED = "";
    public static final String ANSI_GREEN = "";
    // Don't touch these, it's for colour purposes

    public static void main(String[] args) {

        System.out.println("Test Made for class Point - Will be checking as far as I can possibly think of\n");
        print("Constructor from x and y coordinates: ");
        Point p1 = new Point(5, 4);
        if (p1.getX() == 5 && p1.getY() == 4) ok();
        else error("(5,4)", p1);
        System.out.print(ANSI_RESET + "Constructor copied from another Point: ");
        Point p2 = new Point(5, 4);
        Point p3 = new Point(p2);
        if (p2.getX() == p3.getX() && p2.getY() == p3.getY()) okn();
        else errorn("(5,4)", p3);

        print("getX function: ");
        Point p4 = new Point(5, 8);
        if (p4.getX() == 5) ok();
        else error(5, p4.getX());

        print("getY function: ");
        if (p4.getY() == 8) okn();
        else errorn(8, p4.getY());

        print("setX function: ");
        p4.setX(3);
        if (p4.getX() == 3) ok();
        else error(3, p4.getX());

        print("setY function: ");
        p4.setY(5);
        if (p4.getY() == 5) okn();
        else errorn(5, p4.getY());

        print("toString function: ");
        if (Objects.equals(p4.toString(), "(3,5)")) ok();
        else error("(3,5)", p4);

        print("equal function: ");
        Point p5 = new Point(5, 4);
        Point p6 = new Point(p5);
        if (p5.equals(p6)) ok();
        else error(true, p5.equals(p6));

        print("isAbove function (non-equal points): ");
        Point p7 = new Point(5, 8);
        if (p7.isAbove(p5)) ok();
        else error(true, p7.isAbove(p5));

        print("isAbove function (equal points): ");
        Point p8 = new Point(p7);
        if (!p8.isAbove(p7)) ok();
        else error(false, p8.isAbove(p7));

        print("isUnder function (non-equal points): ");
        Point p9 = new Point(9, 20);
        if (p8.isUnder(p9)) ok();
        else error(true, p8.isUnder(p9));

        print("isUnder function (equal points): ");
        Point p10 = new Point(p9);
        if (!p10.isUnder(p9)) ok();
        else error(false, p10.isUnder(p9));

        Point p11 = new Point(5, 5);
        Point p12 = new Point(9, 10);
        Point p13 = new Point(p12);

        print("isLeft function (equal points): ");
        if (!p12.isLeft(p13)) ok();
        else error(false, p12.isLeft(p13));

        print("isLeft function (non-equal points): ");
        if (p11.isLeft(p12)) ok();
        else error(true, p11.isLeft(p12));

        print("isRight function (equal points): ");
        if (!p12.isRight(p13)) ok();
        else error(false, p12.isRight(p13));

        print("isRight function (non-equal points): ");
        if (p12.isRight(p11)) okn();
        else errorn(true, p12.isRight(p11));

        print("move function: ");
        p11.move(5, -5);
        if (p11.getX() == 10 && p11.getY() == 0) ok();
        else error("(5,0)", p11);

        print("distance function: ");
        Point p14 = new Point(5, 5);
        Point p15 = new Point(8, 8);
        double exe = Math.sqrt(Math.pow(p14.getX() - p15.getX(), 2) + Math.pow(p14.getY() - p15.getY(), 2));
        if (p14.distance(p15) == exe) ok();
        else error(exe, p14.distance(p15));
    }

    private static void print(String sentence) {
        System.out.print(ANSI_RESET + sentence);
    }

    private static void error(Object expected, Object actual) {
        System.out.println(ANSI_RED + "Returned ERROR - Expected: " + expected + " || Actual: " + actual);
    }

    private static void errorn(Object expected, Object actual) {
        System.out.println(ANSI_RED + "Returned ERROR - Expected: " + expected + " || Actual: " + actual + "\n");
    }

    private static void ok() {
        System.out.println(ANSI_GREEN + "Returned OK");
    }

    private static void okn() {
        System.out.println(ANSI_GREEN + "Returned OK\n");
    }
}
