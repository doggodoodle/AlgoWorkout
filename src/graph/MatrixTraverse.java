package graph;

/**
 * Created  on 4/17/17.
 */
public class MatrixTraverse {
    static final int SIZE = 8;
    public static void main(String[] args) {
        int [][] matrix = new int[SIZE][SIZE];
        MatrixTraverse matrixTraverse = new MatrixTraverse();
        matrixTraverse.printAllAntPaths(0, 0, "");
    }

    private void printAllAntPaths(int i, int j, String s) {
        if(i>=SIZE || j>=SIZE)
            return;

        StringBuilder sb = new StringBuilder(s);
        sb.append(i+"-"+j+" ");
        if(i==j && i==SIZE-1){
            System.out.println(sb.toString());
            return;
        }
        printAllAntPaths(i+1, j, sb.toString());
        printAllAntPaths(i, j+1, sb.toString());

    }
}
