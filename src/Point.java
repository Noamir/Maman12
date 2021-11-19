public class Point {
    // 1. instance variable
    private int _x;
    private int _y;

    // 2. constructors
    public Point(int x, int y) {
        _x = x;
        _y = y;
    }

    // copy constructor
    public Point(Point other) {
        _x = other._x;
        _y = other._y;
    }

    // 3. getters and setters
    int getX() {
        return _x;
    }

    int getY() {
        return _y;
    }

    void setX(int num) {
        _x = num;
    }

    void setY(int num) {
        _y = num;
    }

    // 4. methods
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }

    // gets other Point and check if the point initiating this method x,y values are equal to other Point's x,y values
    public boolean equals(Point other) {
        return this._x == other._x && this._y == other._y;
    }

    // gets other Point and check if the point initiating this method is above other Point
    public boolean isAbove(Point other) {
        return this._y > other._y;
    }

    // gets other Point and check if the point initiating this method is under other Point
    // check if other Point isAbove the point initiating this method (this) - if true, then the point initiating this method isUnder other Point - what we need.
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    // gets other Point and check if the point initiating this method is left to other Point
    public boolean isLeft(Point other) {
        return this._x < other._x;
    }

    // gets other Point and check if the point initiating this method is right to other Point
    // check if other Point isLeft to the point initiating this method (this) - if true, then the point initiating this method isRight to other Point - what we need.
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    // moves this point - x with deltaX and y with deltaY
    public void move(int deltaX, int deltaY) {
        _x = _x + deltaX;
        _y = _y + deltaY;
    }

    // gets Point p and return distance between the point initiating this method and Point p
    public double distance(Point p) {
        return Math.sqrt(Math.pow(_x - p._x, 2) + Math.pow(_y - p._y, 2));
    }
}