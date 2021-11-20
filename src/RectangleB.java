/**
 * Maman 12 - Class RectangleB.
 * The RectangleB class represents a 2D axis aligned integral rectangles.
 *
 * @author Noa Amir
 * @version 2022a
 */
public class RectangleB {
    // 1. instance variables
    private Point _pointSW;
    private Point _pointNE;

    // 2. constructors

    /**
     * First constructor for objects of class RectangleB Constructs a new rectangle with the specified width, height and it's south west corner is (0,0)
     *
     * @param w - The rectangle width
     * @param h - The rectangle height
     */
    public RectangleB(int w, int h) {
        _pointSW = new Point(0, 0);

        if (w < 1)
            w = 1;  // TODO: Should I do final DEFAULT_WIDTH = 1

        if (h < 1)
            h = 1; // TODO: Should I do final DEFAULT_HEIGHT = 1

        _pointNE = new Point(w, h);
    }

    /**
     * Second constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
     *
     * @param p - south-western vertex
     * @param w - The rectangle width
     * @param h - The rectangle height
     */
    public RectangleB(Point p, int w, int h) {
        _pointSW = new Point(p);

        if (w < 1)
            w = 1;

        if (h < 1)
            h = 1;

        _pointNE = new Point(_pointSW.getX() + w, _pointSW.getY() + h);
    }

    /**
     * Third constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
     *
     * @param sw - south-western vertex
     * @param ne - north-eastern vertex
     */
    public RectangleB(Point sw, Point ne) {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }

    /**
     * Copy constructor for objects of class RectangleB Constructs a rectangle using another rectangle
     *
     * @param r - The rectangle from which to construct the new object
     */
    public RectangleB(RectangleB r) {
        _pointSW = new Point(r._pointSW);
        _pointNE = new Point(r._pointNE);
    }

    // 3. getters and setters

    /**
     * Returns the South-West point of the rectangle
     *
     * @return a copy of the s-w point of the rectangle
     */
    public Point getPointSW() {
        return new Point(_pointSW);
    }

    /**
     * Returns the North-East point of the rectangle
     *
     * @return a copy of the n-e point of the rectangle
     */
    public Point getPointNE() {
        return new Point(_pointNE);
    }

    /**
     * Sets the South-West point of the rectangle.
     * This change affects also the NE Point since the width and height of the rectangle should NOT change
     *
     * @param p - the new S-W point of the rectangle
     */
    // TODO: NOT SURE!
    public void setPointSW(Point p) {
        int deltaX = p.getX() - _pointSW.getX();
        int deltaY = p.getY() - _pointSW.getY();
        //_pointSW = new Point(p);
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }

    // 4. methods

    /**
     * Returns a string representation of the rectangle
     *
     * @return a string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2)
     */
    public String toString() {
        return "Width=" + getWidth() + " Height=" + getHeight() + " PointSW=" + _pointSW.toString();
    }

    /**
     * Calculates the perimeter of the rectangle
     *
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter() {
        return 2 * getWidth() + 2 * getHeight();
    }

    /**
     * Calculates the area of the rectangle
     *
     * @return The area of the rectangle.
     */
    public int getArea() {
        return getWidth() * getHeight();
    }

    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction
     *
     * @param deltaX - translate the rectangle deltaX in the x direction.
     * @param deltaY - translate the rectangle deltaY in the y direction.
     */
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }

    /**
     * Returns the width of the rectangle
     *
     * @return the width of the rectangle
     */
    public int getWidth() {
        return _pointNE.getX() - _pointSW.getX();
    }

    /**
     * Returns the height of the rectangle
     *
     * @return the height of the rectangle
     */
    public int getHeight() {
        return _pointNE.getY() - _pointSW.getY();
    }

    /**
     * Sets the width of the rectangle
     *
     * @param w - the width of the rectangle to set to
     */
    public void setWidth(int w) {
        _pointNE.setX(_pointSW.getX() + w);
    }

    /**
     * Sets the height of the rectangle
     *
     * @param h - the height of the rectangle to set to
     */
    public void setHeight(int h) {
        _pointNE.setY(_pointSW.getY() + h);
    }

    /**
     * Returns true if the given rectangle is equal to this rectangle
     *
     * @param other - the rectangle to check equality with
     * @return true if other and this rectangle are equal
     */
    //TODO: NOT SURE!
    public boolean equals(RectangleB other) {
        return this.toString().equals(other.toString());
    }

    /**
     * Returns the length of the rectangle diagonal
     *
     * @return the length of the diagonal of the Rectangle
     */
    public double getDiagonalLength() {
        return _pointSW.distance(_pointNE);
    }

    /**
     * Returns true if the current rectangle is larger than the parameter rectangle
     *
     * @param other - another Rectangle to compare with
     * @return true - if the current Rectangle's area is larger than the other Rectangle which recieved as parameter, otherwise - false
     */
    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }

    /**
     * Changes the width to height and vice versa
     */
    // TODO: NOT SURE!
    public void changeSides() {
        int temp = getWidth();
        setWidth(getHeight());
        setHeight(temp);
    }

    /**
     * Returns true if the current rectangle is in the parameter rectangle
     *
     * @param r - another Rectangle to check with
     * @return true - if the current Rectangle's completely in the other Rectangle which received as parameter, otherwise -false
     */
    public boolean isIn(RectangleB r) {
        // all the options that rectangle r is PARTIALLY OUT of this rectangle. So return not all of these options.
        return !(r._pointSW.isLeft(this._pointSW)) && !(r._pointSW.isUnder(this._pointSW)) && !(r.getPointNE().isRight(this.getPointNE()) && !(r.getPointNE().isAbove(this.getPointNE())));
    }

    /**
     * Returns true if the current rectangle overlaps with the parameter rectangle
     *
     * @param r - another Rectangle to check with
     * @return true - if the current Rectangle's overlaps with the other Rectangle which received as parameter even by a single point, otherwise -false
     */
    public boolean overlap(RectangleB r) {
        // all the options that the rectangles ARE COMPLETELY STRANGERS. So return not all of these options.
        return !(r.getPointNE().isLeft(this._pointSW) || r._pointSW.isRight(this.getPointNE()) || r._pointSW.isAbove(this.getPointNE()) || r.getPointNE().isUnder(this._pointSW));
    }
}
