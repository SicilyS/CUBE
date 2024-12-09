public class Ops {
    static double[][] product(double[][] m, double[][] n) {
        double[][] result = new double[m.length][n[0].length];
        double point = 0;
        for (int x = 0; x < result.length; x++) {
            for (int y = 0; y < result[0].length; y++) {
                for (int z = 0; z < n.length; z++) {
                    point += m[x][z] * n[z][y];
                }
                result[x][y] = point;
                point = 0;
            }
        }

        return result;
    }

    static double magnitude(double[] v) {
        double result = 0;
        for (int i = 0; i < v.length; i++) {
            double a = v[i] * v[i];
            result = result + a;
        }
        return Math.sqrt(result);
    }

    static double[] sum(double[] v, double[] w) {
        double[] result = new double[v.length];
        for(int i = 0; i < v.length; i++){
            result[i] = v[i] + w[i];
        }
        return result;


    }
    static double[] difference(double[] v, double[] w) {
        double[] result = new double[v.length];
        for(int i = 0; i < v.length; i++){
            result[i] = v[i] - w[i];
        }
        return result;
    }


    static double[] vectorScale(double[] v, double s) {
        double[] result = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            result[i] = s * v[i];
        }
        return result;
    }

    static double[][] matrixScale(double[][] v, double s) {
        double[][] result = new double[v.length][v[0].length];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                result[i][j] = s * v[i][j];
            }
        }
        return result;
    }

    // works for 3d vectors only
    static double[] crossProd(double[] m, double[] n) {
        double[] result = new double[3];
        result[0] = m[1] * n[2] - m[2] * n[1];
        result[1] = m[2] * n[0] - m[0] * n[2];
        result[2] = m[0] * n[1] - m[1] * n[0];

        return result;
    }

    static void printMatrix(double[][] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.println(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printVector(double[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }

    static double[] transform( double[][] m, double[] v) {
        double[][] n = new double[v.length][1];
        for (int i = 0; i < v.length; i++) {
            n[i][0] = v[i];
        }
        double[][] result = new double[m.length][n[0].length];
        double point = 0;
        for (int x = 0; x < result.length; x++) {
            for (int y = 0; y < result[0].length; y++) {
                for (int z = 0; z < n.length; z++) {
                    point += m[x][z] * n[z][y];
                }
                result[x][y] = point;
                point = 0;
            }
        }
        double[] resultV = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            resultV[i] = result[i][0];
        }
        return resultV;

    }
}
