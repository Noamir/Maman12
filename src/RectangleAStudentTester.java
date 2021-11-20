public class RectangleAStudentTester
{
    public static void main(String[] args)
    {
        final double EPSILON = 0.001;

        System.out.println("********** Test Q2 RectangleA - Start **********");
        System.out.println("********** Note that these are only basic tests. You need to think which tests to add for each constructor and method in order to test your class thoroughly.**********");

        System.out.println("testing first constructor and getters:");

        RectangleA r0 = new RectangleA(3,5);
        if (r0.getWidth() != 3 || r0.getHeight() != 5 ||
                !r0.getPointSW().equals(new Point(0,0)) || !r0.getPointNE().equals(new Point(3, 5)))
            System.out.println("\t ERROR -  constructor and getters expected Width=3 Height=5 PointSW=(0,0) actual= " + r0);
        else
            System.out.println("\t OK -  constructor and getters expected Width=3 Height=5 PointSW=(0,0) actual= " + r0);


        System.out.println("testing second constructor and getters:");
        RectangleA r1 = new RectangleA(new Point(1,2),3,5);
        if (r1.getWidth() != 3 || r1.getHeight() != 5 ||
                !r1.getPointSW().equals(new Point(1,2)))
            System.out.println("\t ERROR -  constructor and getters expected Width=3 Height=5 PointSW=(1,2) actual= " + r1);
        else
            System.out.println("\t OK -  constructor and getters expected Width=3 Height=5 PointSW=(1,2) actual= " + r1);


        System.out.println("testing third constructor and getters:");
        RectangleA r2 = new RectangleA(new Point(-1,2),new Point(2,7));
        if (r2.getWidth() != 3 || r2.getHeight() != 5 ||
                !r2.getPointSW().equals(new Point(-1,2)))
            System.out.println("\t ERROR -  constructor and getters expected Width=3 Height=5 PointSW=(-1,2) actual= " + r2);
        else
            System.out.println("\t OK -  constructor and getters expected Width=3 Height=5 PointSW=(-1,2) actual= " + r2);

        System.out.println("testing copy constructor: ");
        RectangleA r3 = new RectangleA(r2);
        if (r3.getWidth() != 3 || r3.getHeight() != 5 ||
                !r3.getPointSW().equals(new Point(-1,2)))
            System.out.println("\t ERROR -  copy constructor expected Width=3 Height=5 PointSW=(-1,2) actual= " + r3);
        else
            System.out.println("\t OK -  copy constructor expected Width=3 Height=5 PointSW=(-1,2) actual= " + r3);


        System.out.println("testing setters:");
        RectangleA r20 = new RectangleA(3,5);
        r20.setWidth(4);
        if (r20.getWidth() != 4 || r20.getHeight() != 5 ||
                !r20.getPointSW().equals(new Point(0,0)))
            System.out.println("\t ERROR -  setWidth(4) on point Width=3 Height=5 PointSW=(0,0) expected Width=4 Height=5 PointSW=(0,0) actual= " + r20);
        else
            System.out.println("\t OK -  setWidth(4) on point Width=3 Height=5 PointSW=(0,0) expected Width=4 Height=5 PointSW=(0,0) actual= " + r20);

        RectangleA r21 = new RectangleA(3,5);
        r21.setHeight(4);
        if (r21.getWidth() != 3 || r21.getHeight() != 4 ||
                !r21.getPointSW().equals(new Point(0,0)))
            System.out.println("\t ERROR -  setHeight(4) on point Width=3 Height=5 PointSW=(0,0) expected Width=3 Height=4 PointSW=(0,0) actual= " + r21);
        else
            System.out.println("\t OK -  setHeight(4) on point Width=3 Height=5 PointSW=(0,0) expected Width=3 Height=4 PointSW=(0,0) actual= " + r21);

        RectangleA r22 = new RectangleA(3,5);
        r22.setPointSW(new Point(1,2));
        if (r22.getWidth() != 3 || r22.getHeight() != 5 ||
                !r22.getPointSW().equals(new Point(1,2)))
            System.out.println("\t ERROR -  setPointSW(new Point(1,2)) on point Width=3 Height=5 PointSW=(0,0) expected Width=3 Height=5 PointSW=(1,2) actual= " + r22);
        else
            System.out.println("\t OK -  setPointSW(new Point(1,2)) on point Width=3 Height=5 PointSW=(0,0) expected Width=3 Height=5 PointSW=(1,2) actual= " + r22);


        System.out.println("testing toString:");
        RectangleA r4 = new RectangleA(3,5);
        if (!r4.toString().equals("Width=3 Height=5 PointSW=(0,0)"))
            System.out.println("\t ERROR -  toString expected Width=3 Height=5 PointSW=(0,0) actual= " + r4);
        else
            System.out.println("\t OK -  toString expected Width=3 Height=5 PointSW=(0,0) actual= " + r4);


        System.out.println("testing equals:");
        RectangleA r5 = new RectangleA(3,5);
        RectangleA r6 = new RectangleA(3,5);
        if (!r5.equals(r6))
            System.out.println("\t ERROR - r5.equals(r6) expected true ; actual=" + r5.equals(r6) + ";  r5=" + r5 + " r6=" + r6);
        else
            System.out.println("\t OK - r5.equals(r6) expected true ; actual=" + r5.equals(r6) + ";  r5=" + r5 + " r6=" + r6);


        System.out.println("testing getPerimeter:");
        RectangleA r7 = new RectangleA(3,5);
        if (r7.getPerimeter() != 16)
            System.out.println("\t ERROR - getPerimeter expected 16 ; actual=" + r7.getPerimeter() + ";  r7=" + r7);
        else
            System.out.println("\t OK - getPerimeter expected 16 ; actual=" + r7.getPerimeter()+ ";  r7=" + r7);


        System.out.println("testing getArea:");
        if (r7.getArea() != 15)
            System.out.println("\t ERROR - getArea expected 15 ; actual=" + r7.getArea() + ";  r7=" + r7);
        else
            System.out.println("\t OK - getArea expected 15 ; actual=" + r7.getArea()+ ";  r7=" + r7);

        System.out.println("testing move:");
        RectangleA r8 = new RectangleA(3,5);
        r8.move(-1, 2);
        if (!r8.getPointSW().equals(new Point(-1,2)))
            System.out.println("\t ERROR - move(-1,2) on point Width=3 Height=5 PointSW=(0,0) expected Width=3 Height=5 PointSW=(-1,2) ; actual= " + r8);
        else
            System.out.println("\t OK - move(-1,2) on point Width=3 Height=5 PointSW=(0,0) expected Width=3 Height=5 PointSW=(-1,2) ; actual= " + r8);


        System.out.println("testing getDiagonalLength:");
        RectangleA r9 = new RectangleA(4,3);
        double d = r9.getDiagonalLength();
        if (Math.abs(d - 5) > EPSILON)
            System.out.println("\t ERROR - getDiagonalLength on point Width=4 Height=3 PointSW=(0,0) expected 5.0 ; actual=" + d);
        else
            System.out.println("\t OK - getDiagonalLength on point Width=4 Height=3 PointSW=(0,0) expected 5.0 ; actual=" + d);


        System.out.println("testing getPointNE:");
        RectangleA r13 = new RectangleA(new Point(2,2),3,5);
        Point NE = r13.getPointNE();
        if (NE.getX()!=5)
            System.out.println("\t ERROR - if SW Point is(2,2) and width and height are 1 and 1, respectively, " +
                    " then the expected x coordinate of the NE point should be 5 while your code returns "+
                    NE.getX());
        if (NE.getY()!=7)
            System.out.println("\t ERROR - if SW Point is(2,2) and width and height are 1 and 1, respectively, " +
                    " then the expected y coordinate of the NE point should be 7 while your code returns "+
                    NE.getY());
        else
            System.out.println("\t OK - if SW Point is(2,2) and width and height are 3 and 5, respectively, " +
                    " then the expected x coordinate of the NE point should be 5 and the y should be 7 as your code returns");

        System.out.println("testing isLarger:");
        RectangleA r10 = new RectangleA(4,4);
        if (!r10.isLarger(r9))
            System.out.println("\t ERROR - r10.isLarger(r9) expected true ; actual=" + r10.isLarger(r9) + ";  r9=" + r9 + " r10=" + r10);
        else
            System.out.println("\t OK - r10.isLarger(r9) expected true ; actual=" + r10.isLarger(r9) + ";  r9=" + r9 + " r10=" + r10);


        System.out.println("testing changeSides:");
        RectangleA r12 = new RectangleA(new Point(2,3),1,2);
        r12.changeSides();
        if (r12.getWidth() != 2 || r12.getHeight() != 1 || !r12.getPointSW().equals(new Point(2,3)))
            System.out.println("\t ERROR - changeSides on point Width=1 Height=2 PointSW=(2,3) expected Width=2 Height=1 PointSW=(2,3) ; actual= " + r12);
        else
            System.out.println("\t OK - changeSides on point Width=1 Height=2 PointSW=(2,3) expected Width=2 Height=1 PointSW=(2,3) ; actual= " + r12);


        System.out.println("testing isIn:");
        if (!r9.isIn(r10))
            System.out.println("\t ERROR - r9.isIn(r10) expected true ; actual=" + r9.isIn(r10) + ";  r9=" + r9 + " r10=" + r10);
        else
            System.out.println("\t OK - r9.isIn(r10) expected true ; actual=" + r9.isIn(r10) + ";  r9=" + r9 + " r10=" + r10);


        System.out.println("testing overlap:");
        RectangleA r11 = new RectangleA(new Point(-1,-2),3,5);
        if (!r11.overlap(r9))
            System.out.println("\t ERROR - r11.overlap(r9) expected true ; actual=" + r11.overlap(r9) + ";  r9=" + r9 + " r11=" + r11);
        else
            System.out.println("\t OK - r11.overlap(r9) expected true ; actual=" + r11.overlap(r9) + ";  r9=" + r9 + " r11=" + r11);

        System.out.println("********** Test Q2 RectangleA - Finished **********\n");
    }
}
