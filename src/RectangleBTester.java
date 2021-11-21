import java.util.Objects;

public class RectangleBTester {
    // Don't touch these, it's for colour purposes in Intellij
    public static final String ANSI_RESET = "";
    public static final String ANSI_RED = "";
    public static final String ANSI_GREEN = "";
    public static final String ANSI_YELLOW = "";
    // Don't touch these, it's for colour purposes in Intellij

    public static void main(String[] args) {
        System.out.println("Test made for class RectangleB - Will be checking as far as I can possibly think of");
        print("Constructor from width, height: ");
        RectangleB r1 = new RectangleB(5, 5);
        if (r1.getPointNE().equals(new Point(5, 5))) ok();
        else error(new Point(5, 5), r1.getPointNE());

        print("Constructor from point, width, height: ");
        RectangleB r2 = new RectangleB(new Point(3, 8), 3, 3);
        if (r2.getPointNE().equals(new Point(6, 11))) ok();
        else error(new Point(6, 11), r2.getPointNE());

        print("Constructor from point,point: ");
        RectangleB r3 = new RectangleB(new Point(3, 5), new Point(8, 8));
        if (r3.getPointSW().equals(new Point(3, 5)) &&
                r3.getPointNE().equals(new Point(8, 8))) ok();
        else error("pointSW=(3,5),pointNE=(8,8)", "pointSW=" + r3.getPointSW() +
                ",pointNE=" + r3.getPointNE());

        print("Constructor from another Rectangle: ");
        RectangleB r4 = new RectangleB(new Point(0, 0), new Point(3, 3));
        RectangleB r5 = new RectangleB(r4);
        if (r5.getPointSW().equals(new Point(0,0)) &&
                r5.getPointNE().equals(new Point(3,3))) okn();
        else errorn("pointSW=(0,0),pointNE=(3,3)", "pointSW=" + r5.getPointSW() +
                ",pointNE=" + r5.getPointNE());

        print("getWidth function: ");
        RectangleB r6 = new RectangleB(new Point(5, 8), new Point(8, 11));
        if (r6.getWidth() == 3) ok();
        else error(3, r6.getWidth());
        print("getHeight function: ");
        if (r6.getHeight() == 3) ok();
        else error(3, r6.getHeight());
        print("getPointSW function: ");
        if (r6.getPointSW().equals(new Point(5, 8))) okn();
        else errorn(new Point(5,8), r6.getPointSW());

        print("setWidth function: ");
        RectangleB r7 = new RectangleB(5, 10);
        r7.setWidth(3);
        if (r7.getWidth() == 3 &&
                r7.getPointNE().equals(new Point(3, 10))) ok();
        else error(3, r7.getWidth() +
                " (NOTE: check if you've set a new value to pointNE)");
        print("setHeight function: ");
        r7.setHeight(5);
        if (r7.getHeight() == 5 && r7.getPointNE().equals(new Point(3, 5))) ok();
        else error(5, r7.getHeight() +
                " (NOTE: check if you've set a new value to pointNE)");
        print("setPointSW function: ");
        r7.setPointSW(new Point(3, 5));
        if (r7.getPointSW().equals(new Point(3, 5)) &&
                r7.getPointNE().equals(new Point(6, 10))) okn();
        else errorn(new Point(3, 5), r7.getPointSW() +
                " (NOTE: check if you've set a new value to pointNE)");

        print("toString function: ");
        RectangleB r8 = new RectangleB(new Point(3, 8), 3, 5);
        if (Objects.equals(r8.toString(), "Width=3 Height=5 PointSW=(3,8)")) ok();
        else error("Width=3 Height=5 PointSW=(3,8)", r8.toString());

        print("getPerimeter function: ");
        if (r8.getPerimeter() == 16) ok();
        else error(16, r8.getPerimeter());

        print("getArea function: ");
        if (r8.getArea() == 15) ok();
        else error(15, r8.getArea());

        print("move function: ");
        RectangleB r9 = new RectangleB(5, 8);
        r9.move(2, 3);
        if (r9.getPointSW().equals(new Point(2, 3)) &&
                r9.getPointNE().equals(new Point(7, 11))) ok();
        else error("pointSW=(2,3),pointNE=(7,11)", "pointSW=" + r9.getPointSW() +
                ",pointNE=" + r9.getPointNE());

        print("equals function: ");
        RectangleB r10 = new RectangleB(5, 5);
        RectangleB r11 = new RectangleB(new Point(0, 0), new Point(5, 5));
        if (r10.equals(r11)) okn();
        else errorn(true, r10.equals(r11));

        print("getDiagonalLength function: ");
        double exe = Math.sqrt(Math.pow(r11.getPointSW().getX() - r11.getPointNE().getX(), 2) + Math.pow(r11.getPointSW().getY() - r11.getPointNE().getY(), 2));
        if (r11.getDiagonalLength() == exe) ok();
        else error(exe, r10.getDiagonalLength());

        print("isLarger function ( equal Rectangles ): ");
        if (!r11.isLarger(r10)) ok();
        else error(false, r11.isLarger(r10));

        print("isLarger function ( non-equal Rectangles ): ");
        RectangleB r12 = new RectangleB(1, 1);
        if (r10.isLarger(r12)) ok();
        else error(true, r10.isLarger(r12));

        print("getPointNE function: ");
        if (r10.getPointNE().equals(new Point(5, 5))) ok();
        else error(new Point(5, 5), r10.getPointNE());

        print("changeSides function: ");
        RectangleB r13 = new RectangleB(new Point(3, 8), 3, 5);
        if (r13.getPointNE().equals(new Point(6, 13))) okn();
        else errorn(new Point(6, 13), r13.getPointNE());

        RectangleB r17 = new RectangleB(10, 10);
        RectangleB r18 = new RectangleB(new Point(1, 1), 1, 1);
        RectangleB r19 = new RectangleB(new Point(3, 4), 2, 2);
        RectangleB r20 = new RectangleB(new Point(8, 8), 3, 3);
        RectangleB r21 = new RectangleB(new Point(9, 9), 1, 1);
        System.out.println(ANSI_RESET + "isIn function for these Rectangles: \n" +
                ANSI_YELLOW + "r17: " + r17 + "\n" +
                "r18: " + r18 + "\n" +
                "r19: " + r19 + "\n" +
                "r20: " + r20 + "\n" +
                "r21: " + r21);
        print("isIn function ( r18 in r17 ): ");
        if (r18.isIn(r17)) ok();
        else error(true, r18.isIn(r17));
        print("isIn function ( r19 outside of r18 ): ");
        if (!r19.isIn(r18)) ok();
        else error(false, r19.isIn(r18));
        print("isIn function ( r20 half inside r17 ): ");
        if (!r20.isIn(r17)) ok();
        else error(false, r20.isIn(r17));
        print("isIn function ( r20 outside of r18 ): ");
        if (!r20.isIn(r18)) ok();
        else error(false, r20.isIn(r18));
        print("isIn function ( r21 inside r17 ): ");
        if (r21.isIn(r17)) ok();
        else error(true, r21.isIn(r17));
        print("isIn function ( r21 inside r20 ): ");
        if (r21.isIn(r20)) okn();
        else errorn(true, r21.isIn(r20));

        RectangleB rA = new RectangleB(new Point(2, 1), new Point(7, 5));
        RectangleB rB = new RectangleB(new Point(4, 2), new Point(6, 3));
        RectangleB rC = new RectangleB(new Point(3, 4), new Point(5, 9));
        RectangleB rD = new RectangleB(new Point(1, 5), new Point(2, 7));
        RectangleB rE = new RectangleB(new Point(9,3), new Point(11, 5));
        System.out.println(ANSI_RESET + "overlap function being used on these Rectangles: \n" +
                ANSI_YELLOW + "rA: " + rA + "\n" +
                "rB: " + rB + "\n" +
                "rC: " + rC + "\n" +
                "rD: " + rD + "\n" +
                "rE: " + rE);
        print("rA overlaps rB: ");
        if (rA.overlap(rB)) ok();
        else error(true, rA.overlap(rB));
        print("rA overlaps rC: ");
        if (rA.overlap(rC)) ok();
        else error(true, rA.overlap(rC));
        print("rA overlaps rD: ");
        if (rA.overlap(rD)) ok();
        else error(true, rA.overlap(rD));
        print("rA overlaps rE: ");
        if (!rA.overlap(rE)) okn();
        else errorn(false, rA.overlap(rE));

        System.out.println(ANSI_RESET + "-----Aliasing Test-----");
        print("Aliasing on Constructor from point,width,height: ");
        Point p1 = new Point(5, 5);
        RectangleB r22 = new RectangleB(p1, 3, 3);
        p1.setX(3);
        if (r22.getPointSW().getX() == 5) ok();
        else error("(5,5)", r22.getPointSW());

        print("Aliasing on Constructor from point,point: ");
        Point p2 = new Point(8, 8);
        Point p3 = new Point(10, 12);
        RectangleB r23 = new RectangleB(p2, p3);
        p2.setX(7);
        p3.setY(10);
        if (r23.getPointSW().equals(new Point(8, 8)) &&
                r23.getPointNE().equals(new Point(10, 12))) ok();
        else error("pointSW=(8,8),pointNE=(10,12)", "pointSW=" + r23.getPointSW() +
                ",pointNE=" + r23.getPointNE());

        print("Aliasing on Constructor from Rectangle r: ");
        RectangleB r24 = new RectangleB(3, 3);
        RectangleB r25 = new RectangleB(r24);
        Point p4 = new Point(1, 1);
        r24.setPointSW(p4);
        if (!r25.getPointSW().equals(r24.getPointSW())) okn();
        else errorn(false, r25.getPointSW().equals(r24.getPointSW()));

        print("Aliasing on getPointSW function: ");
        Point p5 = new Point( 5, 8);
        RectangleB r26 = new RectangleB(p5, 3, 3);
        p5.setY(3);
        if (!r26.getPointSW().equals(p5)) ok();
        else error(false, r26.getPointSW().equals(p5));
        p5.setY(8);

        print("Aliasing on setPointSW function: ");
        Point p6 = new Point(1, 2);
        RectangleB r27 = new RectangleB(5, 8);
        r27.setPointSW(p6);
        p6.setX(0);
        if (!r27.getPointSW().equals(p6)) ok();
        else error(false, r27.getPointSW().equals(p6));

        print("Aliasing on getPointNE function: ");
        Point p7 = new Point(5, 6);
        Point p8 = new Point(7, 9);
        RectangleB r28 = new RectangleB(p7, p8);
        r28.getPointNE().setX(5);
        if (r28.getPointNE().equals(p8)) ok();
        else error(true, r28.getPointNE().equals(p8));

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
