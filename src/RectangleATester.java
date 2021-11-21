import java.util.Objects;

public class RectangleATester {

    // Don't touch these, it's for colour purposes in Intellij
    public static final String ANSI_RESET = "";
    public static final String ANSI_RED = "";
    public static final String ANSI_GREEN = "";
    public static final String ANSI_YELLOW = "";
    // Don't touch these, it's for colour purposes in Intellij

    public static void main(String[] args) {
        System.out.println("Test made for class RectangleA - Will be checking as far as I can possibly think of");
        print("Constructor from width and height: ");
        RectangleA r1 = new RectangleA(5, 4);
        Point p0 = new Point(0,0);
        if (r1.getWidth() == 5 && r1.getHeight() == 4 && r1.getPointSW().equals(p0)) {
            ok();
        } else {
            error("w=5,h=4,pointSW=(0,0)", "w=" + r1.getWidth() + ",h=" + r1.getHeight() + ",pointSW=" + r1.getPointSW());
        }

        print("Constructor from Point, Width, Height: ");
        Point p1 = new Point(5, 6);
        RectangleA r2 = new RectangleA(p1, 5, 4);
        if (r2.getWidth() == 5 && r2.getHeight() == 4 && r2.getPointSW().equals(p1)) {
            ok();
        } else {
            error("w=5,h=4,pointSW=(5,6)", "w=" + r2.getWidth() + ",h=" + r2.getHeight() + ",pointSW=" + r2.getPointSW());
        }

        print("Constructor from Point, Width, Height (Negative option): ");
        RectangleA r3 = new RectangleA(p1, -2, -5);
        if (r3.getWidth() == 1 && r3.getHeight() == 1) {
            ok();
        } else {
            error("w=1,h=1", "w=" + r3.getWidth() + ",h=" + r3.getHeight());
        }

        print("Constructor from two Points: ");
        Point p2 = new Point(5, 6);
        Point p3 = new Point(8, 10);
        RectangleA r4 = new RectangleA(p2, p3);
        if (r4.getWidth() == 3 && r4.getHeight() == 4) {
            ok();
        } else {
            error("w=3,h=4", "w=" + r4.getWidth() + ",h=" + r4.getHeight());
        }

        print("Constructor from another Rectangle: ");
        RectangleA r5 = new RectangleA(5, 4);
        RectangleA r6 = new RectangleA(r5);
        if (r6.getWidth() == 5 && r6.getHeight() == 4 && r6.getPointSW().equals(r5.getPointSW())) {
            okn();
        } else {
            errorn("w=5,h=4,pointSW=(0,0)", "w=" + r6.getWidth() + ",h=" + r6.getHeight() + ",pointSW=" + r6.getPointSW());
        }

        print("getWidth function: ");
        if (r5.getWidth() == 5) ok();
        else error(5, r5.getWidth());

        print("getHeight function: ");
        if (r5.getHeight() == 4) ok();
        else error(4, r5.getHeight());

        print("getPointSW function: ");
        if (r5.getPointSW().equals(new Point(0,0))) okn();
        else errorn(new Point(0,0), r5.getPointSW());

        print("setWidth function: ");
        RectangleA r7 = new RectangleA(5, 7);
        r7.setWidth(3);
        if (r7.getWidth() == 3) ok();
        else error(3, r7.getWidth());

        print("setHeight function: ");
        r7.setHeight(2);
        if (r7.getHeight() == 2) ok();
        else error(2, r7.getHeight());

        print("setPointSW function: ");
        r7.setPointSW(new Point(5, 5));
        if (r7.getPointSW().equals(new Point(5,5))) okn();
        else errorn(new Point(5,5), r7.getPointSW());

        print("toString function: ");
        if (Objects.equals(r7.toString(), "Width=3 Height=2 PointSW=(5,5)")) ok();
        else error("Width=3 Height=2 PointSW=(5,5)", r7);

        print("getPerimeter function: ");
        RectangleA r8 = new RectangleA(new Point(8, 7), new Point(11, 10));
        if (r8.getPerimeter() == 12) ok();
        else error(12, r8.getPerimeter());

        print("getArea function: ");
        if (r8.getArea() == 9) ok();
        else error(9, r8.getArea());

        print("move function: ");
        RectangleA r9 = new RectangleA(new Point(8, 11), 5, 8);
        r9.move(5, -5);
        if (r9.getPointSW().equals(new Point(13, 6))) ok();
        else error(new Point(13, 6), r9.getPointSW());

        print("equals function: ");
        RectangleA r10 = new RectangleA(5, 5);
        RectangleA r11 = new RectangleA(new Point(5, 8), 5, 5);
        if (!r10.equals(r11)) okn();
        else errorn(false, r10.equals(r11));

        print("getDiagonalLength function: ");
        RectangleA r12 = new RectangleA(new Point(5, 5), 5, 5);
        double exe = Math.sqrt(Math.pow(r12.getPointSW().getX() - r12.getPointNE().getX(), 2) + Math.pow(r12.getPointSW().getY() - r12.getPointNE().getY(), 2));
        if (r12.getDiagonalLength() == exe) ok();
        else error(exe, r12.getDiagonalLength());

        print("isLarger function (equal Rectangles ): ");
        RectangleA r26 = new RectangleA(5, 5);
        RectangleA r27 = new RectangleA(new Point(0,0), new Point(5, 5));
        if (!r27.isLarger(r26)) ok();
        else error(false, r27.isLarger(r26));

        print("isLarger function ( non-equal Rectangles ): ");
        RectangleA r13 = new RectangleA(new Point(8, 8), 3, 3);
        RectangleA r14 = new RectangleA(5, 8);
        if (r14.isLarger(r13)) ok();
        else error(true, r14.isLarger(r13));

        print("getPointNE function: ");
        RectangleA r15 = new RectangleA(new Point(5, 8), 2, 5);
        if (r15.getPointNE().equals(new Point(7, 13))) ok();
        else error(true, r15.getPointNE().equals(new Point(7, 13)));

        print("changeSides function: ");
        RectangleA r16 = new RectangleA(new Point(7, 5), 3, 5);
        r16.changeSides();
        if (r16.getWidth() == 5 && r16.getHeight() == 3) okn();
        else errorn("5,3", r16.getWidth() + "," + r16.getHeight());



        RectangleA r17 = new RectangleA(10, 10);
        System.out.println(r17);
        System.out.println(r17.getPointNE());
        RectangleA r18 = new RectangleA(new Point(1, 1), 1, 1);
        System.out.println(r18);
        System.out.println(r18.getPointNE());
        RectangleA r19 = new RectangleA(new Point(3, 4), 2, 2);
        RectangleA r20 = new RectangleA(new Point(8, 8), 3, 3);
        RectangleA r21 = new RectangleA(new Point(9, 9), 1, 1);
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

        RectangleA rA = new RectangleA(new Point(2, 1), new Point(7, 5));
        RectangleA rB = new RectangleA(new Point(4, 2), new Point(6, 3));
        RectangleA rC = new RectangleA(new Point(3, 4), new Point(5, 9));
        RectangleA rD = new RectangleA(new Point(1, 5), new Point(2, 7));
        RectangleA rE = new RectangleA(new Point(9,3), new Point(11, 5));
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

        System.out.println(ANSI_RESET + "-----Aliasing Tests-----");
        print("Aliasing on Constructor point,width,height: ");
        Point p4 = new Point(1, 2);
        RectangleA r22 = new RectangleA(p4, 3, 3);
        p4.setX(2);
        if (r22.getPointSW().getX() == 1) ok();
        else error(1, r22.getPointSW().getX());

        Point p5 = new Point(1, 2);
        Point p6 = new Point(4, 4);
        RectangleA r23 = new RectangleA(p5, p6);
        p5.setX(2);
        print("Aliasing on Constructor point,point: ");
        if (r23.getPointSW().getX() == 1) ok();
        else error(1, r23.getPointSW().getX());
        print("Aliasing on Constructor copying another r: ");
        RectangleA r24 = new RectangleA(new Point(3, 5), 5, 5);
        RectangleA r25 = new RectangleA(r24);
        r24.setPointSW(new Point(8, 10));
        if (!r25.getPointSW().equals(new Point(8, 10))) okn();
        else errorn(new Point(3, 5), new Point(8, 10));

        print("Aliasing on getPointSW function: ");
        Point p7 = new Point(1, 2);
        RectangleA r28 = new RectangleA(p7, 2, 2);
        r28.getPointSW().setX(8);
        if (r28.getPointSW().equals(p7)) ok();
        else error(true, r28.getPointNE().equals(p7));

        print("Aliasing on setPointSW function: ");
        Point p8 = new Point(3, 5);
        RectangleA r29 = new RectangleA(5, 6);
        r29.setPointSW(p8);
        p8.setY(6);
        if (!r29.getPointSW().equals(p8)) ok();
        else error(false, r29.getPointSW().equals(p8));
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
