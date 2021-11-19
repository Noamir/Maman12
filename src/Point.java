/**
 * Maman 12 - Class Point.
 *
 * @author Noa Amir
 * @version 2022a
 */

public class Point {
    // 1. instance variable
    private int _x;
    private int _y;

    // 2. constructors
    /**
     * Constructor for objects of class Point Constructs a new point with the specified x y coordinates
     *
     * @param x - the x coordinate
     * @param y - the y coordinate
     */
    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    /**
     * Copy constructor, constructs and initializes a point using another point
     *
     * @param other - The point from which to construct the new object
     */
    public Point(Point other) {
        _x = other._x;
        _y = other._y;
    }

    // 3. getters and setters
    /**
     * Returns the x coordinate of the point.
     *
     * @return the x coordinate of the point
     */
    public int getX() {
        return _x;
    }

    /**
     * Returns the y coordinate of the point.
     *
     * @return the y coordinate of the point
     */
    public int getY() {
        return _y;
    }

    /**
     * Sets the x coordinate of the point
     *
     * @param num - a new value for the x coordinate
     */
    public void setX(int num) {
        _x = num;
    }

    /**
     * Sets the y coordinate of the point
     *
     * @param num - a new value for the y coordinate
     */
    public void setY(int num) {
        _y = num;
    }

    // 4. methods
    /**
     * Representation of the object in String
     *
     * @return the coordinates of a point as a string; for example : (1,2)
     */
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }

    /**
     * Checks if two points are equal.
     *
     * @param other - The point to be compared with the current point.
     * @return true if the point to be compared is equal to the current point.
     */
    public boolean equals(Point other) {
        return this._x == other._x && this._y == other._y;
        // TODO: I think we also can do this.equals(other) --> it adds the toString method by default, than we compare the 2 full string
        // return this.equals(other);
    }

    /**
     * Checks if the current point is above the point it is to be compared with.
     *
     * @param other - the point to be compared with the current point.
     * @return true if the current point is above the point it is to be compared with.
     */
    public boolean isAbove(Point other) {
        return this._y > other._y;
    }

    /**
     * Checks if the current point is beneath the point it is to be compared with.
     *
     * @param other - the point to be compared with the current point
     * @return true if the current point is beneath the point it is to be compared with
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * Checks if the current point is left of the point it is to be compared with.
     *
     * @param other - the point to be compared with the current point
     * @return true if the current point is left of the point it is to be compared with.
     */
    public boolean isLeft(Point other) {
        return this._x < other._x;
    }

    /**
     * Checks if the current point is right of the point it is to be compared with.
     *
     * @param other - the point to be compared with the current point
     * @return true if the current point is right of the point it is to be compared with.
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * Moves the current point , at location (x,y) to a new location.
     * This new location is determined by deltaX which changes X's position along the X axis and deltaY which changes Y's position along the Y axis.
     *
     * @param deltaX - the distance to move the current point along the X axis
     * @param deltaY - the distance to move the current point along the Y axis
     */
    public void move(int deltaX, int deltaY) {
        _x = _x + deltaX;
        _y = _y + deltaY;
    }

    /**
     * Calculates the distance between two points.
     *
     * @param p - the second point whose distance from the current point is to be calculated
     * @return the distance between the current point and the point passed as a parameter.
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(_x - p._x, 2) + Math.pow(_y - p._y, 2));
    }
}