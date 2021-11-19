public class RectangleA {
    // 1. instance variables
    private int _width;
    private int _height;
    private Point _pointSW;

    // 2. constructors

    // gets 2 integers - w for width h for height
    // w,h must be positive ints. if not - defaulting to 1
    // point SW is initiated to (0,0)
    public RectangleA(int w, int h) {
        _pointSW = new Point(0, 0);

        if (w < 1)
            _width = 1; // TODO: Should I do final DEFAULT_WIDTH = 1
        else
            _width = w;

        if (h < 1)
            _height = 1; // TODO: Should I do final DEFAULT_HEIGHT = 1
        else
            _height = h;
    }

    // gets a point for SW point - not null
    // and 2 integers for width and height
    // w,h must be positive ints. if not - defaulting to 1
    public RectangleA(Point p, int w, int h) {
        _pointSW = new Point(p);

        if (w < 1)
            _width = 1;
        else
            _width = w;

        if (h < 1)
            _height = 1;
        else
            _height = h;
    }

    // gets sw point and ne point, both are different (different x and different y values) and not null
    public RectangleA(Point sw, Point ne) {
        _width = ne.getX() - sw.getX();
        _height = ne.getY() - sw.getY();
        _pointSW = new Point(sw);
    }

    // copy constructor
    public RectangleA(RectangleA r) {
        _width = r._width;
        _height = r._height;
        _pointSW = new Point(r._pointSW);
    }

    // 3. getters and setters
    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public Point getPointSW() {
        return new Point(_pointSW);
    }

    public void setWidth(int w) {
        if (w > 0)
            _width = w;
    }

    public void setHeight(int h) {
        if (h > 0)
            _height = h;
    }

    public void setPointSW(Point p) {
        _pointSW = new Point(p);
    }

    // 4. methods
    public String toString() {
        return "Width=" + _width + " Height=" + _height + " PointSW=" + _pointSW.toString();
    }

    // returns rectangle perimeter
    public int getPerimeter() {
        return 2 * _width + 2 * _height;
    }

    // returns rectangle area
    public int getArea() {
        return _width * _height;
    }

    // moves the rectangle deltaX and deltaY
    // adding deltaX to SW point x, and deltaY to SW point y
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
    }

    // check if the rectangle that initiates this method is equal (in all characters) to the other rectangle
    //TODO: NOT SURE!
    public boolean equals(RectangleA other) {
        return this.toString().equals(other.toString());
    }

    // returns rectangle diagonal length
    public double getDiagonalLength() {
        return _pointSW.distance(getPointNE());
    }

    // gets other rectangle, and check if the rectangle initiating this method (this) has larger area than other rectangle
    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    public Point getPointNE() {
        return new Point(_pointSW.getX() + _width, _pointSW.getY() + _height);
    }

    // change width to height, and height to width
    // TODO: NOT SURE!
    public void changeSides() {
        int temp = _width;
        _width = _height;
        _height = temp;
    }

    // check if rectangle r is inside the rectangle initiating this method
    public boolean isIn(RectangleA r) {
        // all the options that rectangle r is PARTIALLY OUT of this rectangle. So return not all of these options.
        return !(r._pointSW.isLeft(this._pointSW)) && !(r._pointSW.isUnder(this._pointSW)) && !(r.getPointNE().isRight(this.getPointNE()) && !(r.getPointNE().isAbove(this.getPointNE())));
    }

    // check if rectangle r has common points with the rectangle initiating this method
    public boolean overlap(RectangleA r) {
        // all the options that the rectangles ARE COMPLETELY STRANGERS. So return not all of these options.
        return !(r.getPointNE().isLeft(this._pointSW) || r._pointSW.isRight(this.getPointNE()) || r._pointSW.isAbove(this.getPointNE()) || r.getPointNE().isUnder(this._pointSW));
    }
}