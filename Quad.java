public class Quad {
    private double side;
    private double area;

    public Quad(double length){
        this.side = length;
        this.area= length * length;
    }

    public void setSide(double length){
        this.side = length;
        this.area = length * length;
    }
    public double area(){
        return this.side * this.side;
    }

    public double getSide(){
        return this.side;
    }


    /**returns the perimeter of quad
     * @return the perimeter of quad
     */
    public double perimeter(){
        return this.side * 4;
    }
    public static void main(String[] args){
        Quad square = new Quad(4.0);
        square.setSide(6);
        StdOut.println(square.area);
        StdOut.println(square.perimeter());
    }
/*

    public boolean equals(){
        // use the wizard?
    }
*/

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
