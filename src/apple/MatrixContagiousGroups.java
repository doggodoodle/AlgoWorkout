package apple;

/**
 * Created by ritvikmathur on 1/7/17.
 */
public class MatrixContagiousGroups {

    public static void main(String[] args) {
        int [][] matrix = getInputMatrix();
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[2][0] = 1;

        matrix[2][1] = 1;
        matrix[2][2] = 1;
        matrix[1][2] = 1;
        //matrix[0][2] = 1;
        printMatrix(matrix);
        System.out.println("groups:"+getNumGroups(matrix));
        printMatrix(matrix);
    }

    static int getNumGroups(int[][] matrix){
        int n = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int row = 0; row < rows; row++){
            for (int col=0; col< cols; col++){
                System.out.print(matrix[row][col]+"     ");
                if(matrix[row][col] == 1 ){

                    if(traverse(matrix, row, col))
                        n++;

                }
            }
            System.out.println("");
        }
        System.out.println("    ----------");


        return n;
    }

    static boolean traverse(int[][] matrix, int row, int col){

        if(isOutOfBounds(matrix, row, col) || matrix[row][col] == 0 )
        return false;
        boolean changed = false;
        if (matrix[row][col] == 1) {
            System.out.println("cell:"+row+"|"+col);
            matrix[row][col] = 0;
            changed = true;
        }
        traverse(matrix, row, col-1) ;
        traverse(matrix, row-1, col) ;
        traverse(matrix, row, col+1) ;
        traverse(matrix, row+1, col) ;

        return changed;

    }

    static boolean isOutOfBounds(int[][] matrix, int row, int col){
        if(row >= matrix.length || col>= matrix[0].length || row < 0 || col<0)
            return true;
        return false;
    }

    static void printMatrix(int [][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int row = 0; row < rows; row++){
            for (int col=0; col< cols; col++){
                System.out.print(matrix[row][col]+"     ");
            }
            System.out.println("");
        }
        System.out.println("    ----------");
    }

    private static int[][] getInputMatrix() {

        int rows = 3;
        int cols = 3;

        int [][] matrix = new int [rows][cols];

        System.out.println("matrix.length="+matrix.length);
        System.out.println("matrix[0].length="+matrix[0].length);

        for(int row = 0; row < rows; row++){
            for (int col=0; col< cols; col++){
                matrix[row][col] = 0;
                System.out.print(matrix[row][col]+"     ");
            }
            System.out.println("");
        }
        System.out.println("    ----------");

        return matrix;
    }
}
