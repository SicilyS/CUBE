/**
 * Various functions dealing with vectors and matrices.
 *
 * @author PUT YOUR NAME HERE!
 */
class LinearAlgebra {

    /**
     * Returns the magnitude of the vector v (which may be of any length).
     * This is found by adding up the squares of all of the elements of v
     * and taking the square root of the total.
     */
    static double magnitude(double[] v) {
        double result = 0;
        for(int i = 0; i < v.length; i++){
            double a = v[i] * v[i];
            result = result + a;
        }
        return Math.sqrt(result);
    }

    /**
     * Returns the sum of vectors v and w. This is a vector of the same
     * length, each of whose elements is the sum of the corresponding
     * elements in v and w.
     */
    static double[] sum(double[] v, double[] w) {
        double[] result = new double[v.length];
        for(int i = 0; i < v.length; i++){
            result[i] = v[i] + w[i];
        }
        return result;


    }

    /**
     * Returns the difference between vectors v and w. This is a vector
     * of the same length, each of whose elements is the difference
     * between the corresponding elements in v and w.
     */
    static double[] difference(double[] v, double[] w) {
        double[] result = new double[v.length];
        for(int i = 0; i < v.length; i++){
            result[i] = v[i] - w[i];
        }
        return result;
    }

    /**
     * Returns the element-wise between vectors v and w. This is a vector
     * of the same length, each of whose elements is the product of the
     * corresponding elements in v and w.
     */
    static double[] elementwiseProduct(double[] v, double[] w) {
        double[] result = new double[v.length];
        for(int i = 0; i < v.length; i++){
            result[i] = v[i] * w[i];
        }
        return result;
    }

    /**
     * Returns the dot product of vectors v and w. This is the sum of
     * the products of the corresponding elements.
     */
    static double dotProduct(double[] v, double[] w) {
        double result = 0;
        for(int i = 0; i < v.length; i++){
            result = result + v[i] * w[i];
        }
        return result;
    }

    /**
     * Returns, as an array of two elements, the dimensions of matrix m.
     */
    static int[] dimensions(double[][] m) {
        int[] result = new int[2];
        result[0] = m.length;
        result[1] = m[0].length;
        return result;
    }

    /**
     * Returns the element-wise sum of matrices m and n.
     */
    static double[][] sum(double[][] m, double[][] n) {
        double result[][] = new double[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            for(int x = 0; x < m[0].length; x++)  {
                result[i][x] = m[i][x] + n[i][x];
            }
        }
        return result;
    }

    /**
     * Returns the element-wise product of matrices m and n.
     */
    static double[][] elementwiseProduct(double[][] m, double[][] n) {
        double result[][] = new double[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            for(int x = 0; x < m[0].length; x++)  {
                result[i][x] = m[i][x] * n[i][x];
            }
        }
        return result;
    }

    /**
     * Returns the transpose of m, that is, a matrix where element
     * i, j is element j, i from m.
     */
    static double[][] transpose(double[][] m) {
       double result[][] = new double[m[0].length][m.length];
        for(int i = 0; i < m.length; i++){
            for(int x = 0; x < m[0].length; x++)  {
                result[x][i] = m[i][x];
            }
        }
        return result;
    }

    /**
     * Returns the matrix product of m and n. (Search the web for a
     * definition.)
     */
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

}
