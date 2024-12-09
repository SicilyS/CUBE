import java.awt.*;
import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        double [] cam = {5,5,2};
        double [] look = {0,0,0};

        double near = -1;
        double far = -1000;
        //fov is horizontal field of view. it's an angle in deg
        double fov = 75;
        //r is aspect ratio. wigth:height 1.5 is 3:2
        double r = 1.5;


        // INIT OBJECT Points. Only doing one object for now
        Point[] cube = new Point[8];
        Point[] object = new Point[cube.length];
        for(int i = 0; i < cube.length; i++){
            cube[i] = new Point();
            object[i] = new Point();
        }
        cube[0].setPoint(-1,-1,-1,1);
        cube[1].setPoint(-1,-1,1,1);
        cube[2].setPoint(1,-1,-1,1);
        cube[3].setPoint(-1,1,-1,1);
        cube[4].setPoint(-1,1,1,1);
        cube[5].setPoint(1,-1,1,1);
        cube[6].setPoint(1,1,-1,1);
        cube[7].setPoint(1,1,1,1);

        Edge[] edges = new Edge[12];
        for(int i = 0; i < edges.length; i++){
            edges[i] = new Edge();
        }

        edges[0].setEdge(0,1);
        edges[1].setEdge(0,2);
        edges[2].setEdge(0,3);
        edges[3].setEdge(2,5);
        edges[4].setEdge(3,6);
        edges[5].setEdge(3,4);
        edges[6].setEdge(4,7);
        edges[7].setEdge(6,7);
        edges[8].setEdge(7,5);
        edges[9].setEdge(5,1);
        edges[10].setEdge(4,1);
        edges[11].setEdge(2,6);

        double deg = 0;
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.black);
        StdDraw.filledSquare(.5,.5,.5);
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setPenRadius(0.005);

        double t = 0;

        while(true){
            t += .01;
            cam[0]= 8 * Math.cos(t);
            cam[1]= 8 * Math.sin(t);

            // apply transformation to points to get them in NDC
            for (int i = 0; i < cube.length; i++) {
                double[] p = {cube[i].x, cube[i].y, cube[i].z, cube[i].w};
                p = viewspace(p, cam, look);
                p = projection(p, fov, r, near, far);
                object[i].x = (p[0] + 1) / 2;
                object[i].y = (p[1] + 1) / 2;
                object[i].z = (p[2] + 1) / 2;
                object[i].w = (p[3] + 1) / 2;
            }
            StdDraw.setPenColor(Color.black);
            StdDraw.filledSquare(.5,.5,.5);
            StdDraw.setPenColor(StdDraw.BLUE);
            //DRAW
            for (int i = 0; i < object.length; i++) {
                StdDraw.point(object[i].x, object[i].y);
            }

            for (int i = 0; i < edges.length; i++) {
                StdDraw.line(object[edges[i].p1].x, object[edges[i].p1].y, object[edges[i].p2].x, object[edges[i].p2].y);
            }
            StdDraw.show();
            StdDraw.pause(3);
        }


    }
    // defining all the transformations
    static double[] rotateX(double[] p,double deg){
        double rad = Math.toRadians(deg);
        double [][] rotX = {{1, 0,0, 0},
                {0,Math.cos(rad), -Math.sin(rad), 0},
                {0,Math.sin(rad),Math.cos(rad),0},
                {0,0,0,1}};
        return Ops.transform(rotX,p);

    }
    static double[] offset(double[] p,double[] offset){
        double [][] trans = {{1, 0,0, offset[0]},
                {0,1, 0, offset[1]},
                {0,0,1,offset[2]},
                {0,0,0,1}};
        return Ops.transform(trans,p);

    }
    static double[] viewspace(double[] p, double[] cam,double[] look){
        double[] up = {0, 1, 0};

        //BELOW SHIFTS POINTS SO CAM IS AT ORIGIN
        double[] negCam = Ops.vectorScale(cam,-1);
        p = offset(p, negCam);

        //finds view plane normal, the z-axis of view plane, called n
        double[] d = Ops.difference(look,cam);
        double dMag = Ops.magnitude(d);
        double[] n = Ops.vectorScale(d,1/dMag);

        //finds the normalized x-axis of the view plane, called u
        double[] upXn = Ops.crossProd(up,n);
        double upXnMag = Ops.magnitude(upXn);
        double[] u= Ops.vectorScale(upXn, 1/upXnMag);

        //finds normalized y-axis of view plane, called v
        double[] v = Ops.crossProd(n,u);

        //using above def of the view space, we transform from world to view coords
        double [][] trans = {{u[0],u[1],u[2],0},
                {v[0],v[1],v[2],0},
                {n[0],n[1],n[2],0},
                {0,0,0,1}};
        return Ops.transform(trans,p);

    }
    static double[] projection(double[] p, double fov,double r,double near,double far){
        double width = -2 * near * Math.tan(Math.toRadians(fov)/2);
        double height = width / r;

        //the transformation scales all axis to within [-1,1] and apply perspective scaling
        double [][] trans = {{((2*near)/width),0,0,0},
                {0,((2*near)/height),0,0},
                {0,0,((-(far+near))/(far-near)),((-2*far*near)/(far-near))},
                {0,0,-1,0}};
        p= Ops.transform(trans,p);

        //normalize so w=1
        return Ops.vectorScale(p,1/p[3]);

    }





}
