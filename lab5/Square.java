class Square extends Point {

    double side;

    public Square(double side, double x, double y) {
    super(x, y);
    this.side = side;
    }

    public double area(){
        return this.side*this.side;
    }

    public String toString(){
        return "Corner = " + super.toString() + "; side = " + this.side;
    }

}