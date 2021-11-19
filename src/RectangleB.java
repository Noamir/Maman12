public class RectangleB {
    // 1. instance variables
    private Point _pointSW;
    private Point _pointNE;

    // 2. constructors
    public RectangleB(int w, int h) {
        _pointSW = new Point(0, 0);

        if (w < 1)
            w = 1;  // TODO: Should I do final DEFAULT_WIDTH = 1

        if (h < 1)
            h = 1; // TODO: Should I do final DEFAULT_HEIGHT = 1

        _pointNE = new Point(w, h);
    }

    public RectangleB(Point p, int w, int h) {
        _pointSW = new Point(p);

        if (w < 1)
            w = 1;

        if (h < 1)
            h = 1;

        _pointNE = new Point(_pointSW.getX() + w, _pointSW.getY() + h);
    }

    public RectangleB(Point sw, Point ne) {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }

    // copy constructor
    public RectangleB(RectangleB r) {
        _pointSW = new Point(r._pointSW);
        _pointNE = new Point(r._pointNE);
    }

    // 3. getters and setters
    public int getWidth() {
        return _pointNE.getX() - _pointSW.getX();
    }

    public int getHeight() {
        return _pointNE.getY() - _pointSW.getY();
    }

    public Point getPointSW() {
        return new Point(_pointSW);
    }

    public Point getPointNE() {
        return new Point(_pointNE);
    }

    // sw is staying in place, while width is changing
    // ne should change accordingly to keep constant width
    public void setWidth(int w) {
        _pointNE.setX(_pointSW.getX() + w);
    }

    public void setHeight(int h) {
        _pointNE.setY(_pointSW.getY() + h);
    }

    // TODO: NOT SURE!
    public void setPointSW(Point p) {
        int deltaX = p.getX() - _pointSW.getX();
        int deltaY = p.getY() - _pointSW.getY();
        //_pointSW = new Point(p);
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }

    // 4. methods
    public String toString() {
        return "Width=" + getWidth() + " Height=" + getHeight() + " PointSW=" + _pointSW.toString();
    }

    // returns rectangle perimeter
    public int getPerimeter() {
        return 2 * getWidth() + 2 * getHeight();
    }

    // returns rectangle area
    public int getArea() {
        return getWidth() * getHeight();
    }

    // moves the rectangle deltaX and deltaY
    // adding deltaX to SW and NE points x, and deltaY to SW and NE points y
    public void move(int deltaX, int deltaY) {
        _pointSW.move(deltaX, deltaY);
        _pointNE.move(deltaX, deltaY);
    }

    // check if the rectangle that initiates this method is equal (in all characters) to the other rectangle
    //TODO: NOT SURE!
    public boolean equals(RectangleB other) {
        return this.toString().equals(other.toString());
    }

    // returns rectangle diagonal length
    public double getDiagonalLength() {
        return _pointSW.distance(_pointNE);
    }

    // gets other rectangle, and check if the rectangle initiating this method (this) has larger area than other rectangle
    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }

    // change width to height, and height to width
    // TODO: NOT SURE!
    public void changeSides() {
        int temp = getWidth();
        setWidth(getHeight());
        setHeight(temp);
    }

    // check if rectangle r is inside the rectangle initiating this method
    public boolean isIn(RectangleB r) {
        // all the options that rectangle r is PARTIALLY OUT of this rectangle. So return not all of these options.
        return !(r._pointSW.isLeft(this._pointSW)) && !(r._pointSW.isUnder(this._pointSW)) && !(r.getPointNE().isRight(this.getPointNE()) && !(r.getPointNE().isAbove(this.getPointNE())));
    }

    // check if rectangle r has common points with the rectangle initiating this method
    public boolean overlap(RectangleB r) {
        // all the options that the rectangles ARE COMPLETELY STRANGERS. So return not all of these options.
        return !(r.getPointNE().isLeft(this._pointSW) || r._pointSW.isRight(this.getPointNE()) || r._pointSW.isAbove(this.getPointNE()) || r.getPointNE().isUnder(this._pointSW));
    }
}
