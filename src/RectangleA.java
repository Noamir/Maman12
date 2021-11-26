/**
 * Maman 12 - Class RectangleA.
 * The RectangleA class represents a 2D axis aligned integral rectangles.
 *
 * @author Noa Amir
 * @version 2022a
 */

public class RectangleA {

    // initialize final variables
    private final int MIN_WIDTH = 1;
    private final int MIN_HEIGHT = 1;
    private final int SW_DEFAULT_X = 0;
    private final int SW_DEFAULT_Y = 0;

    // 1. instance variables
    private int _width;
    private int _height;
    private Point _pointSW;

    // 2. constructors

    /**
     * Construct a new rectangle with the specified width, height. Initialize south-west corner to (0,0)
     *
     * @param w - The rectangle width
     * @param h - The rectangle height
     */
    public RectangleA(int w, int h) {
        _width = getProperWidth(w);
        _height = getProperHeight(h);
        _pointSW = new Point(SW_DEFAULT_X, SW_DEFAULT_Y);
    }

    /**
     * Construct a new rectangle with the specified width, height and south-west vertex
     *
     * @param p - south-western vertex
     * @param w - The rectangle width
     * @param h - The rectangle height
     */
    public RectangleA(Point p, int w, int h) {
        _width = getProperWidth(w);
        _height = getProperHeight(h);
        _pointSW = new Point(p);
    }

    /**
     * Construct a new rectangle with the specified vertices
     *
     * @param sw - south-western vertex
     * @param ne - north-eastern vertex
     */
    public RectangleA(Point sw, Point ne) {
        _width = ne.getX() - sw.getX();
        _height = ne.getY() - sw.getY();
        _pointSW = new Point(sw);
    }

    /**
     * Copy constructor for objects of class RectangleA Constructs a rectangle using another rectangle
     *
     * @param r - The rectangle from which to construct the new object
     */
    public RectangleA(RectangleA r) {
        _width = r._width;
        _height = r._height;
        _pointSW = new Point(r._pointSW);
    }

    // 3. getters and setters

    /**
     * Returns the width of the rectangle
     *
     * @return the width of the rectangle
     */
    public int getWidth() {
        return _width;
    }

    /**
     * Returns the height of the rectangle
     *
     * @return the height of the rectangle
     */
    public int getHeight() {
        return _height;
    }

    /**
     * Returns the South-West point of the rectangle
     *
     * @return a copy of the s-w point of the rectangle
     */
    public Point getPointSW() {
        return new Point(_pointSW);
    }

    /**
     * Sets the width of the rectangle
     *
     * @param w - the width of the rectangle to set to
     */
    public void setWidth(int w) {
        if (w >= MIN_WIDTH)
            _width = w;
    }

    /**
     * Sets the height of the rectangle
     *
     * @param h - the height of the rectangle to set to
     */
    public void setHeight(int h) {
        if (h >= MIN_HEIGHT)
            _height = h;
    }

    /**
     * Sets the South-West point of the rectangle
     *
     * @param p - the S-W point of the rectangle to set to
     */
    public void setPointSW(Point p) {
        _pointSW = new Point(p);
    }

    // 4. methods

    // width must be bigger than MIN_WIDTH. If not - return MIN_WIDTH
    private int getProperWidth(int w) {
        return Math.max(w, MIN_WIDTH);
    }

    // height must be bigger than MIN_HEIGHT. If not - return MIN_HEIGHT
    private int getProperHeight(int h) {
        return Math.max(h, MIN_HEIGHT);
    }

    /**
     * Returns a string representation of the rectangle
     *
     * @return a string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2)
     */
    public String toString() {
        return "Width=" + _width + " Height=" + _height + " PointSW=" + _pointSW.toString();
    }

    /**
     * Calculates the perimeter of the rectangle
     *
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        return 2 * _width + 2 * _height;
    }

    /**
     * Calculates the area of the rectangle
     *
     * @return The area of the rectangle.
     */
    public int getArea() {
        return _width * _height;
    }

    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction
     *
     * @param deltaX - translate the rectangle deltaX in the x direction.
     * @param deltaY - translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
    }

    /**
     * Returns true if the given rectangle is equal to this rectangle
     *
     * @param other - the rectangle to check equality with
     * @return true if other and this rectangle are equal
     */
    public boolean equals(RectangleA other) {
        return this._width == other._width &&
                this._height == other._height &&
                this._pointSW.equals(other._pointSW);
    }

    /**
     * Returns the length of the rectangle diagonal
     *
     * @return the length of the diagonal of the Rectangle
     */
    public double getDiagonalLength() {
        return _pointSW.distance(getPointNE());
    }

    /**
     * Returns true if the current rectangle is larger than the parameter rectangle
     *
     * @param other - another Rectangle to compare with
     * @return true - if the current Rectangle's area is larger than the other Rectangle which received as parameter, otherwise - false
     */
    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    /**
     * Returns the North-East point of the rectangle
     *
     * @return a copy of the North-East point of the Rectangle
     */
    public Point getPointNE() {
        return new Point(_pointSW.getX() + _width, _pointSW.getY() + _height);
    }

    /**
     * Changes the width to height and vice versa
     */
    public void changeSides() {
        int temp = _width;
        _width = _height;
        _height = temp;
    }

    /**
     * Returns true if the current rectangle is in the parameter rectangle
     *
     * @param r - another Rectangle to check with
     * @return true - if the current Rectangle's completely in the other Rectangle which received as parameter, otherwise - false
     */
    public boolean isIn(RectangleA r) {
        if (this.getPointNE().isRight(r.getPointNE()))
            return false; // current is out of r to the east
        if (this._pointSW.isLeft(r._pointSW))
            return false; // current is out of r to the west
        if (this.getPointNE().isAbove(r.getPointNE()))
            return false; // current is out of r to the north
        if (this._pointSW.isUnder(r._pointSW))
            return false; // current is out of r to the south

        return true; // if got here, current is not out of r
    }

    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle
     *
     * @param r - another Rectangle to check with
     * @return true - if the current Rectangle's overlaps with the other Rectangle which received as parameter even by a single point, otherwise - false
     */
    public boolean overlap(RectangleA r) {
        if (this._pointSW.isRight(r.getPointNE()))
            return false; // current is completely to the east of r
        if (this.getPointNE().isLeft(r._pointSW))
            return false; // current is completely to the west of r
        if (this._pointSW.isAbove(r.getPointNE()))
            return false; // current is completely to the north of r
        if (this.getPointNE().isUnder(r._pointSW))
            return false; // current is completely to the south of r

        return true; // if got here, current is not a stranger to r
    }
}