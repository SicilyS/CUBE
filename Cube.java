public class Cube {

    private double edge;

    public Cube(double length){
        this.edge = length;
    }

    public double volume(){
        return this.edge * this.edge * this.edge;
    }

    public double surfaceArea(){
        return 6 * this.edge * this.edge;
    }

    public boolean equals(Cube that){
        return this.edge == that.edge;
    }

    public static void main(String[] args){
        Cube cube = new Cube(3);
        StdOut.println(cube.volume());
        Cube cube2 = new Cube(3);
        StdOut.println(cube.equals(cube2));
        StdOut.println(cube == cube2);
    }

}
