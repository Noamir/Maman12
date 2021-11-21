
/**
 * Write a description of class RectBOverlapTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RectBOverlapTest
{
    private static int totalCount = 0;
    private static int passedCount = 0;

    public static void main(String[] args)
    {
        // RectangleB r1 = new RectangleB(new Point(1, 1), new Point(5, 5));
        // RectangleB r2 = new RectangleB(new Point(2, 2), new Point(3, 3));
        // RectangleB r3 = new RectangleB(new Point(2, 4), new Point(4, 7));
        // RectangleB r4 = new RectangleB(new Point(4, 0), new Point(6, 2));
        // RectangleB r5 = new RectangleB(new Point(2, 4), new Point(4, 7));
        // RectangleB r6 = new RectangleB(new Point(5, 5), new Point(6, 6));
        // RectangleB r7 = new RectangleB(new Point(5, 2), new Point(6, 4));
        // RectangleB r8 = new RectangleB(new Point(6, 7), new Point(7, 8));
        // RectangleB r9 = new RectangleB(new Point(7, 4), new Point(9, 5));
        // RectangleB r10 = new RectangleB(new Point(7, 2), new Point(8, 3));

        System.out.println("----- Testing Overlapping 4 Points Inside -----\n");
        RectangleB r1 = new RectangleB(new Point(2, 2), new Point(5, 5));
        RectangleB r2 = new RectangleB(new Point(3, 3), new Point(4, 4));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Overlapping 2 Points Inside -----\n");
        System.out.println("Right");
        r2 = new RectangleB(new Point(3, 3), new Point(6, 4));
        runOverlap(r1, r2, true);

        System.out.println("Top");
        r2 = new RectangleB(new Point(3, 4), new Point(4, 6));
        runOverlap(r1, r2, true);

        System.out.println("Left");
        r2 = new RectangleB(new Point(1, 3), new Point(3, 4));
        runOverlap(r1, r2, true);

        System.out.println("Bottom");
        r2 = new RectangleB(new Point(3, 4), new Point(4, 6));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Overlapping 1 Point Inside -----\n");
        System.out.println("Bottom-Right");
        r2 = new RectangleB(new Point(4, 1), new Point(6, 3));
        runOverlap(r1, r2, true);

        System.out.println("Bottom-Left");
        r2 = new RectangleB(new Point(1, 1), new Point(3, 3));
        runOverlap(r1, r2, true);

        System.out.println("Top-left");
        r2 = new RectangleB(new Point(1, 4), new Point(3, 6));
        runOverlap(r1, r2, true);

        System.out.println("Top-Right");
        r2 = new RectangleB(new Point(4, 4), new Point(6, 6));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Overlapping Crossing No Points Inside -----\n");
        r2 = new RectangleB(new Point(1, 3), new Point(6, 4));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Overlapping Touching Sides Outside -----\n");
        System.out.println("Right");
        r2 = new RectangleB(new Point(5, 3), new Point(6, 4));
        runOverlap(r1, r2, true);

        System.out.println("Top");
        r2 = new RectangleB(new Point(3, 5), new Point(4, 6));
        runOverlap(r1, r2, true);

        System.out.println("Left");
        r2 = new RectangleB(new Point(1, 3), new Point(2, 4));
        runOverlap(r1, r2, true);

        System.out.println("Bottom");
        r2 = new RectangleB(new Point(3, 1), new Point(4, 2));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Overlapping Touching Sides Inside -----\n");
        System.out.println("Right");
        r2 = new RectangleB(new Point(4, 3), new Point(5, 4));
        runOverlap(r1, r2, true);

        System.out.println("Top");
        r2 = new RectangleB(new Point(3, 4), new Point(4, 5));
        runOverlap(r1, r2, true);

        System.out.println("Left");
        r2 = new RectangleB(new Point(2, 3), new Point(3, 4));
        runOverlap(r1, r2, true);

        System.out.println("Bottom");
        r2 = new RectangleB(new Point(3, 2), new Point(4, 3));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Overlapping Touching Points -----\n");
        System.out.println("Bottom-Right");
        r2 = new RectangleB(new Point(5, 1), new Point(6, 2));
        runOverlap(r1, r2, true);

        System.out.println("Bottom-Left");
        r2 = new RectangleB(new Point(1, 1), new Point(2, 2));
        runOverlap(r1, r2, true);

        System.out.println("Top-left");
        r2 = new RectangleB(new Point(1, 5), new Point(2, 6));
        runOverlap(r1, r2, true);

        System.out.println("Top-Right");
        r2 = new RectangleB(new Point(5, 5), new Point(6, 6));
        runOverlap(r1, r2, true);

        System.out.println("----- Testing Not Overlapping Smaller -----\n");
        System.out.println("Right");
        r2 = new RectangleB(new Point(6, 3), new Point(7, 4));
        runOverlap(r1, r2, false);

        System.out.println("Top");
        r2 = new RectangleB(new Point(3, 6), new Point(4, 7));
        runOverlap(r1, r2, false);

        System.out.println("Left");
        r2 = new RectangleB(new Point(0, 3), new Point(1, 4));
        runOverlap(r1, r2, false);

        System.out.println("Bottom");
        r2 = new RectangleB(new Point(3, 0), new Point(4, 1));
        runOverlap(r1, r2, false);

        System.out.println("----- Testing Not Overlapping Larger -----\n");
        System.out.println("Left");
        r2 = new RectangleB(new Point(6, 3), new Point(7, 4));
        runOverlap(r2, r1, false);

        System.out.println("Bottom");
        r2 = new RectangleB(new Point(3, 6), new Point(4, 7));
        runOverlap(r2, r1, false);

        System.out.println("Right");
        r2 = new RectangleB(new Point(0, 3), new Point(1, 4));
        runOverlap(r2, r1, false);

        System.out.println("Top");
        r2 = new RectangleB(new Point(3, 0), new Point(4, 1));
        runOverlap(r2, r1, false);

        System.out.println("----- Testing Not Overlapping No Common -----\n");
        System.out.println("Bottom-Right");
        r2 = new RectangleB(new Point(6, 0), new Point(7, 1));
        runOverlap(r1, r2, false);

        System.out.println("Bottom-Left");
        r2 = new RectangleB(new Point(0, 0), new Point(1, 1));
        runOverlap(r1, r2, false);

        System.out.println("Top-left");
        r2 = new RectangleB(new Point(0, 6), new Point(1, 7));
        runOverlap(r1, r2, false);

        System.out.println("Top-Right");
        r2 = new RectangleB(new Point(6, 6), new Point(7, 7));
        runOverlap(r1, r2, false);

        System.out.println("Tests Passed: " + passedCount + "/" + totalCount);
    }

    private static void runOverlap(RectangleB rA, RectangleB rB, boolean expected)
    {
        totalCount++;

        System.out.println(rA);
        System.out.println(rB);
        System.out.println("Expected: " + expected + " Actucal: " + rA.overlap(rB));

        if( expected == rA.overlap(rB))
        {
            passedCount++;
            System.out.println("Test Passed");
        }
        else
        {
            System.out.println("Test Failed");
        }
        System.out.println();
    }
}
