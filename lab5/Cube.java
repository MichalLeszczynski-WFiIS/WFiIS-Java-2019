class Cube extends Square {

    double depth;

    public Cube(double side, double x, double y) {
    super(side, x, y);
    this.depth = side;
    }

    public double area(){
        return super.area()*6.0;
    }

    public double volume(){
        return super.area()*this.depth;
    }

    public String toString(){
        return super.toString() + "; depth = " + this.depth;
    }
}